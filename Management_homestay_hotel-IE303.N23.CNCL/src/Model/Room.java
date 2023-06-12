package Model;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.*;

public class Room {

    /**
     * Default constructor
     */
    public Room() {
    }

    /**
     * 
     */
    private int roomId;

    /**
     * 
     */
    private String roomName;

    /**
     * 
     */
    private String roomType;

    /**
     * 
     */
    private double roomRates;

    /**
     * 
     */
    private boolean roomStatus;
    
    /**
     * 
     */
    private int htId;

    /**
     * @param roomId 
     * @param roomName 
     * @param roomType 
     * @param roomRates 
     * @param roomStatus
     * @param htId
     */
    public Room(int roomId, String roomName, String roomType, double roomRates, boolean roomStatus, int htId) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.roomRates = roomRates;
        this.roomStatus = roomStatus;
        this.htId = htId;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getRoomRates() {
        return roomRates;
    }

    public boolean isRoomStatus() {
        return roomStatus;
    }
    
    public int getHtId() {
        return htId;
    }

    public void setHtId(int htId) {
        this.htId = htId;
    }
    
    Connection cn = DataConnection.Connect();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void insertRoom(Room room)
    {
         try
        {
            String sqlInsert = "INSERT INTO ROOM(room_id, room_name, room_type, room_rates, room_status, ht_id) values(" 
                    + room.getRoomId() 
                    + ", '" + room.getRoomName() 
                    + "','" + room.getRoomType()
                    + "'," + room.getRoomRates() 
                    + "," + room.isRoomStatus()
                    + "," + room.getHtId() + ")";
            String selectAll = "SELECT * FROM ROOM";
            
            ps = cn.prepareStatement(sqlInsert);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Successful insert!");
            
            ps = cn.prepareStatement(selectAll);
            rs = ps.executeQuery();
        }
        catch(HeadlessException | SQLException | NumberFormatException e)
        {  
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Failed insert!");
        }
        finally
        {
            closeStatementOnly();
        }
    }
    
    public ArrayList<Room> getRooms() {
        ArrayList<Room> rooms = new ArrayList<>();
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cn.prepareStatement("SELECT * FROM ROOM");
            rs = ps.executeQuery();

            while (rs.next()) {
                int roomId = rs.getInt("room_id");
                String roomName = rs.getString("room_name");
                String roomType = rs.getString("room_type");
                Double roomRates = rs.getDouble("room_rates");
                Boolean roomStatus = rs.getBoolean("room_status");
                int htId = rs.getInt("ht_id");
                
                Room room = new Room(roomId, roomName, roomType, roomRates, roomStatus, htId);
                rooms.add(room);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data download failed!");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
            }
        }
        return rooms;
    }
     
    public void statusRoom(Room room)
    {
        try {
            if(room.isRoomStatus()){
            String updateQuery = "UPDATE ROOM SET room_status= "
                    +boolToString(false)
                    ;
                    

            System.out.println(">>>>>>>>>> "+ updateQuery);
            ps = cn.prepareStatement(updateQuery);

            ps.execute();
            }else {
                String updateQuery = "UPDATE ROOM SET room_status= "
                    +boolToString(true)
                    ;
                    

            System.out.println(">>>>>>>>>> "+ updateQuery);
            ps = cn.prepareStatement(updateQuery);

            ps.execute();
            }
            JOptionPane.showMessageDialog(null, "successfully updated a room");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Update query Failed");
        }
        finally
        {
            closeStatementOnly();
        }
    } 
     
    public void deleteRoom(String roomName){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        
        try {
            String sqlDelete = "DELETE FROM ROOM WHERE room_name = ?";

            ps = cn.prepareStatement(sqlDelete);
            ps.setString(1, roomName);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Successful delete room!");
            } else {
                JOptionPane.showMessageDialog(null, "No matching record found!");
            }
            ps.close();
            cn.close();
            System.out.println("Closing DataBase!");
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Unsuccessful delete!");
        } 
    }
    
    public void updateRoom(String roomNameSearch, String roomName, String roomType, double roomRates, boolean roomStatus, int htId)
    {
        try {
            String updateQuery = "UPDATE ROOM SET room_name = '"
                    +roomName + "' , room_type = '"
                    +roomType + "' , room_rates = "
                    +roomRates + " , room_status= "
                    +boolToString(roomStatus) + " ,  ht_id = "
                    +htId + " WHERE room_name = " + roomNameSearch;

            System.out.println(">>>>>>>>>> "+ updateQuery);
            ps = cn.prepareStatement(updateQuery);

            ps.execute();

            JOptionPane.showMessageDialog(null, "successfully updated a room");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Update query Failed");
        }
        finally
        {
            closeStatementOnly();
        }
    }
    
    public void closeAll()
    {
        try
        {
            ps.close();
            rs.close();
        }
        catch(SQLException e)
        {
            System.out.println("Closing DataBase!!!");
        }
    }
    private void closeStatementOnly()
    {
        try
        {
            ps.close();
        }
        catch(SQLException e)
        {
            System.out.println("Closing DataBase!");
        }
    }
    public String boolToString(boolean value) {
        return value ? "true" : "false";
    }

}
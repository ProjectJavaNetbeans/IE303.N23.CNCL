package Model;



import java.util.*;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.*;

/**
 * 
 */
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
    private int htID;

    /**
     * @param roomId 
     * @param roomName 
     * @param roomType 
     * @param roomRates 
     * @param roomStatus
     * @param htID
     */
    public Room(int roomId, String roomName, String roomType, double roomRates, boolean roomStatus, int htID) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.roomRates = roomRates;
        this.roomStatus = roomStatus;
        this.htID = htID;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getRoomRates() {
        return roomRates;
    }

    public void setRoomRates(double roomRates) {
        this.roomRates = roomRates;
    }

    public boolean isRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(boolean roomStatus) {
        this.roomStatus = roomStatus;
    }

    public int getHtID() {
        return htID;
    }

    public void setHtID(int htID) {
        this.htID = htID;
    }
    
    Connection conn = DataConnection.Connect();
    PreparedStatement stat = null;
    ResultSet rs = null;
    
    public void insertRoom(Room room)
    {
        try
        {
            String insertRoom = "insert into room(room_name, room_type, room_rates, room_status, ht_id) values("+ room.getRoomName() +
                ",'"+room.getRoomType()+"',"+room.getRoomRates()+",'"+room.isRoomStatus()+"','"+room.getHtID()+"')";
            stat = conn.prepareStatement(insertRoom);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Thêm phòng thành công!");
        }
        catch(HeadlessException | SQLException | NumberFormatException e)
        {  
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Lỗi! Thêm phòng thất bại");
        }
        finally
        {
            flushStatementOnly();
        }
    }
    
    public List<Room> getRooms() {
        List<Room> rooms = new ArrayList<>();
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cn.prepareStatement("SELECT * FROM ROOM");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("room_id");
                String name = rs.getString("room_name");
                String type = rs.getString("room_type");
                Double rates = rs.getDouble("room_rates");
                int ht_id = rs.getInt("ht_id");
                boolean status = rs.getBoolean("room_status");

                Room room = new Room(id, name, type, rates, status, ht_id);
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
    
//    public ResultSet getRoomType() {
//        try {
//            String query = "select distinct room_type from room";
//            stat = conn.prepareStatement(query);
//            rs = stat.executeQuery();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all Room Type DB Operation");
//        }
//
//        return rs;
//    }
//    
    public void updateRoom(Room room)
    {
        try {
            String updateQuery ="update room set room_name = '"
                    +room.getRoomName()+"', room_type ='"
                    +room.getRoomType()+"', room_rates ='"
                    +room.getRoomRates()+"', room_status= '"
                    +boolToString(room.isRoomStatus())+"',  ht_id ='"
                    +room.getHtID()
                    ;
                    

            System.out.println(">>>>>>>>>> "+ updateQuery);
            //System.out.println(updateQuery);
            stat = conn.prepareStatement(updateQuery);

            //System.out.println(updateQuery);
            stat.execute();

            JOptionPane.showMessageDialog(null, "successfully updated a room");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Update query Failed");
        }
        finally
        {
            flushStatementOnly();
        }
    }
    
    public void statusRoom(Room room)
    {
        try {
            if(room.isRoomStatus()){
            String updateQuery ="update room set room_status= '"
                    +boolToString(false)
                    ;
                    

            System.out.println(">>>>>>>>>> "+ updateQuery);
            //System.out.println(updateQuery);
            stat = conn.prepareStatement(updateQuery);

            //System.out.println(updateQuery);
            stat.execute();
            }else {
                String updateQuery ="update room set room_status= '"
                    +boolToString(true)
                    ;
                    

            System.out.println(">>>>>>>>>> "+ updateQuery);
            //System.out.println(updateQuery);
            stat = conn.prepareStatement(updateQuery);

            //System.out.println(updateQuery);
            stat.execute();
            }
            JOptionPane.showMessageDialog(null, "successfully updated a room");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Update query Failed");
        }
        finally
        {
            flushStatementOnly();
        }
    }
    
    public void deleteRoom(int roomId)
    {
        try
        {
            String deleteRoom = "delete from room where room_id = '"+roomId+"'";
            stat = conn.prepareStatement(deleteRoom);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Xóa thành công!!!");
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Xóa thất bại!!!");
        }
        finally
        {
            flushStatementOnly();
        }
    }
    
    public void flushAll()
    {
        try
        {
            stat.close();
            rs.close();
        }
        catch(Exception e)
        {
            System.out.println("Closing DataBase!!!");
        }
    }
    private void flushStatementOnly()
    {
        try
        {
            stat.close();
        }
        catch(Exception e)
        {
            System.out.println("Closing DataBase!");
        }
    }
    public String boolToString(boolean value) {
        return value ? "true" : "false";
    }


}
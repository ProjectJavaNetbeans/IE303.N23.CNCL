package Model;


import java.util.*;
import java.sql.*;
import javax.swing.*;
/**
 * 
 */
public class Service {

    /**
     * Default constructor
     */
    public Service() {
    }

    /**
     * 
     */
    private int svId;

    /**
     * 
     */
    private String svName;

    /**
     * 
     */
    private double svPrice;

    /**
     * @param svId 
     * @param svName 
     * @param svPrice
     */
    public Service(int svId, String svName, double svPrice) {
        this.svId = svId;
        this.svName = svName;
        this.svPrice = svPrice;
        // TODO implement here
    }

    public int getSvId() {
        return svId;
    }

    public void setSvId(int svId) {
        this.svId = svId;
    }

    public String getSvName() {
        return svName;
    }

    public void setSvName(String svName) {
        this.svName = svName;
    }

    public double getSvPrice() {
        return svPrice;
    }

    public void setSvPrice(double svPrice) {
        this.svPrice = svPrice;
    }

    Connection cn = DataConnection.Connect();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void addService(Service sv)
    {
        try
        {
            String insertService = "INSERT INTO SERVICE(sv_id, sv_name, sv_price) VALUES (" 
                    + sv.getSvId() + ", '"
                    + sv.getSvName() + "',"
                    + sv.getSvPrice() + ")";
            String selectAll = "SELECT * FROM SERVICE";

            ps =cn.prepareStatement(insertService);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Successful insert!");
            
            ps = cn.prepareStatement(selectAll);
            rs = ps.executeQuery();
        }
        catch(SQLException e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Failed insert!");
        }
        finally
        {
            closeStatementOnly();
        }        
    }
    
    public ArrayList<Service> getServices() {
        ArrayList<Service> svs = new ArrayList<>();
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cn.prepareStatement("SELECT * FROM SERVICE");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("sv_id");
                String name = rs.getString("sv_name");
                Double price = rs.getDouble("sv_price");

                Service sv = new Service(id, name, price);
                svs.add(sv);
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
        return svs;
    }
    
    public void updateService(Service sv)
    {
        try
        {
            String updateService = "UPDATE SERVICE SET sv_name = '" 
                    + sv.getSvName() + "', sv_price = "
                    + sv.getSvPrice() + " WHERE sv_id ="
                    + sv.getSvId();
            ps = cn.prepareStatement(updateService);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Successful update!");
        }
        catch(SQLException e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Failed update!");
        }
        finally
        {
            closeStatementOnly();
        }
    }
    
    public void deleteService(int svId)
    {
        try
        {
            String deleteService = "DELETE FROM SERVICE WHERE sv_id = " + svId;
            ps = cn.prepareStatement(deleteService);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Successful delete!");
        }
        catch(SQLException e)
        {
            System.out.println(e);
            System.out.println("Failed detele!");
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


}
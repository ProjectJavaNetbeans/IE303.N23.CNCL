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

    Connection conn = DataConnection.Connect();
    PreparedStatement stat = null;
    ResultSet rs = null;
    
    public void addService(Service sv)
    {
        try
        {
            String insertService = "insert into service(sv_name, sv_price) values ('"+sv.getSvName()+"',"+sv.getSvPrice()+")";
            stat =conn.prepareStatement(insertService);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Thêm thất bại!");
        }
        finally
        {
            flushStatementOnly();
        }        
    }
    
    public List<Service> getSvs() {
        List<Service> svs = new ArrayList<>();
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
            String updateService = "update service set sv_name = '" + sv.getSvName()+"', sv_prive = "+sv.getSvPrice()+" where sv_id ='"
                    + sv.getSvId()+"'";
            stat = conn.prepareStatement(updateService);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!!!");
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Cập nhất thất bại!!!");
        }
        finally
        {
            flushStatementOnly();
        }
    }
    
    public void deleteService(int svId)
    {
        try
        {
            String deleteService = "delete from service where sv_id = '"+svId+"'";
            stat = conn.prepareStatement(deleteService);
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


}
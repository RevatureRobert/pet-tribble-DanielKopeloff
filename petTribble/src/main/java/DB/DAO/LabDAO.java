package DB.DAO;

import DB.Query;
import Model.Lab;
import Model.Tribble;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class LabDAO extends Query implements CRUDDAO {

    private static LabDAO labDAO = null;
    private LabDAO() throws SQLException {
    }

    public static LabDAO getInstance(){
        if(labDAO == null){
            try {
                labDAO = new LabDAO();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return labDAO;
    }

    public Object add(Object o) {
        Lab temp;
        if (!(o instanceof Lab)) return null;
        else {
            temp = (Lab) o;
        }
        String sql =  "INSERT INTO public.labs\n" +
                "(address, zip, country)\n" +
                "VALUES(?, ?, ?);\n";

        int rows = -1;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,temp.address);
            stmt.setString(2,temp.zip);
            stmt.setString(3,temp.country);

            rows = stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    public Object readbyID(int id) {
        String sql = "Select * from labs where id = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return new Lab(rs);
    }

    public Object readbyName(String address) {
        String sql = "Select * from labs where address = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,address);
            rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return new Lab(rs);
    }

    public List readAll() {
        String sql = "Select * from labs";
        List list = new LinkedList();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getMetaData().getColumnCount());
                list.add(new Lab(rs));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }

    public int update(Object o) {
        Lab temp;
        if (!(o instanceof Lab)) return -1;
        else {
            temp = (Lab) o;
        }
       String sql = "UPDATE public.labs\n" +
               "SET address=?, zip=?, country=?\n" +
               "WHERE id=?;\n";

        int rows = -1;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,temp.address);
            stmt.setString(2,temp.zip);
            stmt.setString(3,temp.country);
            stmt.setInt(4 ,temp.id);
            rows = stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rows;


    }

    public int delete(Object o) {
        Lab temp;
        if (!(o instanceof Lab)) return -1;
        else {
            temp = (Lab) o;
        }
        String sql = "Delete from public.labs where id = ?";

        int rows = -1;
        try{

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1 , temp.id);
            rows = stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return rows;
    }
}

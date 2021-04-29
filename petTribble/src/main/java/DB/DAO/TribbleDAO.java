package DB.DAO;

import DB.Query;
import Model.Tribble;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TribbleDAO extends Query implements CRUDDAO  {

    private static TribbleDAO tribbleDAO = null;
    private TribbleDAO() throws SQLException {
    }

    public static TribbleDAO getInstance(){
        if(tribbleDAO == null){
            try {
                tribbleDAO = new TribbleDAO();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return tribbleDAO;
    }

    public Object add(Object o) {
        Tribble temp;
        if (!(o instanceof Tribble)) return null;
        else {
           temp = (Tribble) o;
        }
        String sql = "INSERT INTO public.tribble\n" +
                "(\"name\", \"size\", color, age, number_of_hairs)\n" +
                "VALUES(?, ?, ?, ?, ?);\n";

        int rows = -1;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,temp.name);
            stmt.setInt(2,temp.size);
            stmt.setString(3,temp.color);
            stmt.setInt(4,temp.age);
            stmt.setInt(5,temp.numberOfHairs);
            rows = stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rows;
    }

    public Object readbyID(int id) {
      String sql = "Select * from tribble where id = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return new Tribble(rs);
    }

    public Object readbyName(String name) {
        String sql = "Select * from tribble where name = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,name);
            rs = stmt.executeQuery();
            rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return new Tribble(rs);
    }

    public List readAll() {
        String sql = "Select * from tribble";
        List list = new LinkedList();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getMetaData().getColumnCount());
                list.add(new Tribble(rs));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }

    public int update(Object o) {
        Tribble temp;
        if (!(o instanceof Tribble)) return -1;
        else {
            temp = (Tribble) o;
        }

        String sql = "UPDATE public.tribble\n" +
                "SET \"name\"=?, \"size\"=?, color=?, age=?, number_of_hairs=?\n" +
                "WHERE id=?;\n";

        int rows = -1;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,temp.name);
            stmt.setInt(2,temp.size);
            stmt.setString(3,temp.color);
            stmt.setInt(4,temp.age);
            stmt.setInt(5,temp.numberOfHairs);
            stmt.setInt(6,temp.id);
            rows = stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rows;


    }

    public int delete(Object o) {
        Tribble temp;
        if (!(o instanceof Tribble)) return -1;
        else {
            temp = (Tribble) o;
        }
        String sql = "Delete from public.tribble where id = ?";
        int rows = -1;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,temp.id);
            rows = stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;


    }
}

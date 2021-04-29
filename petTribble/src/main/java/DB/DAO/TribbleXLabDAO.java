package DB.DAO;

import DB.Query;
import Model.Lab;
import Model.Tribble;
import Model.TribbleXLabs;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TribbleXLabDAO extends Query {
    public TribbleXLabDAO() throws SQLException {
    }

    public int add(Tribble t , Lab l) {
        String sql = "Insert into public.tribblexlabs values (? ,?)";

         int rows = -1;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, t.id);
            stmt.setInt(2,l.id);
            rows = stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rows;

    }

    public Tribble findByTribble(int id) {
        String sql = "Select * from tribblexlabs where tribbleId = ?";

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

    public List findByLab(int id) {
        String sql = "Select * from tribblexlabs, tribble where labId = ? and tribble.id = tribblexlabs.tribbleId";
        LinkedList list = new LinkedList();

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while(rs.next()){
                list.add(new Tribble(rs));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }

    public List readAll() {
        String sql = " Select * from tribblexlabs, tribble ,labs where labId = labs.id and tribble.id = tribblexlabs.tribbleId";
        LinkedList list = new LinkedList();
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                list.add(new TribbleXLabs(new Tribble(rs) , new Lab(rs)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }


    public int delete(int id) {
        String sql = "Delete from tribblexlabs where tribbleId = ?";
        int rows = -1;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1 ,id);
            rows = stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return rows;
    }
}

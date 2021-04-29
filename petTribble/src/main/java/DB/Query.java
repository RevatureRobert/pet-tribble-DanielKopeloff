package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Query {

     protected static Connection conn;

     protected static PreparedStatement stmt;

     protected static ResultSet rs;

    static {
        try {
            conn = DB_Connection.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Query() throws SQLException {
    }
}

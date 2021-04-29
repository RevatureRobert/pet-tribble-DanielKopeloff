package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB_Connection {

    private static final String userName = "postgres";
    private static final String password = "rootroot";
    private static final String port = "5432";
    private static final String hostname ="database-2.cpjsotrqrzgi.us-east-1.rds.amazonaws.com";
    private static final String dbName = "postgres";
    private static String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
    private static Connection conn;

        public static synchronized Connection getConnection() throws SQLException {

            if (conn == null) {
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException e) {
                    System.out.println("Could not register driver!");
                    e.printStackTrace();
                }
                conn = DriverManager.getConnection(jdbcUrl);
            }


            //If connection was closed then retrieve a new connection
            if (conn.isClosed()) {
                System.out.println("Opening new connection...");
                conn = DriverManager.getConnection(jdbcUrl);
            }
            return conn;
        }

    }









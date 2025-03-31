package JobConnect.Dao.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;
    final static  String url   = "jdbc:mysql://localhost:3306/jobconnect";
    final static  String username = "root";
    final static  String password = "root";

    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
       return   connection = DriverManager.getConnection(url,username,password);
    }
}

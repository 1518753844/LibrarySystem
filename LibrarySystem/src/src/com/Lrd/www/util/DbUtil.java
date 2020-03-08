package src.com.Lrd.www.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author
 * @date 2020/2/19-11:10
 */
public class DbUtil {
    private final static String URL = "jdbc:mysql://localhost:3306/library_system?serverTimezone=GMT%2B8";
    private final static String USER= "root";
    private final static String PASSWORD = "root";

    private static Connection conn =null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        return conn;
    }

}

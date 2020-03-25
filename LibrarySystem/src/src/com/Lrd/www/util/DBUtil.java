package src.com.Lrd.www.util;

import java.sql.Connection;

/**
 * @author dada哈哈哈
 * @date 2020/2/19-11:10
 */
public class DBUtil {
    private static MyDateSource myDs = MyDateSource.getMyDateSource();
    private static Connection conn = myDs.getConnection();

//    static {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(URL,USER,PASSWORD);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
        public static Connection getConn() {
            return conn;
        }

    }

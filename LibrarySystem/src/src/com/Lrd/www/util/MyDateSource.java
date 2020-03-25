package src.com.Lrd.www.util;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * @author dada
 * @date 2020/3/24-21:10
 */
public class MyDateSource implements DataSource {
    private final LinkedList<Connection> dataSources = new LinkedList<>();
    private final String DRIVERCLASSNAME = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/library_system?serverTimezone=GMT%2B8";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";
    private final int INITIALSIZE = 10;
    private final static MyDateSource myDs = new MyDateSource();

    private MyDateSource() {

        try {
            Class.forName(DRIVERCLASSNAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < INITIALSIZE; i++) {
            try {
                Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                dataSources.add(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static MyDateSource getMyDateSource(){
        return myDs;
    }
    /**
     * 获取一个连接
     * @return 连接池中的一个连接
     */
    @Override
    public Connection getConnection() {
        Connection conn = dataSources.removeLast();
        return conn;
    }

    /**
     * 功能：释放连接
     * @param conn 为需要释放的连接
     */
    public void releaseConnection(Connection conn) {
        dataSources.add(conn);
    }

    @Override
    public ConnectionBuilder createConnectionBuilder() throws SQLException {
        return null;
    }
    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }


    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}

package src.com.Lrd.www.dao;


import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

/**
 * @date 2020/2/19-12:01
 */
public class UserDao {

    //增
    public void addUser(User u) throws SQLException {
        Connection conn = DBUtil.getConn();
        String sql = "INSERT user set job_id = (SELECT id FROM job_name WHERE job_name = ?) ," +
                " real_name = ?, username = ?, psw = ?, " +
                "member_of_library = (SELECT id FROM library WHERE library_name = ?), on_commission = DEFAULT ";
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1,u.getJob());
        pstm.setString(2,u.getRealName());
        pstm.setString(3,u.getUsername());
        pstm.setString(4,u.getPassword());
        pstm.setString(5,u.getMemberOfLibrary());
        pstm.execute();
    }

    //删(通过单例组合)
    public void deleteUser(int id) throws SQLException {
        AllDao ad = AllDao.getAd();
        ad.deleteById("user",id);
    }

    //查-通过username来查
    public User getUser(String colName,Object value) throws SQLException {
        Connection conn = DBUtil.getConn();

        /*设置并执行sql语句*/
        String sql = "SELECT u.id, u.real_name, j.job_name, u.username, u.psw, l.library_name,u.on_commission FROM user AS u " +
                "INNER JOIN job_name AS j ON u.job_id = j.id " +
                "INNER JOIN library AS l ON u.member_of_library = l.id  " +
                "WHERE u." + colName+ " = " + value;
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        User u = new User();

        //取值
        while (rs.next()) {
            u.setId(rs.getInt("id"));
            u.setRealName(rs.getString("real_name"));
            u.setJob(rs.getString("job_name"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("psw"));
            u.setMemberOfLibrary(rs.getString("library_name"));
            u.setOnCommission(rs.getInt("on_commission"));
        }
        return u;
    }

    //列出所有的员工
    public ArrayList<User> listUser() throws SQLException {
        Connection conn = DBUtil.getConn();

        /*设置并执行sql语句*/
        String sql = "SELECT u.id, u.real_name, j.job_name, u.username, u.psw, l.library_name,u.on_commission FROM user AS u " +
                "INNER JOIN job_name AS j ON u.job_id = j.id " +
                "INNER JOIN library AS l ON u.member_of_library = l.id  " ;
        PreparedStatement psmt = conn.prepareStatement(sql);
        ResultSet rs = psmt.executeQuery();
        User u;
        ArrayList<User> users = new ArrayList<>();

        //取值
        while (rs.next()) {
            u = new User();

            u.setId(rs.getInt("id"));
            u.setRealName(rs.getString("real_name"));
            u.setJob(rs.getString("job_name"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("psw"));
            u.setMemberOfLibrary(rs.getString("library_name"));
            u.setOnCommission(rs.getInt("on_commission"));

            users.add(u);
        }
        return users;
    }



    /*功能：修改个人信息
      参数：修改后user对象，账户id*/
    public void updateInfo(User u) throws SQLException {
        Connection conn = DBUtil.getConn();

        /*从staff表中更新对应id的字段*/
        String sql = "UPDATE user set  job_id = (SELECT id FROM job_name WHERE job_name = ?) ," +
                " real_name = ?, username = ?, psw = ?, " +
                "member_of_library = (SELECT id FROM library WHERE library_name = ?), on_commission = ? " +
                "WHERE id = ?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1,u.getJob());
        psmt.setString(2,u.getRealName());
        psmt.setString(3,u.getUsername());
        psmt.setString(4,u.getPassword());
        psmt.setString(5,u.getMemberOfLibrary());
        psmt.setInt(6,u.getOnCommission());
        psmt.setInt(7,u.getId());

        psmt.execute();
    }


}

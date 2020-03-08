package src.com.Lrd.www.dao;


import src.com.Lrd.www.bean.Curator;
import src.com.Lrd.www.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @date 2020/2/21-10:43
 */
public class CuratorDao {

   //查-获取一个实例
    public Curator getCurator(int id) throws SQLException {
        Connection conn = DBUtil.getConn();

        String sql = "SELECT * FROM curator WHERE id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);

        ResultSet rs = pstm.executeQuery();
        Curator curator = new Curator();

        while (rs.next()) {
            curator.setId(rs.getInt("id"));
            curator.setTruthName(rs.getString("truth_name"));
            curator.setSex(rs.getString("sex"));
            curator.setEmail(rs.getString("email"));
            curator.setMobile(rs.getString("mobile"));
        }

        return curator;
    }

    //改
    public void updateInfoOfCurator(Curator curator) throws SQLException {
        Connection conn = DBUtil.getConn();

        String sql = "UPDATE curator SET truth_name = ? , sex = ?, " +
                " email = ? , mobile = ? WHERE id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);

        /*填充sql语句*/
        pstm.setString(1,curator.getTruthName());
        pstm.setString(2,curator.getSex());
        pstm.setString(3,curator.getEmail());
        pstm.setString(4,curator.getMobile());
        pstm.setInt(5,curator.getId());

        pstm.execute();
    }

}

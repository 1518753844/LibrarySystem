package src.com.Lrd.www.dao;


import src.com.Lrd.www.bean.CommonStaff;
import src.com.Lrd.www.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

/**
 * @date 2020/2/21-8:48
 */
public class CommonStaffDao {

    //增
    public void addCmnStf(CommonStaff cmnStf) throws SQLException{
        Connection conn = DBUtil.getConn();
        /*设置sql语句模板*/
        String sql = "INSERT common_staff set id = ?, truth_name = ?, sex = ?, " +
                " email = ?, mobile = ? ";
        PreparedStatement pstm = conn.prepareStatement(sql);

        /*填充sql语句*/
        pstm.setInt(1,cmnStf.getId());
        pstm.setString(2,cmnStf.getTruthName());
        pstm.setString(3,cmnStf.getSex());
        pstm.setString(4,cmnStf.getEmail());
        pstm.setString(5,cmnStf.getMobile());

        pstm.execute();
    }

    //删除（单例组合）
    public void deleteCmnStf(int id) throws SQLException{
        AllDao ad = AllDao.getAd();
        ad.deleteById("common_staff",id);
    }

    //查-获取一个实例
    public CommonStaff getCmnStf(int id) throws SQLException {
        Connection conn = DBUtil.getConn();

        String sql = "SELECT * FROM common_staff WHERE id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);

        ResultSet rs = pstm.executeQuery();
        CommonStaff cmnStf = new CommonStaff();
        /*取值*/
        while (rs.next()) {
            cmnStf.setId(rs.getInt("id"));
            cmnStf.setTruthName(rs.getString("truth_name"));
            cmnStf.setSex(rs.getString("sex"));
            cmnStf.setEmail(rs.getString("email"));
            cmnStf.setMobile(rs.getString("mobile"));
        }

        return cmnStf;
    }

    //查-获取多个实例
    public ArrayList<CommonStaff> listCmnStf() throws SQLException {
        Connection conn = DBUtil.getConn();

        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM common_staff");
        /*取值*/
        CommonStaff cmnStf;
        ArrayList<CommonStaff> listCmnStfs = new ArrayList<>();
        while (rs.next()) {
            cmnStf = new CommonStaff();
            cmnStf.setId(rs.getInt("id"));
            cmnStf.setTruthName(rs.getString("truth_name"));
            cmnStf.setSex(rs.getString("sex"));
            cmnStf.setEmail(rs.getString("email"));
            cmnStf.setMobile(rs.getString("mobile"));

            listCmnStfs.add(cmnStf);
        }

        return listCmnStfs;
    }

    //改
    public void updateInfoOfCmnStf(CommonStaff cmnStf) throws SQLException {
        Connection conn = DBUtil.getConn();

        String sql = "UPDATE common_staff SET truth_name = ? , sex = ?, " +
                " email = ? , mobile = ? WHERE id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);

        /*填充sql语句*/
        pstm.setString(1,cmnStf.getTruthName());
        pstm.setString(2,cmnStf.getSex());
        pstm.setString(3,cmnStf.getEmail());
        pstm.setString(4,cmnStf.getMobile());
        pstm.setInt(5,cmnStf.getId());

        pstm.execute();
    }
}

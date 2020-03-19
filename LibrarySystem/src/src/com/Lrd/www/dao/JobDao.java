package src.com.Lrd.www.dao;


import src.com.Lrd.www.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

/**
 * @date 2020/2/23-10:48
 */
public class JobDao {

    public String getJobName(int id) throws SQLException {
        Connection conn = DBUtil.getConn();
        String name = null;

        String sql = "SELECT  job_name FROM job_name WHERE id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            name = rs.getString("job_name");
        }

        return name;
    }

    /*通过对应string寻找job对应的id号*/
    public int findJobId(String job) throws SQLException {
        AllDao ad = AllDao.getAd();
        int id = ad.findId("job_name","job_name","\'"+job+"\'");
        return id;
    }

    public ArrayList<String> listJobName() throws SQLException{
        Connection conn = DBUtil.getConn();
        ArrayList<String> jobNames = new ArrayList<>();
        String name = null;

        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT  job_name FROM job_name");

        while (rs.next()) {
            name = rs.getString("job_name");
            jobNames.add(name);
        }

        return jobNames;
    }
}

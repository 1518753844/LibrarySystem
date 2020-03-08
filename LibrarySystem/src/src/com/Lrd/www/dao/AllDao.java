package src.com.Lrd.www.dao;


import src.com.Lrd.www.util.DBUtil;

import java.sql.*;

/**
 * @date 2020/2/20-15:35
 */
public class AllDao {

    private static final AllDao ad = new AllDao();

    private AllDao() {}

    public static AllDao getAd() {
        return ad;
    }

    /*
    功能：获取到某些表内连接表的对应值
    参数：查询的列名,被查询的表名，值对应列名，值
    返回值：对应的id
    */
    public int findIntValue(String content,String beFoundedTbName,String colName,Object value) throws SQLException {
        Connection conn = DBUtil.getConn();

        /*设置并执行sql语句*/
        String sql = "SELECT " + content + " FROM " + beFoundedTbName +
                " WHERE " + colName + " = "  + value;

        PreparedStatement psmt = conn.prepareStatement(sql);
        ResultSet rs = psmt.executeQuery();
        int returnValue = 0;

        //取值
        while (rs.next())
            returnValue = rs.getInt(content);

        return returnValue;
    }

    /*
    功能：判断某表中某字段的记录是否存在（通过count函数来判断 返回 1为存在 0为不存在））
    参数：表名，列名，值
    返回值：存在为true否则为false
    */
    public boolean judgeExistence(String tbName,String colName ,Object value) throws SQLException {
        Connection conn = DBUtil.getConn();

        /*用count函数数在某个表里是否存在id，存在的话应该为1*/
        int count = findIntValue("COUNT(id)",tbName,colName,value);

        if (count == 0)
            return false;
        else
            return true;
    }

    /*
    功能：寻找某表内连接表对应内容的id
    参数：表名，列名，值
    返回值：id
     */
    public int findId(String tbName,String colName ,Object value) throws SQLException {
        Connection conn = DBUtil.getConn();

        int id = findIntValue("id",tbName,colName,value);

        return id;
    }
    /*
    功能：删除成员
    参数：表名，id
     */
    public void deleteById(String tbName, int id) throws SQLException {
        Connection conn = DBUtil.getConn();

        String sql = "DELETE FROM " + tbName + " WHERE id = " + id;
        Statement stm = conn.createStatement();

        stm.execute(sql);
    }

    //想试着弄个数据框架，但是有些要用到连接，所以这个方法并没有用到
//    public void updateInfo(ArrayList<HashMap<String, Object>> sqlValues, String tbName, int id) throws SQLException {
//        Connection conn = DBUtil.getConn();
//
//        StringBuilder sql = new StringBuilder("UPDATE " + tbName + " SET ");
//
//        for (int i = 0; i < sqlValues.size(); i++) {
//            /*通过hash表来填入对应的列名和内容*/
//            sql.append(" " + sqlValues.get(i).get("name") + " = " + sqlValues.get(i).get("value"));
//
//            if (i != sqlValues.size() - 1)
//                sql.append(", ");
//            else
//                sql.append("WHERE id = " + id);
//        }
//        PreparedStatement pstm = conn.prepareStatement(sql.toString());
//        pstm.execute();
//    }

}

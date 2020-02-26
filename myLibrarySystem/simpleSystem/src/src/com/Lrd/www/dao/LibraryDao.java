package src.com.Lrd.www.dao;


import src.com.Lrd.www.bean.Library;
import src.com.Lrd.www.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

/**
 * @date 2020/2/21-11:32
 */
public class LibraryDao {

    //增
    public void addLibrary(Library library) throws SQLException {
        Connection conn = DBUtil.getConn();
        /*设置sql语句模板*/
        String sql = "INSERT library set id = ?, library_name = ?, " +
                "curator_id = (SELECT id FROM curator WHERE truth_name = ?), " +
                " address = ? ";
        PreparedStatement pstm = conn.prepareStatement(sql);

        /*填充sql语句*/
        pstm.setInt(1,library.getId());
        pstm.setString(2,library.getLibraryName());
        pstm.setString(3,library.getCurator());
        pstm.setString(4,library.getAddress());

        pstm.execute();
    }

    //删除（单例组合）
    public void deleteLibrary(int id) throws SQLException{
        AllDao ad = AllDao.getAd();
        ad.deleteById("Library",id);
    }

    //查-获取一个实例
    public Library getLibrary(String colName,Object value) throws SQLException {
        Connection conn = DBUtil.getConn();

        String sql = "SELECT l.id, library_name, truth_name, address FROM library AS l " +
            "INNER JOIN curator AS c ON  c.id = l.curator_id " + colName + "=" + value;
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        Library library = new Library();

        while (rs.next()) {
            library.setId(rs.getInt("id"));
            library.setLibraryName(rs.getString("library_name"));
            library.setCurator(rs.getString("truth_name"));
            library.setAddress(rs.getString("address"));
        }

        return library;
    }




    //查-获取多个实例
    public ArrayList<Library> listLibrary() throws SQLException {
        Connection conn = DBUtil.getConn();

        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT l.id, library_name, truth_name, address FROM library AS l " +
                " INNER JOIN curator AS c ON  c.id = l.curator_id");

        Library library;
        ArrayList<Library> listLibrary = new ArrayList<>();
        while (rs.next()) {
            library = new Library();
            library.setId(rs.getInt("id"));
            library.setLibraryName(rs.getString("library_name"));
            library.setCurator(rs.getString("truth_name"));
            library.setAddress(rs.getString("address"));

            listLibrary.add(library);
        }

        return listLibrary;
    }

    //改
    public void updateInfoOfLibrary(Library library) throws SQLException {
        Connection conn = DBUtil.getConn();

        String sql = "UPDATE library SET  library_name = ?, " +
                " curator_id =  (SELECT id FROM curator WHERE truth_name = ?)," +
                " address = ? WHERE id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);

        /*填充sql语句*/
        pstm.setString(1,library.getLibraryName());
        pstm.setString(2,library.getCurator());
        pstm.setString(3,library.getAddress());
        pstm.setInt(4,library.getId());

        pstm.execute();
    }

}

package src.com.Lrd.www.dao;


import src.com.Lrd.www.bean.Book;
import src.com.Lrd.www.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

/**
 * @date 2020/2/21-10:54
 */
public class BookDao {
    //增
    public void addBook(Book book) throws SQLException {
        Connection conn = DBUtil.getConn();
        /*设置sql语句模板*/
        String sql = "INSERT book set id = ?, book_name = ?, ISBN = ?, " +
            " cate_id = (SELECT id FROM book_cate WHERE cate_name = ?), remaining_qty = ?, "
                +"lend_out_qty = ?, price = ?, author = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);

        /*填充sql语句*/
        pstm.setInt(1,book.getId());
        pstm.setString(2,book.getBookName());
        pstm.setString(3,book.getISBN());
        pstm.setString(4,book.getBookCate());
        pstm.setInt(5,book.getRemainingQuantity());
        pstm.setInt(6,book.getLendOutQty());
        pstm.setDouble(7,book.getPrice());
        pstm.setString(8,book.getAuthor());

        pstm.execute();
    }

    //删除（单例组合）
    public void deleteBook(int id) throws SQLException{
        AllDao ad = AllDao.getAd();
        ad.deleteById("book",id);
    }

    //查-获取一个实例
    public Book getBook(String colName, Object value) throws SQLException {
        Connection conn = DBUtil.getConn();

        String sql = "SELECT b.id, book_name, ISBN, cate_name, remaining_qty, " +
            "lend_out_qty, price, author FROM book AS b" +
                " INNER JOIN book_cate bc on b.cate_id = bc.id WHERE " + colName + " = " + value;
        Statement stm = conn.createStatement();

        ResultSet rs = stm.executeQuery(sql);
        Book book = new Book();

        while (rs.next()) {
            book.setId(rs.getInt("id"));
            book.setBookName(rs.getString("book_name"));
            book.setISBN(rs.getString("ISBN"));
            book.setBookCate(rs.getString("cate_name"));
            book.setRemainingQuantity(rs.getInt("remaining_qty"));
            book.setLendOutQty(rs.getInt("lend_out_qty"));
            book.setPrice(rs.getDouble("price"));
            book.setAuthor(rs.getString("author"));
        }

        return book;
    }

    //查-获取多个实例
    public ArrayList<Book> listBook() throws SQLException {
        Connection conn = DBUtil.getConn();

        String sql = "SELECT b.id, book_name, ISBN, cate_name, remaining_qty, " +
            "lend_out_qty, price, author FROM book AS b" +
                " INNER JOIN book_cate bc on b.cate_id = bc.id";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        Book book;
        ArrayList<Book> books = new ArrayList<>();
        while (rs.next()) {
            book = new Book();
            book.setId(rs.getInt("id"));
            book.setBookName(rs.getString("book_name"));
            book.setISBN(rs.getString("ISBN"));
            book.setBookCate(rs.getString("cate_name"));
            book.setRemainingQuantity(rs.getInt("remaining_qty"));
            book.setLendOutQty(rs.getInt("lend_out_qty"));
            book.setPrice(rs.getDouble("price"));
            book.setAuthor(rs.getString("author"));

            books.add(book);
        }

        return books;
    }

    //改
    public void updateInfoOfBook(Book book) throws SQLException {
        Connection conn = DBUtil.getConn();

        String sql = "UPDATE book set book_name = ?, ISBN = ?, " +
                "cate_id = (SELECT id FROM book_cate WHERE cate_name = ?), remaining_qty = ?," +
                " lend_out_qty = ?, price = ?, author = ? WHERE id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);

        /*填充sql语句*/
        pstm.setString(1,book.getBookName());
        pstm.setString(2,book.getISBN());
        pstm.setString(3,book.getBookCate());
        pstm.setInt(4,book.getRemainingQuantity());
        pstm.setInt(5,book.getLendOutQty());
        pstm.setDouble(6,book.getPrice());
        pstm.setString(7,book.getAuthor());
        pstm.setInt(8,book.getId());

        pstm.execute();
    }

}


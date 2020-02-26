package src.com.Lrd.www.service;

import src.com.Lrd.www.bean.Book;
import src.com.Lrd.www.dao.BookDao;

import java.sql.SQLException;

/**
 * @date 2020/2/25-17:51
 */
public class BookService {

    //查书 -通过id或书名
    public Book get(String value) throws SQLException {
        BookDao bd = new BookDao();

        boolean flag = false;
        char[] cs = value.toCharArray();
        for (char c : cs) {
            if ((!Character.isDigit(c)))
                flag = true;
        }

        if (flag)
            return bd.getBook("b.book_name",'\''+value+'\'');
        else //全为数字去找id
            return bd.getBook("b.id",value);
    }

    //改
    public void update(Book b) throws SQLException {
        BookDao bd = new BookDao();

        bd.updateInfoOfBook(b);
    }

}

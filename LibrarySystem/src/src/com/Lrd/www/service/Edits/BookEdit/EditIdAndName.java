package src.com.Lrd.www.service.Edits.BookEdit;

import src.com.Lrd.www.bean.Book;
import src.com.Lrd.www.service.BookService;
import src.com.Lrd.www.service.CheckException;

import java.sql.SQLException;

/**
 * @date 2020/2/25-18:10
 */

/*
功能：判断书本id的内容输入的合理性，并获取该书本对象，进行下一步具体操作
属性：
    nowProcess 通过id或书名获取Book对象
    EditBook eb ：通过对第一个外面这个类的操作后，将结果给到这个对象中的nowProcess并在view中输出
函数：
    void work() 判断输入内容和设置书籍对象的所有属性
 */
public class EditIdAndName implements EditBook{
    private final String nowProcess = "请输入书籍名称或id号：\n";
    private EditBook eb = null;   //这个是在第一次输入后，新出现的一个类，它要随着书籍的信息来改变自己的属性

    @Override
    public void work(String content, Book b) throws CheckException, SQLException {
        BookService bs = new BookService();
        Book book = bs.get(content);

        if (book.getId() == 0)
            throw new CheckException("未有匹配的书籍信息");


        //todo book若加了属性要在这里注意
        b.setId(book.getId());
        b.setLendOutQty(book.getLendOutQty());
        b.setRemainingQuantity(book.getRemainingQuantity());
        b.setAuthor(book.getAuthor());
        b.setBookCate(book.getBookCate());
        b.setBookName(book.getBookName());
        b.setPrice(book.getPrice());
        b.setISBN(book.getISBN());
        eb.setNowProcess(book + "\n" + eb.getNowProcess());  //对下一个内容进行更改 将查询到的内容放入下一个edit的nowProcess中
    }


    @Override
    public String getNowProcess() {
        return nowProcess;
    }

    @Override
    public void setNowProcess(String nowProcess) {
    }

    public EditBook getEb() {
        return eb;
    }

    public void setEb(EditBook eb) {
        this.eb = eb;
    }
}

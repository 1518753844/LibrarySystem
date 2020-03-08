package src.com.Lrd.www.view.eachView.cmnStfView;

import src.com.Lrd.www.bean.Book;
import src.com.Lrd.www.service.BookService;
import src.com.Lrd.www.service.CheckException;
import src.com.Lrd.www.service.Edits.BookEdit.EditBook;
import src.com.Lrd.www.service.Edits.BookEdit.EditIdAndName;
import src.com.Lrd.www.view.ViewI;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * @date 2020/2/25-16:20
 */

/*
    功能：更新书本的存有量或借出量（两者共同之处很多只有对应的edit不同）
    属性：
        hint：提示输出
        matchHint：匹配输出的东西（这两个在构造函数进行赋值）
        EditIdAndName 类型的对象是View的实际体且该类型里面还有一个EditBook这个对应不同的内容就要进行不同的设置
        （首先执行外部的EditIdAndName里的work，得到的结果影响对象里的一个EditBook，再执行这个EditBook的相关操作）
        ArrayList<EditBook> editBooks是将editIdAndName这个对象和这个对象里的EditBook类放入其中
    函数：view():实现各自的view
 */
public class UpdateBookView implements ViewI {
    private String hint = "";
    private String matchHint = "";

    private EditIdAndName editIdAndName = new EditIdAndName();
    private ArrayList<EditBook> editBooks = new ArrayList<>();

    public UpdateBookView(String hint, String matchHint) {
        this.hint = hint;
        this.matchHint = matchHint;
    }
    @Override
    public void view() {
        Scanner in = new Scanner(System.in);

        BookService bs = new BookService();
        Book b = new Book();

        for (int i = 0; i < editBooks.size(); i++) {
            EditBook eb = editBooks.get(i);
            System.out.print(eb.getNowProcess());//输出提示
            String content = in.next();//输入
            try {
                eb.work(content,b);//执行
            } catch (CheckException e) {
                if (!(e.getConcreteException().isEmpty()))
                    System.out.println("--------" + e.getConcreteException() + "--------");
                i--;//若有报错，则回到上一个EditBook对象
            } catch (SQLException e) {
                System.out.println("系统出错，正在退出...");
                e.printStackTrace();
                exit(0);
            }
        }


        try {
            bs.update(b);//修改
            System.out.println("修改成功");
            System.out.println("---------------------------------------------");
        } catch (SQLException e) {
            System.out.println("更新错误...");
            e.printStackTrace();
        }
    }

    @Override
    public String getHint() {
        return hint;
    }



    @Override
    public String getMatchHint() {
        return matchHint;
    }

    public ArrayList<EditBook> getEditBooks() {
        return editBooks;
    }

    public EditIdAndName getEditIdAndName() {
        return editIdAndName;
    }
}

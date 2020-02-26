package src.com.Lrd.www.service.Edits.BookEdit;


import src.com.Lrd.www.bean.Book;
import src.com.Lrd.www.service.CheckException;

/**
 * @date 2020/2/24-11:05
 */

/*
功能：判断书本ISBN的内容输入的合理性，并进行更改
 */
public class EditISBN implements EditBook {

    private final String nowProcess = "请输入书籍的ISBN码:";


    @Override
    public void work(String content, Book b) throws CheckException {
        char[] cs = content.toCharArray();
        for (char c : cs) {
            if (!(Character.isDigit(c)) && c != '-') //排查isbn码的内容是否正确
                throw new CheckException("ISBN仅由字符'-'和数字组成(如：2-02-033598-0)");
        }

        if (content.length() >20)
            throw new CheckException("ISBN码输入内容长度过长");

        b.setISBN(content);
    }


    @Override
    public String getNowProcess() {
        return nowProcess;
    }

    @Override
    public void setNowProcess(String nowProcess) {

    }

}


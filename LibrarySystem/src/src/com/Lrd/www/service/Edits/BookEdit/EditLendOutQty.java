package src.com.Lrd.www.service.Edits.BookEdit;


import src.com.Lrd.www.bean.Book;
import src.com.Lrd.www.service.CheckException;

/**
 * @date 2020/2/24-11:26
 */
/*
功能：判断书本借出量内容输入的合理性，并进行更改
 */
public class EditLendOutQty implements EditBook {
    private String nowProcess = "请输入现图书馆存有的数量:";


    @Override
    public void work(String content, Book b) throws CheckException {
        char[] cs = content.toCharArray();
        for (char c : cs) {
            if (!(Character.isDigit(c)) || c == '.' || c == '-') //排除输入的数字为字母或是小数或是负数
                throw new CheckException("请正确输入正整数数字");
        }

        b.setLendOutQty(Integer.valueOf(content));
    }




    @Override
    public String getNowProcess() {
        return nowProcess;
    }

    @Override
    public void setNowProcess(String nowProcess) {
        this.nowProcess = nowProcess;

    }


}


package src.com.Lrd.www.service.Edits.BookEdit;

import src.com.Lrd.www.bean.Book;
import src.com.Lrd.www.service.CheckException;

import java.sql.SQLException;

/**
 * @date 2020/2/25-15:48
 */
/*
属性：
    nowProcess 是view层用来展示内容（以及获取信息并修改信息）
函数：
    work即时对应类主要作用部分如进行修改或设置
 */
public interface EditBook {
    String nowProcess = null;
    void work(String content, Book b) throws CheckException, SQLException;
    String getNowProcess();
    void setNowProcess(String nowProcess);
}

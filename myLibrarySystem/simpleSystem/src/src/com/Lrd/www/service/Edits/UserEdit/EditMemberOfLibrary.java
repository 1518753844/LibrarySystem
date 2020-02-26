package src.com.Lrd.www.service.Edits.UserEdit;

import src.com.Lrd.www.bean.Library;
import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.dao.LibraryDao;
import src.com.Lrd.www.service.CheckException;
import src.com.Lrd.www.service.Edits.Edit;
import src.com.Lrd.www.service.LibraryService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @date 2020/2/24-9:54
 */

/*
功能：判断用户所处图书馆的内容输入的合理性，并进行更改
 */
public class EditMemberOfLibrary implements Edit {
    private final StringBuilder nowProcess = new StringBuilder("系统现有图书馆有：");

    {
        LibraryDao ld = new LibraryDao();
        try {
            ArrayList<Library> ls = ld.listLibrary();
            for (Library l : ls) {
                nowProcess.append(" " + l.getLibraryName() + " ");
            }
            nowProcess.append("\n请输入您所处的图书馆:");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void work(String content, User u) throws CheckException, SQLException {
        LibraryService ls = new LibraryService();
        if (!(ls.judgeIfExistLibraryByName(content)))//检测
            throw new CheckException("不存在该图书馆");

        u.setMemberOfLibrary(content);
    }

    @Override
    public void work(String content, HashMap<String, Object> infoMap) throws CheckException, SQLException {

    }


    @Override
    public void work(String content) throws CheckException, SQLException {

    }
    @Override
    public String getNowProcess() {
        return nowProcess.toString();
    }


}

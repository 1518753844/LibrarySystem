package src.com.Lrd.www.service.Edits.UserEdit;


import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.dao.UserDao;
import src.com.Lrd.www.service.CheckException;
import src.com.Lrd.www.service.Edits.Edit;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * @date 2020/2/24-7:59
 */

/*
功能：判断User个人账号的内容输入的合理性，并进行更改
 */
public class EditUsername implements Edit {

    private final String nowProcess = "请输入账号：";

    @Override
    public void work(String content, User u) throws CheckException, SQLException {
        UserDao ud = new UserDao();

        if (content.length() < 4 || content.length() > 10)
            throw new CheckException("账号长度出错(注意长度在4-10之间)");

        if (ud.getUser("username",'\''+content+'\'').getId() != 0)
            throw new CheckException("已存在该账号，请重新输入：");
        u.setUsername(content);
    }

    @Override
    public void work(String content, HashMap<String, Object> infoMap) throws CheckException, SQLException {

    }

    @Override
    public void work(String content) throws CheckException, SQLException { }

    @Override
    public String getNowProcess() {
        return nowProcess;
    }


}

package src.com.Lrd.www.service.Edits.UserEdit;


import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.service.CheckException;
import src.com.Lrd.www.service.Edits.Edit;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * @date 2020/2/24-10:01
 */

/*
功能：判断User姓名的内容输入的合理性，并进行更改
 */
public class EditRealName implements Edit {
    private final String nowPress = "请输入姓名：";

    @Override
    public void work(String content) throws CheckException, SQLException {

    }

    @Override
    public void work(String content, User u) throws CheckException, SQLException {
        if (content.length() > 20)
            throw new CheckException("姓名内容输入过长");
        u.setRealName(content);
    }

    @Override
    public void work(String content, HashMap<String, Object> infoMap) throws CheckException, SQLException {

    }

    @Override
    public String getNowProcess() {
        return nowPress;
    }



}

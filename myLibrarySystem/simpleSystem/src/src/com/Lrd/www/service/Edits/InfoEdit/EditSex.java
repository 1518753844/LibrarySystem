package src.com.Lrd.www.service.Edits.InfoEdit;


import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.service.CheckException;
import src.com.Lrd.www.service.Edits.Edit;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * @date 2020/2/24-10:22
 */

/*
功能：判断性别的内容输入的合理性，并进行设置
 */
public class EditSex implements Edit {
    private final String nowProcess = "请输入性别:";

    @Override
    public void work(String content, HashMap<String, Object> infoMap) throws CheckException, SQLException {
        if (((!"男".equals(content))&&(!("女".equals(content)))))
            throw new CheckException("性别内容输入错误");

        infoMap.put("sex",content);
    }

    @Override
    public void work(String content, User u) throws CheckException, SQLException {

    }

    @Override
    public void work(String content) throws CheckException, SQLException {

    }

    @Override
    public String getNowProcess() {
        return nowProcess;
    }


}

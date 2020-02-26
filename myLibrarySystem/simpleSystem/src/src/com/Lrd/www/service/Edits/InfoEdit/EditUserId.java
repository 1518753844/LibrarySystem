package src.com.Lrd.www.service.Edits.InfoEdit;


import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.dao.AllDao;
import src.com.Lrd.www.service.CheckException;
import src.com.Lrd.www.service.Edits.Edit;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * @date 2020/2/24-11:50
 */

/*
功能：判断User的id的内容输入的合理性
 */
public class EditUserId implements Edit {

    private final String nowProcess = "请输入您的id号:";

    @Override
    public void work(String content) throws CheckException, SQLException {
        AllDao ad = AllDao.getAd();

        char[] cs = content.toCharArray();
        for (char c : cs) {
            if (!(Character.isDigit(c)))
                throw new CheckException("id内容输入错误(请输入数字)");
        }

        if (!ad.judgeExistence("user","id",content))  //检测
            throw new CheckException("未有匹配id的用户");
    }

    @Override
    public String getNowProcess() {
        return nowProcess;
    }


    @Override
    public void work(String content, User u) throws CheckException, SQLException { }

    @Override
    public void work(String content, HashMap<String, Object> infoMap) throws CheckException, SQLException { }
}

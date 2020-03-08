package src.com.Lrd.www.service.Edits.InfoEdit;


import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.dao.AllDao;
import src.com.Lrd.www.service.CheckException;
import src.com.Lrd.www.service.Edits.Edit;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * @date 2020/2/24-10:31
 */

/*
功能：判断手机号码的内容输入的合理性，并进行设置
 */
public class EditMobile implements Edit {
    private final String nowProcess = "请输入电话号码：";
    private String tbName = null;

    @Override
    public void work(String content, HashMap<String, Object> infoMap) throws CheckException, SQLException {
        AllDao ad = AllDao.getAd();
        if (content.length()>20)
            throw new CheckException("电话号码内容长度过长(长度应在20以内)");
        if (ad.judgeExistence(tbName,"mobile",'\''+content+'\'')) //检测
            throw new CheckException("电话号码已被使用");

        infoMap.put("mobile",content);
    }

    @Override
    public void work(String content, User u) throws CheckException, SQLException { }

    @Override
    public void work(String content) throws CheckException, SQLException { }


    @Override
    public String getNowProcess() {
        return nowProcess;
    }

    public void setTbName(String tbName) {
        this.tbName = tbName;
    }
}

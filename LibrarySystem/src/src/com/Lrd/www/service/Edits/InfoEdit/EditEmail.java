package src.com.Lrd.www.service.Edits.InfoEdit;

import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.dao.AllDao;
import src.com.Lrd.www.service.CheckException;
import src.com.Lrd.www.service.Edits.Edit;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * @date 2020/2/24-10:25
 */
/*
功能：判断个人邮箱的内容输入的合理性，并进行设置
 */
public class EditEmail implements Edit {
    private final String nowProcess = "请输入邮箱:";
    private String tbName = null;

    @Override
    public void work(String content, HashMap<String,Object> infoMap) throws CheckException, SQLException {
        AllDao ad = AllDao.getAd();

        if (content.length() > 20)
            throw new CheckException("邮箱内容长度过长(长度应在20以内)");
        if (ad.judgeExistence(tbName,"email",'\''+ content + '\''))
            throw new CheckException("邮箱已被使用");

        infoMap.put("email",content);
    }

    @Override
    public String getNowProcess() {
        return nowProcess;
    }


    public void setTbName(String tbName) {
        this.tbName = tbName;
    }


    @Override
    public void work(String content) throws CheckException, SQLException { }
    @Override
    public void work(String content, User u) throws CheckException, SQLException { }
}

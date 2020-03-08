package src.com.Lrd.www.service.Edits.InfoEdit;


import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.dao.JobDao;
import src.com.Lrd.www.service.CheckException;
import src.com.Lrd.www.service.Edits.Edit;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @date 2020/2/24-10:07
 */

/*
功能：判断职业输入内容的合理性，并进行设置
 */
public class EditJob implements Edit {

    private final StringBuilder nowProcess = new StringBuilder("现存可注册职业有：");
    private JobDao jd = new JobDao();
    {
        try {
            ArrayList<String> job = jd.listJobName();
            for (String s : job)
                if (!"馆长".equals(s)) //馆长不能注册所以不输出
                    nowProcess.append(s+" ");
            nowProcess.append("\n请输入您的职业:");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void work(String content, User u) throws CheckException, SQLException {

        if ("馆长".equals(content)) //馆长不可被注册
            throw new CheckException("该职业需工作人员添加，不可注册");

        if (jd.findJobId(content) == 0 )  //检测
            throw new CheckException("未有匹配的职业");

        u.setJob(content);
    }

    @Override
    public void work(String content) throws CheckException, SQLException {}
    @Override
    public void work(String content, HashMap<String, Object> infoMap) throws CheckException, SQLException {}

    @Override
    public String getNowProcess() {
        return nowProcess.toString();
    }

}

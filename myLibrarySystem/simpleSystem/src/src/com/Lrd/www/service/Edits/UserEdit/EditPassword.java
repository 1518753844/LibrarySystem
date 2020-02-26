package src.com.Lrd.www.service.Edits.UserEdit;


import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.service.CheckException;
import src.com.Lrd.www.service.Edits.Edit;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * @date 2020/2/24-8:14
 */

/*
功能：判断User个人密码的内容输入的合理性，并进行更改
属性：
    nowProcess 注册或修改信息时输入密码
    editTime 是进入该类的次数，每次进行的内容不同
    password是存储第一次输入的密码内容用于第二次进入该类的匹配
函数：
    void work()
        1.第一次输入密码后检测 检测完毕然后抛出异常在 view接收后再回到该类
        2.第二次输入密码检测是否相同 检测完毕后设置传入对象的属性
 */
public class EditPassword implements Edit {
    private String nowProcess = "请输入密码：";
    private int editTime = 1;
    private String password = null;


    @Override
    public void work(String content) throws CheckException, SQLException {}

    @Override
    public void work(String content, User u) throws CheckException, SQLException {
        if (editTime == 1) {
            password = content;
            if (content.length() < 4 || content.length() > 15) {
                throw new CheckException("密码长度出错(注意长度在4-15之间)");
            }
            nowProcess = "请再次输入密码：";
            editTime++;
            throw new CheckException("");
        }

        if (editTime == 2) {
            if (!(password.equals(content))) {
                password = null;
                editTime = 1;
                nowProcess = "请输入密码:";
                throw new CheckException("两次密码内容不同，请重新输入密码！");
            } else
                u.setPassword(content);
        }
    }

    @Override
    public void work(String content, HashMap<String, Object> infoMap) throws CheckException, SQLException {

    }


    @Override
    public String getNowProcess() {
        return nowProcess;
    }
}

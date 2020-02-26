package src.com.Lrd.www.service.Edits.CuratorEdits;

import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.dao.UserDao;
import src.com.Lrd.www.service.CheckException;
import src.com.Lrd.www.service.Edits.Edit;
import src.com.Lrd.www.service.Edits.InfoEdit.EditUserId;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * @date 2020/2/25-23:01
 */

/*
功能：馆长授权员工
属性：
    nowProcess 输入id和确认授权员工
    User u是通过id得到的对象
    User onlineUser是使用该系统的馆长user的对象（用来判断该员工和馆长同处一个图书馆）
    editTime 是进入该类的次数，每次进行的内容不同
函数：
    void work()
        1.先读入id然后寻找对应id对象并将该对象的信息内容通过异常处理传出该类
        2.再次回到该类函数进行确认授权
        注：id要检测的有1.全为数字，2.存在，3.与馆长图书管相符
 */
public class EditUserUnauthorized implements Edit {
    private String nowProcess = "请输入id:";
    private int editTime = 0;
    private User u;
    private User onlineUser;



    @Override
    public void work(String content) throws CheckException, SQLException {

        UserDao ud = new UserDao();
        EditUserId eui = new EditUserId();



        if (editTime == 1) {
            eui.work(content);//判断全为数字和存在性

            u = ud.getUser("id",Integer.valueOf(content));
            String staffLibrary = u.getMemberOfLibrary();
            String curatorLibrary = onlineUser.getMemberOfLibrary();

            if (!staffLibrary.equals(curatorLibrary))//判断是否是对应员工
                throw new CheckException("该员工不是您所在图书馆的员工");

            if (u.getOnCommission() == 1) {//判断是否已经授权
                    throw new CheckException("用户已授权");
            }
            //若上述都正确第一次进入该edit已经完成准备下一次edit的操作
            nowProcess = "请输入Y确认授权，N取消授权:";
            editTime++;
            throw new CheckException(u.toDiffString());

        }

        if (editTime == 2) {
            if ((!"Y".equals(content)) && (!("N".equals(content)))) {
                editTime = 1;
                throw new CheckException("请正确输入Y或N");
            }

            if ("Y".equals(content)) {
                u.setOnCommission(1);
                ud.updateInfo(u);
            } else
                editTime = 0;
        }
    }

    public void setOnLineUser(User onLineUser) {
        this.onlineUser = onlineUser;
    }
    @Override
    public String getNowProcess() {
        return nowProcess;
    }


    @Override
    public void work(String content, User u) throws CheckException, SQLException {}

    @Override
    public void work(String content, HashMap<String, Object> infoMap) throws CheckException, SQLException {}


}

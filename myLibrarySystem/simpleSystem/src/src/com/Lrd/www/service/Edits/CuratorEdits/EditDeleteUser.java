package src.com.Lrd.www.service.Edits.CuratorEdits;

import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.dao.UserDao;
import src.com.Lrd.www.service.CheckException;
import src.com.Lrd.www.service.Edits.Edit;
import src.com.Lrd.www.service.Edits.InfoEdit.EditUserId;
import src.com.Lrd.www.service.Service;
import src.com.Lrd.www.service.ServiceData;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * @date 2020/2/26-10:37
 */

/*
功能：馆长删除员工
属性：
    nowProcess 提示输入id和确认删除员工
    User u是通过id得到的对象
    User onlineUser是使用该系统的馆长user的对象（用来判断该员工和馆长同处一个图书馆）
    editTime 是进入该类的次数，每次进行的内容不同
函数：
    void work()
        1.先读入id然后寻找对应id对象并将该对象的信息内容通过异常处理传出该类
        2.再次回到该类函数进行确认删除
        注：id要检测的有1.全为数字，2.存在，3.与馆长图书管相符，4.非馆长id
 */
public class EditDeleteUser implements Edit {
    private String nowProcess = "请输入id:";
    private int editTime = 1;   //进入该类的work的次数
    private User u; //被删除者
    private User onlineUser = null; //馆长


    @Override
    public void work(String content) throws CheckException, SQLException {

        UserDao ud = new UserDao();
        EditUserId eui = new EditUserId();
        ServiceData sd = new ServiceData();
        HashMap<String, Service> serviceMap = sd.getSsMap();

        if (editTime == 1) {
            eui.work(content);//判断全为数字和存在性

            u = ud.getUser("id",Integer.valueOf(content));
            String staffLibrary = u.getMemberOfLibrary();
            String curatorLibrary = onlineUser.getMemberOfLibrary();

            if ("馆长".equals(u.getJob()))//判断其非馆长
                throw new CheckException("不可删除馆长信息");

            if (!staffLibrary.equals(curatorLibrary))//判断其是对应员工
                throw new CheckException("该员工不是您所在图书馆的员工");

            //若上述都正确第一次进入该edit已经完成准备下一次edit的操作
            nowProcess = "请输入Y确认删除，N取消删除:";
            editTime++;
            throw new CheckException(u.toDiffString());//用异常来输出员工内容

        }

        if (editTime == 2) {
            if ((!"Y".equals(content)) && (!("N".equals(content)))) {
                editTime = 1;
                throw new CheckException("请正确输入Y或N");
            }

            if ("Y".equals(content)) {
                ud.deleteUser(u.getId());   //删除员工在user的数据表里的信息
                serviceMap.get(u.getJob()).delete(u.getId());  //删除员工在对应职业数据表里的信息
            } else
                editTime = 0;
        }
    }

    public void setOnlineUser(User onlineUser) {
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

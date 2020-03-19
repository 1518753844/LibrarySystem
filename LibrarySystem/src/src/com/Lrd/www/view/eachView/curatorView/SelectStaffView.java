package src.com.Lrd.www.view.eachView.curatorView;

import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.service.UserService;
import src.com.Lrd.www.view.ViewI;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @date 2020/2/25-22:49
 */

//功能：展示所有员工user的基本信息
public class SelectStaffView implements ViewI {
    private final String hint = "[SHOW/S]展示:查看所有员工";
    private final String matchHint = "SHOW";
    @Override
    public void view() {
        UserService us = new UserService();
        try {
            ArrayList<User> users= us.listUser();
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.printf("%5s \t%15s \t%15s \t%15s \t%15s \t%5s\n","id","姓名","职业","用户名","所处图书馆","授权状态");
            System.out.println("----------------------------------------------------------------------------------------------------");
            for (User u : users) {
                if(!"馆长".equals(u.getJob())){
                    System.out.println(u);
                }
            }
        } catch (SQLException e) {
            System.out.println("信息系统出错");
            e.printStackTrace();
        }
            System.out.println("----------------------------------------------------------------------------------------------------");
    }

    @Override
    public String getHint() {
        return hint;
    }

    @Override
    public String getMatchHint() {
        return matchHint;
    }


}

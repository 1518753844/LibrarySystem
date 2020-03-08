package src.com.Lrd.www.view.MainView;


import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.service.CheckException;
import src.com.Lrd.www.service.UserService;
import src.com.Lrd.www.view.ViewI;
import src.com.Lrd.www.view.eachView.EachView;
import src.com.Lrd.www.view.eachView.cmnStfView.CmnStfView;
import src.com.Lrd.www.view.eachView.curatorView.CuratorView;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * @date 2020/2/24-14:55
 */
public class LoginView implements ViewI {

    private String hint = "[LOGIN/L]登录:登录用户";
    private String matchHint = "LOGIN";

    private User u;

    @Override
    //登录界面
    public void view() {
        Scanner in = new Scanner(System.in);
        UserService us = new UserService();
        boolean flag1 = true;
        String username = null;
        String password = null;
        //登录完毕后通过登录用户的职业在map中寻找匹配的view
        HashMap<String, EachView> EachViewMap = new HashMap<>();
        {
            //todo 新职员view的在此处添加
            EachViewMap.put("普通职员",new CmnStfView());
            EachViewMap.put("馆长",new CuratorView());
        }
        System.out.println("正在登录...");

        while (true) {
            if (flag1) {
                System.out.print("输入账号：");
                username = in.next();
            }
            System.out.print("输入密码：");
            password = in.next();

            try {
                u = us.login(username,password);//判断输入是否正确
                System.out.println("登录成功！");
                break;
            } catch (SQLException e) {
                System.out.println("系统操作失败！");
                e.printStackTrace();
            } catch (UserService.incorrectPassword incorrectPassword) {
                System.out.println("---密码输入错误，请重新输入密码---");    //密码错误账户就不用再输入了
                flag1 = false;
            } catch (CheckException e) {
                System.out.println(e.getConcreteException());     //账户不存在就都得重新输入
            }
        }
        if (u.getOnCommission() == 0) {
            System.out.println("您未授权，请及时上报授权，获得使用资格，谢谢。");
            exit(0);
        }
        //这是员工各自的view
        EachView ev = EachViewMap.get(u.getJob());
        ev.setUser(u);//传入user
        System.out.println("---------------------------------------------");
        System.out.println(ev.getNowView());
        ev.view();
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

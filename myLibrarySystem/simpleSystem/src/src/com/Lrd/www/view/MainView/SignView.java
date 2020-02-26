package src.com.Lrd.www.view.MainView;


import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.service.CheckException;
import src.com.Lrd.www.service.Edits.Edit;
import src.com.Lrd.www.service.Edits.InfoEdit.EditData;
import src.com.Lrd.www.service.Service;
import src.com.Lrd.www.service.ServiceData;
import src.com.Lrd.www.service.UserService;
import src.com.Lrd.www.view.ViewI;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * @date 2020/2/24-14:52
 */

/*功能：注册页面的实现（注册过程：User注册 -> 对应职业注册）
  属性：
        hint和matchHint是提示信息和匹配信息
        EditData 和 ServiceDate是获取User注册过程的信息和各个职业不同的service的数据
        editsOfUser即是User的注册过程的各个edit
        editsOfInfo即时各自职业注册过程的各个edit
        inputContents是装在职业注册过程中的信息，传入各自职业的service中进行建立新的对象再写入数据表中
        ssMap是各个职业对应的service
   函数：view()注册功能的实现
 */
public class SignView implements ViewI {

    //该view的提示信息和匹配信息
    private String hint = "[SIGN/S]注册:注册账户和完善信息";
    private String matchHint = "SIGN";


    //获取数据信息
    private EditData ed = new EditData();
    private ServiceData sd = new ServiceData();


    private ArrayList<Edit> editsOfUser = ed.getEditsOfUser();  //装有注册账户的操作集
    private HashMap<String,ArrayList<Edit>> editsOfInfo;  //装有完善信息的操作集
    private HashMap<String, Object> inputContents = new HashMap<>(); //装有输入的信息map
    private HashMap<String, Service> ssMap = sd.getSsMap();  //将完善的信息写入表的service

    //装入注册写入的信息

    @Override
    //注册界面
    public void view() {
        Scanner in = new Scanner(System.in);
        UserService us = new UserService();
        User u = new User();


        //账户注册逐步进行各种edit
        for (int i = 0; i < editsOfUser.size(); i++) {
            Edit r = editsOfUser.get(i);
            System.out.print(r.getNowProcess());
            String content = in.next();
            try {
                r.work(content, u);//顺序进行edit
            } catch (CheckException e) {
                if (!(e.getConcreteException().isEmpty()))
                    System.out.println("--------" + e.getConcreteException() + "--------");
                i--;
            } catch (SQLException e) {
                System.out.println("系统出错，正在退出...");
                e.printStackTrace();
                exit(0);
            }
        }

        //写入user数据表中
        try {
            us.add(u);
            System.out.println("账号注册成功，请继续完善您的信息...");
        } catch (SQLException e) {
            System.out.println("注册失败...");
            e.printStackTrace();
        }


        //完善信息过程
        String job = u.getJob();  //不同职业进行不同的完善信息操作
        editsOfInfo = ed.getEditsOfInfo(job);
        ArrayList<Edit> completeInfoEdits = editsOfInfo.get(job);
        try {
            u = us.get(u.getUsername());
        } catch (SQLException e) {
            System.out.println("系统出错，正在退出...");
            e.printStackTrace();
            exit(0);
        }

        //主要操作过程 逐个建立不同的edit
        for (int i = 0; i < completeInfoEdits.size(); i++) {
            Edit r = completeInfoEdits.get(i);
            System.out.print(r.getNowProcess());
            String content = in.next();
            try {
                r.work(content, inputContents);//顺序进行edit
            } catch (CheckException e) {
                if (!(e.getConcreteException().isEmpty()))
                    System.out.println("--------" + e.getConcreteException() + "--------");
                i--;
            } catch (SQLException e) {
                System.out.println("系统出错，正在退出...");
                e.printStackTrace();
                exit(0);
            }
        }

        //将id和姓名信息写入信息表中
        inputContents.put("id",u.getId());
        inputContents.put("realName",u.getRealName());

        //根据职业载入不同的数据表中
        try {
            ssMap.get(job).add(inputContents);
            System.out.println("注册成功，请及时上报授权获取使用资格！");
            exit(0);
        } catch (SQLException e) {
            System.out.println("系统出错，正在退出...");
            e.printStackTrace();
            exit(0);
        }
    }

    @Override
    public String getHint() {
        return hint;
    }

    @Override
    public String getMatchHint() {
        return matchHint;
    }


    public static void main(String[] args) {
        SignView sv = new SignView();
        sv.view();
    }
}



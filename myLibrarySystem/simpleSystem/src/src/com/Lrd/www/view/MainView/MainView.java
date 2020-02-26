package src.com.Lrd.www.view.MainView;


import src.com.Lrd.www.view.ExitView;
import src.com.Lrd.www.view.ViewI;
import src.com.Lrd.www.view.eachView.ViewSamePart;

import java.util.ArrayList;

/**
 * @date 2020/2/24-7:56
 */

//实现主界面的功能也是传入viewSamePart实现
public class MainView{
    private static ArrayList<ViewI> viewIList = new ArrayList<>();
    static {
        //todo 主界面要加view在这里加
        viewIList.add(new LoginView());
        viewIList.add(new SignView());
        viewIList.add(new ExitView());
    }

    public static void main(String[] args) {
        ViewSamePart vsp = new ViewSamePart();
        System.out.println("欢迎来到图书馆管理系统！");
        vsp.view(viewIList);
    }
}

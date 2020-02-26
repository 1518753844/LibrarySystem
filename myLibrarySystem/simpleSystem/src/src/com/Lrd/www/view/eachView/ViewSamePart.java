package src.com.Lrd.www.view.eachView;

import src.com.Lrd.www.view.ViewI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @date 2020/2/25-22:41
 */

//所有各自职业的view都是通过这个类的函数实现的，只需传入不同的viewList即可
public class ViewSamePart {

    public void view(ArrayList<ViewI> viewIList) {
        Scanner in = new Scanner(System.in);
        HashMap<String, ViewI> viewIMap = new HashMap<>();

        //为输入匹配view做数据准备
        for (ViewI vi : viewIList) {
            viewIMap.put(vi.getMatchHint(),vi);
            viewIMap.put(String.valueOf(vi.getMatchHint().charAt(0)),vi); //截取第一个字符
        }

        while (true) {

            //输出界面
            for (ViewI vi : viewIList) {
                System.out.println(vi.getHint());
             }

            ViewI v ;
            while ((v = viewIMap.get(in.next().toUpperCase())) == null)//输入且判断
                System.out.println("请正确输入主界面内容");

            //展示内容
            v.view();
        }

    }
}

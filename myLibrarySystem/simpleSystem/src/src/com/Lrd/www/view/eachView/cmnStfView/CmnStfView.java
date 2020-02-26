package src.com.Lrd.www.view.eachView.cmnStfView;

import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.service.Edits.BookEdit.EditBookRemainingQty;
import src.com.Lrd.www.service.Edits.BookEdit.EditLendOutQty;
import src.com.Lrd.www.view.ExitView;
import src.com.Lrd.www.view.ViewI;
import src.com.Lrd.www.view.eachView.EachView;
import src.com.Lrd.www.view.eachView.ViewSamePart;

import java.util.ArrayList;

/**
 * @date 2020/2/25-16:12
 */

/*
    普通职员的view类
    功能：
        更新书本余留量和借出量
    属性：nowView 普通职员进入该view的时候输出的内容
          UpdateBookView的 uRemain 是设置余留量的view(设置UpdateBookView里的EditBook类对象为EditRemainingQty)
          UpdateBookView的 uLendOut 是设置借出量的view(设置UpdateBookView里的EditBook类对象为EditLendOutQty)
          viewIList 是装普通员工的所有功能的view 并通过viewSamePart在view函数实现普通职员的view
 */
public class CmnStfView implements EachView {
    private final String nowView = "欢迎来到普通职员图书管理系统！\n";
    private User OnlineUser = null;

    private UpdateBookView uRemain  = new UpdateBookView("[REMAIN/R]更新:书本余留量","REMAIN");
    private UpdateBookView uLendOut = new UpdateBookView("[LENDOUT/L]更新:书本借出量","LENDOUT");
    //借出量和余留量界面的数据准备
    {
        //更改获取量
        uRemain.getEditBooks().add(uRemain.getEditIdAndName());
        uRemain.getEditIdAndName().setEb(new EditBookRemainingQty());
        uRemain.getEditBooks().add(uRemain.getEditIdAndName().getEb());

        //更改借出量
        uLendOut.getEditBooks().add(uRemain.getEditIdAndName());
        uLendOut.getEditIdAndName().setEb(new EditLendOutQty());
        uLendOut.getEditBooks().add(uRemain.getEditIdAndName().getEb());
    }
    private ArrayList<ViewI> viewIList = new ArrayList<>();
    {
        //todo 普通员工界面的功能添加
        viewIList.add(new ExitView());
        viewIList.add(uRemain);
        viewIList.add(uLendOut);
    }


    @Override
    public void view() {
        ViewSamePart vsp = new ViewSamePart();
        vsp.view(viewIList);
    }

    @Override
    public String getNowView() {
        return nowView;
    }

    @Override
    public void setUser(User u) {
        OnlineUser = u;
    }

    public ArrayList<ViewI> getViewIList() {
        return viewIList;
    }

}

package src.com.Lrd.www.view.eachView.curatorView;

import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.service.Edits.CuratorEdits.EditDeleteUser;
import src.com.Lrd.www.service.Edits.CuratorEdits.EditUserUnauthorized;
import src.com.Lrd.www.view.ViewI;
import src.com.Lrd.www.view.eachView.EachView;
import src.com.Lrd.www.view.eachView.ViewSamePart;
import src.com.Lrd.www.view.eachView.cmnStfView.CmnStfView;

import java.util.ArrayList;

/**
 * @date 2020/2/25-22:45
 */
public class CuratorView implements EachView {
    private String nowView = "欢迎来到馆长所属图书馆管理系统！\n";
    private User onLineUser = null;
    @Override
    public void view() {
        //todo 馆长界面的功能添加
        CmnStfView csv = new CmnStfView();
        ArrayList<ViewI> viewIList = csv.getViewIList();//获取普通员工的view

        //数据准备 将授权的view和删除员工的view
        CuratorSameView authorizeView = new CuratorSameView("[AUTHORIZE/A]授权:授予员工使用系统权力","AUTHORIZE");
        CuratorSameView deleteView = new CuratorSameView("[DELETE/D]删除:删除员工信息","DELETE");

        //设置好并通存入viewList并传给ViewSamePart实现馆长的view
        EditUserUnauthorized euu = new EditUserUnauthorized();
        euu.setOnLineUser(onLineUser);//将馆长对应的User传入对象中
        EditDeleteUser edu = new EditDeleteUser();
        edu.setOnlineUser(onLineUser);

        //设置view中实际操作的edit
        authorizeView.setEdit(euu);
        deleteView.setEdit(edu);

        //添加至容器
        viewIList.add(new SelectStaffView());
        viewIList.add(authorizeView);
        viewIList.add(deleteView);

        //实现
        ViewSamePart vsp = new ViewSamePart();
        vsp.view(viewIList);
    }

    public String getNowView() {
        return nowView;
    }

    @Override
    public void setUser(User u) {
        onLineUser = u;
    }
}

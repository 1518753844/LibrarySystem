package src.com.Lrd.www.view.eachView;

import src.com.Lrd.www.bean.User;

/**
 * @date 2020/2/26-11:03
 */

/*
    该接口用于各个职业对应的管理界面
    nowView ：显示当下是哪个职业的界面
    view：展示主功能
    setUser：是为某些edit(如馆长的edit)提供登陆者信息
 */
public interface EachView {
    String nowView = null;
    public void view();
    String getNowView();
    void setUser(User u);
}

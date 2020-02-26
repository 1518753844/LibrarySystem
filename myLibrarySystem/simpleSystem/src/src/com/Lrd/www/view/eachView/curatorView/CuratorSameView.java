package src.com.Lrd.www.view.eachView.curatorView;

import src.com.Lrd.www.service.CheckException;
import src.com.Lrd.www.service.Edits.Edit;
import src.com.Lrd.www.view.ViewI;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @date 2020/2/26-8:46
 */

/*
    功能：实现馆长的删除员工和授权员工的操作
 */
public class CuratorSameView implements ViewI {
    private String hint = "";
    private String matchHint = "";
    private Edit edit = null;

    public CuratorSameView(String hint, String matchHint) {
        this.hint = hint;
        this.matchHint = matchHint;
    }

    @Override
    public void view() {
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                System.out.print(edit.getNowProcess());  //提示输出
                edit.work(in.next());        //进行判断
                break;
            } catch (CheckException e) {
                System.out.println("------"+e.getConcreteException()+"------");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("操作完毕！");

    }

    @Override
    public String getHint() {
        return hint;
    }

    @Override
    public String getMatchHint() {
        return matchHint;
    }

    public void setEdit(Edit edit) {
        this.edit = edit;
    }
}

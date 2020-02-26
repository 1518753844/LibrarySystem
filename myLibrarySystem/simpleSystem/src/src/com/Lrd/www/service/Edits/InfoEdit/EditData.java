package src.com.Lrd.www.service.Edits.InfoEdit;


import src.com.Lrd.www.service.Edits.Edit;
import src.com.Lrd.www.service.Edits.UserEdit.EditMemberOfLibrary;
import src.com.Lrd.www.service.Edits.UserEdit.EditPassword;
import src.com.Lrd.www.service.Edits.UserEdit.EditRealName;
import src.com.Lrd.www.service.Edits.UserEdit.EditUsername;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @date 2020/2/24-11:40
 */

//功能：为注册提供数据 注册分为User注册和对应职业注册
public class EditData {
    private ArrayList<Edit> editsOfUser = new ArrayList<Edit>();  //装有注册账户的edit
    private HashMap<String,ArrayList<Edit>> editsOfInfo = new HashMap<>();  //装有完善信息的edit

    private HashMap<String,String> tbNames = new HashMap<>();  //职业对应的表名
    private String tbName = null; //该表名是用于输入email和mobile的时候查重


    //基本用户信息的操作集
    {
        //TODO user要添加属性就在这里加
        editsOfUser.add(new EditUsername());//账号
        editsOfUser.add(new EditPassword());//密码
        editsOfUser.add(new EditRealName());//真实姓名
        editsOfUser.add(new EditMemberOfLibrary());//所处图书馆
        editsOfUser.add(new EditJob());//职位
    }

    //完善信息里的操作集
    public void setEditsOfUser()
    {
        ArrayList<Edit> edits = new ArrayList<>();  //后续装入hashmap里的edit

        //todo 普通职员，总管理员的注册内容添加处在这
        EditEmail editEmail = new EditEmail();
        editEmail.setTbName(tbName);
        EditMobile editMobile = new EditMobile();
        editMobile.setTbName(tbName);

        edits.add(new EditSex());
        edits.add(editEmail);
        edits.add(editMobile);

        editsOfInfo.put("普通职员",edits);
        editsOfInfo.put("总管理员",edits);

        //新增职业的往后new一个 再添加到hashMap里
    }

    //职业对应的表名
    {
        //todo 新增职业和表要注意在这里加好
        tbNames.put("普通职员","common_staff");
        tbNames.put("馆长","curator");
    }


    public ArrayList<Edit> getEditsOfUser() {
        return editsOfUser;
    }

    public HashMap<String, ArrayList<Edit>> getEditsOfInfo(String job) {
        tbName = tbNames.get(job);
        setEditsOfUser();
        return editsOfInfo;
    }
}

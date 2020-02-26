package src.com.Lrd.www.service.Edits;

import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.service.CheckException;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * @date 2020/2/24-7:57
 */

/*
    nowProcess 是用与view层显示内容
    void work(String content, User u) 是用于注册user的
    void work(String content, HashMap<String,Object> infoMap) 是用于不同职业注册的（先将信息写入表，再到add中去创建新对象再添加）
    void work(String content) 是用于简单查询操作的
 */
public interface Edit {

    String nowProcess =null;
    void work(String content, User u) throws CheckException, SQLException;
    void work(String content, HashMap<String,Object> infoMap) throws CheckException, SQLException;
    void work(String content)  throws CheckException, SQLException;
    String getNowProcess();
}

package src.com.Lrd.www.service;


import src.com.Lrd.www.bean.User;
import src.com.Lrd.www.dao.UserDao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @date 2020/2/22-7:17
 */
public class UserService {


    /*增*/
    public void add(User u) throws SQLException {
        UserDao ud = new UserDao();
        ud.addUser(u);

    }

    /*通过账户名获取账户*/
    public User get(String username) throws SQLException {
        UserDao ud = new UserDao();
        User u = ud.getUser("username",'\''+username+'\'');

        return u;
    }

    public User get(int id) throws SQLException {
        UserDao ud = new UserDao();
        User u = ud.getUser("id",id);

        return u;
    }

    /*列出所有user*/
    public ArrayList<User> listUser() throws SQLException {
        UserDao ud = new UserDao();
        return ud.listUser();
    }

    /*
    功能：实现登录
    参数：账户密码
    返回值：返回一个user对象
     */
    public User login(String username,String password) throws SQLException, incorrectPassword, CheckException {
        User u = get(username);

        //无对应账号情况
        if (u.getId() == 0)
            throw new CheckException("账号不存在，请重新输入账号和密码");

        //密码不正确情况
        if (!(u.getPassword().equals(password)))
            throw new incorrectPassword();
        else
            return u;
    }

    //删
    public void deleteUser(int id) throws SQLException{
        UserDao ud = new UserDao();
        ud.deleteUser(id);
    }


    /*密码输入错误异常*/
    public class incorrectPassword extends Exception {
        public incorrectPassword() {}
    }



}

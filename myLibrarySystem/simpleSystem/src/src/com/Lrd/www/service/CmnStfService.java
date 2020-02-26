package src.com.Lrd.www.service;


import src.com.Lrd.www.bean.CommonStaff;
import src.com.Lrd.www.dao.CommonStaffDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @date 2020/2/23-9:56
 */
public class CmnStfService implements Service {

    //增
    @Override
    public void add(HashMap<String, Object> info) throws SQLException {
        CommonStaffDao cd = new CommonStaffDao();
        CommonStaff cs = new CommonStaff();

        cs.setSex((String) info.get("sex"));
        cs.setEmail((String) info.get("email"));
        cs.setMobile((String) info.get("mobile"));
        cs.setTruthName((String) info.get("realName"));
        cs.setId((int) info.get("id"));

        cd.addCmnStf(cs);
    }


    //删
    @Override
    public void delete(int id) throws SQLException {
        CommonStaffDao cd = new CommonStaffDao();
        cd.getCmnStf(id);
        cd.deleteCmnStf(id);
    }


    //查--所有成员
    public ArrayList<CommonStaff> listCmnStf() throws SQLException {
        ArrayList<CommonStaff> css = new ArrayList<>();
        CommonStaffDao cd = new CommonStaffDao();
        css = cd.listCmnStf();
        return css;
    }

    public void updateCmnStf(CommonStaff cs) throws SQLException {
        CommonStaffDao cd = new CommonStaffDao();
        cd.updateInfoOfCmnStf(cs);
    }
}

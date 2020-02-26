package src.com.Lrd.www.service;


import src.com.Lrd.www.bean.Library;
import src.com.Lrd.www.dao.AllDao;
import src.com.Lrd.www.dao.LibraryDao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @date 2020/2/22-16:37
 */
public class LibraryService {

    //增加图书馆
    public void add(Library library) throws SQLException {
        LibraryDao ld = new LibraryDao();
        ld.addLibrary(library);
    }

    //通过id判断对应的library是否存在
    public boolean judgeIfExistLibraryById(int id) throws SQLException{
        AllDao ad = AllDao.getAd();
        boolean flag = ad.judgeExistence("library","id",id);
        return flag;
    }

    //通过名字判断对应的library是否存在
    public boolean judgeIfExistLibraryByName(String name) throws SQLException{
        AllDao ad = AllDao.getAd();
        boolean flag = ad.judgeExistence("library","library_name",'\''+name+'\'');
        return flag;
    }


    //获取对应id的library
    public Library getLibrary(int id) throws SQLException {
        LibraryDao ld = new LibraryDao();
        Library l = ld.getLibrary("id",id);
        return l;
    }

    //获取对应名称的library
    public Library getLibrary(String id) throws SQLException {
        LibraryDao ld = new LibraryDao();
        Library l = ld.getLibrary("id",id);
        return l;
    }

    //获取所有的library
    public ArrayList<Library> listLibrary() throws SQLException {
        LibraryDao ld = new LibraryDao();
        ArrayList<Library> list = ld.listLibrary();
        return list;
    }

    //更新信息
    public void update(Library library) throws SQLException {
        LibraryDao ld = new LibraryDao();
        ld.updateInfoOfLibrary(library);
    }

}

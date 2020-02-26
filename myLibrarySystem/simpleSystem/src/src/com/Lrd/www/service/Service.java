package src.com.Lrd.www.service;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * @date 2020/2/25-10:52
 */


public interface Service {
    void add(HashMap<String,Object> info) throws SQLException;
    void delete(int id) throws SQLException;
}

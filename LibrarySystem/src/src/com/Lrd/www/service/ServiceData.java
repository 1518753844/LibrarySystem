package src.com.Lrd.www.service;

import java.util.HashMap;

/**
 * @date 2020/2/25-10:58
 */

/*
    功能：为某些类的增删查改提供数据
    职业对应->service
*/
public class ServiceData {
    private HashMap<String,Service> ssMap = new HashMap<>();
    {
        //TODO 注意今后新增职业要在这里加service
        ssMap.put("普通职员",new CmnStfService());
    }

    public HashMap<String, Service> getSsMap() {
        return ssMap;
    }
}

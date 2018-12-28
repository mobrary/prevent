package com.tlkj.gw.API;

import com.tlkj.db.DBResult;

import java.util.List;
import java.util.Map;

public interface IService<T> {

    public Integer Save(T vo, String cKeyID);

    public Integer DeleteItem(String cKeyID);

    public Integer DeleteList(String cKeyID);

    public T FindItem(String cKeyID);

    public List<T> getList(String cWhereParm);

    public DBResult Query(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize);

    public List<Map<String, Object>> getListAsMap(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize);
}

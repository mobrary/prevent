package com.tlkj.CommonUtils;

import java.util.List;
import java.util.Map;

public interface IDao<T> {
    public Integer AddNew(T vo);

    public Integer Update(T vo);

    public Integer DelItem(String cKeyID);

    public T FindOne(String cKeyID);

    public List<T> Query(String cWhereParm);

    public List<Map<String, Object>> QueryList();
}
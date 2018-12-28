package com.tlkj.db;

import java.util.List;
import java.util.Map;

public interface IDB {
    DBResult Query(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize);

    List<Map<String, Object>> QueryList(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize);
}
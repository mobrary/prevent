package com.tlkj.db;

import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.DbKit;
import com.tlkj.CommonUtils.AppConfig;
import com.tlkj.CommonUtils.StringEx;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbManager {
    private final static Logger log = Logger.getLogger(DbManager.class);

    public static Integer ExeSql(String sql) {
        return ExeSql(sql, null);
    }

    public static int ExeSql(String sql, Object[] objs) {
        List<String> sqls = new ArrayList<>(1);
        List<Object[]> ParmsList = new ArrayList<>(1);
        sqls.add(sql);
        ParmsList.add(objs);
        return ExeSql(sqls, ParmsList);
    }

    public static int ExeSql(List<String> sqlsList, List<Object[]> ParmsList) {
        IDB vSQLDB = getSQLDB();
        JDBBASE vDB = (JDBBASE) vSQLDB;
        return vDB.ExeSql(sqlsList, ParmsList);
    }

    public static List<Map<String, Object>> QueryList(String sql) {
        IDB vSQLDB = getSQLDB();
        JDBBASE vDB = (JDBBASE) vSQLDB;
        return vDB.QueryList(sql);
    }

    public static int ExeSql(List<String> sqls) {
        return ExeSql(sqls, null);
    }

    public static IDB getSQLDB() {
        String cDB_TYPE = PropKit.get("DB_TYPE");
        if (StringEx.isEmpty(cDB_TYPE)) {
            DBMySQL vDB = new DBMySQL();
            return vDB;
        } else if (cDB_TYPE.equals("SQLSERVER")) {
            DBSQLSERVER vDB = new DBSQLSERVER();
            return vDB;
        } else {
            DBMySQL vDB = new DBMySQL();
            return vDB;
        }
    }

    public static DBResult Query(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize) {
        IDB vSQLDB = getSQLDB();
        return vSQLDB.Query(cFileList, cTableName, cWhereParm, cOrderBy, iPageNo, iPageSize);
    }

    public static List<Map<String, Object>> QueryList(String cFileList, String cTableName, String cWhereParm, String cOrderBy) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT " + cFileList);
        sql.append(" FROM " + cTableName);
        if (!StringUtils.isEmpty(cWhereParm)) {
            sql.append(" WHERE  " + cWhereParm);
        }
        if (!StringUtils.isEmpty(cOrderBy)) {
            sql.append(" ORDER BY " + cOrderBy);
        }

        return QueryList(sql.toString());
    }


    public static List<Map<String, Object>> QueryList(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize) {
        IDB vSQLDB = getSQLDB();
        return vSQLDB.QueryList(cFileList, cTableName, cWhereParm, cOrderBy, iPageNo, iPageSize);
    }

    public static String getStrValue(String sql) {
        Object objValue = getValue(sql);
        return StringEx.getStr(objValue);
    }

    public static int getIntValue(String sql) {
        Object objValue = getValue(sql);
        return StringEx.getInt(objValue);
    }

    public static Object getValue(String sql) {
        List<Map<String, Object>> dtRows = QueryList(sql);
        Object objValue = null;
        if (dtRows != null && dtRows.size() > 0) {
            Map<String, Object> rowKey = dtRows.get(0);
            for (Object cKeyValue : rowKey.values()) {
                objValue = cKeyValue;
                break;
            }
        }
        return objValue;
    }


}
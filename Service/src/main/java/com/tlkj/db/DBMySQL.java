package com.tlkj.db;

import com.tlkj.CommonUtils.StringEx;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBMySQL extends JDBBASE implements IDB {
    private final static Logger log = Logger.getLogger(DBMySQL.class);


    public DBResult Query(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT count(1)");
        sql.append(" FROM " + cTableName);
        if (!StringUtils.isEmpty(cWhereParm)) {
            sql.append(" WHERE  " + cWhereParm);
        }

        int iRSCount = getIntValue(sql.toString());
        sql.setLength(0);
        sql.append(" SELECT " + cFileList);
        sql.append(" FROM " + cTableName);
        if (!StringUtils.isEmpty(cWhereParm)) {
            sql.append(" WHERE  " + cWhereParm);
        }
        if (!StringUtils.isEmpty(cOrderBy)) {
            sql.append(" ORDER BY " + cOrderBy);
        }

        List<Map<String, Object>> dtRows = QueryList(cFileList, cTableName, cWhereParm, cOrderBy, iPageNo, iPageSize);
        DBResult vResult = new DBResult();
        vResult.dtrows = dtRows;
        vResult.ROW_COUNT = iRSCount;
        return vResult;
    }


    public List<Map<String, Object>> QueryList(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT " + cFileList);
        sql.append(" FROM " + cTableName);
        if (!StringUtils.isEmpty(cWhereParm)) {
            sql.append(" WHERE  " + cWhereParm);
        }
        if (!StringUtils.isEmpty(cOrderBy)) {
            sql.append(" ORDER BY " + cOrderBy);
        }

        int iRowCount = StringEx.getInt(getStrValue(sql.toString()));
        int iPageCount = iRowCount / iPageSize;
        int iPageLeft = iRowCount % iPageSize;
        if (iPageLeft != 0) {
            iPageCount = iPageCount + 1;
        }
        if (iPageNo > iPageCount) {
            iPageNo = iPageCount;
        }
        if (iPageNo <= 0) {
            iPageNo = 1;
        }

        int iStart = (iPageNo - 1) * iPageSize;
        int iFinish = iPageNo * iPageSize;
        sql.append(" LIMIT  " + iStart + ", " + iPageSize);
        return QueryList(sql.toString());
    }

    public String getStrValue(String sql) {
        Object objValue = getValue(sql);
        return StringEx.getStr(objValue);
    }

    public int getIntValue(String sql) {
        Object objValue = getValue(sql);
        return StringEx.getInt(objValue);
    }

    public Object getValue(String sql) {
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

    public List<Map<String, Object>> QueryList(String sql) {
        log.debug("执行语句:" + sql);
        List<Map<String, Object>> dtRows = new ArrayList<Map<String, Object>>();
        Statement stmt = null;
        Connection Connect = null;
        ResultSet rs = null;
        ResultSetMetaData resultMeta = null;
        try {
            Connect = DbConnectionPool.Instance().getConnection();
            // 下面这段支持嵌套事务，可以忽略不看
            if (Connect != null) {
                stmt = Connect.createStatement();
                log.debug("DbManager.QueryList:" + sql);
                rs = stmt.executeQuery(sql);
                //纪录集字段数
                resultMeta = rs.getMetaData();//得到结果集的结构信息，比如字段名，字段数等
                int columns = resultMeta.getColumnCount(); //返回数据集的列数
                int i = 0;
                int rows = 0;
                dtRows.clear();
                while (rs.next()) {
                    Map<String, Object> rowKey = new HashMap<String, Object>();

                    for (i = 1; i <= columns; i++) {
                        String fieldName = new String(resultMeta.getColumnLabel(i));//得到每一列的列名
                        fieldName = fieldName.toLowerCase();
                        String fieldType = new String(resultMeta.getColumnTypeName(i));//得到每一列的类型
                        fieldType = fieldType.toLowerCase();

                        Object fieldValue = rs.getObject(i);//得到相应列的值
                        rowKey.put(fieldName, fieldValue);
                    }
                    dtRows.add(rowKey);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception ignore) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception ignore) {
                }
            }
            if (Connect != null) {
                try {
                    Connect.close();
                } catch (Exception ignore) {
                }
            }
            rs = null;
            stmt = null;
            Connect = null;
        }
        return dtRows;
    }
}
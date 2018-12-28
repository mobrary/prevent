package com.tlkj.db;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBBASE {
    private final static Logger log = Logger.getLogger(JDBBASE.class);
    public Connection Connect = null;

    public Connection getConnection() {
        if (Connect == null) {
            Connect = DbConnectionPool.Instance().getConnection();
        }
        return Connect;
    }

    public int ExeSql(List<String> sqlsList, List<Object[]> ParmsList) {
        int iEffect = 0;
        String sql = "";
        Object[] vps = null;
        Connection Connect = getConnection();
        try {
            Connect.setAutoCommit(false);
            for (int i = 0; i < sqlsList.size(); i++) {
                sql = sqlsList.get(i);
                if ((sql != null) && (sql.length() > 10)) {
                    vps = (ParmsList == null) ? null : ParmsList.get(i);
                    if (vps == null) {
                        Statement sment = Connect.createStatement();
                        iEffect = iEffect + sment.executeUpdate(sql);
                    } else {
                        PreparedStatement sment = Connect.prepareStatement(sql);
                        for (int k = 0; k < vps.length; k++) {
                            Object objValue = vps[k];
                            sment.setObject(k + 1, objValue);
                        }
                        iEffect = iEffect + sment.executeUpdate();
                    }
                }
            }
            Connect.commit();
            Connect.setAutoCommit(true);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            log.error("SQL:" + sql + "\n\r" + ex.getMessage());
            int iLength = (vps == null) ? 0 : vps.length;
            for (int i = 0; i < iLength; i++) {
                log.error("SQL.PARM.(" + (i) + "):" + vps[i].toString());
            }
            try {
                Connect.rollback();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        } finally {
            if (Connect != null)
                try {
                    Connect.close();
                    Connect = null;
                } catch (SQLException e) {
                }
        }
        return (iEffect);
    }

    public List<Map<String, Object>> QueryList(String sql) {
        List<Map<String, Object>> dtRows = new ArrayList<Map<String, Object>>();
        Statement stmt = null;
        Connection Connect = getConnection();
        ResultSet rs = null;
        ResultSetMetaData resultMeta = null;
        try {
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

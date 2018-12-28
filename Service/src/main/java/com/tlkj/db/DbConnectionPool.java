package com.tlkj.db;

import com.alibaba.druid.pool.DruidDataSource;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.tlkj.CommonUtils.DBType;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DbConnectionPool {
    private static Map<String, DruidDataSource> DSMap = null;
    private static Map<String, Boolean> DSFlag = null;
    private static String MASTER = "MASTER";
    private static String SLAVE = "SLAVE";

    private static DbConnectionPool instance = null;

    public static DbConnectionPool Instance() {
        if (instance == null)
            instance = new DbConnectionPool();
        return instance;
        //13653710091黄彦超
        //15039057575刘晨飞

    }

    private DbConnectionPool() {
        DSMap = new HashMap<String, DruidDataSource>();
        DSFlag = new HashMap<String, Boolean>();
    }

    public Connection getConnection() {
        return getConnection(MASTER);
    }
  
    public Connection getConnection(String cKeyID) {
        try {
            Connection Connect = getDataSource(cKeyID).getConnection();
            if (!DSFlag.containsKey(cKeyID)) {
                System.out.println(cKeyID + "数据库连接成功！");
                DSFlag.put(cKeyID, true);
            }
            return Connect;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(cKeyID + "数据库连接失败！");
            return null;
        }
    }

    private static DruidDataSource getDataSource(String cKeyID) {
        DruidDataSource ds = null;
        ds = DSMap.get(cKeyID);
        if (ds == null) {
            MDBConfig cfg = MDBConfig.readConfig(cKeyID);
            if (cfg != null) {
                ds = new DruidDataSource();
                ds.setDriverClassName(cfg.getDBDriver());
                ds.setUrl(cfg.getConnStr());
                ds.setUsername(cfg.getUserID());
                ds.setPassword(cfg.getPassword());

                ds.setMaxActive(cfg.getMAX());
                ds.setMinIdle(3);
                ds.setInitialSize(3);
                ds.setPoolPreparedStatements(true);
                ds.setValidationQuery(cfg.getValidQuery());
                ds.setTestOnBorrow(true);
                ds.setTestOnReturn(true);
                ds.setTestWhileIdle(true);
                // 大于0 ，进行连接空闲时间判断，或为0，对空闲的连接不进行验证
                ds.setMinEvictableIdleTimeMillis(1 * 60 * 1000);

                // 失效线程运行时间间隔，如果小于5 * 60 * 1000，不会启动检查
                ds.setTimeBetweenEvictionRunsMillis(5 * 60 * 1000);

                ds.setMaxWaitThreadCount(1000);

                System.out.println(cKeyID + ".DBDriver:" + cfg.getDBDriver());
                System.out.println(cKeyID + ".ConnStr:" + cfg.getConnStr());
                System.out.println(cKeyID + ".UserID:" + cfg.getUserID());
                System.out.println(cKeyID + ".Password:" + cfg.getPassword());
                System.out.println(cKeyID + ".DateKey:" + cfg.getDateKey());
                System.out.println(cKeyID + ".ValidQuery:" + cfg.getValidQuery());
                DSMap.put(cKeyID, ds);
            }
        }
        return ds;
    }
}

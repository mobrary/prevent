package com.tlkj.db;

import com.jfinal.kit.PropKit;

import java.util.HashMap;
import java.util.Map;

public class MDBConfig {
    private static Map<String, MDBConfig> DB = new HashMap<String, MDBConfig>();
    private String DBDriver = "";
    private int MAX = 100;
    private String ConnStr = "";
    private String UserID = "";
    private String Password = "";
    private String DateKey = "";
    private String ValidQuery = "";

    public String getDBDriver() {
        return DBDriver;
    }

    public void setDBDriver(String dBDriver) {
        DBDriver = dBDriver;
    }

    public int getMAX() {
        return MAX;
    }

    public void setMAX(int mAX) {
        MAX = mAX;
    }

    public String getConnStr() {
        return ConnStr;
    }

    public void setConnStr(String connStr) {
        ConnStr = connStr;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getDateKey() {
        return DateKey;
    }

    public void setDateKey(String dateKey) {
        DateKey = dateKey;
    }

    public String getValidQuery() {
        return ValidQuery;
    }

    public void setValidQuery(String validQuery) {
        ValidQuery = validQuery;
    }

    public static MDBConfig readConfig(String cKeyID) {
        MDBConfig vCfg = DB.get(cKeyID);
        if (vCfg == null) {
            vCfg = new MDBConfig();
            vCfg.setDBDriver(PropKit.get(cKeyID + ".DBDriver", ""));
            vCfg.setConnStr(PropKit.get(cKeyID + ".ConnStr", ""));
            vCfg.setUserID(PropKit.get(cKeyID + ".UserID", ""));
            vCfg.setPassword(PropKit.get(cKeyID + ".Password", ""));
            vCfg.setDateKey(PropKit.get(cKeyID + ".DateKey", ""));
            vCfg.setValidQuery(PropKit.get(cKeyID + ".ValidQuery", ""));
            String cMaxConnection = PropKit.get(cKeyID + ".MaxConnection", "100");
            vCfg.setMAX(PropKit.getInt(cMaxConnection, 100));
            if (vCfg.getDBDriver().length() > 0) {
                DB.put(cKeyID, vCfg);
            } else {
                vCfg = null;
            }
        }
        return vCfg;
    }
}

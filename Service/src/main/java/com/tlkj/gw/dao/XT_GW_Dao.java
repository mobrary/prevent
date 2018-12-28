package com.tlkj.gw.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tlkj.db.DBResult;
import com.tlkj.db.DbManager;
import com.tlkj.framework.AutoID;
import com.tlkj.framework.BeanUtil;
import com.tlkj.gw.API.IService;
import com.tlkj.gw.entity.XT_GW;
import com.tlkj.gw.entity.XT_GW_STEP;
import org.apache.commons.lang3.StringUtils;
import com.tlkj.framework.BeanUtil;

public class XT_GW_Dao implements IService<XT_GW> {
    public Integer Save(XT_GW vo, String cKeyID) {
        String sql;
        String id = AutoID.getAutoID().getID();
        if (StringUtils.isEmpty(cKeyID)) {
            vo.setGw_id(id);
            sql = BeanUtil.getInsertSQL(vo, "XT_GW");
        } else {
            vo.setGw_id(cKeyID);
            sql = BeanUtil.getUpdateSQL(vo, "XT_GW", " gw_id='" + cKeyID + "'");
        }
        return DbManager.ExeSql(sql.toString());
    }

    public Integer Save(XT_GW vo, XT_GW_STEP vNext, String cKeyID) {
        List<String> sqls = new ArrayList<String>();
        String sql;
        String id = AutoID.getAutoID().getID();

        if (StringUtils.isEmpty(cKeyID)) {
            vo.setGw_id(id);
            sqls.add(BeanUtil.getInsertSQL(vo, "XT_GW"));
            if (vNext != null) {
                vNext.setGw_id(id);
                sqls.add(BeanUtil.getInsertSQL(vNext, "XT_GW_STEP"));
                sqls.add("UPDATE XT_GW SET FLOW_ACTION_ID='" + vNext.getAction_id() + "',FLOW_GUID='" + vNext.getStep_guid() + "' WHERE GW_ID='" + vo.getGw_id() + "'");
            }
        } else {
            vo.setGw_id(cKeyID);
            sql = BeanUtil.getUpdateSQL(vo, "XT_GW",  " gw_id='" + cKeyID + "'");
        }
        return DbManager.ExeSql(sqls);
    }

    public Integer Save(String vContent,String cKeyID) {
        StringBuilder sql = new StringBuilder();
        sql.append(" update XT_GW SET SY_CONTENT='"+vContent);
        sql.append("' WHERE gw_id='" + cKeyID + "'");
        return DbManager.ExeSql(sql.toString());
    }

    public Integer DeleteItem(String cKeyID) {
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM XT_GW ");
        sql.append(" WHERE gw_id='" + cKeyID + "'");
        return DbManager.ExeSql(sql.toString());
    }

    public Integer DeleteList(String cKeyList) {
        String[] KeyList = cKeyList.split(",");
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM XT_GW ");
        sql.append(" WHERE gw_id IN (");
        for (int i = 0; i < KeyList.length; i++) {
            String cUserID = KeyList[i].trim();
            if (i == 0) {
                sql.append("'" + cUserID + "'");
            } else {
                sql.append(",'" + cUserID + "'");
            }
        }
        sql.append(" )");
        return DbManager.ExeSql(sql.toString());
    }

    public XT_GW FindItem(String cKeyID) {
        String cWhereParm = " gw_id='" + cKeyID + "'";
        List<XT_GW> rs = getList(cWhereParm);
        return (rs != null && rs.size() > 0) ? rs.get(0) : null;
    }

    public List<XT_GW> getList(String cWhereParm) {
        String sql = "SELECT * FROM XT_GW ";
        if (!StringUtils.isEmpty(cWhereParm)) {
            sql = sql + " WHERE " + cWhereParm;
        }
        List<XT_GW> KeyList = new ArrayList<XT_GW>();
        List<Map<String, Object>> rs = DbManager.QueryList(sql);
        for (int i = 0; (rs != null) && (i < rs.size()); i++) {
            XT_GW vo = new XT_GW();
            Map<String, Object> rowKey = rs.get(i);
            vo = (XT_GW) BeanUtil.Map2Obj(rowKey, vo);
            KeyList.add(vo);
        }
        return KeyList;
    }

    public DBResult Query(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize) {
        return DbManager.Query(cFileList, cTableName, cWhereParm, cOrderBy, iPageNo, iPageSize);
    }

    public List<Map<String, Object>> getListAsMap(String cFileList, String cTableName, String cWhereParm, String cOrderBy) {
        return DbManager.QueryList(cFileList, cTableName, cWhereParm, cOrderBy);
    }

    public List<Map<String, Object>> getListAsMap(String cFileList, String cWhereParm, String cOrderBy) {
        return DbManager.QueryList(cFileList, "XT_GW", cWhereParm, cOrderBy);
    }

    public List<Map<String, Object>> getListAsMap(String cWhereParm, String cOrderBy) {
        return DbManager.QueryList("*", "XT_GW", cWhereParm, cOrderBy);
    }

    public List<Map<String, Object>> getListAsMap(String cWhereParm) {
        return DbManager.QueryList("*", "XT_GW", cWhereParm, null);
    }

    public List<Map<String, Object>> getListAsMap(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize) {
        return DbManager.QueryList(cFileList, "XT_GW", cWhereParm, cOrderBy, iPageNo, iPageSize);
    }
}

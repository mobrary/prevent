package com.tlkj.gw.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map; 

import com.tlkj.db.DBResult;
import com.tlkj.db.DbManager;
import com.tlkj.framework.BeanUtil;
import com.tlkj.gw.API.IService;
import com.tlkj.gw.entity.XT_MACHINE;
import org.apache.commons.lang3.StringUtils;
import com.tlkj.framework.BeanUtil;

public class XT_MACHINE_Dao implements IService<XT_MACHINE> {

	public Integer Save(XT_MACHINE vo, String cKeyID) {
        String sql;
        if (StringUtils.isEmpty(cKeyID))
            sql = BeanUtil.getInsertSQL(vo, "XT_MACHINE");
        else
            sql = BeanUtil.getUpdateSQL(vo, "XT_MACHINE", "device_id='" + cKeyID + "'");
        return DbManager.ExeSql(sql.toString());
    }

    public Integer DeleteItem(String cKeyID) {
		StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM XT_MACHINE ");
		sql.append(" WHERE device_id='"+cKeyID+"'"); 
		return DbManager.ExeSql(sql.toString());
    }

    public Integer DeleteList(String cKeyList) {
        String[] KeyList = cKeyList.split(",");
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM XT_MACHINE ");
		sql.append(" WHERE device_id IN (");
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

    public XT_MACHINE FindItem(String cKeyID) { 
		String cWhereParm = " device_id='" + cKeyID + "'";
        List<XT_MACHINE> rs = getList(cWhereParm);
        return (rs != null && rs.size() > 0) ? rs.get(0) : null;
    }

    public List<XT_MACHINE> getList(String cWhereParm) {
       String sql = "SELECT * FROM XT_MACHINE ";
	   if (!StringUtils.isEmpty(cWhereParm)) {
            sql = sql + " WHERE " + cWhereParm;
        }
        List<XT_MACHINE> KeyList = new ArrayList<XT_MACHINE>();
        List<Map<String, Object>> rs = DbManager.QueryList(sql);
        for (int i = 0; (rs != null) && (i < rs.size()); i++) {
            XT_MACHINE vo = new XT_MACHINE();
            Map<String, Object> rowKey = rs.get(i); 
            vo = (XT_MACHINE) BeanUtil.Map2Obj(rowKey, vo);            
            KeyList.add(vo);
        }
        return KeyList;
    }

    public DBResult Query(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize) {
        return DbManager.Query(cFileList, "XT_MACHINE", cWhereParm, cOrderBy, iPageNo, iPageSize);
    }

    public List<Map<String, Object>> getListAsMap(String cFileList, String cTableName, String cWhereParm, String cOrderBy) {
         return DbManager.QueryList(cFileList,cTableName, cWhereParm, cOrderBy);
    }

    public List<Map<String, Object>> getListAsMap(String cFileList, String cWhereParm, String cOrderBy) {
         return DbManager.QueryList(cFileList,"XT_MACHINE", cWhereParm, cOrderBy);
    }

    public List<Map<String, Object>> getListAsMap( String cWhereParm, String cOrderBy) {
         return DbManager.QueryList("*","XT_MACHINE", cWhereParm, cOrderBy);
    }

    public List<Map<String, Object>> getListAsMap(String cWhereParm) {
         return DbManager.QueryList("*","XT_MACHINE", cWhereParm,null);
    }

    public List<Map<String, Object>> getListAsMap(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize) {
         return DbManager.QueryList(cFileList,"XT_MACHINE", cWhereParm, cOrderBy, iPageNo, iPageSize);
    }
}

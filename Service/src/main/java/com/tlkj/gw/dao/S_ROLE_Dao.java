package com.tlkj.gw.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map; 

import com.tlkj.db.DBResult;
import com.tlkj.db.DbManager;
import com.tlkj.framework.BeanUtil;
import com.tlkj.gw.API.IService;
import com.tlkj.gw.entity.S_ROLE;
import org.apache.commons.lang3.StringUtils;
import com.tlkj.framework.BeanUtil;

public class S_ROLE_Dao implements IService<S_ROLE> {

	public Integer Save(S_ROLE vo, String cKeyID) {
        String sql;
        if (StringUtils.isEmpty(cKeyID))
            sql = BeanUtil.getInsertSQL(vo, "S_ROLE");
        else
            sql = BeanUtil.getUpdateSQL(vo, "S_ROLE", "role_id='" + cKeyID + "'");
        return DbManager.ExeSql(sql.toString());
    }

    public Integer DeleteItem(String cKeyID) {
		StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM S_ROLE ");
		sql.append(" WHERE role_id='"+cKeyID+"'"); 
		return DbManager.ExeSql(sql.toString());
    }

    public Integer DeleteList(String cKeyList) {
        String[] KeyList = cKeyList.split(",");
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM S_ROLE ");
		sql.append(" WHERE role_id IN (");
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

    public S_ROLE FindItem(String cKeyID) { 
		String cWhereParm = " role_id='" + cKeyID + "'";
        List<S_ROLE> rs = getList(cWhereParm);
        return (rs != null && rs.size() > 0) ? rs.get(0) : null;
    }

    public List<S_ROLE> getList(String cWhereParm) {
       String sql = "SELECT * FROM S_ROLE ";
	   if (!StringUtils.isEmpty(cWhereParm)) {
            sql = sql + " WHERE " + cWhereParm;
        }
        List<S_ROLE> KeyList = new ArrayList<S_ROLE>();
        List<Map<String, Object>> rs = DbManager.QueryList(sql);
        for (int i = 0; (rs != null) && (i < rs.size()); i++) {
            S_ROLE vo = new S_ROLE();
            Map<String, Object> rowKey = rs.get(i); 
            vo = (S_ROLE) BeanUtil.Map2Obj(rowKey, vo);            
            KeyList.add(vo);
        }
        return KeyList;
    }

    public DBResult Query(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize) {
        return DbManager.Query(cFileList, "S_ROLE", cWhereParm, cOrderBy, iPageNo, iPageSize);
    }

    public List<Map<String, Object>> getListAsMap(String cFileList, String cTableName, String cWhereParm, String cOrderBy) {
         return DbManager.QueryList(cFileList,cTableName, cWhereParm, cOrderBy);
    }

    public List<Map<String, Object>> getListAsMap(String cFileList, String cWhereParm, String cOrderBy) {
         return DbManager.QueryList(cFileList,"S_ROLE", cWhereParm, cOrderBy);
    }

    public List<Map<String, Object>> getListAsMap( String cWhereParm, String cOrderBy) {
         return DbManager.QueryList("*","S_ROLE", cWhereParm, cOrderBy);
    }

    public List<Map<String, Object>> getListAsMap(String cWhereParm) {
         return DbManager.QueryList("*","S_ROLE", cWhereParm,null);
    }

    public List<Map<String, Object>> getListAsMap(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize) {
         return DbManager.QueryList(cFileList,"S_ROLE", cWhereParm, cOrderBy, iPageNo, iPageSize);
    }
}

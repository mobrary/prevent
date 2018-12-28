package com.tlkj.gw.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map; 

import com.tlkj.db.DBResult;
import com.tlkj.db.DbManager;
import com.tlkj.framework.AutoID;
import com.tlkj.framework.BeanUtil;
import com.tlkj.gw.API.IService;
import com.tlkj.gw.entity.XT_LAW_INF;
import org.apache.commons.lang3.StringUtils;
import com.tlkj.framework.BeanUtil;

public class XT_LAW_INF_Dao implements IService<XT_LAW_INF> {

	public Integer Save(XT_LAW_INF vo, String cKeyID) {
        String sql;
        if (StringUtils.isEmpty(cKeyID)) {
            vo.setId(AutoID.getAutoID(vo.getOrg_id()).getID());
            sql = BeanUtil.getInsertSQL(vo, "XT_LAW_INF");
        } else {
            vo.setId(cKeyID);
            sql = BeanUtil.getUpdateSQL(vo, "XT_LAW_INF", "id='" + cKeyID + "'");
        }
            return DbManager.ExeSql(sql.toString());
    }

    public Integer DeleteItem(String cKeyID) {
		StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM XT_LAW_INF ");
		sql.append(" WHERE id='"+cKeyID+"'"); 
		return DbManager.ExeSql(sql.toString());
    }

    public Integer DeleteList(String cKeyList) {
        String[] KeyList = cKeyList.split(",");
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM XT_LAW_INF ");
		sql.append(" WHERE id IN (");
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

    public XT_LAW_INF FindItem(String cKeyID) { 
		String cWhereParm = " id='" + cKeyID + "'";
        List<XT_LAW_INF> rs = getList(cWhereParm);
        return (rs != null && rs.size() > 0) ? rs.get(0) : null;
    }

    public List<XT_LAW_INF> getList(String cWhereParm) {
       String sql = "SELECT * FROM XT_LAW_INF ";
	   if (!StringUtils.isEmpty(cWhereParm)) {
            sql = sql + " WHERE " + cWhereParm;
        }
        List<XT_LAW_INF> KeyList = new ArrayList<XT_LAW_INF>();
        List<Map<String, Object>> rs = DbManager.QueryList(sql);
        for (int i = 0; (rs != null) && (i < rs.size()); i++) {
            XT_LAW_INF vo = new XT_LAW_INF();
            Map<String, Object> rowKey = rs.get(i); 
            vo = (XT_LAW_INF) BeanUtil.Map2Obj(rowKey, vo);            
            KeyList.add(vo);
        }
        return KeyList;
    }

    public DBResult Query(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize) {
        return DbManager.Query(cFileList, "XT_LAW_INF", cWhereParm, cOrderBy, iPageNo, iPageSize);
    }

    public List<Map<String, Object>> getListAsMap(String cFileList, String cTableName, String cWhereParm, String cOrderBy) {
         return DbManager.QueryList(cFileList,cTableName, cWhereParm, cOrderBy);
    }

    public List<Map<String, Object>> getListAsMap(String cFileList, String cWhereParm, String cOrderBy) {
         return DbManager.QueryList(cFileList,"XT_LAW_INF", cWhereParm, cOrderBy);
    }

    public List<Map<String, Object>> getListAsMap( String cWhereParm, String cOrderBy) {
         return DbManager.QueryList("*","XT_LAW_INF", cWhereParm, cOrderBy);
    }

    public List<Map<String, Object>> getListAsMap(String cWhereParm) {
         return DbManager.QueryList("*","XT_LAW_INF", cWhereParm,null);
    }

    public List<Map<String, Object>> getListAsMap(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize) {
         return DbManager.QueryList(cFileList,"XT_LAW_INF", cWhereParm, cOrderBy, iPageNo, iPageSize);
    }
}

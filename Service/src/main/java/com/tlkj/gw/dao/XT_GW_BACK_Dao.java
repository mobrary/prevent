package com.tlkj.gw.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map; 

import com.tlkj.db.DBResult;
import com.tlkj.db.DbManager;
import com.tlkj.framework.AutoID;
import com.tlkj.framework.BeanUtil;
import com.tlkj.gw.API.IService;
import com.tlkj.gw.entity.XT_GW_BACK;
import org.apache.commons.lang3.StringUtils;
import com.tlkj.framework.BeanUtil;

public class XT_GW_BACK_Dao implements IService<XT_GW_BACK> {

    public Integer Save(XT_GW_BACK vo, String cKeyID) {
        String sql;
        List<String> sqls;
        if (StringUtils.isEmpty(cKeyID)){
            sqls = new ArrayList<String>();
            vo.setBack_id(AutoID.getAutoID().getID());
        sql = BeanUtil.getInsertSQL(vo, "XT_GW_BACK");
        sqls.add(sql);
        //DELETE  from xt_gw_step where gw_id='201812140931580000000501' and FLOW_ID <>'1';
            //update xt_gw_step set READ_FLAG='0' where GW_ID='201812140931580000000501';
        String sql1="DELETE  from xt_gw_step where gw_id='"+vo.getGw_id()+"' and FLOW_ID <>'1'";
        String sql2="update xt_gw_step set READ_FLAG='0' where GW_ID='"+vo.getGw_id()+"'";
            sqls.add(sql1);
            sqls.add(sql2);
    }else {
            sqls = new ArrayList<String>();
            vo.setBack_id(cKeyID);
            sql = BeanUtil.getUpdateSQL(vo, "XT_GW_BACK", "back_id='" + cKeyID + "'");
            sqls.add(sql);
    }
        return DbManager.ExeSql(sqls);
}

    public Integer DeleteItem(String cKeyID) {
		StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM XT_GW_BACK ");
		sql.append(" WHERE back_id='"+cKeyID+"'"); 
		return DbManager.ExeSql(sql.toString());
    }

    public Integer DeleteList(String cKeyList) {
        String[] KeyList = cKeyList.split(",");
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM XT_GW_BACK ");
		sql.append(" WHERE back_id IN (");
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

    public XT_GW_BACK FindItem(String cKeyID) { 
		String cWhereParm = " gw_id='" + cKeyID + "'";
        List<XT_GW_BACK> rs = getList(cWhereParm);
        return (rs != null && rs.size() > 0) ? rs.get(0) : null;
    }

    public List<XT_GW_BACK> getList(String cWhereParm) {
       String sql = "SELECT * FROM XT_GW_BACK ";
	   if (!StringUtils.isEmpty(cWhereParm)) {
            sql = sql + " WHERE " + cWhereParm;
        }
        List<XT_GW_BACK> KeyList = new ArrayList<XT_GW_BACK>();
        List<Map<String, Object>> rs = DbManager.QueryList(sql);
        for (int i = 0; (rs != null) && (i < rs.size()); i++) {
            XT_GW_BACK vo = new XT_GW_BACK();
            Map<String, Object> rowKey = rs.get(i); 
            vo = (XT_GW_BACK) BeanUtil.Map2Obj(rowKey, vo);            
            KeyList.add(vo);
        }
        return KeyList;
    }

    public DBResult Query(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize) {
        return DbManager.Query(cFileList, "XT_GW_BACK", cWhereParm, cOrderBy, iPageNo, iPageSize);
    }

    public List<Map<String, Object>> getListAsMap(String cFileList, String cTableName, String cWhereParm, String cOrderBy) {
         return DbManager.QueryList(cFileList,cTableName, cWhereParm, cOrderBy);
    }

    public List<Map<String, Object>> getListAsMap(String cFileList, String cWhereParm, String cOrderBy) {
         return DbManager.QueryList(cFileList,"XT_GW_BACK", cWhereParm, cOrderBy);
    }

    public List<Map<String, Object>> getListAsMap( String cWhereParm, String cOrderBy) {
         return DbManager.QueryList("*","XT_GW_BACK", cWhereParm, cOrderBy);
    }

    public List<Map<String, Object>> getListAsMap(String cWhereParm) {
         return DbManager.QueryList("*","XT_GW_BACK", cWhereParm,null);
    }

    public List<Map<String, Object>> getListAsMap(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize) {
         return DbManager.QueryList(cFileList,"XT_GW_BACK", cWhereParm, cOrderBy, iPageNo, iPageSize);
    }
}

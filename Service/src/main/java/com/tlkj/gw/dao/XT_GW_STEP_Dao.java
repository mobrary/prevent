package com.tlkj.gw.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jfinal.template.stat.ast.Else;
import com.tlkj.CommonUtils.JActiveTable;
import com.tlkj.CommonUtils.StringEx;
import com.tlkj.db.DBResult;
import com.tlkj.db.DbManager;
import com.tlkj.framework.AutoID;
import com.tlkj.framework.BeanUtil;
import com.tlkj.framework.DateUtil;
import com.tlkj.gw.API.IService;
import com.tlkj.gw.entity.XT_GW_STEP;
import com.tlkj.gw.entity.XT_WF_ACTION;
import com.tlkj.gw.entity.XT_WF_FLOW;
import org.apache.commons.lang3.StringUtils;
import com.tlkj.framework.BeanUtil;

public class XT_GW_STEP_Dao implements IService<XT_GW_STEP> {


    public Integer Save(XT_GW_STEP vo, String cKeyID) {
        String sql;
        if (StringUtils.isEmpty(cKeyID))
            sql = BeanUtil.getInsertSQL(vo, "XT_GW_STEP");
        else
            sql = BeanUtil.getUpdateSQL(vo, "XT_GW_STEP", "step_guid='" + cKeyID + "'");
        return DbManager.ExeSql(sql.toString());
    }

    public Integer DeleteItem(String cKeyID) {
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM XT_GW_STEP ");
        sql.append(" WHERE step_guid='" + cKeyID + "'");
        return DbManager.ExeSql(sql.toString());
    }

    public Integer DeleteList(String cKeyList) {
        String[] KeyList = cKeyList.split(",");
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM XT_GW_STEP ");
        sql.append(" WHERE step_guid IN (");
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

    public XT_GW_STEP FindItem(String cKeyID) {
        String cWhereParm = " step_guid='" + cKeyID + "'";
        List<XT_GW_STEP> rs = getList(cWhereParm);
        return (rs != null && rs.size() > 0) ? rs.get(0) : null;
    }

    public List<XT_GW_STEP> getList(String cWhereParm) {
        String sql = "SELECT * FROM XT_GW_STEP ";
        if (!StringUtils.isEmpty(cWhereParm)) {
            sql = sql + " WHERE " + cWhereParm;
        }
        List<XT_GW_STEP> KeyList = new ArrayList<XT_GW_STEP>();
        List<Map<String, Object>> rs = DbManager.QueryList(sql);
        for (int i = 0; (rs != null) && (i < rs.size()); i++) {
            XT_GW_STEP vo = new XT_GW_STEP();
            Map<String, Object> rowKey = rs.get(i);
            vo = (XT_GW_STEP) BeanUtil.Map2Obj(rowKey, vo);
            KeyList.add(vo);
        }
        return KeyList;
    }

    public Integer Save_step(String cKeyID, String cUserId, String NextUserID, String cFLOW_CONTENT) {
        String cFLOW_GUID = DbManager.getStrValue("select step_guid from XT_GW_STEP where gw_id='" + cKeyID + "' and IS_COMPLETE=0 and COMPLETE_USER_ID='" + cUserId + "'");
        XT_GW_STEP_Dao wfStepDao = new XT_GW_STEP_Dao();
        XT_GW_STEP rowStep = wfStepDao.FindItem(cFLOW_GUID);

        XT_WF_ACTION_Dao wfFlowDao = new XT_WF_ACTION_Dao();
        String cCurActionID = rowStep.getAction_id();
        String cWF_ID = rowStep.getWf_id();
        XT_WF_ACTION rowAction = wfFlowDao.FindItem(rowStep.getAction_id());

        List<String> sqls = new ArrayList<String>();
        JActiveTable aTable = new JActiveTable();
        aTable.setTableName("XT_GW_STEP");
        aTable.setFieldValue("IS_COMPLETE", 1);
        aTable.setFieldValue("COMPLETE_TIME", DateUtil.getDayTimeNum());
        aTable.setFieldValue("FLOW_STATUS", 1);
        aTable.setFieldValue("FLOW_CONTENT", cFLOW_CONTENT);
        aTable.setWhereParm(" step_guid='" + cFLOW_GUID + "'");
        String sql = aTable.getSQL();
        sqls.add(sql);
        int iTypeID = rowAction.getType_id();
        if (iTypeID == 0) {
            iTypeID = 1;
        }
        iTypeID++;
        String cNextAction_ID = DbManager.getStrValue("select START_ID from xt_wf_action where FINISH_ID>='" + cCurActionID + "' and FINISH_ID LIKE '" + cWF_ID + "%' and TYPE_ID=" + iTypeID);

        if (!StringEx.isEmpty(cNextAction_ID)) {
            rowStep.setStep_guid(AutoID.getAutoID().getID());
            rowStep.setCreate_user_id(cUserId);
            rowStep.setCreate_time(DateUtil.getDayTimeNum());

            rowStep.setComplete_user_id(NextUserID);
            rowStep.setComplete_time("");
            rowStep.setIs_complete(0);
            rowStep.setRead_time("");
            rowStep.setRead_flag(0);
            rowStep.setFlow_id(StringEx.getStr(iTypeID));
            rowStep.setAction_id(cNextAction_ID);

            sql = BeanUtil.getInsertSQL(rowStep, "XT_GW_STEP");
            sqls.add(sql);
            sqls.add("UPDATE XT_GW SET FLOW_GUID='"+ rowStep.getStep_guid()+"',FLOW_ACTION_ID='"+cNextAction_ID+"' WHERE GW_ID='"+cKeyID+"'" );
        }
        else
        {
            sqls.add("UPDATE XT_GW SET FLOW_GUID='',FLOW_ACTION_ID='"+cWF_ID+"_999' WHERE GW_ID='"+cKeyID+"'" );
        }
        return DbManager.ExeSql(sqls);
    }

    public DBResult Query(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize) {
        return DbManager.Query(cFileList, "XT_GW_STEP", cWhereParm, cOrderBy, iPageNo, iPageSize);
    }

    public List<Map<String, Object>> getListAsMap(String cFileList, String cTableName, String cWhereParm, String cOrderBy) {
        return DbManager.QueryList(cFileList, cTableName, cWhereParm, cOrderBy);
    }

    public List<Map<String, Object>> getListAsMap(String cFileList, String cWhereParm, String cOrderBy) {
        return DbManager.QueryList(cFileList, "XT_GW_STEP", cWhereParm, cOrderBy);
    }

    public List<Map<String, Object>> getListAsMap(String cWhereParm, String cOrderBy) {
        return DbManager.QueryList("*", "XT_GW_STEP", cWhereParm, cOrderBy);
    }

    public List<Map<String, Object>> getListAsMap(String cWhereParm) {
        return DbManager.QueryList("*", "XT_GW_STEP", cWhereParm, null);
    }

    public List<Map<String, Object>> getListAsMap(String cFileList, String cTableName, String cWhereParm, String cOrderBy, int iPageNo, int iPageSize) {
        return DbManager.QueryList(cFileList, "XT_GW_STEP", cWhereParm, cOrderBy, iPageNo, iPageSize);
    }

    public List<Map<String,Object>>  StepFindItem(String cURL_id) {
        String cWhereParm = " gw_id='" + cURL_id + "'";
        List<Map<String,Object>>  rs = getListAsMap(cWhereParm);
        return rs;
    }
}

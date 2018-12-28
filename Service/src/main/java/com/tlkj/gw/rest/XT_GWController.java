package com.tlkj.gw.rest;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tlkj.CommonUtils.ActiveResult;
import com.tlkj.CommonUtils.RequestUtil;
import com.tlkj.CommonUtils.StringEx;
import com.tlkj.db.DBResult;
import com.tlkj.db.DbManager;
import com.tlkj.framework.AutoID;
import com.tlkj.framework.DateUtil;
import com.tlkj.framework.TLKJController;
import com.tlkj.gw.dao.XT_GW_STEP_Dao;
import com.tlkj.gw.dao.XT_WF_ACTION_Dao;
import com.tlkj.gw.dao.XT_WF_Dao;
import com.tlkj.gw.entity.XT_GW_STEP;
import com.tlkj.gw.entity.XT_WF;
import org.apache.log4j.Logger;
import io.jboot.web.controller.annotation.RequestMapping;

import com.tlkj.gw.dao.XT_GW_Dao;
import com.tlkj.gw.entity.XT_GW;

@RequestMapping("/rest/gw")
public class XT_GWController extends TLKJController {
    public final static String BASE_URL = "/gw";
    static Logger log = Logger.getLogger(XT_GWController.class);
    private XT_GW_Dao dao = new XT_GW_Dao();

    public void list() {
        request = this.getRequest();
        response = this.getResponse();
        readQueryString();
        ActiveResult vret = new ActiveResult();
        String cORG_ID = StringEx.getStr(request.getParameter("ORGID"));
        String cUSER_ID = StringEx.getStr(request.getParameter("USER_ID"));
        String cREAD_FLAG = StringEx.getStr(request.getParameter("READ_FLAG"));
        String cOrderBy = " T.GW_ID desc";
        String cWhereParam = " EXISTS(SELECT 1 FROM xt_gw_step X WHERE X.COMPLETE_USER_ID='" + cUSER_ID + "' AND X.GW_ID=T.GW_ID AND IS_COMPLETE=" + cREAD_FLAG + ")";
        String cFieldList = "T.*";
        cFieldList = cFieldList + ",(SELECT MAX(STEP_GUID) FROM xt_gw_step X WHERE X.GW_ID=T.GW_ID) AS STEP_GUID ";
        cFieldList = cFieldList + ",(SELECT X.ACTION_NAME FROM xt_wf_action X WHERE X.ACTION_ID=T.FLOW_ACTION_ID) AS ACTION_NAME ";

        //cFieldList = cFieldList + ",(SELECT CREATE_TIME FROM xt_gw_step X WHERE X.GW_ID=T.GW_ID AND COMPLETE_USER_ID='" + cUSER_ID + "') AS CREATE_TIME ";
        //cFieldList = cFieldList + ",(SELECT COMPLETE_TIME FROM xt_gw_step X WHERE X.GW_ID=T.GW_ID AND COMPLETE_USER_ID='" + cUSER_ID + "') AS COMPLETE_TIME ";
        String cTableList = "XT_GW T ";
        DBResult dbret = dao.Query(cFieldList, cTableList, cWhereParam, cOrderBy, iPageNo, iPageSize);
        List<Map<String, Object>> dtRows = dbret.dtrows;
        int iRowCount = (dtRows == null) ? 0 : dbret.ROW_COUNT;
        vret = ActiveResult.Query(dtRows);
        vret.total = iRowCount;
        renderJson(vret);
    }

    public void save() {
        request = this.getRequest();
        response = this.getResponse();

        ActiveResult vret = new ActiveResult();
        String cKeyID = StringEx.getSafeParm(request.getParameter(ITEM_KEY));
        String cGw_Type = StringEx.getSafeParm(request.getParameter("gw_type"));
        String cUser_ID = StringEx.getSafeParm(request.getParameter("user_id"));
        int iCode = 0;
        XT_GW vo = new XT_GW();
        XT_GW_STEP vStart = new XT_GW_STEP();
        String cFileList = "";
        vo = (XT_GW) RequestUtil.readFromRequest(this.request, vo);
        if (StringEx.isEmpty(cKeyID)) {
            String[] FileList = request.getParameterValues("file_list");
            for (int i = 0; i < FileList.length; i++) {
                if (i == 0) {
                    cFileList = FileList[0];
                } else {
                    cFileList = cFileList + "," + FileList[0];
                }
            }
            vo.setFile_list(cFileList);

            vStart.setStep_guid(AutoID.getAutoID().getID());
            vStart.setCreate_time(vo.getSw_date());
            String cWF_ID = (new XT_WF_Dao()).getList("type_id='" + cGw_Type + "'").get(0).getWf_id();
            vStart.setWf_id(cWF_ID);
            String cACTION_ID = (new XT_WF_ACTION_Dao()).getList("type_id=0 AND action_id like '" + cWF_ID + "%'").get(0).getAction_id();
            vStart.setAction_id(cACTION_ID);
            vStart.setFlow_id("1");
            vStart.setOrg_id(vo.getOrg_id());
            vStart.setCreate_user_id(cUser_ID);
            vStart.setRead_flag(1);
            vStart.setRead_time(DateUtil.getDayTimeNum());
            vStart.setAction_type("1");
            vStart.setComplete_user_id(cUser_ID);
            vStart.setComplete_time(null);
            vStart.setFlow_status(0);
            vStart.setFlow_content(null);
            vStart.setIs_complete(0);
            vo.setGw_type(cGw_Type);
            iCode = dao.Save(vo, vStart, cKeyID);
        } else {
            iCode = dao.Save(vo, cKeyID);
        }
        vret = ActiveResult.Valid(iCode);
        renderJson(vret);
    }

    public void find_item() {
        request = this.getRequest();
        response = this.getResponse();

        ActiveResult vret = new ActiveResult();
        String cURL_ID = StringEx.getStr(request.getParameter("ID"));
        XT_GW obj = dao.FindItem(cURL_ID);
        vret = ActiveResult.Info(obj);
        renderJson(vret);
    }

    public void del_item() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = ActiveResult.Valid("参数传递错误！");
        String cKeyID = StringEx.getStr(request.getParameter("ID"));
        if (StringEx.isEmpty(cKeyID)) {
            vret = ActiveResult.Valid("参数传递错误！");
        } else {
            int iCode = dao.DeleteItem(cKeyID);
            vret = ActiveResult.Valid(iCode);
        }
        renderJson(vret);
    }

    public void save_content(){
        request = this.getRequest();
        response = this.getResponse();
     ActiveResult vret = ActiveResult.Valid("参数传递错误！");
    String cKeyID = StringEx.getStr(request.getParameter(ITEM_KEY));
        String cContent = StringEx.getStr(request.getParameter("sy_content"));
        if (StringEx.isEmpty(cKeyID)) {
        vret = ActiveResult.Valid("参数传递错误！");
    } else {
        int iCode = dao.Save(cContent,cKeyID);
        vret = ActiveResult.Valid(iCode);
    }
    renderJson(vret);
}

}

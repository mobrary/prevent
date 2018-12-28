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
import com.tlkj.framework.DateUtil;
import com.tlkj.framework.TLKJController;
import com.tlkj.gw.dao.XT_GW_Dao;
import com.tlkj.gw.dao.XT_GW_STEP_Dao;
import com.tlkj.gw.dao.XT_WF_ACTION_Dao;
import com.tlkj.gw.entity.XT_GW;
import com.tlkj.gw.entity.XT_GW_STEP;
import org.apache.log4j.Logger;
import io.jboot.web.controller.annotation.RequestMapping;

import com.tlkj.gw.dao.XT_GW_BACK_Dao;
import com.tlkj.gw.entity.XT_GW_BACK;

@RequestMapping("/rest/gw_back")
public class XT_GW_BACKController extends TLKJController {
    public final static String BASE_URL = "/gw_back";
    static Logger log = Logger.getLogger(XT_GW_BACKController.class);
    private XT_GW_BACK_Dao dao = new XT_GW_BACK_Dao(); 

    public void list() {
        request = this.getRequest();
        response = this.getResponse();

        ActiveResult vret = new ActiveResult();
        String cORG_ID = StringEx.getStr(request.getParameter("ORGID"));
        String cWhereParm = "";
        String cOrderBy = " back_id asc";
        DBResult dbret = dao.Query("*", "XT_GW_BACK", cWhereParm, cOrderBy, iPageNo, iPageSize);
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
        String cKeyID = StringEx.getStr(request.getParameter(ITEM_KEY));
        String cGw_ID= StringEx.getStr(request.getParameter("gw_id"));
        String cUserID= StringEx.getStr(request.getParameter("user_id"));
        String cYj= StringEx.getStr(request.getParameter("yj"));
        int iCode = 0;
        XT_GW_BACK vo = new XT_GW_BACK();
        vo = (XT_GW_BACK) RequestUtil.readFromRequest(this.request, vo);
        String cFLOW_GUID = DbManager.getStrValue("select step_guid from XT_GW_STEP where gw_id='" + cGw_ID + "' and IS_COMPLETE=0 and COMPLETE_USER_ID='" + cUserID + "'");
        XT_GW_STEP_Dao wfStepDao = new XT_GW_STEP_Dao();
        XT_GW_STEP rowStep = wfStepDao.FindItem(cFLOW_GUID);
        String cCurActionID = rowStep.getAction_id();
        String cStepGuid=rowStep.getStep_guid();
        rowStep.setComplete_time("");
        rowStep.setIs_complete(0);
        XT_GW_Dao xt_gw_dao = new XT_GW_Dao();
        XT_GW xt_gw = xt_gw_dao.FindItem(cFLOW_GUID);
        xt_gw.setFlow_guid(cStepGuid);
        String cType=xt_gw.getGw_type();//select MIN(FLOW_ID) from xt_wf_flow where FLOW_ID like 'F%'
        String cActionID=DbManager.getStrValue("select MIN(FLOW_ID) from xt_wf_flow where FLOW_ID like '"+cType+"%'");
        xt_gw.setFlow_action_id(cActionID);
        if (StringEx.isEmpty(cKeyID)) {
            vo.setUser_id(cUserID);
            vo.setGw_id(cGw_ID);
            vo.setBack_remark(cYj);
            vo.setBack_time(DateUtil.getDayTimeNum());
            vo.setAction_id(cCurActionID);
              iCode = dao.Save(vo, cKeyID);
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
        XT_GW_BACK obj = dao.FindItem(cURL_ID);
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
}

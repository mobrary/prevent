package com.tlkj.gw.rest;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tlkj.CommonUtils.ActiveResult;
import com.tlkj.CommonUtils.RequestUtil;
import com.tlkj.CommonUtils.StringEx;
import com.tlkj.db.DBResult;
import com.tlkj.framework.TLKJController; 
import org.apache.log4j.Logger;
import io.jboot.web.controller.annotation.RequestMapping;

import com.tlkj.gw.dao.XT_MACHINE_Dao;
import com.tlkj.gw.entity.XT_MACHINE;

@RequestMapping("/rest/machine")
public class XT_MACHINEController extends TLKJController {
    public final static String BASE_URL = "/machine";
    static Logger log = Logger.getLogger(XT_MACHINEController.class);
    private XT_MACHINE_Dao dao = new XT_MACHINE_Dao(); 

    public void list() {
        request = this.getRequest();
        response = this.getResponse();
        readQueryString();

        ActiveResult vret = new ActiveResult();
        String cORG_ID = StringEx.getStr(request.getParameter("ORGID"));
        String cWhereParm = "";
        String cOrderBy = " device_id asc";
        DBResult dbret = dao.Query("*", "XT_MACHINE", cWhereParm, cOrderBy, iPageNo, iPageSize);
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
        int iCode = 0;
        XT_MACHINE vo = new XT_MACHINE();
        vo = (XT_MACHINE) RequestUtil.readFromRequest(this.request, vo);
        if (StringEx.isEmpty(cKeyID)) {
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
        XT_MACHINE obj = dao.FindItem(cURL_ID);
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

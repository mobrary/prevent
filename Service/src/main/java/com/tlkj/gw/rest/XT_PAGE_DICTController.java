package com.tlkj.gw.rest;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tlkj.CommonUtils.ActiveResult;
import com.tlkj.CommonUtils.AppConfig;
import com.tlkj.CommonUtils.RequestUtil;
import com.tlkj.CommonUtils.StringEx;
import com.tlkj.db.DBResult;
import com.tlkj.db.DbManager;
import com.tlkj.framework.TLKJController;
import org.apache.log4j.Logger;
import io.jboot.web.controller.annotation.RequestMapping;

import com.tlkj.gw.dao.XT_PAGE_DICT_Dao;
import com.tlkj.gw.entity.XT_PAGE_DICT;

@RequestMapping("/rest/page_dict")
public class XT_PAGE_DICTController extends TLKJController {
    public final static String BASE_URL = "/page_dict";
    static Logger log = Logger.getLogger(XT_PAGE_DICTController.class);
    private XT_PAGE_DICT_Dao dao = new XT_PAGE_DICT_Dao();

    public void list() {
        request = this.getRequest();
        response = this.getResponse();

        ActiveResult vret = new ActiveResult();
        String cORG_ID = StringEx.getStr(request.getParameter("ORGID"));
        String cWhereParm = "";
        String cOrderBy = " dict_id asc";
        DBResult dbret = dao.Query("*", "XT_PAGE_DICT", cWhereParm, cOrderBy, iPageNo, iPageSize);
        List<Map<String, Object>> dtRows = dbret.dtrows;
        int iRowCount = (dtRows == null) ? 0 : dbret.ROW_COUNT;
        vret = ActiveResult.Query(dtRows);
        vret.total = iRowCount;
        renderJson(vret);
    }

    public void dict() {
        request = this.getRequest();
        response = this.getResponse();

        ActiveResult vret = ActiveResult.Valid(AppConfig.FAILURE);
        String cORG_ID = StringEx.getSafeParm(request.getParameter("ORGID"));
        String cDICT_ID = StringEx.getSafeParm(request.getParameter("DICT_ID"));
        XT_PAGE_DICT_Dao dao = new XT_PAGE_DICT_Dao();
        XT_PAGE_DICT rowKey = dao.FindItem(cDICT_ID);

        String vSQL;
        if (rowKey != null) {
            vSQL = rowKey.getDict_sql();
            List<Map<String, Object>> dtRows = DbManager.QueryList(vSQL);
            vret = ActiveResult.Query(dtRows);
        }
        renderJson(vret);
    }

    public void save() {
        request = this.getRequest();
        response = this.getResponse();

        ActiveResult vret = new ActiveResult();
        String cKeyID = StringEx.getStr(request.getParameter(ITEM_KEY));
        int iCode = 0;
        XT_PAGE_DICT vo = new XT_PAGE_DICT();
        vo = (XT_PAGE_DICT) RequestUtil.readFromRequest(this.request, vo);
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
        XT_PAGE_DICT obj = dao.FindItem(cURL_ID);
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

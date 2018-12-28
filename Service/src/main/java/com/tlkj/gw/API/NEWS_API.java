package com.tlkj.gw.API;

import com.tlkj.CommonUtils.ActiveResult;
import com.tlkj.CommonUtils.AppConfig;
import com.tlkj.CommonUtils.StringEx;
import com.tlkj.db.DbManager;
import com.tlkj.gw.dao.XT_NEWS_Dao;
import com.tlkj.gw.entity.S_USER_INF;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NEWS_API {
    public static ActiveResult QueryList(HttpServletRequest request, HttpServletResponse response) {
        ActiveResult vret = ActiveResult.Info("参数:ORG_ID,USER_ID,ID,CLS_ID=ZWGK,GZDT");
        XT_NEWS_Dao dao = new XT_NEWS_Dao();
        String cCLS_ID = StringEx.getStr(request.getParameter("CLS_ID"));
        String cTAG = StringEx.getStr(request.getParameter("TAG"));
        String cID = StringEx.getStr(request.getParameter("ID"));
        String cTYPE_NAME = StringEx.getStr(request.getParameter("TYPE_NAME"));
        String cWhereParm = " CLS_ID='" + cCLS_ID + "'";
        if (!StringEx.isEmpty(cTYPE_NAME)) {
            cWhereParm = cWhereParm + " AND title LIKE '%" + cTYPE_NAME + "%'";
        }

        if (!StringEx.isEmpty(cID)) {
            if (StringEx.isEmpty(cTAG)) {
                cWhereParm = cWhereParm + " AND ID>'" + cID + "' ";
            } else {
                if (cTAG.equals("0")) {
                    cWhereParm = cWhereParm + " AND ID>'" + cID + "' ";
                } else {
                    cWhereParm = cWhereParm + " AND ID<'" + cID + "' ";
                }
            }
        }

        List<Map<String, Object>> rs = dao.getListAsMap("*", "XT_NEWS", cWhereParm, " ID DESC ", 1, 10);
        vret = ActiveResult.Query(rs);
        return vret;
    }
}

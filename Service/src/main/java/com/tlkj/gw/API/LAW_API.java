package com.tlkj.gw.API;

import com.tlkj.CommonUtils.ActiveResult;
import com.tlkj.CommonUtils.AppManager;
import com.tlkj.CommonUtils.StringEx;
import com.tlkj.gw.dao.XT_LAW_INF_Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class LAW_API {
    public static ActiveResult QueryList(HttpServletRequest request, HttpServletResponse response) {
        ActiveResult vret = ActiveResult.Info("参数:ORG_ID,ID");

        XT_LAW_INF_Dao dao = new XT_LAW_INF_Dao();
        String cTAG = StringEx.getStr(request.getParameter("TAG"));
        String cTYPE_NAME = StringEx.getStr(request.getParameter("TYPE_NAME"));
        String cID = StringEx.getStr(request.getParameter("ID"));

        String cOrderBy = " id desc";
        String cORG_ID = StringEx.getStr(request.getParameter("ORG_ID"));
        String cWhereParm = "ORG_ID like '" + AppManager.getOrgID(cORG_ID) + "%'";
        if (!StringEx.isEmpty(cTYPE_NAME)) {
            cWhereParm = cWhereParm + " AND title LIKE '%" + cTYPE_NAME + "%'";
        }

        if (!StringEx.isEmpty(cID)) {
            if (StringEx.isEmpty(cTAG)) { //cTAG为空
                cWhereParm = cWhereParm + " AND ID>'" + cID + "' ";
            } else {
                if (cTAG.equals("0")) {
                    cWhereParm = cWhereParm + " AND ID<'" + cID + "' ";
                } else {
                    cWhereParm = cWhereParm + " AND ID>'" + cID + "' ";
                }
            }
        }

        List<Map<String, Object>> rs = dao.getListAsMap("*", "XT_LAW_INF", cWhereParm, cOrderBy, 1, 10);
        vret = ActiveResult.Query(rs);
        return vret;
    }


}

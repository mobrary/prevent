package com.tlkj.gw.API;

import com.tlkj.CommonUtils.ActiveResult;
import com.tlkj.CommonUtils.StringEx;
import com.tlkj.gw.dao.XT_ARCHIVE_Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ARCHIVE_API {

    public static ActiveResult QueryList(HttpServletRequest request, HttpServletResponse response) {
        ActiveResult vret = ActiveResult.Info("参数:ORG_ID");

        String cTAG = StringEx.getStr(request.getParameter("TAG"));
        String cID = StringEx.getStr(request.getParameter("ID"));

        XT_ARCHIVE_Dao dao = new XT_ARCHIVE_Dao();
        String cORG_ID = StringEx.getStr(request.getParameter("ORG_ID"));
        if (StringEx.isEmpty(cORG_ID)) {
            vret = ActiveResult.Valid("USER_ID参数不能为空！");
        } else {
            String cWhereParm = "ORG_ID = '" + cORG_ID + "'";
            String cOrderBy = " ID DESC  LIMIT 10";
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
            List<Map<String, Object>> rs = dao.getListAsMap(cWhereParm, cOrderBy);
            vret = ActiveResult.Query(rs);
        }
        return vret;
    }
}

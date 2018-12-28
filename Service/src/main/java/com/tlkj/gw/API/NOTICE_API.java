package com.tlkj.gw.API;

import com.tlkj.CommonUtils.ActiveResult;
import com.tlkj.CommonUtils.StringEx;
import com.tlkj.gw.dao.XT_NOTICE_Dao;
import org.apache.commons.lang3.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class NOTICE_API {
    public static ActiveResult QueryList(HttpServletRequest request, HttpServletResponse response) {
        ActiveResult vret = ActiveResult.Info("参数:USER_ID");

        XT_NOTICE_Dao dao = new XT_NOTICE_Dao();

        String cTAG = StringEx.getStr(request.getParameter("TAG"));
        String cID = StringEx.getStr(request.getParameter("ID"));

        String cWhereParm = null;
        String cOrderBy = " NOTICE_ID DESC ";

        if (!StringEx.isEmpty(cID)) {
            if (StringEx.isEmpty(cTAG)) {
                cWhereParm = " NOTICE_ID>'" + cID + "' ";
            } else {
                if (cTAG.equals("0")) {
                    cWhereParm = " NOTICE_ID>'" + cID + "' ";
                } else {
                    cWhereParm = " NOTICE_ID<'" + cID + "' ";
                }
            }
        }
        List<Map<String, Object>> rs = dao.getListAsMap("*", "XT_NOTICE", cWhereParm, cOrderBy, 1, 1);
        vret = ActiveResult.Query(rs);

        return vret;
    }
}

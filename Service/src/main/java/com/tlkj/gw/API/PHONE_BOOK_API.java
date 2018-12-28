package com.tlkj.gw.API;


import com.tlkj.CommonUtils.ActiveResult;
import com.tlkj.CommonUtils.StringEx;
import com.tlkj.gw.dao.XT_PHONE_BOOK_Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PHONE_BOOK_API {
    public static ActiveResult QueryList(HttpServletRequest request, HttpServletResponse response) {
        ActiveResult vret = ActiveResult.Info("参数:USER_ID");
        XT_PHONE_BOOK_Dao dao = new XT_PHONE_BOOK_Dao();
        String cUSER_ID = StringEx.getStr(request.getParameter("USER_ID"));
        String cWhereParm = " USER_ID = '"+cUSER_ID+"'";
        List<Map<String,Object>> rs = dao.getListAsMap(cWhereParm);

        vret = ActiveResult.Query(rs);
        return vret;
    }
}

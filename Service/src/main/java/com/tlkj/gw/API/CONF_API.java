package com.tlkj.gw.API;

import com.tlkj.CommonUtils.ActiveResult;
import com.tlkj.CommonUtils.AppConfig;
import com.tlkj.CommonUtils.RequestUtil;
import com.tlkj.CommonUtils.StringEx;
import com.tlkj.db.DbManager;
import com.tlkj.gw.dao.XT_CONF_Dao;
import com.tlkj.gw.dao.XT_CONF_USERS_Dao;
import com.tlkj.gw.entity.XT_CONF;
import com.tlkj.gw.entity.XT_CONF_USERS;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CONF_API {
    public static ActiveResult QueryList(HttpServletRequest request, HttpServletResponse response) {
        ActiveResult vret = ActiveResult.Info("参数:ORG_ID,USER_ID,READ_FLAG,ID");
        XT_CONF_USERS_Dao dao = new XT_CONF_USERS_Dao();
        String cORG_ID = StringEx.getStr(request.getParameter("ORG_ID"));
        String cUSER_ID = StringEx.getStr(request.getParameter("USER_ID"));
        if (StringEx.isEmpty(cUSER_ID)) {
            vret = ActiveResult.Valid("USER_ID参数不能为空！");
        } else {
            String cTAG = StringEx.getStr(request.getParameter("TAG"));
            String cID = StringEx.getStr(request.getParameter("ID"));

            String cREAD_FLAG = StringEx.getStr(request.getParameter("READ_FLAG"));
            String cWhereParm = " A.CONF_ID=B.CONF_ID  AND B.USER_ID='" + cUSER_ID + "'";
            String cFieldList = "A.*,B.READ_FLAG,B.READ_TIME";
            String cTableList = "xt_conf A ,xt_conf_users B";
            String cOrderList = " A.CONF_ID ASC LIMIT 10";

            if (!StringEx.isEmpty(cID)) {
                if (StringEx.isEmpty(cTAG)) {
                    cWhereParm = cWhereParm + " AND A.CONF_ID>'" + cID + "' ";
                } else {
                    if (cTAG.equals("0")) {
                        cWhereParm = cWhereParm + " AND A.CONF_ID>'" + cID + "' ";
                    } else {
                        cWhereParm = cWhereParm + " AND A.CONF_ID<'" + cID + "' ";
                    }
                }
            }

            //if (StringEx.isEmpty(cREAD_FLAG)) {
            //    cREAD_FLAG = "0";
            //}
            //cWhereParm = cWhereParm + " AND B.READ_FLAG='" + cREAD_FLAG + "'";

            List<Map<String, Object>> rs = dao.getListAsMap(cFieldList, cTableList, cWhereParm, cOrderList);
            vret = ActiveResult.Query(rs);
        }
        return vret;
    }

    public static ActiveResult Read_Flag(HttpServletRequest request,HttpServletResponse response) {
        ActiveResult vret = ActiveResult.Info("参数：READ_FLAG");
        //XT_CONF_USERS_Dao dao = new XT_CONF_USERS_Dao();
        //XT_CONF_USERS vo = new XT_CONF_USERS();
       // vo = (XT_CONF_USERS) RequestUtil.readFromRequest(request, vo);

        String cCONF_ID = StringEx.getStr(request.getParameter("CONF_ID"));
        String cUSER_ID = StringEx.getStr(request.getParameter("USER_ID"));
        if (StringEx.isEmpty(cCONF_ID)) {
            vret = ActiveResult.Valid("CONF_ID参数不能为空！");
        } else if (StringEx.isEmpty(cUSER_ID)) {
            vret = ActiveResult.Valid("USER_ID参数不能为空！");
        } else {
            int iCode = DbManager.ExeSql(" update XT_CONF_USERS set READ_FLAG = 1 where CONF_ID = '" + cCONF_ID + "' and USER_ID = '" + cUSER_ID + "'");
            vret = ActiveResult.Info("READ_FLAG标记更新成功");
        }
        return vret;
    }
}

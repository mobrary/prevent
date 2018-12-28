package com.tlkj.gw.API;

import com.jfinal.template.stat.ast.Return;
import com.tlkj.CommonUtils.ActiveResult;
import com.tlkj.CommonUtils.AppConfig;
import com.tlkj.CommonUtils.StringEx;
import com.tlkj.db.DbManager;
import com.tlkj.gw.dao.S_ORG_INF_Dao;
import com.tlkj.gw.dao.S_USER_INF_Dao;
import com.tlkj.gw.dao.S_VERSION_Dao;
import com.tlkj.gw.dao.XT_DEVICE_Dao;
import com.tlkj.gw.entity.S_ORG_INF;
import com.tlkj.gw.entity.S_USER_INF;
import com.tlkj.gw.entity.S_VERSION;
import com.tlkj.gw.entity.XT_DEVICE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WEB_API {
    public static ActiveResult USER_LOGIN(HttpServletRequest request, HttpServletResponse response) {
        S_USER_INF_Dao dao = new S_USER_INF_Dao();
        String cUSER_ID = StringEx.getStr(request.getParameter("USER_NAME"));
        String cUSER_PASS = StringEx.getStr(request.getParameter("USER_PASS"));
        List<S_USER_INF> rs = dao.getList("USER_CODE='" + cUSER_ID + "'");
        ActiveResult vret = ActiveResult.Valid(AppConfig.FAILURE);
        Map<String, Object> vLoginUserInfo = null;
        if ((rs != null) && (rs.size() == 1)) {
            S_USER_INF vUserInf = rs.get(0);
            if (vUserInf.getUser_pass().equals(cUSER_PASS)) {
                if (vUserInf.getUser_status() == 0) {
                    vret = ActiveResult.Valid("用户账号尚未启用！");
                } else {
                    vLoginUserInfo = new HashMap<String, Object>();
                    vLoginUserInfo.put("org_id", vUserInf.getOrg_id());
                    vLoginUserInfo.put("user_id", vUserInf.getUser_id());
                    vLoginUserInfo.put("role_id", vUserInf.getRole_id());
                    vLoginUserInfo.put("user_name", vUserInf.getUser_name());
                    vLoginUserInfo.put("db_ver", "");
                    vLoginUserInfo.put("sys_ver", "");
                    vLoginUserInfo.put("update_time", "");
                    vLoginUserInfo.put("org_name", "");
                    S_VERSION_Dao VerDao = new S_VERSION_Dao();
                    List<S_VERSION> verRS = VerDao.getList(null);
                    if ((verRS != null) && (rs.size() > 1)) {
                        S_VERSION sVersion = verRS.get(0);
                        vLoginUserInfo.put("db_ver", sVersion.getDb_ver());
                        vLoginUserInfo.put("sys_ver", sVersion.getSys_ver());
                        vLoginUserInfo.put("update_time", sVersion.getUpdate_time());
                    }

                    S_ORG_INF_Dao OrgDao = new S_ORG_INF_Dao();
                    String cWhereParm = "ORG_ID='" + vUserInf.getOrg_id() + "'";
                    List<S_ORG_INF> orgRS = OrgDao.getList(cWhereParm);

                    if ((orgRS != null) && (orgRS.size() > 1)) {
                        S_ORG_INF rowKey = orgRS.get(0);
                        vLoginUserInfo.put("org_name", rowKey.getOrg_name());
                    }
                    vret = ActiveResult.Info(vLoginUserInfo);
                }
            } else {
                vret = ActiveResult.Valid("用户账号或密码错误！");
            }
        } else {
            vret = ActiveResult.Valid("系统服务器状态异常！");
        }
        return vret;
    }

    public static ActiveResult getLeft(HttpServletRequest request, HttpServletResponse response) {
        ActiveResult vret = null;
        String cUSER_ID = StringEx.getStr(request.getParameter("USER_ID"));
        if (StringEx.isEmpty(cUSER_ID)) {
            return ActiveResult.Valid("USER_ID参数不能为空！");
        }
        String cTYPE_ID = StringEx.getStr(request.getParameter("TYPE_ID"));
        if (StringEx.isEmpty(cTYPE_ID)) {
            return ActiveResult.Valid("USER_ID参数不能为空！");
        }
        Integer iROLE_ID = new S_USER_INF_Dao().FindItem(cUSER_ID).getRole_id();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT X.* FROM s_nodes X, s_role_grant B ");
        sql.append(" WHERE X.NODE_ID = B.NODE_ID AND PARENT_ID='" + cTYPE_ID + "' AND B.ROLE_ID = '" + iROLE_ID + "'");
        List<Map<String, Object>> rs = DbManager.QueryList(sql.toString());
        return ActiveResult.Query(rs);
    }

    public static ActiveResult getTop(HttpServletRequest request, HttpServletResponse response) {
        String cUSER_ID = StringEx.getStr(request.getParameter("USER_ID"));
        if (StringEx.isEmpty(cUSER_ID)) {
            return ActiveResult.Valid("USER_ID参数不能为空！");
        }
        Integer iROLE_ID = new S_USER_INF_Dao().FindItem(cUSER_ID).getRole_id();
        if (StringEx.isEmpty(iROLE_ID)) {
            return ActiveResult.Valid("ROLE_ID获取失败！");
        }
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT X.* FROM s_nodes X, s_role_grant B ");
        sql.append(" WHERE X.NODE_ID = B.NODE_ID AND PARENT_ID=0 AND B.ROLE_ID = '" + iROLE_ID + "'");
        List<Map<String, Object>> rs = DbManager.QueryList(sql.toString());
        return ActiveResult.Query(rs);
    }

    public static ActiveResult getList(HttpServletRequest request, HttpServletResponse response) {
        String cUSER_ID = StringEx.getStr(request.getParameter("USER_ID"));
        if (StringEx.isEmpty(cUSER_ID)) {
            return ActiveResult.Valid("USER_ID参数不能为空！");
        }
        Integer iROLE_ID = new S_USER_INF_Dao().FindItem(cUSER_ID).getRole_id();
        if (StringEx.isEmpty(iROLE_ID)) {
            return ActiveResult.Valid("ROLE_ID获取失败！");
        }
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT X.* FROM s_nodes X, s_role_grant B ");
        sql.append(" WHERE X.NODE_ID = B.NODE_ID AND B.ROLE_ID = '" + iROLE_ID + "'");
        List<Map<String, Object>> rs = DbManager.QueryList(sql.toString());
        return ActiveResult.Query(rs);
    }
}

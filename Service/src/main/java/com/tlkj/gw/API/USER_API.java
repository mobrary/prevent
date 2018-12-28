package com.tlkj.gw.API;

import com.tlkj.CommonUtils.ActiveResult;
import com.tlkj.CommonUtils.AppConfig;
import com.tlkj.CommonUtils.StringEx;
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
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class USER_API {
    public static ActiveResult APP_USER_LOGIN(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");//只对post提交有效
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

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
                    XT_DEVICE_Dao deviceDao = new XT_DEVICE_Dao();
                    String cDEVICE_ID = StringEx.getStr(request.getParameter("DEVICE_ID"));
                    String cAPP_VER = StringEx.getStr(request.getParameter("APP_VER"));
                    String cSYS_VER = StringEx.getStr(request.getParameter("SYS_VER"));

                    XT_DEVICE xtDevice = new XT_DEVICE();
                    xtDevice.setDevice_id(cDEVICE_ID);
                    xtDevice.setOrg_id(vUserInf.getOrg_id());
                    xtDevice.setAppver(cAPP_VER);
                    xtDevice.setSysver(cSYS_VER);
                    xtDevice.setUser_id(vUserInf.getUser_id());
                    xtDevice.setIsactive(1);
                    int iCode = deviceDao.Save(xtDevice, xtDevice.getDevice_id());
                    if (iCode == 0) {
                        deviceDao.Save(xtDevice, null);
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


    public static ActiveResult ModifyKeyWord(HttpServletRequest request, HttpServletResponse response) {
        S_USER_INF_Dao dao = new S_USER_INF_Dao();
        String cUSER_ID = StringEx.getStr(request.getParameter("USER_NAME"));
        String cUSER_PASS = StringEx.getStr(request.getParameter("USER_PASS"));//新密码
        String cOLD_PASS = StringEx.getStr(request.getParameter("OLD_PASS"));
        List<S_USER_INF> rs = dao.getList("USER_CODE='" + cUSER_ID + "' AND USER_PASS='" + cOLD_PASS + "'");
        ActiveResult vret = ActiveResult.Valid(AppConfig.FAILURE);
        Map<String,Object> vLoginUserInfo = null;
        if((rs != null)&&(rs.size() == 1)){
            S_USER_INF vUserInf = rs.get(0);
            if(vUserInf.getUser_pass().equals(cOLD_PASS)){
                if((vUserInf.getUser_status() == 0)){
                    vret = ActiveResult.Valid("用户账号尚未启用！");
                }else{
                    Integer iCode = AppConfig.FAILURE;
                    if (rs != null && rs.size() == 1) {
                        S_USER_INF rowKey = rs.get(0);
                        rowKey.setUser_pass(cUSER_PASS);
                        iCode = dao.Save(rowKey, rowKey.getUser_id());
                    }
                    vret = ActiveResult.Valid("密码修改成功！");
                }
            }else {
                vret = ActiveResult.Valid("系统服务器状态异常！");
            }
        }else{
            vret = ActiveResult.Valid("密码输入错误！");
        }

        return vret;
    }
}

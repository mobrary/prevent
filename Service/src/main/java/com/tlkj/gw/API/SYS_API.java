package com.tlkj.gw.API;

import com.tlkj.CommonUtils.ActiveResult;
import com.tlkj.CommonUtils.AppConfig;
import com.tlkj.CommonUtils.RequestUtil;
import com.tlkj.CommonUtils.StringEx;
import com.tlkj.framework.AutoID;
import com.tlkj.gw.dao.S_ORG_INF_Dao;
import com.tlkj.gw.dao.S_USER_INF_Dao;
import com.tlkj.gw.dao.S_VERSION_Dao;
import com.tlkj.gw.dao.XT_FEED_BACK_Dao;
import com.tlkj.gw.entity.S_ORG_INF;
import com.tlkj.gw.entity.S_USER_INF;
import com.tlkj.gw.entity.S_VERSION;
import com.tlkj.gw.entity.XT_FEED_BACK;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SYS_API {
    public static ActiveResult Feed_Back(HttpServletRequest request, HttpServletResponse response) {
        ActiveResult vret = ActiveResult.Info("参数:DEVICE_ID,PHONE_NUM,LOG_TEXT,MAILNO");
        XT_FEED_BACK vo = new XT_FEED_BACK();
        vo = (XT_FEED_BACK) RequestUtil.readFromRequest(request, vo);
        if (StringEx.isEmpty(vo.getDevice_id())) {
            vret = ActiveResult.Info("DEVICE_ID不能为空！");
        } else if (StringEx.isEmpty(vo.getPhone_num())) {
            vret = ActiveResult.Info("PHONE_NUM不能为空！");
        } else if (StringEx.isEmpty(vo.getLog_text())) {
            vret = ActiveResult.Info("LOG_TEXT不能为空！");
        } else {
            vo.setId(AutoID.getAutoID().getID());
            XT_FEED_BACK_Dao dao = new XT_FEED_BACK_Dao();
            int iCode = dao.Save(vo, null);
            vret = ActiveResult.Valid(iCode);
        }
        return vret;
    }
}

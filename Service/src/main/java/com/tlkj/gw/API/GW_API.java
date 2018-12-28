package com.tlkj.gw.API;

import com.jfinal.kit.PropKit;
import com.tlkj.CommonUtils.ActiveResult;
import com.tlkj.CommonUtils.AppConfig;
import com.tlkj.CommonUtils.RequestUtil;
import com.tlkj.CommonUtils.StringEx;
import com.tlkj.Utils.WordUtil;
import com.tlkj.db.DBResult;
import com.tlkj.db.DbManager;
import com.tlkj.framework.AutoID;
import com.tlkj.framework.DateUtil;
import com.tlkj.gw.dao.S_ORG_INF_Dao;
import com.tlkj.gw.dao.S_USER_INF_Dao;
import com.tlkj.gw.dao.XT_GW_STEP_Dao;
import com.tlkj.gw.entity.XT_GW_STEP;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.Map;

public class GW_API {
    private static Logger log = LoggerFactory.getLogger(GW_API.class);

    public static ActiveResult GW(HttpServletRequest request, HttpServletResponse response) {

        ActiveResult vret = ActiveResult.Info("参数:ORG_ID,USER_ID,READ_FLAG,ID");
        String cORG_ID = StringEx.getStr(request.getParameter("ORG_ID"));
        String cUSER_ID = StringEx.getStr(request.getParameter("USER_ID"));
        String cREAD_FLAG = StringEx.getStr(request.getParameter("READ_FLAG"));
        String cTYPE_NAME = StringEx.getStr(request.getParameter("TYPE_NAME"));
        String cTAG = StringEx.getStr(request.getParameter("TAG"));
        String cID = StringEx.getStr(request.getParameter("ID"));
        if (StringEx.isEmpty(cREAD_FLAG)) {
            cREAD_FLAG = "0";
        }
        if (StringEx.isEmpty("cUSER_ID")) {
            vret = ActiveResult.Info("USER_ID不能为空！");
        } else {
            String cWhereParm = " EXISTS(SELECT 1 FROM xt_gw_step X WHERE X.COMPLETE_USER_ID='" + cUSER_ID + "' AND X.GW_ID=T.GW_ID AND IS_COMPLETE=" + cREAD_FLAG + ")";
            if (!StringEx.isEmpty(cTYPE_NAME)) {
                cWhereParm = cWhereParm + " AND (gw_title LIKE '%" + cTYPE_NAME + "%' OR (gw_no LIKE '%" + cTYPE_NAME + "%'))";
            }
            //String cFieldList = "STEP_GUID,ORG_ID,GW_ID,WF_ID,ACTION_ID,FLOW_ID,CREATE_USER_ID,CREATE_TIME,READ_FLAG,READ_TIME,ACTION_TYPE,COMPLETE_USER_ID,COMPLETE_TIME,FLOW_STATUS,FLOW_CONTENT,IS_COMPLETE,GW_ID,ORG_ID,GW_NO,SW_DATE,SW_NO,SW_ORG,GW_TITLE,GW_TYPE,GW_SAFE,FW_ORG,FW_KEYWORD,FW_TYPE,FW_CHECK,FW_COPY,FW_SIGN,FILE_LIST,GW_CS";
            //cFieldList = cFieldList + ",CONCAT('/api/make_pdf?ID=',GW_ID) AS PDF_LIST";
            // cFieldList = cFieldList + ",(SELECT MAX(STEP_GUID) FROM xt_gw_step X WHERE X.COMPLETE_USER_ID='" + cUSER_ID + "' AND IS_COMPLETE=0 AND X.GW_ID=T.GW_ID) AS STEP_GUID";
//            cFieldList = cFieldList + ",(SELECT READ_FLAG FROM xt_gw_step X WHERE X.COMPLETE_USER_ID='" + cUSER_ID + "' AND IS_COMPLETE=0 AND X.GW_ID=T.GW_ID ORDER BY STEP_GUID DESC limit 1) AS READ_FLAG";
            String cOrderList = " T.GW_ID desc";
            String cFieldList = "T.*";
            cFieldList = cFieldList + ",(SELECT MAX(STEP_GUID) FROM xt_gw_step X WHERE X.GW_ID=T.GW_ID) AS STEP_GUID ";
            cFieldList = cFieldList + ",(SELECT X.ACTION_NAME FROM xt_wf_action X WHERE X.ACTION_ID=T.FLOW_ACTION_ID) AS ACTION_NAME ";
            String cTableList = "XT_GW T ";
            if (!StringEx.isEmpty(cID)) {
                if (StringEx.isEmpty(cTAG) && cTAG.equals("1")) {
                    cWhereParm = cWhereParm + " AND GW_ID>'" + cID + "'";
                } else {
                    cWhereParm = cWhereParm + " AND GW_ID<'" + cID + "'";
                }
            }
            List<Map<String, Object>> rs = DbManager.QueryList(cFieldList, cTableList, cWhereParm, cOrderList);
            for (int i = 0; (rs != null) && (i < rs.size()); i++) {
                Map<String, Object> rowKey = rs.get(i);
                String cSTEP_GUID = StringEx.getMapVal(rowKey, "step_guid");
                String cGW_ID = StringEx.getMapVal(rowKey, "gw_id");
                rowKey.put("pdf_list", "/api/gw_pdf?ID=" + cGW_ID);
                String vSQL = " SELECT count(1) FROM xt_gw_step WHERE COMPLETE_USER_ID='" + cUSER_ID + "' AND gw_id='" + cGW_ID + "'";
                int iREAD_FLAG = DbManager.getIntValue(vSQL);
                if (iREAD_FLAG > 0)
                    rowKey.put("read_flag", 1);
                else
                    rowKey.put("read_flag", 0);
            }
            vret = ActiveResult.Query(rs);
        }
        return vret;
    }

    public static ActiveResult make_pdf(HttpServletRequest request, HttpServletResponse response) {
        ActiveResult vret = ActiveResult.Valid(AppConfig.FAILURE);
        String cPath = PropKit.get("WEB_PATH");
        String cGW_ID = StringEx.getSafeParm(request.getParameter("GW_ID"));
        if (StringEx.isEmpty(cGW_ID)) {
            cGW_ID = StringEx.getSafeParm(request.getParameter("ID"));
        }

        String cSql = " select * from v_gw where gw_id ='" + cGW_ID + "'";
        List<Map<String, Object>> rs = DbManager.QueryList(cSql);
        for (int i = 0; (rs != null) && (i < rs.size()); i++) {
            Map<String, Object> rowkey = rs.get(i);
            String cGW_TYPE = StringEx.getMapVal(rowkey, "gw_type");
            String cTemplate = "";
            if (cGW_TYPE.equals("F")) {
                cTemplate = cPath + "doc\\GW_FW.docx"; //文件路径
            } else if (cGW_TYPE.equals("S")) {
                cTemplate = cPath + "doc\\GW_SW.docx"; //文件路径
            }
            String cExportFileName = cPath + "upload\\gw\\" + cGW_ID + ".pdf";
            File f = new File(cTemplate);
            if (!f.exists()) {
                log.error("模板文件不存在!");
                vret = ActiveResult.Valid(cTemplate + "模板文件不存在！");
            } else {
                if (WordUtil.ExportPDF(cTemplate, cExportFileName, rowkey)) {
                    vret = ActiveResult.Info("/upload/gw/" + cGW_ID + ".pdf");
                } else {
                    log.error("生成Word文件失败!");
                    vret = ActiveResult.Valid(cTemplate + "生成Word文件失败！");
                }
            }
        }

        return vret;
    }

    public static ActiveResult doSIGN(HttpServletRequest request, HttpServletResponse response) {
        ActiveResult vret = ActiveResult.Info("参数:ORG_ID,USER_ID,GW_ID,GUID");
        String cUSER_ID = StringEx.getStr(request.getParameter("USER_ID"));
        String cSTEP_GUID = StringEx.getStr(request.getParameter("STEP_GUID"));
        String cGW_ID = StringEx.getStr(request.getParameter("GW_ID"));
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE xt_gw_step SET READ_FLAG=1,READ_TIME='" + DateUtil.getDayTimeNum() + "' WHERE STEP_GUID='" + cSTEP_GUID + "'");
        int iCode = DbManager.ExeSql(sql.toString());
        vret = ActiveResult.Valid(iCode);
        return vret;
    }

    public static ActiveResult doTG(HttpServletRequest request, HttpServletResponse response) {
        XT_GW_STEP_Dao dao = new XT_GW_STEP_Dao();
        ActiveResult vret = new ActiveResult();
        String cSTEP_GUID = StringEx.getStr(request.getParameter("STEP_GUID"));
        String cKeyID = DbManager.getStrValue("SELECT GW_ID FROM XT_GW_STEP WHERE STEP_GUID='" + cSTEP_GUID + "'");
        String cUserID = StringEx.getSafeParm(request.getParameter("USER_ID"));
        String cNextUserID = StringEx.getSafeParm(request.getParameter("COMPLETE_USER_ID"));
        String cFLOW_CONTENT = StringEx.getSafeParm(request.getParameter("FLOW_CONTENT"));
        int iCode = 0;
        XT_GW_STEP vo = new XT_GW_STEP();
        vo = (XT_GW_STEP) RequestUtil.readFromRequest(request, vo);
        if (StringEx.isEmpty(cKeyID)) {
            iCode = dao.Save(vo, cKeyID);
        } else {
            iCode = dao.Save_step(cKeyID, cUserID, cNextUserID, cFLOW_CONTENT);
        }
        vret = ActiveResult.Valid(iCode);
        return vret;
    }

    public static ActiveResult orglist(HttpServletRequest request, HttpServletResponse response) {
        ActiveResult vret = ActiveResult.Info("参数:ORG_ID,USER_ID,GW_ID,GUID");
        S_ORG_INF_Dao dao = new S_ORG_INF_Dao();
        String cWhereParm = "";
        List<Map<String, Object>> rs = dao.getListAsMap(cWhereParm);
        vret = ActiveResult.Query(rs);
        return vret;
    }

    public static ActiveResult userlist(HttpServletRequest request, HttpServletResponse response) {
        ActiveResult vret = ActiveResult.Info("参数:ORG_ID");
        S_USER_INF_Dao dao = new S_USER_INF_Dao();
        String cORG_ID = StringEx.getStr(request.getParameter("ORG_ID"));
        String cWhereParm = " ORG_ID='" + cORG_ID + "' ";
        List<Map<String, Object>> rs = dao.getListAsMap(cWhereParm);
        vret = ActiveResult.Query(rs);
        return vret;
    }
}

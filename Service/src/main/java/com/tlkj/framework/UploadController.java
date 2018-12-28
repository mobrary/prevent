package com.tlkj.framework;

import com.jfinal.kit.PropKit;
import com.jfinal.upload.UploadFile;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.tlkj.CommonUtils.ActiveResult;
import com.tlkj.CommonUtils.StringEx;
import com.tlkj.Utils.WordUtil;
import com.tlkj.gw.dao.XT_UPLOAD_Dao;
import com.tlkj.gw.entity.XT_UPLOAD;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/upload")
public class UploadController extends JbootController {
    private static final Logger log= LoggerFactory.getLogger(UploadController.class);
    public void getUploadFile() {
        XT_UPLOAD_Dao dao = new XT_UPLOAD_Dao();
        ActiveResult vret = null;
        String cTYPE_ID = getPara("TYPE_ID").toUpperCase();
        if (StringEx.isEmpty(cTYPE_ID)) {
            vret = ActiveResult.Valid("TYPE_ID参数不能为空！");
        }
        List<UploadFile> UploadFileList = this.getFiles();
        int iLength = (UploadFileList == null) ? 0 : UploadFileList.size();
        if (iLength == 0) {
            vret = ActiveResult.Valid("上传文件不能为空！");
        }
        String cUploadPath= PropKit.get("WEB_PATH");
        log.info("文件路径："+ cUploadPath);;
        List<XT_UPLOAD> KeyList = new ArrayList<XT_UPLOAD>();
        for (int i = 0; i < iLength; i++) {
            UploadFile upload = UploadFileList.get(i);
            File f = upload.getFile();
            XT_UPLOAD rowKey = new XT_UPLOAD();

            String cRootDir = cUploadPath;
            if(!cRootDir.endsWith(File.separator))
            {
                cRootDir=cRootDir+File.separator;
            }
            cRootDir = cRootDir + File.separator + "upload";
            File fDir = new File(cRootDir);
            if (!fDir.exists()) {
                fDir.mkdir();
            }

            String cFileName = f.getName();
            //类型文件夹
            String cFileDir = cRootDir;
            if (!StringEx.isEmpty(cTYPE_ID)) {
                cFileDir = cFileDir + File.separator + cTYPE_ID.toUpperCase();
                fDir = new File(cFileDir);
                if (!fDir.exists()) {
                    fDir.mkdir();
                }
            }

            //日期文件夹
            String cDayNum = DateUtil.getDayNum();
            cFileDir = cFileDir + File.separator + cDayNum.toUpperCase();
            fDir = new File(cFileDir);
            if (!fDir.exists()) {
                fDir.mkdir();
            }

            AutoID vKeyID = AutoID.getAutoID();
            String cFileID = vKeyID.getID();
            String cUPDATE_TIME = vKeyID.getUPDATE_TIME();
            String cFileExt = cFileName.substring(cFileName.lastIndexOf("."));
            String cFileUrl = cFileDir + File.separator + cFileID + "_" + cFileName;
            File fOut = new File(cFileUrl);
            String cUrl = "/upload/" + cTYPE_ID + "/" + cDayNum + "/" + cFileID + "_" + cFileName;
            Boolean isCopyed = FileUtil.Copy(f, fOut);
            if (isCopyed) {
                WordUtil.Word2Pdf(cFileUrl,cFileUrl.replace(".docx",".pdf"));
                int iCode = dao.Save(rowKey, "");
                rowKey.setFile_id(cFileID);
                rowKey.setFile_url(cUrl);
                rowKey.setFile_name(cFileName);
                rowKey.setUpdate_time(cUPDATE_TIME);
                KeyList.add(rowKey);
            }
        }
        vret = ActiveResult.Info(KeyList);
        this.renderJson(vret);
    }
}
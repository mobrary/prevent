package com.tlkj.CommonUtils;

import java.util.List;
import java.util.Map;

public class ActiveResult {
    public int result;
    public String FieldName;
    public String FieldValue;
    public List<Map<String, Object>> rows;
    public Object Info;
    public int total;
    public int pageno;
    public int pagesize;

    public long getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getFieldName() {
        return FieldName;
    }

    public void setFieldName(String fieldName) {
        FieldName = fieldName;
    }

    public String getFieldValue() {
        return FieldValue;
    }

    public void setFieldValue(String fieldValue) {
        FieldValue = fieldValue;
    }

    public List<Map<String, Object>> getRows() {
        return rows;
    }

    public void setRows(List<Map<String, Object>> rows) {
        this.rows = rows;
    }

    public Object getInfo() {
        return Info;
    }

    public void setInfo(Object info) {
        Info = info;
    }

    public ActiveResult() {

    }

    public ActiveResult(String cFieldName, String cFieldValue) {
        ActiveResult ret = new ActiveResult();
        ret.setResult(AppConfig.FAILURE);
        ret.setFieldName(cFieldName);
        ret.setFieldValue(cFieldValue);
    }

    public static ActiveResult Valid(String cFieldName, String cFieldValue) {
        ActiveResult ret = new ActiveResult();
        ret.setResult(AppConfig.FAILURE);
        ret.setFieldName(cFieldName);
        ret.setFieldValue(cFieldValue);
        return ret;

    }

    public static ActiveResult Valid(int iCode) {
        ActiveResult ret = new ActiveResult();
        if (iCode > 0) {
            ret.setResult(AppConfig.SUCCESS);
        } else {
            ret.setResult(iCode);
        }
        return ret;
    }

    public static ActiveResult Valid(String cMessage) {
        ActiveResult ret = new ActiveResult();
        ret.setResult(AppConfig.FAILURE);
        ret.setFieldValue(cMessage);
        return ret;
    }

    public static ActiveResult Query(List<Map<String, Object>> arKeys) {
        ActiveResult ret = new ActiveResult();
        if (arKeys != null) {
            ret.setRows(arKeys);
            ret.setResult(AppConfig.SUCCESS);
        } else {
            ret.setResult(AppConfig.FAILURE);
        }
        return ret;
    }

    public static ActiveResult Info(Object obj) {
        ActiveResult ret = new ActiveResult();
        if (obj != null) {
            ret.setResult(AppConfig.SUCCESS);
            ret.setInfo(obj);
        } else {
            ret.setResult(AppConfig.FAILURE);
        }
        return ret;
    }

}
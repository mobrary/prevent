package com.tlkj.CommonUtils;

import com.tlkj.framework.BeanUtil;
import com.tlkj.framework.Validity;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JActiveTable {
    private String TableName;
    private String WhereParm;

    public Object[] ParmList = null;

    List<JActiveField> FieldList = new ArrayList<JActiveField>();
    List<String> KeyList = new ArrayList<String>();

    public String getWhereParm() {
        return WhereParm;
    }

    public void setWhereParm(String whereParm) {
        WhereParm = whereParm;
    }

    public Object[] getParmList() {
        return ParmList;
    }

    public String getTableName() {
        return TableName;
    }

    public void setTableName(String tableName) {
        TableName = tableName;
    }

    public List<JActiveField> getFieldList() {
        return FieldList;
    }

    public int AddField(JActiveField afField) {
        FieldList.add(afField);
        return FieldList.size() - 1;
    }

    public int setFieldValue(String cFieldName, int iFieldValue) {
        return setFieldValue(cFieldName, String.valueOf(iFieldValue));
    }

    public int setFieldValue(String cFieldName, float fFieldValue) {
        return setFieldValue(cFieldName, String.valueOf(fFieldValue));
    }

    public int setFieldValue(String cFieldName, double dFieldValue) {
        return setFieldValue(cFieldName, String.valueOf(dFieldValue));
    }

    public int setFieldValue(String cFieldName, String cFieldValue) {
        int idx = -1;
        for (int i = 0; i < FieldList.size(); i++) {
            JActiveField acField = FieldList.get(i);
            if (StringUtils.equalsIgnoreCase(acField.getFieldName(), cFieldName)) {
                acField.setFieldValue(cFieldValue);
                idx = i;
                break;
            }
        }
        if(idx        ==-1)
        {
            JActiveField aField=new JActiveField();
            aField.setFieldValue(cFieldValue);
            aField.setFieldName(cFieldName);
            AddField(aField);
            idx= KeyList.size()-1;
        }
        return idx;
    }

    public int AddField(String cFieldName, String cFieldDesc, int iFieldType) {
        return AddField(cFieldName, cFieldDesc, iFieldType, 0, 100, false, false);
    }

    public int AddField(String cFieldName, String cFieldDesc, int iFieldType, int iMinLength, int iMaxLength) {
        return AddField(cFieldName, cFieldDesc, iFieldType, iMinLength, iMaxLength, false, false);
    }

    public int AddField(String cFieldName, String cFieldDesc, int iFieldType, int iMinLength, int iMaxLength, Boolean isKey, Boolean isRequire) {
        JActiveField acField = new JActiveField();
        acField.setDBType(iFieldType);
        acField.setKey(isKey);
        acField.setRequire(isRequire);
        acField.setFieldName(cFieldName);
        acField.setFieldDesc(cFieldDesc);
        FieldList.add(acField);
        return FieldList.size() - 1;
    }

    public int AddField(String cFieldName, String cFieldDesc, String cFieldValue, int iFieldType
            , Boolean isKey, Boolean isRequire
            , Boolean bAllowInsert, String cInsertDefault
            , Boolean bAllowUpdate, String cUpdateDefault) {
        JActiveField acField = new JActiveField();
        acField.setDBType(iFieldType);
        acField.setKey(isKey);
        acField.setRequire(isRequire);
        acField.setFieldName(cFieldName);
        acField.setFieldDesc(cFieldDesc);
        acField.setAllowInsert(bAllowInsert);
        acField.setAllowUpdate(bAllowUpdate);
        acField.setInsertDefault(cInsertDefault);
        acField.setUpdateDefault(cUpdateDefault);
        FieldList.add(acField);
        return FieldList.size() - 1;
    }


    private String getInsertParmSQL() {
        ParmList = new Object[FieldList.size()];
        StringBuffer sql = new StringBuffer();
        List<String> KeyList = new ArrayList<String>();
        List<String> ValList = new ArrayList<String>();
        for (int i = 0; i < FieldList.size(); i++) {
            JActiveField acField = FieldList.get(i);
            String cFieldName = acField.getFieldName();
            String cFieldValue = acField.getFieldValue();
            if (!StringEx.isEmpty(cFieldValue)) {
                String cDefaultValue = acField.getInsertDefault();
                KeyList.add(cFieldName);
                ValList.add(cFieldValue);
                if (sql.length() == 0) {
                    sql.append("INSERT INTO " + this.getTableName() + "(" + cFieldName);
                } else {
                    sql.append("," + cFieldName);
                }
            }
        }
        sql.append(")");
        sql.append(" VALUES(");
        Object[] ParmList = new Object[KeyList.size()];
        for (int i = 0; i < KeyList.size(); i++) {
            sql.append(i == 0 ? "?" : ",?");
            String cFieldValue = ValList.get(i);
            ParmList[i] = cFieldValue.trim();
        }
        sql.append(")");
        return sql.toString();
    }
    private String getInsertSQL() {
        StringBuffer sql = new StringBuffer();
        List<String> KeyList = new ArrayList<String>();
        List<String> ValList = new ArrayList<String>();
        for (int i = 0; i < FieldList.size(); i++) {
            JActiveField acField = FieldList.get(i);
            String cFieldName = acField.getFieldName();
            String cFieldValue = acField.getFieldValue();
            if (!StringEx.isEmpty(cFieldValue)) {
                String cDefaultValue = acField.getInsertDefault();
                KeyList.add(cFieldName);
                ValList.add(cFieldValue);
                if (sql.length() == 0) {
                    sql.append("INSERT INTO " + this.getTableName() + "(" + cFieldName);
                } else {
                    sql.append("," + cFieldName);
                }
            }
        }
        sql.append(")");
        sql.append(" VALUES(");
        for (int i = 0; i < ValList.size(); i++) {
             String cFieldValue = ValList.get(i);
            if (sql.length() == 0) {
                sql.append("'"+cFieldValue+"'");
            } else {
                sql.append(",'"+ cFieldValue+"'");
            }
        }
        sql.append(")");
        return sql.toString();
    }
    private String getUpdateParmSQL() {
        ParmList = new Object[FieldList.size()];
        StringBuffer sql = new StringBuffer();
        List<String> KeyList = new ArrayList<String>();
        List<String> ValList = new ArrayList<String>();
        for (int i = 0; i < FieldList.size(); i++) {
            JActiveField acField = FieldList.get(i);
            String cFieldName = acField.getFieldName();
            String cFieldValue = acField.getFieldValue();
            if (!StringEx.isEmpty(cFieldValue)) {
                String cDefaultValue = acField.getInsertDefault();
                KeyList.add(cFieldName);
                ValList.add(cFieldValue);
                ParmList[i] = cFieldValue.trim();

                if (sql.length() == 0) {
                    sql.append("UPDATE " + this.getTableName() + " SET " + cFieldName + "=?");
                } else {
                    sql.append("," + cFieldName + "=?");
                }
            }
        }

        sql.append(" WHERE "+ getWhereParm());
        return sql.toString();
    }
    private String getUpdateSQL() {
        StringBuffer sql = new StringBuffer();
        List<String> KeyList = new ArrayList<String>();
        List<String> ValList = new ArrayList<String>();
        for (int i = 0; i < FieldList.size(); i++) {
            JActiveField acField = FieldList.get(i);
            String cFieldName = acField.getFieldName();
            String cFieldValue = acField.getFieldValue();
            if (!StringEx.isEmpty(cFieldValue)) {
                String cDefaultValue = acField.getInsertDefault();
                KeyList.add(cFieldName);
                ValList.add(cFieldValue);

                if (sql.length() == 0) {
                    sql.append("UPDATE " + this.getTableName() + " SET " + cFieldName + "='"+cFieldValue+"'");
                } else {
                    sql.append("," + cFieldName + "='"+cFieldValue+"'");
                }
            }
        }

        sql.append(" WHERE "+ getWhereParm());
        return sql.toString();
    }
    public String getParmSQL() {
        if (StringEx.isEmpty(WhereParm))
            return getInsertParmSQL();
        else
            return getUpdateParmSQL();
    }

    public String getSQL() {
        if (StringEx.isEmpty(WhereParm))
            return getInsertSQL();
        else
            return getUpdateSQL();
    }
}

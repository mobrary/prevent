package com.tlkj.CommonUtils;

public class JActiveField {
    private int DBType;
    private Boolean isKey;
    private Boolean isRequire;
    private String FieldName;
    private String FieldValue;
    private String FieldDesc;
    private int MinLength;
    private int MaxLength;
    private Boolean AllowInsert;
    private String InsertDefault;
    private Boolean AllowUpdate;
    private String UpdateDefault;

    public int getDBType() {
        return DBType;
    }

    public void setDBType(int DBType) {
        this.DBType = DBType;
    }

    public String getFieldName() {
        return FieldName;
    }

    public void setFieldName(String fieldName) {
        FieldName = fieldName;
    }

    public String getFieldDesc() {
        return FieldDesc;
    }

    public void setFieldDesc(String fieldDesc) {
        FieldDesc = fieldDesc;
    }

    public int getMinLength() {
        return MinLength;
    }

    public void setMinLength(int minLength) {
        MinLength = minLength;
    }

    public int getMaxLength() {
        return MaxLength;
    }

    public void setMaxLength(int maxLength) {
        MaxLength = maxLength;
    }

    public String getFieldValue() {
        return FieldValue;
    }

    public void setFieldValue(String fieldValue) {
        FieldValue = fieldValue;
    }

    public Boolean getAllowInsert() {
        return AllowInsert;
    }

    public void setAllowInsert(Boolean allowInsert) {
        AllowInsert = allowInsert;
    }

    public String getInsertDefault() {
        return InsertDefault;
    }

    public void setInsertDefault(String insertDefault) {
        InsertDefault = insertDefault;
    }

    public Boolean getAllowUpdate() {
        return AllowUpdate;
    }

    public void setAllowUpdate(Boolean allowUpdate) {
        AllowUpdate = allowUpdate;
    }

    public String getUpdateDefault() {
        return UpdateDefault;
    }

    public void setUpdateDefault(String updateDefault) {
        UpdateDefault = updateDefault;
    }

    public Boolean getKey() {
        return isKey;
    }

    public void setKey(Boolean key) {
        isKey = key;
    }

    public Boolean getRequire() {
        return isRequire;
    }

    public void setRequire(Boolean require) {
        isRequire = require;
    }

    public JActiveField() {
        DBType = com.tlkj.CommonUtils.DBType.ftString;
        isKey = false;
        isRequire = false;
        FieldName = "";
        FieldValue = "";
        FieldDesc = "";
        MinLength = 0;
        MaxLength = 100;
        AllowInsert = true;
        InsertDefault = null;
        AllowUpdate = false;
        UpdateDefault = null;
    }
}

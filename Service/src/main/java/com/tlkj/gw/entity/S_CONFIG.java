package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "S_CONFIG",TableDesc = "配置信息")
public class S_CONFIG
{
 @Column(DBType = DBType.ftString, FieldName = "key_id",FieldDesc = "字典编码", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String key_id;
 @Column(DBType = DBType.ftString, FieldName = "org_id",FieldDesc = "所属字典", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String org_id;
 @Column(DBType = DBType.ftString, FieldName = "key_value",FieldDesc = "字典数值", MinLength = 0,MaxLength = 200,isRequire = false,isKey = false)
 private  String key_value;
 @Column(DBType = DBType.ftString, FieldName = "update_time",FieldDesc = "更新时间", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String update_time;
 public   String getKey_id()
 {
     return key_id;
 }
 public   void setKey_id(String vo)
 {
	key_id=vo;
 }
 public   String getOrg_id()
 {
     return org_id;
 }
 public   void setOrg_id(String vo)
 {
	org_id=vo;
 }
 public   String getKey_value()
 {
     return key_value;
 }
 public   void setKey_value(String vo)
 {
	key_value=vo;
 }
 public   String getUpdate_time()
 {
     return update_time;
 }
 public   void setUpdate_time(String vo)
 {
	update_time=vo;
 }
}


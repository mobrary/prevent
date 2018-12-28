package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_DEVICE",TableDesc = "终端信息")
public class XT_DEVICE
{
 @Column(DBType = DBType.ftString, FieldName = "device_id",FieldDesc = "终端编码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String device_id;
 @Column(DBType = DBType.ftString, FieldName = "org_id",FieldDesc = "单位编码", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String org_id;
 @Column(DBType = DBType.ftString, FieldName = "user_id",FieldDesc = "用户编码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String user_id;
 @Column(DBType = DBType.ftString, FieldName = "appver",FieldDesc = "APP版本", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String appver;
 @Column(DBType = DBType.ftString, FieldName = "sysver",FieldDesc = "系统版本", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String sysver;
 @Column(DBType = DBType.ftInteger, FieldName = "isactive",FieldDesc = "是否有效",isRequire = false,isKey = false)
 private  Integer isactive;
 public   String getDevice_id()
 {
     return device_id;
 }
 public   void setDevice_id(String vo)
 {
	device_id=vo;
 }
 public   String getOrg_id()
 {
     return org_id;
 }
 public   void setOrg_id(String vo)
 {
	org_id=vo;
 }
 public   String getUser_id()
 {
     return user_id;
 }
 public   void setUser_id(String vo)
 {
	user_id=vo;
 }
 public   String getAppver()
 {
     return appver;
 }
 public   void setAppver(String vo)
 {
	appver=vo;
 }
 public   String getSysver()
 {
     return sysver;
 }
 public   void setSysver(String vo)
 {
	sysver=vo;
 }
 public   Integer getIsactive()
 {
     return isactive;
 }
 public   void setIsactive(Integer vo)
 {
	isactive=vo;
 }
}


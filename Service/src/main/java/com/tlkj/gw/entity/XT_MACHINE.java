package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_MACHINE",TableDesc = "设备信息")
public class XT_MACHINE
{
 @Column(DBType = DBType.ftString, FieldName = "device_id",FieldDesc = "设备编码", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String device_id;
 @Column(DBType = DBType.ftString, FieldName = "org_id",FieldDesc = "单位编码", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String org_id;
 @Column(DBType = DBType.ftInteger, FieldName = "device_type",FieldDesc = "设备类型",isRequire = false,isKey = false)
 private  Integer device_type;
 @Column(DBType = DBType.ftString, FieldName = "device_ip",FieldDesc = "设备IP地址", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String device_ip;
 @Column(DBType = DBType.ftString, FieldName = "device_user",FieldDesc = "账号", MinLength = 0,MaxLength = 36,isRequire = false,isKey = false)
 private  String device_user;
 @Column(DBType = DBType.ftString, FieldName = "device_pass",FieldDesc = "密码", MinLength = 0,MaxLength = 36,isRequire = false,isKey = false)
 private  String device_pass;
 @Column(DBType = DBType.ftInteger, FieldName = "device_status",FieldDesc = "设备状态",isRequire = false,isKey = false)
 private  Integer device_status;
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
 public   Integer getDevice_type()
 {
     return device_type;
 }
 public   void setDevice_type(Integer vo)
 {
	device_type=vo;
 }
 public   String getDevice_ip()
 {
     return device_ip;
 }
 public   void setDevice_ip(String vo)
 {
	device_ip=vo;
 }
 public   String getDevice_user()
 {
     return device_user;
 }
 public   void setDevice_user(String vo)
 {
	device_user=vo;
 }
 public   String getDevice_pass()
 {
     return device_pass;
 }
 public   void setDevice_pass(String vo)
 {
	device_pass=vo;
 }
 public   Integer getDevice_status()
 {
     return device_status;
 }
 public   void setDevice_status(Integer vo)
 {
	device_status=vo;
 }
}


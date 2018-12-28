package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "S_VERSION",TableDesc = "版本信息")
public class S_VERSION
{
 @Column(DBType = DBType.ftString, FieldName = "ver_id",FieldDesc = "版本号", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String ver_id;
 @Column(DBType = DBType.ftString, FieldName = "sys_ver",FieldDesc = "系统版本", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String sys_ver;
 @Column(DBType = DBType.ftString, FieldName = "db_ver",FieldDesc = "数据库版本", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String db_ver;
 @Column(DBType = DBType.ftString, FieldName = "update_time",FieldDesc = "更新时间", MinLength = 0,MaxLength = 14,isRequire = false,isKey = false)
 private  String update_time;
 public   String getVer_id()
 {
     return ver_id;
 }
 public   void setVer_id(String vo)
 {
	ver_id=vo;
 }
 public   String getSys_ver()
 {
     return sys_ver;
 }
 public   void setSys_ver(String vo)
 {
	sys_ver=vo;
 }
 public   String getDb_ver()
 {
     return db_ver;
 }
 public   void setDb_ver(String vo)
 {
	db_ver=vo;
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


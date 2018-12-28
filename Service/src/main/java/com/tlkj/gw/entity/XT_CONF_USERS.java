package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_CONF_USERS",TableDesc = "会议人员")
public class XT_CONF_USERS
{
 @Column(DBType = DBType.ftString, FieldName = "conf_id",FieldDesc = "会议编码", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String conf_id;
 @Column(DBType = DBType.ftString, FieldName = "user_id",FieldDesc = "用户编码", MinLength = 0,MaxLength = 12,isRequire = false,isKey = false)
 private  String user_id;
 @Column(DBType = DBType.ftInteger, FieldName = "read_flag",FieldDesc = "读取标志",isRequire = false,isKey = false)
 private  Integer read_flag;
 @Column(DBType = DBType.ftString, FieldName = "read_time",FieldDesc = "读取时间", MinLength = 0,MaxLength = 14,isRequire = false,isKey = false)
 private  String read_time;
 public   String getConf_id()
 {
     return conf_id;
 }
 public   void setConf_id(String vo)
 {
	conf_id=vo;
 }
 public   String getUser_id()
 {
     return user_id;
 }
 public   void setUser_id(String vo)
 {
	user_id=vo;
 }
 public   Integer getRead_flag()
 {
     return read_flag;
 }
 public   void setRead_flag(Integer vo)
 {
	read_flag=vo;
 }
 public   String getRead_time()
 {
     return read_time;
 }
 public   void setRead_time(String vo)
 {
	read_time=vo;
 }
}


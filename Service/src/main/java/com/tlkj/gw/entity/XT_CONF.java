package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_CONF",TableDesc = "会议信息")
public class XT_CONF
{
 @Column(DBType = DBType.ftString, FieldName = "conf_id",FieldDesc = "会议编码", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String conf_id;
 @Column(DBType = DBType.ftString, FieldName = "conf_name",FieldDesc = "会议名称", MinLength = 0,MaxLength = 200,isRequire = false,isKey = false)
 private  String conf_name;
 @Column(DBType = DBType.ftString, FieldName = "conf_start_time",FieldDesc = "会议时间-开始时间", MinLength = 0,MaxLength = 14,isRequire = false,isKey = false)
 private  String conf_start_time;
 @Column(DBType = DBType.ftString, FieldName = "conf_finish_time",FieldDesc = "会议时间-结束时间", MinLength = 0,MaxLength = 14,isRequire = false,isKey = false)
 private  String conf_finish_time;
 @Column(DBType = DBType.ftString, FieldName = "conf_message",FieldDesc = "通知内容", MinLength = 0,MaxLength = 600,isRequire = false,isKey = false)
 private  String conf_message;
 @Column(DBType = DBType.ftString, FieldName = "org_id",FieldDesc = "发布单位", MinLength = 0,MaxLength = 10,isRequire = false,isKey = false)
 private  String org_id;
 public   String getConf_id()
 {
     return conf_id;
 }
 public   void setConf_id(String vo)
 {
	conf_id=vo;
 }
 public   String getConf_name()
 {
     return conf_name;
 }
 public   void setConf_name(String vo)
 {
	conf_name=vo;
 }
 public   String getConf_start_time()
 {
     return conf_start_time;
 }
 public   void setConf_start_time(String vo)
 {
	conf_start_time=vo;
 }
 public   String getConf_finish_time()
 {
     return conf_finish_time;
 }
 public   void setConf_finish_time(String vo)
 {
	conf_finish_time=vo;
 }
 public   String getConf_message()
 {
     return conf_message;
 }
 public   void setConf_message(String vo)
 {
	conf_message=vo;
 }
 public   String getOrg_id()
 {
     return org_id;
 }
 public   void setOrg_id(String vo)
 {
	org_id=vo;
 }
}


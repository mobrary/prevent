package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_FEED_BACK",TableDesc = "信息反馈")
public class XT_FEED_BACK
{
 @Column(DBType = DBType.ftString, FieldName = "id",FieldDesc = "反馈信息编码", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String id;
 @Column(DBType = DBType.ftString, FieldName = "device_id",FieldDesc = "终端编码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String device_id;
 @Column(DBType = DBType.ftString, FieldName = "phone_num",FieldDesc = "联系电话", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String phone_num;
 @Column(DBType = DBType.ftString, FieldName = "log_text",FieldDesc = "反馈内容", MinLength = 0,MaxLength = 2000,isRequire = false,isKey = false)
 private  String log_text;
 @Column(DBType = DBType.ftString, FieldName = "mailno",FieldDesc = "电子邮箱", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String mailno;
 @Column(DBType = DBType.ftString, FieldName = "update_time",FieldDesc = "反馈时间", MinLength = 0,MaxLength = 14,isRequire = false,isKey = false)
 private  String update_time;
 public   String getId()
 {
     return id;
 }
 public   void setId(String vo)
 {
	id=vo;
 }
 public   String getDevice_id()
 {
     return device_id;
 }
 public   void setDevice_id(String vo)
 {
	device_id=vo;
 }
 public   String getPhone_num()
 {
     return phone_num;
 }
 public   void setPhone_num(String vo)
 {
	phone_num=vo;
 }
 public   String getLog_text()
 {
     return log_text;
 }
 public   void setLog_text(String vo)
 {
	log_text=vo;
 }
 public   String getMailno()
 {
     return mailno;
 }
 public   void setMailno(String vo)
 {
	mailno=vo;
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


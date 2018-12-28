package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_PUSH",TableDesc = "推送信息")
public class XT_PUSH
{
 @Column(DBType = DBType.ftString, FieldName = "id",FieldDesc = "推送GUID", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String id;
 @Column(DBType = DBType.ftString, FieldName = "user_id",FieldDesc = "用户编码", MinLength = 0,MaxLength = 12,isRequire = false,isKey = false)
 private  String user_id;
 @Column(DBType = DBType.ftInteger, FieldName = "push_flag",FieldDesc = "推送标志",isRequire = false,isKey = false)
 private  Integer push_flag;
 @Column(DBType = DBType.ftString, FieldName = "push_text",FieldDesc = "推送内容", MinLength = 0,MaxLength = 600,isRequire = false,isKey = false)
 private  String push_text;
 @Column(DBType = DBType.ftString, FieldName = "push_time",FieldDesc = "推送时间", MinLength = 0,MaxLength = 14,isRequire = false,isKey = false)
 private  String push_time;
 public   String getId()
 {
     return id;
 }
 public   void setId(String vo)
 {
	id=vo;
 }
 public   String getUser_id()
 {
     return user_id;
 }
 public   void setUser_id(String vo)
 {
	user_id=vo;
 }
 public   Integer getPush_flag()
 {
     return push_flag;
 }
 public   void setPush_flag(Integer vo)
 {
	push_flag=vo;
 }
 public   String getPush_text()
 {
     return push_text;
 }
 public   void setPush_text(String vo)
 {
	push_text=vo;
 }
 public   String getPush_time()
 {
     return push_time;
 }
 public   void setPush_time(String vo)
 {
	push_time=vo;
 }
}


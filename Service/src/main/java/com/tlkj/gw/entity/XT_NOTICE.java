package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_NOTICE",TableDesc = "##")
public class XT_NOTICE
{
 @Column(DBType = DBType.ftString, FieldName = "notice_id",FieldDesc = "", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String notice_id;
 @Column(DBType = DBType.ftString, FieldName = "user_id",FieldDesc = "", MinLength = 0,MaxLength = 8,isRequire = false,isKey = false)
 private  String user_id;
 @Column(DBType = DBType.ftString, FieldName = "notice_content",FieldDesc = "", MinLength = 0,MaxLength = 65535,isRequire = false,isKey = false)
 private  String notice_content;
 @Column(DBType = DBType.ftString, FieldName = "notice_date",FieldDesc = "", MinLength = 0,MaxLength = 14,isRequire = false,isKey = false)
 private  String notice_date;
 @Column(DBType = DBType.ftString, FieldName = "notice_struct",FieldDesc = "", MinLength = 0,MaxLength = 50,isRequire = false,isKey = false)
 private  String notice_struct;
 @Column(DBType = DBType.ftString, FieldName = "notice_title",FieldDesc = "", MinLength = 0,MaxLength = 50,isRequire = false,isKey = false)
 private  String notice_title;
 @Column(DBType = DBType.ftInteger, FieldName = "isactive",FieldDesc = "",isRequire = false,isKey = false)
 private  Integer isactive;
 public   String getNotice_id()
 {
     return notice_id;
 }
 public   void setNotice_id(String vo)
 {
	notice_id=vo;
 }
 public   String getUser_id()
 {
     return user_id;
 }
 public   void setUser_id(String vo)
 {
	user_id=vo;
 }
 public   String getNotice_content()
 {
     return notice_content;
 }
 public   void setNotice_content(String vo)
 {
	notice_content=vo;
 }
 public   String getNotice_date()
 {
     return notice_date;
 }
 public   void setNotice_date(String vo)
 {
	notice_date=vo;
 }
 public   String getNotice_struct()
 {
     return notice_struct;
 }
 public   void setNotice_struct(String vo)
 {
	notice_struct=vo;
 }
 public   String getNotice_title()
 {
     return notice_title;
 }
 public   void setNotice_title(String vo)
 {
	notice_title=vo;
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


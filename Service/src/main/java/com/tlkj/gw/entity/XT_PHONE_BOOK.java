package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_PHONE_BOOK",TableDesc = "通讯录")
public class XT_PHONE_BOOK
{
 @Column(DBType = DBType.ftString, FieldName = "id",FieldDesc = "ID", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String id;
 @Column(DBType = DBType.ftString, FieldName = "user_id",FieldDesc = "用户编码", MinLength = 0,MaxLength = 12,isRequire = false,isKey = false)
 private  String user_id;
 @Column(DBType = DBType.ftString, FieldName = "telno",FieldDesc = "电话号码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String telno;
 @Column(DBType = DBType.ftString, FieldName = "user_name",FieldDesc = "姓名", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String user_name;
 @Column(DBType = DBType.ftString, FieldName = "unit_name",FieldDesc = "单位", MinLength = 0,MaxLength = 300,isRequire = false,isKey = false)
 private  String unit_name;
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
 public   String getTelno()
 {
     return telno;
 }
 public   void setTelno(String vo)
 {
	telno=vo;
 }
 public   String getUser_name()
 {
     return user_name;
 }
 public   void setUser_name(String vo)
 {
	user_name=vo;
 }
 public   String getUnit_name()
 {
     return unit_name;
 }
 public   void setUnit_name(String vo)
 {
	unit_name=vo;
 }
}


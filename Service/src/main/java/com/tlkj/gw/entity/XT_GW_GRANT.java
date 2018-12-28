package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_GW_GRANT",TableDesc = "")
public class XT_GW_GRANT
{
 @Column(DBType = DBType.ftString, FieldName = "action_id",FieldDesc = "流程活动编码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String action_id;
 @Column(DBType = DBType.ftString, FieldName = "action_name",FieldDesc = "流程活动名称", MinLength = 0,MaxLength = 100,isRequire = false,isKey = false)
 private  String action_name;
 @Column(DBType = DBType.ftString, FieldName = "role_id",FieldDesc = "角色编码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String role_id;
 @Column(DBType = DBType.ftString, FieldName = "user_id",FieldDesc = "用户编码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String user_id;
 public   String getAction_id()
 {
     return action_id;
 }
 public   void setAction_id(String vo)
 {
	action_id=vo;
 }
 public   String getAction_name()
 {
     return action_name;
 }
 public   void setAction_name(String vo)
 {
	action_name=vo;
 }
 public   String getRole_id()
 {
     return role_id;
 }
 public   void setRole_id(String vo)
 {
	role_id=vo;
 }
 public   String getUser_id()
 {
     return user_id;
 }
 public   void setUser_id(String vo)
 {
	user_id=vo;
 }
}


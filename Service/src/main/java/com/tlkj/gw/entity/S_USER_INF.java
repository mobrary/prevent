package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "S_USER_INF",TableDesc = "用户信息")
public class S_USER_INF
{
 @Column(DBType = DBType.ftString, FieldName = "user_id",FieldDesc = "用户编码", MinLength = 0,MaxLength = 12,isRequire = false,isKey = false)
 private  String user_id;
 @Column(DBType = DBType.ftString, FieldName = "user_code",FieldDesc = "登录账号", MinLength = 0,MaxLength = 50,isRequire = false,isKey = false)
 private  String user_code;
 @Column(DBType = DBType.ftString, FieldName = "user_name",FieldDesc = "用户名称", MinLength = 0,MaxLength = 50,isRequire = false,isKey = false)
 private  String user_name;
 @Column(DBType = DBType.ftString, FieldName = "user_pass",FieldDesc = "用户权限", MinLength = 0,MaxLength = 50,isRequire = false,isKey = false)
 private  String user_pass;
 @Column(DBType = DBType.ftInteger, FieldName = "role_id",FieldDesc = "角色编号",isRequire = false,isKey = false)
 private  Integer role_id;
 @Column(DBType = DBType.ftString, FieldName = "org_id",FieldDesc = "单位编码", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String org_id;

 @Column(DBType = DBType.ftInteger, FieldName = "user_status",FieldDesc = "用户状态",isRequire = false,isKey = false)
 private  Integer user_status;

 @Column(DBType = DBType.ftInteger, FieldName = "isactive",FieldDesc = "是否启用",isRequire = false,isKey = false)
 private  Integer isactive;

 public   String getUser_id()
 {
     return user_id;
 }
 public   void setUser_id(String vo)
 {
	user_id=vo;
 }
 public   String getUser_code()
 {
     return user_code;
 }
 public   void setUser_code(String vo)
 {
	user_code=vo;
 }
 public   String getUser_name()
 {
     return user_name;
 }
 public   void setUser_name(String vo)
 {
	user_name=vo;
 }
 public   String getUser_pass()
 {
     return user_pass;
 }
 public   void setUser_pass(String vo)
 {
	user_pass=vo;
 }
 public   Integer getRole_id()
 {
     return role_id;
 }
 public   void setRole_id(Integer vo)
 {
	role_id=vo;
 }
 public   String getOrg_id()
 {
     return org_id;
 }
 public   void setOrg_id(String vo)
 {
	org_id=vo;
 }
 public   Integer getUser_status()
 {
     return user_status;
 }
 public   void setUser_status(Integer vo)
 {
	user_status=vo;
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


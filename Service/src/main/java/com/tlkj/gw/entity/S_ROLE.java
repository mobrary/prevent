package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "S_ROLE",TableDesc = "角色信息")
public class S_ROLE
{
 @Column(DBType = DBType.ftInteger, FieldName = "role_id",FieldDesc = "角色编号",isRequire = false,isKey = false)
 private  Integer role_id;
 @Column(DBType = DBType.ftString, FieldName = "role_name",FieldDesc = "角色名称", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String role_name;
 @Column(DBType = DBType.ftInteger, FieldName = "role_level",FieldDesc = "角色级别",isRequire = false,isKey = false)
 private  Integer role_level;
 @Column(DBType = DBType.ftInteger, FieldName = "orderby",FieldDesc = "排序",isRequire = false,isKey = false)
 private  Integer orderby;
 @Column(DBType = DBType.ftInteger, FieldName = "isactive",FieldDesc = "是否启用",isRequire = false,isKey = false)
 private  Integer isactive;
 public   Integer getRole_id()
 {
     return role_id;
 }
 public   void setRole_id(Integer vo)
 {
	role_id=vo;
 }
 public   String getRole_name()
 {
     return role_name;
 }
 public   void setRole_name(String vo)
 {
	role_name=vo;
 }
 public   Integer getRole_level()
 {
     return role_level;
 }
 public   void setRole_level(Integer vo)
 {
	role_level=vo;
 }
 public   Integer getOrderby()
 {
     return orderby;
 }
 public   void setOrderby(Integer vo)
 {
	orderby=vo;
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


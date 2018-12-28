package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "S_ROLE_GRANT",TableDesc = "角色权限")
public class S_ROLE_GRANT
{
 @Column(DBType = DBType.ftString, FieldName = "node_id",FieldDesc = "模块编号", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String node_id;
 @Column(DBType = DBType.ftString, FieldName = "role_id",FieldDesc = "角色编号", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String role_id;
 public   String getNode_id()
 {
     return node_id;
 }
 public   void setNode_id(String vo)
 {
	node_id=vo;
 }
 public   String getRole_id()
 {
     return role_id;
 }
 public   void setRole_id(String vo)
 {
	role_id=vo;
 }
}


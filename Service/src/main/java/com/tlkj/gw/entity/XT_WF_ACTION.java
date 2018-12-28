package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_WF_ACTION",TableDesc = "")
public class XT_WF_ACTION
{
 @Column(DBType = DBType.ftString, FieldName = "action_id",FieldDesc = "流程活动编码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String action_id;
 @Column(DBType = DBType.ftString, FieldName = "action_name",FieldDesc = "流程活动名称", MinLength = 0,MaxLength = 100,isRequire = false,isKey = false)
 private  String action_name;
 @Column(DBType = DBType.ftInteger, FieldName = "type_id",FieldDesc = "流程类型",isRequire = false,isKey = false)
 private  Integer type_id;
 @Column(DBType = DBType.ftString, FieldName = "start_id",FieldDesc = "开始流程编码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String start_id;
 @Column(DBType = DBType.ftString, FieldName = "finish_id",FieldDesc = "结束流程编码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String finish_id;
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
 public   Integer getType_id()
 {
     return type_id;
 }
 public   void setType_id(Integer vo)
 {
	type_id=vo;
 }
 public   String getStart_id()
 {
     return start_id;
 }
 public   void setStart_id(String vo)
 {
	start_id=vo;
 }
 public   String getFinish_id()
 {
     return finish_id;
 }
 public   void setFinish_id(String vo)
 {
	finish_id=vo;
 }
}


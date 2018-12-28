package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_WF_FLOW",TableDesc = "")
public class XT_WF_FLOW
{
 @Column(DBType = DBType.ftString, FieldName = "flow_id",FieldDesc = "流程编码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String flow_id;
 @Column(DBType = DBType.ftString, FieldName = "flow_name",FieldDesc = "流程名称", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String flow_name;
 @Column(DBType = DBType.ftInteger, FieldName = "type_id",FieldDesc = "节点类型",isRequire = false,isKey = false)
 private  Integer type_id;
 @Column(DBType = DBType.ftString, FieldName = "wf_id",FieldDesc = "工作流编码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String wf_id;
 @Column(DBType = DBType.ftInteger, FieldName = "orderby",FieldDesc = "流程排序",isRequire = false,isKey = false)
 private  Integer orderby;
 public   String getFlow_id()
 {
     return flow_id;
 }
 public   void setFlow_id(String vo)
 {
	flow_id=vo;
 }
 public   String getFlow_name()
 {
     return flow_name;
 }
 public   void setFlow_name(String vo)
 {
	flow_name=vo;
 }
 public   Integer getType_id()
 {
     return type_id;
 }
 public   void setType_id(Integer vo)
 {
	type_id=vo;
 }
 public   String getWf_id()
 {
     return wf_id;
 }
 public   void setWf_id(String vo)
 {
	wf_id=vo;
 }
 public   Integer getOrderby()
 {
     return orderby;
 }
 public   void setOrderby(Integer vo)
 {
	orderby=vo;
 }
}


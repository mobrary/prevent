package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_WF",TableDesc = "")
public class XT_WF
{
 @Column(DBType = DBType.ftString, FieldName = "wf_id",FieldDesc = "工作流编码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String wf_id;
 @Column(DBType = DBType.ftString, FieldName = "wf_name",FieldDesc = "工作流名称", MinLength = 0,MaxLength = 200,isRequire = false,isKey = false)
 private  String wf_name;
 @Column(DBType = DBType.ftString, FieldName = "type_id",FieldDesc = "工作流类型", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String type_id;
 @Column(DBType = DBType.ftString, FieldName = "template_id",FieldDesc = "页面模板", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String template_id;
 @Column(DBType = DBType.ftString, FieldName = "org_id",FieldDesc = "单位编码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String org_id;
 public   String getWf_id()
 {
     return wf_id;
 }
 public   void setWf_id(String vo)
 {
	wf_id=vo;
 }
 public   String getWf_name()
 {
     return wf_name;
 }
 public   void setWf_name(String vo)
 {
	wf_name=vo;
 }
 public   String getType_id()
 {
     return type_id;
 }
 public   void setType_id(String vo)
 {
	type_id=vo;
 }
 public   String getTemplate_id()
 {
     return template_id;
 }
 public   void setTemplate_id(String vo)
 {
	template_id=vo;
 }
 public   String getOrg_id()
 {
     return org_id;
 }
 public   void setOrg_id(String vo)
 {
	org_id=vo;
 }
}


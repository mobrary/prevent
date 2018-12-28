package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_WF_FORM",TableDesc = "")
public class XT_WF_FORM
{
 @Column(DBType = DBType.ftString, FieldName = "form_id",FieldDesc = "表单元素编码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String form_id;
 @Column(DBType = DBType.ftString, FieldName = "form_name",FieldDesc = "表单元素名称", MinLength = 0,MaxLength = 120,isRequire = false,isKey = false)
 private  String form_name;
 @Column(DBType = DBType.ftString, FieldName = "wf_id",FieldDesc = "工作流编码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String wf_id;
 @Column(DBType = DBType.ftString, FieldName = "type_id",FieldDesc = "元素类型", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String type_id;
 @Column(DBType = DBType.ftInteger, FieldName = "form_width",FieldDesc = "宽度",isRequire = false,isKey = false)
 private  Integer form_width;
 @Column(DBType = DBType.ftInteger, FieldName = "form_height",FieldDesc = "高度",isRequire = false,isKey = false)
 private  Integer form_height;
 @Column(DBType = DBType.ftString, FieldName = "valid_msg",FieldDesc = "验证消息", MinLength = 0,MaxLength = 300,isRequire = false,isKey = false)
 private  String valid_msg;
 public   String getForm_id()
 {
     return form_id;
 }
 public   void setForm_id(String vo)
 {
	form_id=vo;
 }
 public   String getForm_name()
 {
     return form_name;
 }
 public   void setForm_name(String vo)
 {
	form_name=vo;
 }
 public   String getWf_id()
 {
     return wf_id;
 }
 public   void setWf_id(String vo)
 {
	wf_id=vo;
 }
 public   String getType_id()
 {
     return type_id;
 }
 public   void setType_id(String vo)
 {
	type_id=vo;
 }
 public   Integer getForm_width()
 {
     return form_width;
 }
 public   void setForm_width(Integer vo)
 {
	form_width=vo;
 }
 public   Integer getForm_height()
 {
     return form_height;
 }
 public   void setForm_height(Integer vo)
 {
	form_height=vo;
 }
 public   String getValid_msg()
 {
     return valid_msg;
 }
 public   void setValid_msg(String vo)
 {
	valid_msg=vo;
 }
}


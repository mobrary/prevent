package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_TYPE",TableDesc = "信息分类")
public class XT_TYPE
{
 @Column(DBType = DBType.ftString, FieldName = "cls_id",FieldDesc = "类型编码", MinLength = 0,MaxLength = 36,isRequire = false,isKey = false)
 private  String cls_id;
 @Column(DBType = DBType.ftString, FieldName = "cls_name",FieldDesc = "类型名称", MinLength = 0,MaxLength = 100,isRequire = false,isKey = false)
 private  String cls_name;
 @Column(DBType = DBType.ftString, FieldName = "type_id",FieldDesc = "类型分类", MinLength = 0,MaxLength = 36,isRequire = false,isKey = false)
 private  String type_id;
 @Column(DBType = DBType.ftInteger, FieldName = "orderby",FieldDesc = "排序",isRequire = false,isKey = false)
 private  Integer orderby;
 @Column(DBType = DBType.ftInteger, FieldName = "isactive",FieldDesc = "是否有效",isRequire = false,isKey = false)
 private  Integer isactive;
 public   String getCls_id()
 {
     return cls_id;
 }
 public   void setCls_id(String vo)
 {
	cls_id=vo;
 }
 public   String getCls_name()
 {
     return cls_name;
 }
 public   void setCls_name(String vo)
 {
	cls_name=vo;
 }
 public   String getType_id()
 {
     return type_id;
 }
 public   void setType_id(String vo)
 {
	type_id=vo;
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


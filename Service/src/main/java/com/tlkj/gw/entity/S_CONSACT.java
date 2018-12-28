package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "S_CONSACT",TableDesc = "系统配置")
public class S_CONSACT
{
 @Column(DBType = DBType.ftString, FieldName = "itemid",FieldDesc = "项目编码", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String itemid;
 @Column(DBType = DBType.ftString, FieldName = "itemname",FieldDesc = "项目名称", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String itemname;
 @Column(DBType = DBType.ftString, FieldName = "def_val",FieldDesc = "默认数值", MinLength = 0,MaxLength = 200,isRequire = false,isKey = false)
 private  String def_val;
 @Column(DBType = DBType.ftInteger, FieldName = "orderby",FieldDesc = "排序",isRequire = false,isKey = false)
 private  Integer orderby;
 @Column(DBType = DBType.ftInteger, FieldName = "isactive",FieldDesc = "是否有效",isRequire = false,isKey = false)
 private  Integer isactive;
 public   String getItemid()
 {
     return itemid;
 }
 public   void setItemid(String vo)
 {
	itemid=vo;
 }
 public   String getItemname()
 {
     return itemname;
 }
 public   void setItemname(String vo)
 {
	itemname=vo;
 }
 public   String getDef_val()
 {
     return def_val;
 }
 public   void setDef_val(String vo)
 {
	def_val=vo;
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


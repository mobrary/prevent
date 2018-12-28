package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "S_DICT",TableDesc = "字典信息")
public class S_DICT
{
 @Column(DBType = DBType.ftInteger, FieldName = "key_id",FieldDesc = "字典编码",isRequire = false,isKey = false)
 private  Integer key_id;
 @Column(DBType = DBType.ftString, FieldName = "key_name",FieldDesc = "字典数值", MinLength = 0,MaxLength = 200,isRequire = false,isKey = false)
 private  String key_name;
 @Column(DBType = DBType.ftInteger, FieldName = "cls_id",FieldDesc = "所属字典",isRequire = false,isKey = false)
 private  Integer cls_id;
 @Column(DBType = DBType.ftString, FieldName = "ext_val",FieldDesc = "扩展数值1", MinLength = 0,MaxLength = 200,isRequire = false,isKey = false)
 private  String ext_val;
 @Column(DBType = DBType.ftString, FieldName = "ext_key",FieldDesc = "扩展数值2", MinLength = 0,MaxLength = 200,isRequire = false,isKey = false)
 private  String ext_key;
 @Column(DBType = DBType.ftInteger, FieldName = "orderby",FieldDesc = "排序",isRequire = false,isKey = false)
 private  Integer orderby;
 @Column(DBType = DBType.ftInteger, FieldName = "isactive",FieldDesc = "是否有效",isRequire = false,isKey = false)
 private  Integer isactive;
 public   Integer getKey_id()
 {
     return key_id;
 }
 public   void setKey_id(Integer vo)
 {
	key_id=vo;
 }
 public   String getKey_name()
 {
     return key_name;
 }
 public   void setKey_name(String vo)
 {
	key_name=vo;
 }
 public   Integer getCls_id()
 {
     return cls_id;
 }
 public   void setCls_id(Integer vo)
 {
	cls_id=vo;
 }
 public   String getExt_val()
 {
     return ext_val;
 }
 public   void setExt_val(String vo)
 {
	ext_val=vo;
 }
 public   String getExt_key()
 {
     return ext_key;
 }
 public   void setExt_key(String vo)
 {
	ext_key=vo;
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


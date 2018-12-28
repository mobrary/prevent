package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_INTERFACE",TableDesc = "统接口")
public class XT_INTERFACE
{
 @Column(DBType = DBType.ftString, FieldName = "interface_url",FieldDesc = "接口地址", MinLength = 0,MaxLength = 100,isRequire = false,isKey = false)
 private  String interface_url;
 @Column(DBType = DBType.ftString, FieldName = "interface_desc",FieldDesc = "接口描述", MinLength = 0,MaxLength = 100,isRequire = false,isKey = false)
 private  String interface_desc;
 public   String getInterface_url()
 {
     return interface_url;
 }
 public   void setInterface_url(String vo)
 {
	interface_url=vo;
 }
 public   String getInterface_desc()
 {
     return interface_desc;
 }
 public   void setInterface_desc(String vo)
 {
	interface_desc=vo;
 }
}


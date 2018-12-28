package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_PAGE_DICT",TableDesc = "页面字典")
public class XT_PAGE_DICT
{
 @Column(DBType = DBType.ftString, FieldName = "dict_id",FieldDesc = "字典编码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String dict_id;
 @Column(DBType = DBType.ftString, FieldName = "dict_sql",FieldDesc = "字典SQL", MinLength = 0,MaxLength = 300,isRequire = false,isKey = false)
 private  String dict_sql;
 @Column(DBType = DBType.ftString, FieldName = "def_val",FieldDesc = "字典默认值", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String def_val;
 public   String getDict_id()
 {
     return dict_id;
 }
 public   void setDict_id(String vo)
 {
	dict_id=vo;
 }
 public   String getDict_sql()
 {
     return dict_sql;
 }
 public   void setDict_sql(String vo)
 {
	dict_sql=vo;
 }
 public   String getDef_val()
 {
     return def_val;
 }
 public   void setDef_val(String vo)
 {
	def_val=vo;
 }
}


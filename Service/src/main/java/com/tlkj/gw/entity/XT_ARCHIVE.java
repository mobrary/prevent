package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_ARCHIVE",TableDesc = "电子档案")
public class XT_ARCHIVE
{
 @Column(DBType = DBType.ftString, FieldName = "id",FieldDesc = "档案编码", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String id;
 @Column(DBType = DBType.ftString, FieldName = "cls_id",FieldDesc = "档案类型编码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String cls_id;
 @Column(DBType = DBType.ftString, FieldName = "org_id",FieldDesc = "单位编码", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String org_id;
 @Column(DBType = DBType.ftString, FieldName = "title",FieldDesc = "档案标题", MinLength = 0,MaxLength = 200,isRequire = false,isKey = false)
 private  String title;
 @Column(DBType = DBType.ftString, FieldName = "page_html",FieldDesc = "档案内容", MinLength = 0,MaxLength = 65535,isRequire = false,isKey = false)
 private  String page_html;
 @Column(DBType = DBType.ftString, FieldName = "create_date",FieldDesc = "创建时间", MinLength = 0,MaxLength = 8,isRequire = false,isKey = false)
 private  String create_date;
 @Column(DBType = DBType.ftString, FieldName = "file_list",FieldDesc = "文件地址", MinLength = 0,MaxLength = 600,isRequire = false,isKey = false)
 private  String file_list;
 public   String getId()
 {
     return id;
 }
 public   void setId(String vo)
 {
	id=vo;
 }
 public   String getCls_id()
 {
     return cls_id;
 }
 public   void setCls_id(String vo)
 {
	cls_id=vo;
 }
 public   String getOrg_id()
 {
     return org_id;
 }
 public   void setOrg_id(String vo)
 {
	org_id=vo;
 }
 public   String getTitle()
 {
     return title;
 }
 public   void setTitle(String vo)
 {
	title=vo;
 }
 public   String getPage_html()
 {
     return page_html;
 }
 public   void setPage_html(String vo)
 {
	page_html=vo;
 }
 public   String getCreate_date()
 {
     return create_date;
 }
 public   void setCreate_date(String vo)
 {
	create_date=vo;
 }
 public   String getFile_list()
 {
     return file_list;
 }
 public   void setFile_list(String vo)
 {
	file_list=vo;
 }
}


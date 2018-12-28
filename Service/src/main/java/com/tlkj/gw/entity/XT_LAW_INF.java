package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_LAW_INF",TableDesc = "法律法规")
public class XT_LAW_INF
{
 @Column(DBType = DBType.ftString, FieldName = "id",FieldDesc = "文书编码", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String id;
 @Column(DBType = DBType.ftString, FieldName = "org_id",FieldDesc = "单位编码", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String org_id;
 @Column(DBType = DBType.ftString, FieldName = "cls_id",FieldDesc = "文书类型", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String cls_id;
 @Column(DBType = DBType.ftString, FieldName = "title",FieldDesc = "文书标题", MinLength = 0,MaxLength = 300,isRequire = false,isKey = false)
 private  String title;
 @Column(DBType = DBType.ftString, FieldName = "page_html",FieldDesc = "文书内容", MinLength = 0,MaxLength = 65535,isRequire = false,isKey = false)
 private  String page_html;
 @Column(DBType = DBType.ftString, FieldName = "publish",FieldDesc = "发文机关", MinLength = 0,MaxLength = 200,isRequire = false,isKey = false)
 private  String publish;
 @Column(DBType = DBType.ftString, FieldName = "publish_date",FieldDesc = "发文时间", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String publish_date;
 @Column(DBType = DBType.ftString, FieldName = "create_date",FieldDesc = "创建时间", MinLength = 0,MaxLength = 8,isRequire = false,isKey = false)
 private  String create_date;
 public   String getId()
 {
     return id;
 }
 public   void setId(String vo)
 {
	id=vo;
 }
 public   String getOrg_id()
 {
     return org_id;
 }
 public   void setOrg_id(String vo)
 {
	org_id=vo;
 }
 public   String getCls_id()
 {
     return cls_id;
 }
 public   void setCls_id(String vo)
 {
	cls_id=vo;
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
 public   String getPublish()
 {
     return publish;
 }
 public   void setPublish(String vo)
 {
	publish=vo;
 }
 public   String getPublish_date()
 {
     return publish_date;
 }
 public   void setPublish_date(String vo)
 {
	publish_date=vo;
 }
 public   String getCreate_date()
 {
     return create_date;
 }
 public   void setCreate_date(String vo)
 {
	create_date=vo;
 }
}


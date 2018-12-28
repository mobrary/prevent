package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_GW",TableDesc = "收发文管理")
public class XT_GW
{
 @Column(DBType = DBType.ftString, FieldName = "gw_id",FieldDesc = "公文ID", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String gw_id;
 @Column(DBType = DBType.ftString, FieldName = "org_id",FieldDesc = "单位编码", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String org_id;
 @Column(DBType = DBType.ftString, FieldName = "gw_no",FieldDesc = "公文编号", MinLength = 0,MaxLength = 120,isRequire = false,isKey = false)
 private  String gw_no;
 @Column(DBType = DBType.ftString, FieldName = "sw_date",FieldDesc = "发文时间", MinLength = 0,MaxLength = 8,isRequire = false,isKey = false)
 private  String sw_date;
 @Column(DBType = DBType.ftString, FieldName = "sw_no",FieldDesc = "原始文号", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String sw_no;
 @Column(DBType = DBType.ftString, FieldName = "sw_org",FieldDesc = "发文机关", MinLength = 0,MaxLength = 120,isRequire = false,isKey = false)
 private  String sw_org;
 @Column(DBType = DBType.ftString, FieldName = "gw_title",FieldDesc = "公文标题", MinLength = 0,MaxLength = 200,isRequire = false,isKey = false)
 private  String gw_title;
 @Column(DBType = DBType.ftString, FieldName = "gw_type",FieldDesc = "公文类型", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String gw_type;
 @Column(DBType = DBType.ftString, FieldName = "gw_safe",FieldDesc = "公文密级", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String gw_safe;
 @Column(DBType = DBType.ftString, FieldName = "fw_org",FieldDesc = "主送机关", MinLength = 0,MaxLength = 120,isRequire = false,isKey = false)
 private  String fw_org;
 @Column(DBType = DBType.ftString, FieldName = "fw_keyword",FieldDesc = "发文主题词", MinLength = 0,MaxLength = 100,isRequire = false,isKey = false)
 private  String fw_keyword;
 @Column(DBType = DBType.ftString, FieldName = "fw_type",FieldDesc = "打字", MinLength = 0,MaxLength = 100,isRequire = false,isKey = false)
 private  String fw_type;
 @Column(DBType = DBType.ftString, FieldName = "fw_check",FieldDesc = "校对", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String fw_check;
 @Column(DBType = DBType.ftString, FieldName = "fw_copy",FieldDesc = "复印分数",MinLength = 0,MaxLength = 11,isRequire = false,isKey = false)
 private  String fw_copy;
 @Column(DBType = DBType.ftString, FieldName = "fw_sign",FieldDesc = "发文签发日期", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String fw_sign;
 @Column(DBType = DBType.ftString, FieldName = "file_list",FieldDesc = "文件列表", MinLength = 0,MaxLength = 600,isRequire = false,isKey = false)
 private  String file_list;
 @Column(DBType = DBType.ftString, FieldName = "gw_cs",FieldDesc = "公文抄送", MinLength = 0,MaxLength = 255,isRequire = false,isKey = false)
 private  String gw_cs;
 @Column(DBType = DBType.ftString, FieldName = "flow_guid",FieldDesc = "流程id", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String flow_guid;
 @Column(DBType = DBType.ftString, FieldName = "flow_action_id",FieldDesc = "flow_action_id", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String flow_action_id;
 @Column(DBType = DBType.ftString, FieldName = "sy_content",FieldDesc = "sy_content", MinLength = 0,MaxLength = 255,isRequire = false,isKey = false)
 private  String sy_content;
 @Column(DBType = DBType.ftString, FieldName = "bz",FieldDesc = "备注", MinLength = 0,MaxLength = 255,isRequire = false,isKey = false)
 private  String bz;
 public   String getGw_id()
 {
     return gw_id;
 }
 public   void setGw_id(String vo)
 {
	gw_id=vo;
 }
 public   String getOrg_id()
 {
     return org_id;
 }
 public   void setOrg_id(String vo)
 {
	org_id=vo;
 }
 public   String getGw_no()
 {
     return gw_no;
 }
 public   void setGw_no(String vo)
 {
	gw_no=vo;
 }
 public   String getSw_date()
 {
     return sw_date;
 }
 public   void setSw_date(String vo)
 {
	sw_date=vo;
 }
 public   String getSw_no()
 {
     return sw_no;
 }
 public   void setSw_no(String vo)
 {
	sw_no=vo;
 }
 public   String getSw_org()
 {
     return sw_org;
 }
 public   void setSw_org(String vo)
 {
	sw_org=vo;
 }
 public   String getGw_title()
 {
     return gw_title;
 }
 public   void setGw_title(String vo)
 {
	gw_title=vo;
 }
 public   String getGw_type()
 {
     return gw_type;
 }
 public   void setGw_type(String vo)
 {
	gw_type=vo;
 }
 public   String getGw_safe()
 {
     return gw_safe;
 }
 public   void setGw_safe(String vo)
 {
	gw_safe=vo;
 }
 public   String getFw_org()
 {
     return fw_org;
 }
 public   void setFw_org(String vo)
 {
	fw_org=vo;
 }
 public   String getFw_keyword()
 {
     return fw_keyword;
 }
 public   void setFw_keyword(String vo)
 {
	fw_keyword=vo;
 }
 public   String getFw_type()
 {
     return fw_type;
 }
 public   void setFw_type(String vo)
 {
	fw_type=vo;
 }
 public   String getFw_check()
 {
     return fw_check;
 }
 public   void setFw_check(String vo)
 {
	fw_check=vo;
 }

 public String getFw_copy() {
  return fw_copy;
 }

 public void setFw_copy(String fw_copy) {
  this.fw_copy = fw_copy;
 }

 public   String getFw_sign()
 {
     return fw_sign;
 }
 public   void setFw_sign(String vo)
 {
	fw_sign=vo;
 }
 public   String getFile_list()
 {
     return file_list;
 }
 public   void setFile_list(String vo)
 {
	file_list=vo;
 }
 public String getGw_cs() {
  return gw_cs;
 }
 public void setGw_cs(String gw_cs) {
  this.gw_cs = gw_cs;
 }

 public String getFlow_guid() {
  return flow_guid;
 }

 public void setFlow_guid(String flow_guid) {
  this.flow_guid = flow_guid;
 }

 public String getFlow_action_id() {
  return flow_action_id;
 }

 public void setFlow_action_id(String flow_action_id) {
  this.flow_action_id = flow_action_id;
 }

 public String getSy_content() {
  return sy_content;
 }

 public void setSy_content(String sy_content) {
  this.sy_content = sy_content;
 }

 public String getBz() {
  return bz;
 }

 public void setBz(String bz) {
  this.bz = bz;
 }
}


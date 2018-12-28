package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "S_ORG_INF",TableDesc = "单位信息")
public class S_ORG_INF
{
 @Column(DBType = DBType.ftString, FieldName = "org_id",FieldDesc = "单位编码", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String org_id;
 @Column(DBType = DBType.ftString, FieldName = "org_name",FieldDesc = "单位名称", MinLength = 0,MaxLength = 50,isRequire = false,isKey = false)
 private  String org_name;
 @Column(DBType = DBType.ftString, FieldName = "org_full_name",FieldDesc = "单位全称", MinLength = 0,MaxLength = 120,isRequire = false,isKey = false)
 private  String org_full_name;
 @Column(DBType = DBType.ftString, FieldName = "org_telno",FieldDesc = "办公电话", MinLength = 0,MaxLength = 12,isRequire = false,isKey = false)
 private  String org_telno;
 @Column(DBType = DBType.ftString, FieldName = "org_mail",FieldDesc = "办公邮箱", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String org_mail;
 @Column(DBType = DBType.ftString, FieldName = "org_leader",FieldDesc = "负责人", MinLength = 0,MaxLength = 50,isRequire = false,isKey = false)
 private  String org_leader;
 @Column(DBType = DBType.ftInteger, FieldName = "org_type",FieldDesc = "单位类型",isRequire = false,isKey = false)
 private  Integer org_type;
 @Column(DBType = DBType.ftInteger, FieldName = "orderby",FieldDesc = "排序",isRequire = false,isKey = false)
 private  Integer orderby;
 @Column(DBType = DBType.ftInteger, FieldName = "isactive",FieldDesc = "是否启用",isRequire = false,isKey = false)
 private  Integer isactive;
 public   String getOrg_id()
 {
     return org_id;
 }
 public   void setOrg_id(String vo)
 {
	org_id=vo;
 }
 public   String getOrg_name()
 {
     return org_name;
 }
 public   void setOrg_name(String vo)
 {
	org_name=vo;
 }
 public   String getOrg_full_name()
 {
     return org_full_name;
 }
 public   void setOrg_full_name(String vo)
 {
	org_full_name=vo;
 }
 public   String getOrg_telno()
 {
     return org_telno;
 }
 public   void setOrg_telno(String vo)
 {
	org_telno=vo;
 }
 public   String getOrg_mail()
 {
     return org_mail;
 }
 public   void setOrg_mail(String vo)
 {
	org_mail=vo;
 }
 public   String getOrg_leader()
 {
     return org_leader;
 }
 public   void setOrg_leader(String vo)
 {
	org_leader=vo;
 }
 public   Integer getOrg_type()
 {
     return org_type;
 }
 public   void setOrg_type(Integer vo)
 {
	org_type=vo;
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


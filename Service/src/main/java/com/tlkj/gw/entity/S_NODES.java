package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "S_NODES",TableDesc = "模块信息表")
public class S_NODES
{
 @Column(DBType = DBType.ftString, FieldName = "node_id",FieldDesc = "模块编号", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String node_id;
 @Column(DBType = DBType.ftString, FieldName = "node_name",FieldDesc = "模块名称", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String node_name;
 @Column(DBType = DBType.ftString, FieldName = "node_url",FieldDesc = "模块地址", MinLength = 0,MaxLength = 120,isRequire = false,isKey = false)
 private  String node_url;
 @Column(DBType = DBType.ftString, FieldName = "parentid",FieldDesc = "上级节点", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String parentid;
 @Column(DBType = DBType.ftString, FieldName = "target",FieldDesc = "对应框架", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String target;
 @Column(DBType = DBType.ftString, FieldName = "imageurl",FieldDesc = "模块缩略图", MinLength = 0,MaxLength = 100,isRequire = false,isKey = false)
 private  String imageurl;
 @Column(DBType = DBType.ftInteger, FieldName = "orderby",FieldDesc = "排序",isRequire = false,isKey = false)
 private  Integer orderby;
 @Column(DBType = DBType.ftInteger, FieldName = "isactive",FieldDesc = "是否启用",isRequire = false,isKey = false)
 private  Integer isactive;
 public   String getNode_id()
 {
     return node_id;
 }
 public   void setNode_id(String vo)
 {
	node_id=vo;
 }
 public   String getNode_name()
 {
     return node_name;
 }
 public   void setNode_name(String vo)
 {
	node_name=vo;
 }
 public   String getNode_url()
 {
     return node_url;
 }
 public   void setNode_url(String vo)
 {
	node_url=vo;
 }
 public   String getParentid()
 {
     return parentid;
 }
 public   void setParentid(String vo)
 {
	parentid=vo;
 }
 public   String getTarget()
 {
     return target;
 }
 public   void setTarget(String vo)
 {
	target=vo;
 }
 public   String getImageurl()
 {
     return imageurl;
 }
 public   void setImageurl(String vo)
 {
	imageurl=vo;
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


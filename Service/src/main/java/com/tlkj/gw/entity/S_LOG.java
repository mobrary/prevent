package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "S_LOG",TableDesc = "系统日志")
public class S_LOG
{
 @Column(DBType = DBType.ftString, FieldName = "log_id",FieldDesc = "日志编号", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String log_id;
 @Column(DBType = DBType.ftString, FieldName = "create_time",FieldDesc = "创建时间", MinLength = 0,MaxLength = 14,isRequire = false,isKey = false)
 private  String create_time;
 @Column(DBType = DBType.ftString, FieldName = "log_content",FieldDesc = "日志内容", MinLength = 0,MaxLength = 200,isRequire = false,isKey = false)
 private  String log_content;
 @Column(DBType = DBType.ftString, FieldName = "create_person",FieldDesc = "创建人", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String create_person;
 public   String getLog_id()
 {
     return log_id;
 }
 public   void setLog_id(String vo)
 {
	log_id=vo;
 }
 public   String getCreate_time()
 {
     return create_time;
 }
 public   void setCreate_time(String vo)
 {
	create_time=vo;
 }
 public   String getLog_content()
 {
     return log_content;
 }
 public   void setLog_content(String vo)
 {
	log_content=vo;
 }
 public   String getCreate_person()
 {
     return create_person;
 }
 public   void setCreate_person(String vo)
 {
	create_person=vo;
 }
}


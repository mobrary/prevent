package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_UPLOAD",TableDesc = "-附件信息")
public class XT_UPLOAD
{
 @Column(DBType = DBType.ftString, FieldName = "file_id",FieldDesc = "FILE_ID", MinLength = 0,MaxLength = 36,isRequire = false,isKey = false)
 private  String file_id;
 @Column(DBType = DBType.ftString, FieldName = "file_name",FieldDesc = "FILE_NAME", MinLength = 0,MaxLength = 100,isRequire = false,isKey = false)
 private  String file_name;
 @Column(DBType = DBType.ftString, FieldName = "file_url",FieldDesc = "FILE_URL", MinLength = 0,MaxLength = 200,isRequire = false,isKey = false)
 private  String file_url;
 @Column(DBType = DBType.ftString, FieldName = "update_time",FieldDesc = "UPDATE_TIME", MinLength = 0,MaxLength = 12,isRequire = false,isKey = false)
 private  String update_time;
 public   String getFile_id()
 {
     return file_id;
 }
 public   void setFile_id(String vo)
 {
	file_id=vo;
 }
 public   String getFile_name()
 {
     return file_name;
 }
 public   void setFile_name(String vo)
 {
	file_name=vo;
 }
 public   String getFile_url()
 {
     return file_url;
 }
 public   void setFile_url(String vo)
 {
	file_url=vo;
 }
 public   String getUpdate_time()
 {
     return update_time;
 }
 public   void setUpdate_time(String vo)
 {
	update_time=vo;
 }
}


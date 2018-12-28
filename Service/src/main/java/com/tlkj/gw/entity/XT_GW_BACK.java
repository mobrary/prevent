package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_GW_BACK",TableDesc = "")
public class XT_GW_BACK
{
 @Column(DBType = DBType.ftString, FieldName = "back_id",FieldDesc = "退回ID", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String back_id;
 @Column(DBType = DBType.ftString, FieldName = "back_remark",FieldDesc = "退回意见", MinLength = 0,MaxLength = 200,isRequire = false,isKey = false)
 private  String back_remark;
 @Column(DBType = DBType.ftString, FieldName = "gw_id",FieldDesc = "公文ID", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String gw_id;
 @Column(DBType = DBType.ftString, FieldName = "action_id",FieldDesc = "活动编码", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String action_id;
 @Column(DBType = DBType.ftString, FieldName = "back_time",FieldDesc = "退回时间", MinLength = 0,MaxLength = 14,isRequire = false,isKey = false)
 private  String back_time;
 @Column(DBType = DBType.ftString, FieldName = "user_id",FieldDesc = "退回人员", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String user_id;
 public   String getBack_id()
 {
     return back_id;
 }
 public   void setBack_id(String vo)
 {
	back_id=vo;
 }
 public   String getBack_remark()
 {
     return back_remark;
 }
 public   void setBack_remark(String vo)
 {
	back_remark=vo;
 }
 public   String getGw_id()
 {
     return gw_id;
 }
 public   void setGw_id(String vo)
 {
	gw_id=vo;
 }
 public   String getAction_id()
 {
     return action_id;
 }
 public   void setAction_id(String vo)
 {
	action_id=vo;
 }
 public   String getBack_time()
 {
     return back_time;
 }
 public   void setBack_time(String vo)
 {
	back_time=vo;
 }
 public   String getUser_id()
 {
     return user_id;
 }
 public   void setUser_id(String vo)
 {
	user_id=vo;
 }
}


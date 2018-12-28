package com.tlkj.gw.entity;
import com.tlkj.CommonUtils.DBType;
import com.tlkj.CommonUtils.Table;
import com.tlkj.CommonUtils.Column;
@Table(TableName = "XT_GW_STEP",TableDesc = "审批信息")
public class XT_GW_STEP
{
 @Column(DBType = DBType.ftString, FieldName = "step_guid",FieldDesc = "流程编码", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String step_guid;
 @Column(DBType = DBType.ftString, FieldName = "org_id",FieldDesc = "单位编码", MinLength = 0,MaxLength = 20,isRequire = false,isKey = false)
 private  String org_id;
 @Column(DBType = DBType.ftString, FieldName = "gw_id",FieldDesc = "公文ID", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String gw_id;
 @Column(DBType = DBType.ftString, FieldName = "wf_id",FieldDesc = "wf_id", MinLength = 0,MaxLength = 60,isRequire = false,isKey = false)
 private  String wf_id;
 @Column(DBType = DBType.ftString, FieldName = "action_id",FieldDesc = "流程活动编码", MinLength = 0,MaxLength = 30,isRequire = false,isKey = false)
 private  String action_id;
 @Column(DBType = DBType.ftString, FieldName = "flow_id",FieldDesc = "流程编号", MinLength = 0,MaxLength = 10,isRequire = false,isKey = false)
 private  String flow_id;
 @Column(DBType = DBType.ftString, FieldName = "create_user_id",FieldDesc = "创建人员", MinLength = 0,MaxLength = 12,isRequire = false,isKey = false)
 private  String create_user_id;
 @Column(DBType = DBType.ftString, FieldName = "create_time",FieldDesc = "创建时间", MinLength = 0,MaxLength = 14,isRequire = false,isKey = false)
 private  String create_time;
 @Column(DBType = DBType.ftInteger, FieldName = "read_flag",FieldDesc = "读取标志",isRequire = false,isKey = false)
 private  Integer read_flag;
 @Column(DBType = DBType.ftString, FieldName = "read_time",FieldDesc = "读取日期", MinLength = 0,MaxLength = 14,isRequire = false,isKey = false)
 private  String read_time;
 @Column(DBType = DBType.ftString, FieldName = "action_type",FieldDesc = "公文类型", MinLength = 0,MaxLength = 10,isRequire = false,isKey = false)
 private  String action_type;
 @Column(DBType = DBType.ftString, FieldName = "complete_user_id",FieldDesc = "审批用户", MinLength = 0,MaxLength = 12,isRequire = false,isKey = false)
 private  String complete_user_id;
 @Column(DBType = DBType.ftString, FieldName = "complete_time",FieldDesc = "审批时间", MinLength = 0,MaxLength = 14,isRequire = false,isKey = false)
 private  String complete_time;
 @Column(DBType = DBType.ftInteger, FieldName = "flow_status",FieldDesc = "审批意见",isRequire = false,isKey = false)
 private  Integer flow_status;
 @Column(DBType = DBType.ftString, FieldName = "flow_content",FieldDesc = "审批内容", MinLength = 0,MaxLength = 200,isRequire = false,isKey = false)
 private  String flow_content;
 @Column(DBType = DBType.ftInteger, FieldName = "is_complete",FieldDesc = "审批标志",isRequire = false,isKey = false)
 private  Integer is_complete;
 public   String getStep_guid()
 {
     return step_guid;
 }
 public   void setStep_guid(String vo)
 {
	step_guid=vo;
 }
 public   String getOrg_id()
 {
     return org_id;
 }
 public   void setOrg_id(String vo)
 {
	org_id=vo;
 }
 public   String getAction_id()
 {
     return action_id;
 }
 public   void setAction_id(String vo)
 {
	action_id=vo;
 }
 public   String getFlow_id()
 {
     return flow_id;
 }
 public   void setFlow_id(String vo)
 {
	flow_id=vo;
 }
 public   String getCreate_user_id()
 {
     return create_user_id;
 }
 public   void setCreate_user_id(String vo)
 {
	create_user_id=vo;
 }
 public   String getCreate_time()
 {
     return create_time;
 }
 public   void setCreate_time(String vo)
 {
	create_time=vo;
 }
 public   Integer getRead_flag()
 {
     return read_flag;
 }
 public   void setRead_flag(Integer vo)
 {
	read_flag=vo;
 }
 public   String getRead_time()
 {
     return read_time;
 }
 public   void setRead_time(String vo)
 {
	read_time=vo;
 }
 public   String getAction_type()
 {
     return action_type;
 }
 public   void setAction_type(String vo)
 {
	action_type=vo;
 }
 public   String getComplete_user_id()
 {
     return complete_user_id;
 }
 public   void setComplete_user_id(String vo)
 {
	complete_user_id=vo;
 }
 public   String getComplete_time()
 {
     return complete_time;
 }
 public   void setComplete_time(String vo)
 {
	complete_time=vo;
 }
 public   Integer getFlow_status()
 {
     return flow_status;
 }
 public   void setFlow_status(Integer vo)
 {
	flow_status=vo;
 }
 public   String getFlow_content()
 {
     return flow_content;
 }
 public   void setFlow_content(String vo)
 {
	flow_content=vo;
 }
 public   Integer getIs_complete()
 {
     return is_complete;
 }
 public   void setIs_complete(Integer vo)
 {
	is_complete=vo;
 }

 public String getGw_id() {
  return gw_id;
 }

 public void setGw_id(String gw_id) {
  this.gw_id = gw_id;
 }

 public String getWf_id() {
  return wf_id;
 }

 public void setWf_id(String wf_id) {
  this.wf_id = wf_id;
 }
}


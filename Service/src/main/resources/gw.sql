/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.9
Source Server Version : 50511
Source Host           : 192.168.1.9:3306
Source Database       : gw

Target Server Type    : MYSQL
Target Server Version : 50511
File Encoding         : 65001

Date: 2018-11-14 18:51:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `s_config`
-- ----------------------------
DROP TABLE IF EXISTS `s_config`;
CREATE TABLE `s_config` (
  `KEY_ID` varchar(20) NOT NULL,
  `ORG_ID` varchar(20) NOT NULL,
  `KEY_VALUE` varchar(200) DEFAULT NULL,
  `UPDATE_TIME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`KEY_ID`,`ORG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_config
-- ----------------------------

-- ----------------------------
-- Table structure for `s_consact`
-- ----------------------------
DROP TABLE IF EXISTS `s_consact`;
CREATE TABLE `s_consact` (
  `ITEMID` varchar(20) NOT NULL,
  `ITEMNAME` varchar(20) DEFAULT NULL,
  `DEF_VAL` varchar(200) DEFAULT NULL,
  `ORDERBY` int(11) DEFAULT NULL,
  `ISACTIVE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ITEMID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_consact
-- ----------------------------

-- ----------------------------
-- Table structure for `s_dict`
-- ----------------------------
DROP TABLE IF EXISTS `s_dict`;
CREATE TABLE `s_dict` (
  `KEY_ID` int(11) NOT NULL,
  `KEY_NAME` varchar(200) DEFAULT NULL,
  `CLS_ID` int(11) NOT NULL,
  `EXT_VAL` varchar(200) DEFAULT NULL,
  `EXT_KEY` varchar(200) DEFAULT NULL,
  `ORDERBY` int(11) DEFAULT NULL,
  `ISACTIVE` int(11) DEFAULT NULL,
  PRIMARY KEY (`KEY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_dict
-- ----------------------------

-- ----------------------------
-- Table structure for `s_log`
-- ----------------------------
DROP TABLE IF EXISTS `s_log`;
CREATE TABLE `s_log` (
  `LOG_ID` varchar(20) NOT NULL,
  `CREATE_TIME` char(14) DEFAULT NULL,
  `LOG_CONTENT` varchar(200) DEFAULT NULL,
  `CREATE_PERSON` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_log
-- ----------------------------

-- ----------------------------
-- Table structure for `s_nodes`
-- ----------------------------
DROP TABLE IF EXISTS `s_nodes`;
CREATE TABLE `s_nodes` (
  `MODEL_ID` varchar(20) NOT NULL,
  `MODEL_NAME` varchar(60) DEFAULT NULL,
  `MODEL_URL` varchar(120) DEFAULT NULL,
  `PARENTID` varchar(20) DEFAULT NULL,
  `TARGET` varchar(60) DEFAULT NULL,
  `IMAGEURL` varchar(100) DEFAULT NULL,
  `ORDERBY` int(11) DEFAULT NULL,
  `ISACTIVE` int(11) DEFAULT NULL,
  PRIMARY KEY (`MODEL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_nodes
-- ----------------------------

-- ----------------------------
-- Table structure for `s_org_inf`
-- ----------------------------
DROP TABLE IF EXISTS `s_org_inf`;
CREATE TABLE `s_org_inf` (
  `ORG_ID` varchar(20) NOT NULL,
  `ORG_NAME` varchar(50) DEFAULT NULL,
  `ORG_FULL_NAME` varchar(120) DEFAULT NULL,
  `ORG_TELNO` varchar(12) DEFAULT NULL,
  `ORG_MAIL` varchar(60) DEFAULT NULL,
  `ORG_LEADER` varchar(50) DEFAULT NULL,
  `ORG_TYPE` int(11) DEFAULT NULL,
  `ORDERBY` int(11) DEFAULT NULL,
  `ISACTIVE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ORG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_org_inf
-- ----------------------------
INSERT INTO `s_org_inf` VALUES ('410100', '郑州市', '郑州市国土资源局', '037166668888', '0371@163.com', null, '4', '0', '1');
INSERT INTO `s_org_inf` VALUES ('411200', '三门峡', '三门峡国土资源局', '037166668888', '411200@163.com', null, '4', '0', '1');

-- ----------------------------
-- Table structure for `s_role`
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role` (
  `ROLE_ID` int(11) NOT NULL,
  `ROLE_NAME` varchar(60) DEFAULT NULL,
  `ROLE_LEVEL` int(11) DEFAULT NULL,
  `ORDERBY` int(11) DEFAULT NULL,
  `ISACTIVE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES ('0', '系统管理员', '0', '1', '1');
INSERT INTO `s_role` VALUES ('1', '管理员', '0', '1', '1');

-- ----------------------------
-- Table structure for `s_role_grant`
-- ----------------------------
DROP TABLE IF EXISTS `s_role_grant`;
CREATE TABLE `s_role_grant` (
  `MODEL_ID` varchar(20) NOT NULL,
  `ROLE_ID` varchar(20) NOT NULL,
  PRIMARY KEY (`MODEL_ID`,`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_role_grant
-- ----------------------------

-- ----------------------------
-- Table structure for `s_user_inf`
-- ----------------------------
DROP TABLE IF EXISTS `s_user_inf`;
CREATE TABLE `s_user_inf` (
  `USER_ID` varchar(12) NOT NULL,
  `USER_CODE` varchar(50) NOT NULL,
  `USER_NAME` varchar(50) NOT NULL,
  `USER_PASS` varchar(50) DEFAULT NULL,
  `ROLE_ID` int(11) DEFAULT NULL,
  `ORG_ID` varchar(20) DEFAULT NULL,
  `USER_STATUS` int(11) DEFAULT NULL,
  `ISACTIVE` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user_inf
-- ----------------------------
INSERT INTO `s_user_inf` VALUES ('41010001', '41010001', '张三', '8888', '1', '410100', '1', '1');
INSERT INTO `s_user_inf` VALUES ('41010002', '41010002', '李四', '8888', '1', '410100', '1', '1');
INSERT INTO `s_user_inf` VALUES ('41010301', 'root', '???', '123456', '1', '410100', '1', '1');

-- ----------------------------
-- Table structure for `s_version`
-- ----------------------------
DROP TABLE IF EXISTS `s_version`;
CREATE TABLE `s_version` (
  `VER_ID` varchar(30) NOT NULL,
  `SYS_VER` varchar(30) DEFAULT NULL,
  `DB_VER` varchar(30) DEFAULT NULL,
  `UPDATE_TIME` char(14) DEFAULT NULL,
  PRIMARY KEY (`VER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_version
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_archive`
-- ----------------------------
DROP TABLE IF EXISTS `xt_archive`;
CREATE TABLE `xt_archive` (
  `ID` varchar(60) NOT NULL,
  `CLS_ID` varchar(30) DEFAULT NULL,
  `ORG_ID` varchar(20) DEFAULT NULL,
  `PAGE_HTML` text,
  `CREATE_DATE` char(8) DEFAULT NULL,
  `FILE_LIST` varchar(600) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_archive
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_archive_cls`
-- ----------------------------
DROP TABLE IF EXISTS `xt_archive_cls`;
CREATE TABLE `xt_archive_cls` (
  `CLS_ID` varchar(30) NOT NULL,
  `CLS_NAME` varchar(200) DEFAULT NULL,
  `TYPE_ID` varchar(30) DEFAULT NULL,
  `ORDERBY` int(11) DEFAULT NULL,
  `ISACTIVE` int(11) DEFAULT NULL,
  PRIMARY KEY (`CLS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_archive_cls
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_black_list`
-- ----------------------------
DROP TABLE IF EXISTS `xt_black_list`;
CREATE TABLE `xt_black_list` (
  `CRIMINAL_ID` varchar(20) NOT NULL,
  `CRIMINAL_NAME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CRIMINAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_black_list
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_conf`
-- ----------------------------
DROP TABLE IF EXISTS `xt_conf`;
CREATE TABLE `xt_conf` (
  `CONF_ID` varchar(60) NOT NULL,
  `CONF_NAME` varchar(200) DEFAULT NULL,
  `CONF_START_TIME` varchar(14) DEFAULT NULL,
  `CONF_FINISH_TIME` varchar(14) DEFAULT NULL,
  `CONF_MESSAGE` varchar(600) DEFAULT NULL,
  `ORG_ID` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`CONF_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_conf
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_conf_users`
-- ----------------------------
DROP TABLE IF EXISTS `xt_conf_users`;
CREATE TABLE `xt_conf_users` (
  `CONF_ID` varchar(60) NOT NULL,
  `USER_ID` varchar(12) DEFAULT NULL,
  `READ_FLAG` int(11) DEFAULT NULL,
  `READ_TIME` char(14) DEFAULT NULL,
  PRIMARY KEY (`CONF_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_conf_users
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_criminal`
-- ----------------------------
DROP TABLE IF EXISTS `xt_criminal`;
CREATE TABLE `xt_criminal` (
  `CRIMINAL_ID` varchar(20) NOT NULL,
  `ORG_ID` varchar(20) DEFAULT NULL,
  `CRIMINAL_NAME` varchar(20) DEFAULT NULL,
  `CRIMINAL_PRISON` varchar(20) DEFAULT NULL,
  `CRIMINAL_STATUS` int(11) DEFAULT NULL,
  `CRIMINAL_PHOTO` varchar(50) DEFAULT NULL,
  `CRIMINAL_TYPE` varchar(50) DEFAULT NULL,
  `CRIMINAL_TERM` int(11) DEFAULT NULL,
  `START_DAY` varchar(10) DEFAULT NULL,
  `FINISH_DAY` varchar(10) DEFAULT NULL,
  `REASON` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CRIMINAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_criminal
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_criminal_status`
-- ----------------------------
DROP TABLE IF EXISTS `xt_criminal_status`;
CREATE TABLE `xt_criminal_status` (
  `CRIMINAL_ID` varchar(20) NOT NULL,
  `ORG_ID` varchar(20) DEFAULT NULL,
  `AREA_ID` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` varchar(20) DEFAULT NULL,
  `TAG` char(1) DEFAULT NULL,
  PRIMARY KEY (`CRIMINAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_criminal_status
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_device`
-- ----------------------------
DROP TABLE IF EXISTS `xt_device`;
CREATE TABLE `xt_device` (
  `DEVICE_ID` varchar(30) NOT NULL,
  `ORG_ID` varchar(20) DEFAULT NULL,
  `USER_ID` varchar(30) NOT NULL,
  `APPVER` varchar(30) DEFAULT NULL,
  `SYSVER` varchar(30) DEFAULT NULL,
  `ISACTIVE` int(11) DEFAULT NULL,
  PRIMARY KEY (`DEVICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_device
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_flow`
-- ----------------------------
DROP TABLE IF EXISTS `xt_flow`;
CREATE TABLE `xt_flow` (
  `FLOW_ID` varchar(20) NOT NULL,
  `ORG_ID` varchar(20) DEFAULT NULL,
  `FLOW_POLICE` varchar(20) DEFAULT NULL,
  `LABEL_LIST` varchar(300) DEFAULT NULL,
  `VALUE_LIST` varchar(300) DEFAULT NULL,
  `FLOW_WHERE` varchar(20) DEFAULT NULL,
  `OUT_TIME` char(14) DEFAULT NULL,
  `BACK_FLAG` int(11) DEFAULT NULL,
  `BACK_TIME` char(14) DEFAULT NULL,
  PRIMARY KEY (`FLOW_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_flow
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_flow_user`
-- ----------------------------
DROP TABLE IF EXISTS `xt_flow_user`;
CREATE TABLE `xt_flow_user` (
  `FLOW_ID` varchar(20) NOT NULL,
  `CRIMINAL_ID` varchar(20) NOT NULL,
  PRIMARY KEY (`FLOW_ID`,`CRIMINAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_flow_user
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_gw_flow`
-- ----------------------------
DROP TABLE IF EXISTS `xt_gw_flow`;
CREATE TABLE `xt_gw_flow` (
  `FLOW_GUID` char(60) NOT NULL,
  `WF_ID` varchar(10) NOT NULL,
  `FLOW_ID` varchar(10) NOT NULL,
  `FLOW_NAME` varchar(200) NOT NULL,
  `FLOW_DESC` varchar(200) DEFAULT NULL,
  `TYPE_ID` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`FLOW_GUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_gw_flow
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_gw_fs`
-- ----------------------------
DROP TABLE IF EXISTS `xt_gw_fs`;
CREATE TABLE `xt_gw_fs` (
  `ORG_ID` varchar(20) DEFAULT NULL,
  `GW_ID` char(60) NOT NULL,
  `GW_TITLE` varchar(200) DEFAULT NULL,
  `GW_SUMMARY` varchar(600) DEFAULT NULL,
  `GW_NO` varchar(120) DEFAULT NULL,
  `GW_ORG` varchar(120) DEFAULT NULL,
  `GW_TYPE` varchar(60) DEFAULT NULL,
  `GW_DATE` varchar(8) DEFAULT NULL,
  `ACCEPT_DATE` varchar(8) DEFAULT NULL,
  `FILE_LIST` varchar(600) DEFAULT NULL,
  `WRITE_USER_ID` varchar(12) DEFAULT NULL,
  `CHECK_USER_ID` varchar(12) DEFAULT NULL,
  `LINK_USER` varchar(50) DEFAULT NULL,
  `LINK_TELNO` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_gw_fs
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_gw_grant`
-- ----------------------------
DROP TABLE IF EXISTS `xt_gw_grant`;
CREATE TABLE `xt_gw_grant` (
  `FLOW_GUID` varchar(60) NOT NULL,
  `ROLE_ID` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`FLOW_GUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_gw_grant
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_gw_js`
-- ----------------------------
DROP TABLE IF EXISTS `xt_gw_js`;
CREATE TABLE `xt_gw_js` (
  `GW_ID` char(60) NOT NULL,
  `ORG_ID` varchar(20) DEFAULT NULL,
  `GW_TITLE` varchar(200) DEFAULT NULL,
  `GW_NO` varchar(120) DEFAULT NULL,
  `GW_ORG` varchar(120) DEFAULT NULL,
  `GW_TYPE` varchar(60) DEFAULT NULL,
  `GW_DATE` varchar(8) DEFAULT NULL,
  `ACCEPT_DATE` varchar(8) DEFAULT NULL,
  `FILE_LIST` varchar(600) DEFAULT NULL,
  `GW_SUMMARY` varchar(600) DEFAULT NULL,
  `LINK_USER` varchar(50) DEFAULT NULL,
  `LINK_TELNO` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`GW_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_gw_js
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_gw_step`
-- ----------------------------
DROP TABLE IF EXISTS `xt_gw_step`;
CREATE TABLE `xt_gw_step` (
  `GUID` char(60) NOT NULL,
  `ORG_ID` varchar(20) DEFAULT NULL,
  `GW_ID` char(60) DEFAULT NULL,
  `GW_LX` varchar(10) DEFAULT NULL,
  `FLOW_ID` varchar(10) DEFAULT NULL,
  `CLS_ID` int(11) DEFAULT NULL,
  `START_USER_ID` varchar(12) DEFAULT NULL,
  `START_TIME` varchar(14) NOT NULL,
  `FINISH_USER_ID` varchar(12) DEFAULT NULL,
  `FINISH_TIME` varchar(14) DEFAULT NULL,
  `FLOW_STATUS` int(11) DEFAULT NULL,
  `CONTENT` varchar(200) DEFAULT NULL,
  `IS_COMPLETE` int(11) DEFAULT NULL,
  PRIMARY KEY (`GUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_gw_step
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_gw_wf`
-- ----------------------------
DROP TABLE IF EXISTS `xt_gw_wf`;
CREATE TABLE `xt_gw_wf` (
  `WF_ID` varchar(10) NOT NULL,
  `ORG_ID` varchar(20) DEFAULT NULL,
  `WF_NAME` varchar(10) NOT NULL,
  `GW_LX` varchar(10) NOT NULL,
  `WF_DESC` varchar(200) DEFAULT NULL,
  `CREATE_DATE` char(8) DEFAULT NULL,
  PRIMARY KEY (`WF_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_gw_wf
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_interface`
-- ----------------------------
DROP TABLE IF EXISTS `xt_interface`;
CREATE TABLE `xt_interface` (
  `INTERFACE_URL` varchar(100) NOT NULL,
  `INTERFACE_DESC` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`INTERFACE_URL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_interface
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_law_inf`
-- ----------------------------
DROP TABLE IF EXISTS `xt_law_inf`;
CREATE TABLE `xt_law_inf` (
  `ID` varchar(60) NOT NULL,
  `ORG_ID` varchar(20) DEFAULT NULL,
  `CLS_ID` varchar(30) DEFAULT NULL,
  `TITLE` varchar(300) DEFAULT NULL,
  `PAGE_HTML` text,
  `PUBLISH` varchar(200) DEFAULT NULL,
  `PUBLISH_DATE` varchar(20) DEFAULT NULL,
  `CREATE_DATE` char(8) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_law_inf
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_machine`
-- ----------------------------
DROP TABLE IF EXISTS `xt_machine`;
CREATE TABLE `xt_machine` (
  `DEVICE_ID` varchar(20) NOT NULL,
  `ORG_ID` varchar(20) DEFAULT NULL,
  `DEVICE_TYPE` int(11) DEFAULT NULL COMMENT '固定设备1，流动设备2',
  `DEVICE_IP` varchar(20) DEFAULT NULL,
  `DEVICE_USER` varchar(36) DEFAULT NULL,
  `DEVICE_PASS` varchar(36) DEFAULT NULL,
  `DEVICE_STATUS` int(11) DEFAULT NULL,
  PRIMARY KEY (`DEVICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_machine
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_news`
-- ----------------------------
DROP TABLE IF EXISTS `xt_news`;
CREATE TABLE `xt_news` (
  `ID` varchar(60) NOT NULL,
  `ORG_ID` varchar(20) DEFAULT NULL,
  `TITLE` varchar(300) DEFAULT NULL,
  `PAGE_HTML` text,
  `CREATE_DATE` char(8) DEFAULT NULL,
  `FILE_LIST` varchar(600) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_news
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_out`
-- ----------------------------
DROP TABLE IF EXISTS `xt_out`;
CREATE TABLE `xt_out` (
  `OUT_ID` varchar(20) NOT NULL,
  `FLOW_ID` varchar(20) DEFAULT NULL,
  `OUT_NAME` varchar(60) DEFAULT NULL,
  `IS_OUT` int(11) DEFAULT NULL,
  `ORG_ID` varchar(20) DEFAULT NULL,
  `ORG_NAME` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`OUT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='医院看病1,保外就医2,保外就医,2,法院提审4';

-- ----------------------------
-- Records of xt_out
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_police_inf`
-- ----------------------------
DROP TABLE IF EXISTS `xt_police_inf`;
CREATE TABLE `xt_police_inf` (
  `POLICE_ID` varchar(20) NOT NULL,
  `ORG_ID` varchar(20) DEFAULT NULL,
  `POLICE_NAME` varchar(20) DEFAULT NULL,
  `BIRTH` varchar(20) DEFAULT NULL,
  `IDCARD` char(18) DEFAULT NULL,
  PRIMARY KEY (`POLICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_police_inf
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_public`
-- ----------------------------
DROP TABLE IF EXISTS `xt_public`;
CREATE TABLE `xt_public` (
  `PUBLIC_CLS` varchar(100) DEFAULT NULL,
  `Column_1` varchar(100) DEFAULT NULL,
  `Column_2` varchar(100) DEFAULT NULL,
  `Column_3` varchar(100) DEFAULT NULL,
  `Column_4` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_public
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_public_type`
-- ----------------------------
DROP TABLE IF EXISTS `xt_public_type`;
CREATE TABLE `xt_public_type` (
  `PUBLIC_CLS` varchar(100) NOT NULL,
  `PUBLIC_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PUBLIC_CLS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_public_type
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_push`
-- ----------------------------
DROP TABLE IF EXISTS `xt_push`;
CREATE TABLE `xt_push` (
  `ID` char(60) NOT NULL,
  `USER_ID` varchar(12) DEFAULT NULL,
  `PUSH_FLAG` int(11) DEFAULT NULL,
  `PUSH_TEXT` varchar(600) DEFAULT NULL,
  `PUSH_TIME` char(14) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_push
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_rc_record`
-- ----------------------------
DROP TABLE IF EXISTS `xt_rc_record`;
CREATE TABLE `xt_rc_record` (
  `DEVICE_ID` varchar(20) DEFAULT NULL,
  `CRIMINAL_ID` varchar(20) DEFAULT NULL,
  `CRIMNAL_ID` varchar(20) DEFAULT NULL,
  `CRIMINAL_NAME` varchar(20) DEFAULT NULL,
  `USER_ID` varchar(20) DEFAULT NULL,
  `CRIMINAL_GROUP` varchar(20) DEFAULT NULL,
  `BATCH_TIME` char(14) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_rc_record
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_tool_back`
-- ----------------------------
DROP TABLE IF EXISTS `xt_tool_back`;
CREATE TABLE `xt_tool_back` (
  `BACK_ID` varchar(20) NOT NULL,
  `USE_ID` varchar(36) NOT NULL,
  `TOOL_ID` varchar(20) NOT NULL,
  `RETURN_TIME` char(14) DEFAULT NULL,
  `CRIMINAL_ID` varchar(20) DEFAULT NULL,
  `RETURN_VOLUME` int(11) DEFAULT NULL,
  PRIMARY KEY (`BACK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_tool_back
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_tool_inf`
-- ----------------------------
DROP TABLE IF EXISTS `xt_tool_inf`;
CREATE TABLE `xt_tool_inf` (
  `TOOL_ID` varchar(20) NOT NULL,
  `TOOL_NAME` varchar(20) DEFAULT NULL,
  `TOOL_VOLUME` int(11) DEFAULT NULL,
  `TOOL_TYPE` int(11) DEFAULT NULL,
  PRIMARY KEY (`TOOL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_tool_inf
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_tool_rec`
-- ----------------------------
DROP TABLE IF EXISTS `xt_tool_rec`;
CREATE TABLE `xt_tool_rec` (
  `USE_ID` varchar(36) NOT NULL,
  `TOOL_ID` varchar(20) NOT NULL,
  `USE_NUM` int(11) DEFAULT NULL,
  PRIMARY KEY (`USE_ID`,`TOOL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_tool_rec
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_tool_use`
-- ----------------------------
DROP TABLE IF EXISTS `xt_tool_use`;
CREATE TABLE `xt_tool_use` (
  `USE_ID` varchar(36) NOT NULL,
  `CRIMINAL_ID` varchar(20) DEFAULT NULL,
  `BORROW_TIME` char(14) DEFAULT NULL,
  `REASON` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`USE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_tool_use
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_upload`
-- ----------------------------
DROP TABLE IF EXISTS `xt_upload`;
CREATE TABLE `xt_upload` (
  `FILE_ID` varchar(36) NOT NULL,
  `FILE_NAME` varchar(100) DEFAULT NULL,
  `FILE_URL` varchar(200) DEFAULT NULL,
  `UPDATE_TIME` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`FILE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_upload
-- ----------------------------

-- ----------------------------
-- Table structure for `点名流水记录`
-- ----------------------------
DROP TABLE IF EXISTS `点名流水记录`;
CREATE TABLE `点名流水记录` (
  `DEVICE_ID` varchar(20) DEFAULT NULL,
  `CRIMINAL_ID` varchar(20) DEFAULT NULL,
  `CRIMNAL_ID` varchar(20) DEFAULT NULL,
  `CRIMINAL_NAME` varchar(20) DEFAULT NULL,
  `USER_ID` varchar(20) DEFAULT NULL,
  `CRIMINAL_GROUP` varchar(20) DEFAULT NULL,
  `BATCH_TIME` char(14) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 点名流水记录
-- ----------------------------

-- ----------------------------
-- Table structure for `点名记录表`
-- ----------------------------
DROP TABLE IF EXISTS `点名记录表`;
CREATE TABLE `点名记录表` (
  `ID` varchar(30) NOT NULL,
  `BATCH_GROUP_NAME` varchar(20) DEFAULT NULL,
  `DEVICE_ID` varchar(20) DEFAULT NULL,
  `START_TIME` char(14) DEFAULT NULL,
  `FINISH_TIME` char(14) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 点名记录表
-- ----------------------------

-- ----------------------------
-- Table structure for `黑名单管理`
-- ----------------------------
DROP TABLE IF EXISTS `黑名单管理`;
CREATE TABLE `黑名单管理` (
  `CRIMINAL_ID` varchar(20) NOT NULL,
  `CRIMINAL_NAME` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 黑名单管理
-- ----------------------------

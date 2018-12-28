/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.9
Source Server Version : 50511
Source Host           : 192.168.1.9:3306
Source Database       : gw

Target Server Type    : MYSQL
Target Server Version : 50511
File Encoding         : 65001

Date: 2018-11-20 19:15:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `s_config`
-- ----------------------------
DROP TABLE IF EXISTS `s_config`;
CREATE TABLE `s_config` (
  `KEY_ID` varchar(20) NOT NULL COMMENT '字典编码',
  `ORG_ID` varchar(20) NOT NULL COMMENT '所属字典',
  `KEY_VALUE` varchar(200) DEFAULT NULL COMMENT '字典数值',
  `UPDATE_TIME` varchar(20) DEFAULT NULL COMMENT '更新时间',
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
  `ITEMID` varchar(20) NOT NULL COMMENT '项目编码',
  `ITEMNAME` varchar(20) DEFAULT NULL COMMENT '项目名称',
  `DEF_VAL` varchar(200) DEFAULT NULL COMMENT '默认数值',
  `ORDERBY` int(11) DEFAULT NULL COMMENT '排序',
  `ISACTIVE` int(11) DEFAULT NULL COMMENT '是否有效',
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
  `KEY_ID` int(11) NOT NULL COMMENT '字典编码',
  `KEY_NAME` varchar(200) DEFAULT NULL COMMENT '字典数值',
  `CLS_ID` int(11) NOT NULL COMMENT '所属字典',
  `EXT_VAL` varchar(200) DEFAULT NULL COMMENT '扩展数值1',
  `EXT_KEY` varchar(200) DEFAULT NULL COMMENT '扩展数值2',
  `ORDERBY` int(11) DEFAULT NULL COMMENT '排序',
  `ISACTIVE` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`KEY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_dict
-- ----------------------------
INSERT INTO `s_dict` VALUES ('101', 'AD', '0', '0', null, null, '1');
INSERT INTO `s_dict` VALUES ('102', '11', '0', null, null, null, '1');
INSERT INTO `s_dict` VALUES ('103', '144', '0', null, null, null, '1');
INSERT INTO `s_dict` VALUES ('104', '152', '0', null, null, null, '1');
INSERT INTO `s_dict` VALUES ('105', '105', '0', null, null, null, null);

-- ----------------------------
-- Table structure for `s_log`
-- ----------------------------
DROP TABLE IF EXISTS `s_log`;
CREATE TABLE `s_log` (
  `LOG_ID` varchar(20) NOT NULL COMMENT '日志编号',
  `CREATE_TIME` char(14) DEFAULT NULL COMMENT '创建时间',
  `LOG_CONTENT` varchar(200) DEFAULT NULL COMMENT '日志内容',
  `CREATE_PERSON` varchar(20) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_log
-- ----------------------------
INSERT INTO `s_log` VALUES ('1', null, '11', null);

-- ----------------------------
-- Table structure for `s_nodes`
-- ----------------------------
DROP TABLE IF EXISTS `s_nodes`;
CREATE TABLE `s_nodes` (
  `NODE_ID` varchar(20) NOT NULL COMMENT '模块编号',
  `NODE_NAME` varchar(60) DEFAULT NULL COMMENT '模块名称',
  `NODE_URL` varchar(120) DEFAULT NULL COMMENT '模块地址',
  `PARENT_ID` varchar(20) DEFAULT NULL COMMENT '上级节点',
  `TARGET` varchar(60) DEFAULT NULL COMMENT '对应框架',
  `IMAGEURL` varchar(100) DEFAULT NULL COMMENT '模块缩略图',
  `ORDERBY` int(11) DEFAULT NULL COMMENT '排序',
  `ISACTIVE` int(11) DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`NODE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_nodes
-- ----------------------------
INSERT INTO `s_nodes` VALUES ('10', '公文管理', '/framework/left.html', '0', 'rf_left', null, null, '1');
INSERT INTO `s_nodes` VALUES ('1001', '收文管理', 'gw/gw_js_list.html', '10', 'rf_right', null, null, '1');
INSERT INTO `s_nodes` VALUES ('1002', '发文管理', 'gw/gw_fs_list.html', '10', 'rf_right', null, null, '1');
INSERT INTO `s_nodes` VALUES ('1003', '工作流管理', 'gw/gw_wf_list.html', '10', 'rf_right', null, null, '1');
INSERT INTO `s_nodes` VALUES ('1004', '审批信息管理', 'gw/gw_step_list.html', '10', 'rf_right', null, null, '1');
INSERT INTO `s_nodes` VALUES ('1005', '流程权限管理', 'gw/gw_grant_list.html', '10', 'rf_right', null, null, '1');
INSERT INTO `s_nodes` VALUES ('1006', '流程信息管理', 'gw/gw_flow_list.html', '10', 'rf_right', null, null, '1');
INSERT INTO `s_nodes` VALUES ('11', '工作动态', 'news/news_list.html', '0', 'rf_main', null, null, '1');
INSERT INTO `s_nodes` VALUES ('12', '会议管理', 'conf/conf_list.html', '0', 'rf_main', null, null, '1');
INSERT INTO `s_nodes` VALUES ('13', '法律法规', 'law_inf/law_inf_list.html', '0', 'rf_main', null, null, '1');
INSERT INTO `s_nodes` VALUES ('14', '电子阅览', 'archive/archive_list.html', '0', 'rf_main', null, null, '1');
INSERT INTO `s_nodes` VALUES ('16', '通讯录', 'user/phone_book_list.html', '0', 'rf_main', null, null, '1');
INSERT INTO `s_nodes` VALUES ('99', '系统管理', '/framework/left.html', '0', 'rf_left', null, null, '1');
INSERT INTO `s_nodes` VALUES ('9901', '单位管理', 'sysweb/org_inf_list.html', '99', 'rf_right', null, null, '1');
INSERT INTO `s_nodes` VALUES ('9902', '用户管理', 'sysweb/user_inf_list.html', '99', 'rf_right', null, null, '1');
INSERT INTO `s_nodes` VALUES ('9903', '角色管理', 'sysweb/role_list.html', '99', 'rf_right', null, null, '1');
INSERT INTO `s_nodes` VALUES ('9904', '终端管理', 'user/device_list.html', '99', 'rf_right', null, null, '1');
INSERT INTO `s_nodes` VALUES ('9909', '意见反馈', 'user/feed_back_list.html', '99', 'rf_right', null, null, '1');

-- ----------------------------
-- Table structure for `s_org_inf`
-- ----------------------------
DROP TABLE IF EXISTS `s_org_inf`;
CREATE TABLE `s_org_inf` (
  `ORG_ID` varchar(20) NOT NULL COMMENT '单位编码',
  `ORG_NAME` varchar(50) DEFAULT NULL COMMENT '单位名称',
  `ORG_FULL_NAME` varchar(120) DEFAULT NULL COMMENT '单位全称',
  `ORG_TELNO` varchar(12) DEFAULT NULL COMMENT '办公电话',
  `ORG_MAIL` varchar(60) DEFAULT NULL COMMENT '办公邮箱',
  `ORG_LEADER` varchar(50) DEFAULT NULL COMMENT '负责人',
  `ORG_TYPE` int(11) DEFAULT NULL COMMENT '单位类型',
  `ORDERBY` int(11) DEFAULT NULL COMMENT '排序',
  `ISACTIVE` int(11) DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`ORG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_org_inf
-- ----------------------------
INSERT INTO `s_org_inf` VALUES ('410100', '郑州市', '郑州市国土资源局', '037166668888', '0371@163.com', null, '4', '0', '1');
INSERT INTO `s_org_inf` VALUES ('410103', '二七区', '二七区国土资源局', '037166668888', '410103@163.com', null, '6', '0', '1');
INSERT INTO `s_org_inf` VALUES ('411200', '三门峡', '三门峡国土资源局', '037166668888', '411200@163.com', null, '4', '0', '1');

-- ----------------------------
-- Table structure for `s_role`
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role` (
  `ROLE_ID` int(11) NOT NULL COMMENT '角色编号',
  `ROLE_NAME` varchar(60) DEFAULT NULL COMMENT '角色名称',
  `ROLE_LEVEL` int(11) DEFAULT NULL COMMENT '角色级别',
  `ORDERBY` int(11) DEFAULT NULL COMMENT '排序',
  `ISACTIVE` int(11) DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES ('0', '系统管理员', '0', '1', '1');
INSERT INTO `s_role` VALUES ('10', '管理员', '0', '1', '1');
INSERT INTO `s_role` VALUES ('13', '科员', '0', '1', '1');
INSERT INTO `s_role` VALUES ('20', '副局长', '0', '1', '1');
INSERT INTO `s_role` VALUES ('30', '局长', '0', '1', '1');

-- ----------------------------
-- Table structure for `s_role_grant`
-- ----------------------------
DROP TABLE IF EXISTS `s_role_grant`;
CREATE TABLE `s_role_grant` (
  `NODE_ID` varchar(20) NOT NULL COMMENT '模块编号',
  `ROLE_ID` varchar(20) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`NODE_ID`,`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_role_grant
-- ----------------------------
INSERT INTO `s_role_grant` VALUES ('10', '0');
INSERT INTO `s_role_grant` VALUES ('10', '10');
INSERT INTO `s_role_grant` VALUES ('10', '13');
INSERT INTO `s_role_grant` VALUES ('10', '20');
INSERT INTO `s_role_grant` VALUES ('10', '30');
INSERT INTO `s_role_grant` VALUES ('1001', '0');
INSERT INTO `s_role_grant` VALUES ('1001', '10');
INSERT INTO `s_role_grant` VALUES ('1001', '13');
INSERT INTO `s_role_grant` VALUES ('1001', '20');
INSERT INTO `s_role_grant` VALUES ('1001', '30');
INSERT INTO `s_role_grant` VALUES ('1002', '0');
INSERT INTO `s_role_grant` VALUES ('1002', '10');
INSERT INTO `s_role_grant` VALUES ('1002', '13');
INSERT INTO `s_role_grant` VALUES ('1002', '20');
INSERT INTO `s_role_grant` VALUES ('1002', '30');
INSERT INTO `s_role_grant` VALUES ('1003', '0');
INSERT INTO `s_role_grant` VALUES ('1003', '10');
INSERT INTO `s_role_grant` VALUES ('1003', '13');
INSERT INTO `s_role_grant` VALUES ('1003', '20');
INSERT INTO `s_role_grant` VALUES ('1003', '30');
INSERT INTO `s_role_grant` VALUES ('1004', '0');
INSERT INTO `s_role_grant` VALUES ('1004', '10');
INSERT INTO `s_role_grant` VALUES ('1004', '20');
INSERT INTO `s_role_grant` VALUES ('1004', '30');
INSERT INTO `s_role_grant` VALUES ('1005', '0');
INSERT INTO `s_role_grant` VALUES ('1005', '10');
INSERT INTO `s_role_grant` VALUES ('1005', '20');
INSERT INTO `s_role_grant` VALUES ('1005', '30');
INSERT INTO `s_role_grant` VALUES ('1006', '0');
INSERT INTO `s_role_grant` VALUES ('1006', '10');
INSERT INTO `s_role_grant` VALUES ('1006', '20');
INSERT INTO `s_role_grant` VALUES ('1006', '30');
INSERT INTO `s_role_grant` VALUES ('11', '0');
INSERT INTO `s_role_grant` VALUES ('11', '10');
INSERT INTO `s_role_grant` VALUES ('11', '13');
INSERT INTO `s_role_grant` VALUES ('11', '20');
INSERT INTO `s_role_grant` VALUES ('11', '30');
INSERT INTO `s_role_grant` VALUES ('12', '0');
INSERT INTO `s_role_grant` VALUES ('12', '10');
INSERT INTO `s_role_grant` VALUES ('12', '13');
INSERT INTO `s_role_grant` VALUES ('12', '20');
INSERT INTO `s_role_grant` VALUES ('12', '30');
INSERT INTO `s_role_grant` VALUES ('13', '0');
INSERT INTO `s_role_grant` VALUES ('13', '10');
INSERT INTO `s_role_grant` VALUES ('13', '13');
INSERT INTO `s_role_grant` VALUES ('13', '20');
INSERT INTO `s_role_grant` VALUES ('13', '30');
INSERT INTO `s_role_grant` VALUES ('14', '0');
INSERT INTO `s_role_grant` VALUES ('14', '10');
INSERT INTO `s_role_grant` VALUES ('14', '13');
INSERT INTO `s_role_grant` VALUES ('14', '20');
INSERT INTO `s_role_grant` VALUES ('14', '30');
INSERT INTO `s_role_grant` VALUES ('16', '0');
INSERT INTO `s_role_grant` VALUES ('16', '10');
INSERT INTO `s_role_grant` VALUES ('16', '13');
INSERT INTO `s_role_grant` VALUES ('16', '20');
INSERT INTO `s_role_grant` VALUES ('16', '30');
INSERT INTO `s_role_grant` VALUES ('99', '0');
INSERT INTO `s_role_grant` VALUES ('99', '10');
INSERT INTO `s_role_grant` VALUES ('99', '13');
INSERT INTO `s_role_grant` VALUES ('99', '20');
INSERT INTO `s_role_grant` VALUES ('99', '30');
INSERT INTO `s_role_grant` VALUES ('9901', '0');
INSERT INTO `s_role_grant` VALUES ('9901', '10');
INSERT INTO `s_role_grant` VALUES ('9901', '13');
INSERT INTO `s_role_grant` VALUES ('9901', '20');
INSERT INTO `s_role_grant` VALUES ('9901', '30');
INSERT INTO `s_role_grant` VALUES ('9902', '0');
INSERT INTO `s_role_grant` VALUES ('9902', '10');
INSERT INTO `s_role_grant` VALUES ('9902', '13');
INSERT INTO `s_role_grant` VALUES ('9902', '20');
INSERT INTO `s_role_grant` VALUES ('9902', '30');
INSERT INTO `s_role_grant` VALUES ('9903', '0');
INSERT INTO `s_role_grant` VALUES ('9903', '10');
INSERT INTO `s_role_grant` VALUES ('9903', '13');
INSERT INTO `s_role_grant` VALUES ('9903', '20');
INSERT INTO `s_role_grant` VALUES ('9903', '30');
INSERT INTO `s_role_grant` VALUES ('9904', '0');
INSERT INTO `s_role_grant` VALUES ('9904', '10');
INSERT INTO `s_role_grant` VALUES ('9904', '13');
INSERT INTO `s_role_grant` VALUES ('9904', '20');
INSERT INTO `s_role_grant` VALUES ('9904', '30');
INSERT INTO `s_role_grant` VALUES ('9906', '0');
INSERT INTO `s_role_grant` VALUES ('9906', '10');
INSERT INTO `s_role_grant` VALUES ('9906', '13');
INSERT INTO `s_role_grant` VALUES ('9906', '20');
INSERT INTO `s_role_grant` VALUES ('9906', '30');
INSERT INTO `s_role_grant` VALUES ('9909', '0');
INSERT INTO `s_role_grant` VALUES ('9909', '10');
INSERT INTO `s_role_grant` VALUES ('9909', '13');
INSERT INTO `s_role_grant` VALUES ('9909', '20');
INSERT INTO `s_role_grant` VALUES ('9909', '30');

-- ----------------------------
-- Table structure for `s_user_inf`
-- ----------------------------
DROP TABLE IF EXISTS `s_user_inf`;
CREATE TABLE `s_user_inf` (
  `USER_ID` varchar(12) NOT NULL COMMENT '用户编码',
  `USER_CODE` varchar(50) NOT NULL COMMENT '登录账号',
  `USER_NAME` varchar(50) NOT NULL COMMENT '用户名称',
  `USER_PASS` varchar(50) DEFAULT NULL COMMENT '用户权限',
  `ROLE_ID` int(11) DEFAULT NULL COMMENT '角色编号',
  `ORG_ID` varchar(20) DEFAULT NULL COMMENT '单位编码',
  `USER_STATUS` int(11) DEFAULT NULL COMMENT '用户状态',
  `ISACTIVE` int(11) DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user_inf
-- ----------------------------
INSERT INTO `s_user_inf` VALUES ('3245345', '34543', '345', '34534', null, '411200', null, null);
INSERT INTO `s_user_inf` VALUES ('41010001', '41010001', '张小军', '8888', '10', '410100', '1', '1');
INSERT INTO `s_user_inf` VALUES ('41010002', '41010002', '李四', '8888', '10', '410100', '1', '1');
INSERT INTO `s_user_inf` VALUES ('41010301', 'root', '管理员', '123456', '10', '410100', '1', '1');
INSERT INTO `s_user_inf` VALUES ('41120001', '41120001', '张局长(01)', '8888', '10', '411200', '1', '1');
INSERT INTO `s_user_inf` VALUES ('41120002', '41120002', '李局长(02)', '8888', '10', '411200', '1', '1');
INSERT INTO `s_user_inf` VALUES ('41120010', '41120003', '王科长(10)', '8888', '10', '411200', '1', '1');
INSERT INTO `s_user_inf` VALUES ('41120011', '41120004', '张科长(11)', '8888', '10', '411200', '1', '1');
INSERT INTO `s_user_inf` VALUES ('41120050', '41120010', '马强(50)', '8888', '10', '411200', '1', '1');
INSERT INTO `s_user_inf` VALUES ('41120051', '41120051', '???(51)', '7777', '10', '411200', '1', '1');

-- ----------------------------
-- Table structure for `s_version`
-- ----------------------------
DROP TABLE IF EXISTS `s_version`;
CREATE TABLE `s_version` (
  `VER_ID` varchar(30) NOT NULL COMMENT '版本号',
  `SYS_VER` varchar(30) DEFAULT NULL COMMENT '系统版本',
  `DB_VER` varchar(30) DEFAULT NULL COMMENT '数据库版本',
  `UPDATE_TIME` char(14) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`VER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_version
-- ----------------------------
INSERT INTO `s_version` VALUES ('1', '20181115', '0.6', '20181115114050');

-- ----------------------------
-- Table structure for `xt_archive`
-- ----------------------------
DROP TABLE IF EXISTS `xt_archive`;
CREATE TABLE `xt_archive` (
  `ID` varchar(60) NOT NULL COMMENT '档案编码',
  `CLS_ID` varchar(30) DEFAULT NULL COMMENT '档案类型编码',
  `ORG_ID` varchar(20) DEFAULT NULL COMMENT '单位编码',
  `TITLE` varchar(200) DEFAULT NULL COMMENT '档案标题',
  `PAGE_HTML` text COMMENT '档案内容',
  `CREATE_DATE` char(8) DEFAULT NULL COMMENT '创建时间',
  `FILE_LIST` varchar(600) DEFAULT NULL COMMENT '文件地址',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='办公系统--电子档案（XT_ARCHIVE)';

-- ----------------------------
-- Records of xt_archive
-- ----------------------------
INSERT INTO `xt_archive` VALUES ('101', '101', '411200', '我市组织收听收看2018年第2期清风中原大讲堂', '11月15日上午，2018年第2期清风中原大讲堂在郑州举行。讲座邀请中央纪委国家监委法规室副局级纪检监察员周鹏飞围绕新修订的《中国共产党纪律处分条例》（以下简称《条例》）作专题讲座。刘南昌、安伟、栗金强、范付中、牛兰英、王振清等副市级以上领导在三门峡分会场集中收听收看了讲座。\r\n　　周鹏飞毕业于中国政法大学研究生院，长期从事纪检监察、党风廉政建设和反腐败立法工作，先后参与《中国共产党纪律处分条例》《中国共产党党内监督条例》《中国共产党党员领导干部廉洁从政若干准则》《行政机关公务员处分条例》《中华人民共和国行政监察法》等一系列法规制度和中央文件的研究起草。在讲座中，周鹏飞深刻阐释了《条例》的由来、如何抓好《条例》的贯彻落实，精辟解读了《条例》的重要内容、重要条款和精髓内涵。讲座系统全面、清晰透彻、联系时弊、发人深省，对深入学习和贯彻执行《条例》具有很强的指导、推动作用。\r\n　　此次集中学习，有助于三门峡党员干部进一步把握要义、掌握要领，切实增强学习贯彻《条例》的责任担当，在今后的工作中，认真学习好、宣传好、执行好《条例》，真正做到入脑入心、知行合一，以纪律为准绳规范言行，落实好全面从严治党责任，推动党的建设高质量，为打造“五彩三门峡”作出积极贡献。      (胡文超)', '20181116', null);
INSERT INTO `xt_archive` VALUES ('102', '101', '411200', '我市召开省文明城市测评迎检动员会', '11月15日，省、市重点民生实事与解决“七大难”工作协调推进会召开，市委常委、常务副市长范付中，市城乡一体化示范区管委会主任刘会林出席会议。各县（市、区）常务副县长、各项重点民生实事牵头部门和责任单位的主要负责同志参加会议。\r\n　　会上，市发改委主要负责人通报了2018年省、市重点民生实事开展情况；市民政局、市环保局、市住建局、市卫计委、市林业和园林局等民生实事和“七大难”工作牵头部门汇报了当前工作进展情况，分析部分工作进展缓慢的原因、下一步措施和预计完成时间。\r\n11月15日，三门峡市2018年省文明城市测评迎检动员会召开。市委常委、宣传部部长、市政府党组成员牛兰英出席会议并讲话，市政府党组成员、市政协副主席高永瑞主持会议。\r\n　　牛兰英强调，一是全体动员，全民参与。要加大文明城市创建宣传动员力度，引导广大干部群众大力支持、主动参与文明城市创建活动，营造浓厚创建氛围。二是突出重点，精心准备。要做好城市大环境短板和死角的排查整改，进区入户宣传好文明城市创建工作，提高群众知晓率、参与率和满意率。三是各司其职，对表落实。各级各部门要明确责任，统筹安排，集中力量，对表对标，高质量、高标准抓好工作落实。四是加强巡查，现场督办。各级各部门要重点关注创建工作，现场督导促整改，牢牢守住政治安全、社会稳定、安全生产等红线。五是服从大局，令行禁止。要强化组织纪律观念，严格执行各项迎检工作安排，确保各项迎检工作精准到位，无脱节、无疏漏、无闪失，全力以赴做好测评迎检工作。       (王志强)', '20181116', null);
INSERT INTO `xt_archive` VALUES ('103', '101', '411200', '省、市重点民生实事与解决“七大难”工作协调推进会召开', '　11月15日，省、市重点民生实事与解决“七大难”工作协调推进会召开，市委常委、常务副市长范付中，市城乡一体化示范区管委会主任刘会林出席会议。各县（市、区）常务副县长、各项重点民生实事牵头部门和责任单位的主要负责同志参加会议。\r\n　　会上，市发改委主要负责人通报了2018年省、市重点民生实事开展情况；市民政局、市环保局、市住建局、市卫计委、市林业和园林局等民生实事和“七大难”工作牵头部门汇报了当前工作进展情况，分析部分工作进展缓慢的原因、下一步措施和预计完成时间。\r\n　　范付中指出，省、市重点民生实事和“七大难”问题是全市关注、群众关心的大事、要事、急事、难事，事关群众切身利益，必须牢牢抓在手上、时刻放在心上。下一步，要突出问题导向，切实增强使命感和紧迫感；要紧盯目标、明确职责，聚焦重点难点，切实增强推进民生实事的针对性和实效性；要切实振奋精神，着力提高推进民生实事的执行力，从自身做起，采取科学方法，集中骨干力量。与此同时，积极谋划好明年的民生实事，向全市人民交上一份满意的民生答卷。    (王婉媚)', '20181116', null);
INSERT INTO `xt_archive` VALUES ('104', '101', '411120', '我市主城区户外广告集中整治动员会召开', '为进一步加强主城区户外广告设置管理，提升我市的城市公共空间品位和档次，11月15日，我市主城区户外广告集中整治动员会召开，副市长李杰出席会议。\r\n　　会议首先传达了市委书记刘南昌对整治主城区户外广告的指示精神，随后宣读了《三门峡市主城区户外广告集中整治工作方案》。\r\n　　李杰指出，户外广告是创建文明城市的重要内容，当前我市户外广告数量多、设置乱、商业广告多、公益广告少，影响了文明城市创建工作。各相关单位及企业要切实增强户外广告整治工作自觉性，把握整治总体要求和原则，认真落实户外广告整治工作任务，齐心协力促进我市文明城市创建工作再上新台阶。     (汪潭)', '20181116', null);
INSERT INTO `xt_archive` VALUES ('105', '101', '411120', '市领导巡查“一节一展”筹备工作', '11月15日，市委常委、宣传部部长、市政府党组成员牛兰英带领市公安、城管、交通等相关部门负责同志，巡查我市“一节一展”布展筹备工作。\r\n　　当天下午，在三门峡国际文博城，牛兰英一行先后来到文博城大剧院、“一节一展”展场、文博城西广场舞台、中国摄影之乡揭幕石等地，察看颁奖晚会舞台准备、展场布置、气氛营造、讲解服务、舞台搭建、安保配备等“一节一展”活动筹备进展情况。\r\n　　随后，牛兰英一行来到天鹅城国际酒店、天鹅湖国家城市湿地公园、高铁三门峡南站广场、三门峡东站高速出口等地，察看嘉宾食宿环境、景区环境、氛围营造、节展宣传等情况，并听取相关工作汇报。\r\n　　牛兰英在巡查中指出，各相关单位要切实把筹备工作摆上重要位置，进一步增强责任感和使命感。要把“一节一展”筹备工作与文明城市创建工作相结合，确保城区、景区干净整洁；精心组织，密切协作，强化宣传造势，营造浓厚氛围，展示三门峡良好形象，高质量、高水平办好“一节一展”。\r\n　　当晚，牛兰英一行还先后来到大岭南路、迎宾大道、陕州大道、上阳路、黄河路、崤山路等市区主干道察看亮化工作情况，并提出具体要求。   　(陈林道)', '20181116', null);
INSERT INTO `xt_archive` VALUES ('106', '101', '411200', '我市启动森林防火宣传月活动', '当前，森林防火进入紧要期。11月13日，我市在湖滨广场启动以“爱护森林资源 保护生态安全”为主题的森林防火宣传月活动。市委副书记吴云、副市长李杰出席活动。\r\n　　当天的湖滨广场，宣传展板整齐排列，咨询台前群众络绎不绝。市林业和园林局、湖滨区、陕州区和市直森林防火指挥部成员单位的领导干部200余人向群众发放宣传资料、手册、入户通知书以及扑克牌、纸杯、手提袋、围裙等小礼品，讲述警示教育案例等，普及森林防火条例等法律法规、防火知识和安全扑救知识。\r\n　　吴云一行来到活动现场，认真查看宣传板面、宣传资料等，听取并询问开展宣传月活动工作的相关情况，对各单位开展群众喜闻乐见、形式多样的宣传活动给予充分肯定。她指出，森林防火和林业保护对我市生态系统的完整性有着重要作用，森林防火安全是全社会的共同职责，要全面增强森林防火责任意识，严防森林火灾隐患。要进一步扩大宣传活动的范围，组织更多单位和群众参与到宣传活动中来，增强全民森林防火意识，提升宣传的深度和效果。要采取更多有效措施，把宣传活动引向深入，渗透到学校、社区等更广泛领域，使人人形成安全防范的自觉，爱护我们的森林资源，保护我们的生态环境安全。\r\n　　据悉，当天共发放各类宣传资料、宣传小礼品等1万多份，使广大群众受到教育，营造了良好宣传氛围', '20181116', null);
INSERT INTO `xt_archive` VALUES ('107', '101', '411200', '关于峡城中心小学校舍维修及围墙建设项目实施方案的批复', '深入贯彻党的十九大精神，以习近平新时代中国特色社会主义思想为指引，全面贯彻落实国务院办公厅《关于全面治理拖欠农民工工资问题的意见》和省、市实施意见，紧紧围绕省、市2018年《保障农民工工资支付工作考核办法》明确的目标和任务，坚持标本兼治、综合治理，着力规范工资支付行为、优化市场环境、强化监管责任，健全预防和解决拖欠农民工工资问题的长效机制，切实保障农民工劳动报酬权益，维护社会公平正义，促进社会和谐稳定。', '20181218', null);
INSERT INTO `xt_archive` VALUES ('108', '101', '411200', '关于印发全域无垃圾长效机制工作方案的通知', '为深入贯彻落实党的十九大提出的坚持人与自然和谐共生基本方略精神，进一步推进全县全域无垃圾城乡环境综合治理工作，全力创建全国全域旅游示范县，营造“干净、整洁、优美”的人居环境，按照《甘肃省农村生活垃圾管理条例》、省市县《全域无垃圾综合治理实施方案》，结合我县实际，特制定本方案。', '20181218', null);
INSERT INTO `xt_archive` VALUES ('109', '10', '411200', '“一节一展”布展工作基本完成', '　11月15日，三门峡日报记者从第十二届中国摄影艺术节暨第二届三门峡白天鹅·野生动物国际摄影大展（以下简称“一节一展”）组委会获悉，“一节一展”布展工作已经基本完成。当天，记者走进三门峡国际文博城会展中心，映入眼帘的是“一节一展”巨幅宣传海报，展区内精美的摄影作品挂满了墙面，工人们正在紧锣密鼓地忙碌着。\r\n　　据了解，第一展区、第二展区的布展工作已经基本结束，展区内部的墙面大部分挂满了摄影作品。“第十二届中国摄影金像奖获得者作品展”“第二届白天鹅·野生动物国际摄影大展”“影像见证四十年”的特装已经制作完毕，在展区内格外引人注目。尤其是“影像见证四十年”特装采用四个层层叠叠的红色框体，形成了多层次的视觉效果，让人从中感受中国改革开放四十年的发展变迁。\r\n　　本次摄影展中，最让人眼前一亮的是“阿尔金山—中国新疆无人区映像”展区。该展区以一幅长15米、宽5米的巨型摄影作品为主体，用与作品相同的黄草、沙石将视觉世界中的阿尔金山和现实展区连接起来，再配上悬浮的云朵和人工制作的湖泊。人站在特定的位置拍照就好像真正置身于阿尔金山，可以充分体验无人区的神秘和摄影艺术的魅力。      (王志强)', '20181115', null);
INSERT INTO `xt_archive` VALUES ('110', '10', '411200', '我市召开省文明城市测评迎检动员会', '11月15日，三门峡市2018年省文明城市测评迎检动员会召开。市委常委、宣传部部长、市政府党组成员牛兰英出席会议并讲话，市政府党组成员、市政协副主席高永瑞主持会议。\r\n　　牛兰英强调，一是全体动员，全民参与。要加大文明城市创建宣传动员力度，引导广大干部群众大力支持、主动参与文明城市创建活动，营造浓厚创建氛围。二是突出重点，精心准备。要做好城市大环境短板和死角的排查整改，进区入户宣传好文明城市创建工作，提高群众知晓率、参与率和满意率。三是各司其职，对表落实。各级各部门要明确责任，统筹安排，集中力量，对表对标，高质量、高标准抓好工作落实。四是加强巡查，现场督办。各级各部门要重点关注创建工作，现场督导促整改，牢牢守住政治安全、社会稳定、安全生产等红线。五是服从大局，令行禁止。要强化组织纪律观念，严格执行各项迎检工作安排，确保各项迎检工作精准到位，无脱节、无疏漏、无闪失，全力以赴做好测评迎检工作。       (王志强)', '20181116', null);
INSERT INTO `xt_archive` VALUES ('111', '101', '411200', '渑池县段村乡:逐村观摩现场评比促工作\r\n', '“近年来，中朝村在上级领导和帮扶单位的大力支持下取得了一系列的成绩，接下来我们将以脱贫摘帽为目标，大力培育集体经济……”11月13日上午，在渑池县段村乡中朝村，该村负责人向参会人员介绍了该村当前重点工作进展情况。这是该乡“逐村观摩、现场评比”现场观摩会上的一幕。\r\n　　当日，该乡对全乡11个行政村开展为期一天的“逐村观摩、现场评比”现场观摩会，就当前脱贫攻坚、产业发展、农村人居环境整治、危房改造、易地搬迁拆旧复垦等各项重点工作进行逐村打分。乡机关部门负责人、村干部、驻村第一书记等参加活动，通过听取汇报、实地察看、翻阅档案、现场打分等形式，对全乡各行政村当前重点工作进行一次全面细致的督导检查，切实提高工作效率，真正将重点工作落到实处。\r\n　　在观摩结束后召开的座谈会上，参会人员畅所欲言，对活动中发现的亮点和工作不足进行了发言。大家纷纷表示，要比照先进找不足，聚焦问题找差距，全面提高工作效率，深化“效能革命”，确保全乡各项重点工作取得实效。      （王一博 杨林涛）', '20181116', null);
INSERT INTO `xt_archive` VALUES ('112', '101', '411200', '渑池县:“五个聚焦”促精神扶贫\r\n', '今年以来，渑池县紧紧围绕中央和省、三门峡市脱贫攻坚相关部署要求，坚持“五个聚焦”，充分发挥文化的励志作用，坚持扶志扶智扶技，全方位、多渠道助力脱贫攻坚，取得了明显成效。\r\n　　聚焦思想教育，基层群众脱贫意识明显增强。该县充分发挥广播电台、电视台、“V观渑池”等县域媒体作用，提高宣传的时效性和普及性，让党的脱贫攻坚政策家喻户晓；深入开展“红色文艺轻骑兵”“百姓宣讲直通车”“咱们一起奔小康”进基层宣讲巡演活动，将党的十九大精神、教育扶贫、金融扶贫、产业扶贫、健康扶贫等相关政策作为主要宣讲内容。目前，该县已开展各类宣讲活动60余场次。精心创作编演了小品《杨大叔脱贫》、串烧《精准扶贫满园春》、音乐快板《十九大精神放光芒》等优秀节目，用群众喜闻乐见的形式，让群众对党的扶贫政策了然于胸。\r\n　　聚焦阵地建设，基层群众活动场所大幅改善。该县重点抓好基层党校和基层综合文化服务中心两个阵地的建设。每年协调县财政拿出不少于150万元的资金用于基层党校建设。目前，全县共建基层党校301所。按照“七个一”建设标准，率先为全县37个贫困村建成村级综合文化服务中心；实施“党校+产业扶贫培训基地”工程，把党校培训内容、培训对象与产业扶贫培训结合起来，举办“农民知识培训工程”“一人一年学一技”“双椒一药”技术等培训班60期，受训2万余人次。通过培训，让基层党员和普通群众都能掌握1—2门实用技术或劳动技能，切实达到了“教育一个带动一片活跃一方”的目的。\r\n　　聚焦典型带动，基层群众脱贫信心更加坚定。该县围绕产业扶贫、健康扶贫、旅游扶贫、教育扶贫等重点工作，相继策划了一系列重大宣传报道活动。如今，“双椒一药”、仰韶大杏、先住院后报销、赵沟古村等扶贫典型经验先后被中央、省市主流媒体关注报道，挖掘推出了“身患癌症、不忘初心”的张东堂、“富不忘本、一心为民”的武安伟、“发展花椒、带富群众”的史明朝等一大批先进基层党员干部，在全县上下汇聚了向上向善向好的强大正能量，为打赢脱贫攻坚战、决胜全面小康提供了思想保障。\r\n　　聚焦价值观培养，基层群众良好风尚逐步养成。该县将脱贫攻坚政策用通俗易懂的公益宣传画形式进行展示，累计新设宣传板面、专栏、文化墙500余块（面），在全县乡村手绘核心价值观宣传文化墙3000余平方米。在中国渑池门户网站、渑池政府网、“V观渑池”长期展播核心价值观公益广告，发布核心价值观宣传教育实践活动动态。在基层贫困群众中广泛开展核心价值观主题道德讲堂、演讲、座谈等主题活动，不断激发贫困群众脱贫致富的积极性和主动性。今年来，举办核心价值观主题道德讲堂26期，各类主题教育活动20余次，受教育群众3.5万余人次。\r\n　　聚焦文化惠民，基层群众脱贫动力更加强劲。深入开展送戏曲、送舞蹈培训、送图书、送公益电影、送文艺演出进贫困村等“五进”工作。今年以来，该县共开展送戏下乡活动121场，省“舞台艺术送农民活动”和市“政府采购百场戏活动”优先安排在贫困村中开展；组织“2018年全县基层文艺骨干舞蹈培训班”，先后培训基层文艺骨干800余名；组织全县236个农家书屋图书管理员开展业务培训，重点为18个贫困村免费赠送致富技术、产业发展、农业技术管理等方面书籍6000余册；以文明新风、适用技术为题材，每月到贫困村免费送电影一次。     （姚朝晖）', '20181116', null);
INSERT INTO `xt_archive` VALUES ('113', '101', '411200', '渑池县四大班子领导集中参加植树造林活动', '为践行习近平生态文明思想，落实全省实施国土绿化提速行动建设森林河南动员大会精神，11月14日，渑池县委书记杨跃民，县委副书记、县长谢喜来，县人大常委会主任张行军，县政协主席郭艳华等县四大班子领导来到位于该县果园乡的渑池南站附近，与广大党员干部和群众一起参加植树活动，动员全县上下迅速行动起来，打一场新时代渑池国土绿化的人民战争，让绿水青山就是金山银山的理念在渑池开花结果，让绿满仰韶、四季常青成为魅力渑池的亮丽底色。\r\n　　当日下午3时许，渑池南站附近植树现场人头攒动，到处是热火朝天的繁忙景象。该县四大班子领导一来到这里就拿起铁锨，投入到植树劳动当中。杨跃民一边与大家一起扶苗、培土、踩实，一边详细了解高铁绿化、土壤墒情、苗木养护等方面情况。他反复叮嘱林业部门要严格标准、严把质量，切实达到栽一棵活一棵，栽一片绿一片的效果。一阵忙碌之后，一株株楸树、栾树等在高铁沿线的林场上昂然挺立，展现出了勃勃生机。\r\n　　植树间隙，杨跃民指出，县四大班子领导参加义务植树，就是希望从领导干部带头做起，增强全民造林意识，大家一起行动起来，植树造林，绿化家园。他指出，全县上下要深刻认识到抓国土绿化就是抓生态文明建设，以更加积极的姿态，实施国土绿化提速行动。要深刻认识到抓国土绿化就是抓高质量发展，加快构建绿色产业体系，形成绿色发展模式，带动全县产业结构、增长方式的转变。要深刻认识到抓国土绿化就是抓民生改善，算好“绿色账”，走好“绿色路”，打好“绿色牌”，让人民群众更好地享受绿色发展带来的实惠。要深刻认识到抓国土绿化就是抓形象提升，自觉地保护好每一寸绿色，树立渑池新形象，增强渑池吸引力。\r\n　　据了解，此次活动共栽植楸树和栾树138亩，其中楸树89亩、栾树49亩。　（赵闪 姚一鹏）', '20181116', null);

-- ----------------------------
-- Table structure for `xt_archive_cls`
-- ----------------------------
DROP TABLE IF EXISTS `xt_archive_cls`;
CREATE TABLE `xt_archive_cls` (
  `CLS_ID` varchar(30) NOT NULL COMMENT '档案类型编码',
  `CLS_NAME` varchar(200) DEFAULT NULL COMMENT '档案类型名称',
  `TYPE_ID` varchar(30) DEFAULT NULL COMMENT '所属类型',
  `ORDERBY` int(11) DEFAULT NULL COMMENT '排序',
  `ISACTIVE` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`CLS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_archive_cls
-- ----------------------------
INSERT INTO `xt_archive_cls` VALUES ('101', '法律类', '0', '1', '1');
INSERT INTO `xt_archive_cls` VALUES ('102', '影像类', '0', '1', '1');

-- ----------------------------
-- Table structure for `xt_conf`
-- ----------------------------
DROP TABLE IF EXISTS `xt_conf`;
CREATE TABLE `xt_conf` (
  `CONF_ID` varchar(60) NOT NULL COMMENT '会议编码',
  `CONF_NAME` varchar(200) DEFAULT NULL COMMENT '会议名称',
  `CONF_START_TIME` varchar(14) DEFAULT NULL COMMENT '会议时间-开始时间',
  `CONF_FINISH_TIME` varchar(14) DEFAULT NULL COMMENT '会议时间-结束时间',
  `CONF_MESSAGE` varchar(600) DEFAULT NULL COMMENT '通知内容',
  `ORG_ID` varchar(10) DEFAULT NULL COMMENT '发布单位',
  PRIMARY KEY (`CONF_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_conf
-- ----------------------------
INSERT INTO `xt_conf` VALUES ('001', '国土资源局第49个世界地球日主题宣传活动周情况总结', '20181116143000', '20181116163000', '2018年4月22日是第49个世界地球日。今年地球日主题为：“珍惜自然资源  呵护美丽国土——讲好我们的地球故事”。旨在借助地球日活动平台，认真贯彻落实党的十九大、十九届二中、三中全会精神和习近平新时代中国特色社会主义思想，结合新时代国土资源工作“加快建设安全、绿色、高效、法治、和谐美丽国土”的总体目标，引导社会大众树立“绿水青山就是金山银山”和“人与自然和谐共生”的理念。', '411200');
INSERT INTO `xt_conf` VALUES ('002', '中牟县国土资源局开展地球日活动', '20181115083000', '20181115113000', '为了进一步增强群众爱护地球，珍惜资源的意识，4月20日，中牟县国土资源局在县文化广场开展了以“珍惜自然资源呵护美丽国土——讲好我们的地球故事”为主题的第49个世界地球日宣传活动，引导广大干部群众树立“绿水青山就是金山银山”和“人与自然和谐共生”的理念，以丰富多彩的形式开展科普宣传。', '411200');

-- ----------------------------
-- Table structure for `xt_conf_users`
-- ----------------------------
DROP TABLE IF EXISTS `xt_conf_users`;
CREATE TABLE `xt_conf_users` (
  `CONF_ID` varchar(60) NOT NULL COMMENT '会议编码',
  `USER_ID` varchar(12) DEFAULT NULL COMMENT '用户编码',
  `READ_FLAG` int(11) DEFAULT NULL COMMENT '读取标志',
  `READ_TIME` char(14) DEFAULT NULL COMMENT '读取时间',
  PRIMARY KEY (`CONF_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_conf_users
-- ----------------------------
INSERT INTO `xt_conf_users` VALUES ('001', '41120051', '1', '20181116133200');
INSERT INTO `xt_conf_users` VALUES ('002', '41010001', '1', '20181116133200');

-- ----------------------------
-- Table structure for `xt_device`
-- ----------------------------
DROP TABLE IF EXISTS `xt_device`;
CREATE TABLE `xt_device` (
  `DEVICE_ID` varchar(30) NOT NULL COMMENT '终端编码',
  `ORG_ID` varchar(20) DEFAULT NULL COMMENT '单位编码',
  `USER_ID` varchar(30) NOT NULL COMMENT '用户编码',
  `APPVER` varchar(30) DEFAULT NULL COMMENT 'APP版本',
  `SYSVER` varchar(30) DEFAULT NULL COMMENT '系统版本',
  `ISACTIVE` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`DEVICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_device
-- ----------------------------
INSERT INTO `xt_device` VALUES ('', '410100', '41010001', '', '', '1');

-- ----------------------------
-- Table structure for `xt_feed_back`
-- ----------------------------
DROP TABLE IF EXISTS `xt_feed_back`;
CREATE TABLE `xt_feed_back` (
  `ID` char(60) NOT NULL COMMENT '反馈信息编码',
  `DEVICE_ID` varchar(30) DEFAULT NULL COMMENT '终端编码',
  `PHONE_NUM` varchar(30) DEFAULT NULL COMMENT '联系电话',
  `LOG_TEXT` varchar(2000) DEFAULT NULL COMMENT '反馈内容',
  `MAILNO` varchar(60) DEFAULT NULL COMMENT '电子邮箱',
  `UPDATE_TIME` varchar(14) DEFAULT NULL COMMENT '反馈时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_feed_back
-- ----------------------------
INSERT INTO `xt_feed_back` VALUES ('201811160959010001', '1', '18939258885', '1234567', null, null);
INSERT INTO `xt_feed_back` VALUES ('201811161000370000000120', '1', '18939258885', '1234567', null, null);
INSERT INTO `xt_feed_back` VALUES ('201811161002150000000120', '1', '18939258885', '1234567', null, null);
INSERT INTO `xt_feed_back` VALUES ('201811161003520000000120', '1', '18939258885', '1234567', null, null);
INSERT INTO `xt_feed_back` VALUES ('201811190202410000000120', '123', '18939258885', '1234567', null, null);
INSERT INTO `xt_feed_back` VALUES ('201811190203000000000220', '1234', '18939258885', '1234567', null, null);

-- ----------------------------
-- Table structure for `xt_gw_flow`
-- ----------------------------
DROP TABLE IF EXISTS `xt_gw_flow`;
CREATE TABLE `xt_gw_flow` (
  `FLOW_GUID` char(60) NOT NULL COMMENT '流程GUID',
  `WF_ID` varchar(10) NOT NULL COMMENT '工作流ID',
  `FLOW_ID` varchar(10) NOT NULL COMMENT '流程编码',
  `FLOW_NAME` varchar(200) NOT NULL COMMENT '流程名称',
  `FLOW_DESC` varchar(200) DEFAULT NULL COMMENT '流程说明',
  `TYPE_ID` varchar(10) DEFAULT NULL COMMENT '上级流程',
  PRIMARY KEY (`FLOW_GUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_gw_flow
-- ----------------------------
INSERT INTO `xt_gw_flow` VALUES ('1', 'SXW_01', '1', '办公室登记', '登记', '0');
INSERT INTO `xt_gw_flow` VALUES ('2', 'SXW_01', '2', '领导批示', '批示', '0');

-- ----------------------------
-- Table structure for `xt_gw_fs`
-- ----------------------------
DROP TABLE IF EXISTS `xt_gw_fs`;
CREATE TABLE `xt_gw_fs` (
  `GW_ID` char(60) NOT NULL COMMENT '公文ID',
  `ORG_ID` varchar(20) DEFAULT NULL COMMENT '单位编码',
  `WF_ID` varchar(10) DEFAULT NULL COMMENT '工作流ID',
  `GW_TITLE` varchar(200) DEFAULT NULL COMMENT '公文标题',
  `GW_SUMMARY` varchar(600) DEFAULT NULL COMMENT '公文摘要',
  `GW_NO` varchar(120) DEFAULT NULL COMMENT '公文编号',
  `GW_ORG` varchar(120) DEFAULT NULL COMMENT '发文机关',
  `GW_TYPE` varchar(60) DEFAULT NULL COMMENT '公文类型',
  `GW_DATE` varchar(8) DEFAULT NULL COMMENT '发文时间',
  `ACCEPT_DATE` varchar(8) DEFAULT NULL COMMENT '收文时间',
  `FILE_LIST` varchar(600) DEFAULT NULL COMMENT '文件列表',
  `WRITE_USER_ID` varchar(12) DEFAULT NULL COMMENT '拟稿人',
  `CHECK_USER_ID` varchar(12) DEFAULT NULL COMMENT '审核人',
  `LINK_USER` varchar(50) DEFAULT NULL COMMENT '联系人',
  `LINK_TELNO` varchar(30) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`GW_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_gw_fs
-- ----------------------------
INSERT INTO `xt_gw_fs` VALUES ('001', '411200', '12', '测试', '我是测试摘要2', '02', 'texte', '通知3', '20181120', '20181120', '123', '??', '??', '??', '15713814998');
INSERT INTO `xt_gw_fs` VALUES ('003', '411200', '16', '测试3', '我是测试摘要3', '03', 'texte', '通知3', '20181118', null, '/upload/gw_fs/2018111802.pdf', '张三3', '李四3', '张三3', '12345678910');

-- ----------------------------
-- Table structure for `xt_gw_grant`
-- ----------------------------
DROP TABLE IF EXISTS `xt_gw_grant`;
CREATE TABLE `xt_gw_grant` (
  `FLOW_GUID` varchar(60) NOT NULL COMMENT '流程GUID',
  `ROLE_ID` varchar(12) DEFAULT NULL COMMENT '角色编码',
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
  `GW_ID` char(60) NOT NULL COMMENT '公文ID',
  `ORG_ID` varchar(20) DEFAULT NULL COMMENT '单位编码',
  `WF_ID` varchar(10) DEFAULT NULL COMMENT '工作流ID',
  `GW_TITLE` varchar(200) DEFAULT NULL COMMENT '公文标题',
  `GW_NO` varchar(120) DEFAULT NULL COMMENT '公文编号',
  `GW_ORG` varchar(120) DEFAULT NULL COMMENT '发文机关',
  `GW_TYPE` varchar(60) DEFAULT NULL COMMENT '公文类型',
  `GW_DATE` varchar(8) DEFAULT NULL COMMENT '发文时间',
  `ACCEPT_DATE` varchar(8) DEFAULT NULL COMMENT '收文时间',
  `FILE_LIST` varchar(600) DEFAULT NULL COMMENT '文件列表',
  `GW_SUMMARY` varchar(600) DEFAULT NULL COMMENT '公文摘要',
  `LINK_USER` varchar(50) DEFAULT NULL COMMENT '联系人',
  `LINK_TELNO` varchar(30) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`GW_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_gw_js
-- ----------------------------
INSERT INTO `xt_gw_js` VALUES ('20181116140000100000120', '411200', null, '《河南省无障碍环境建设管理办法》(省政府令184号)', '省政府令184号', '河南省人民政府', 'TZ', '20180213', '20181013', '/upload/gw_js/2018111602.pdf', '《河南省无障碍环境建设管理办法》已经2018年1月12日省政府第149次常务会议通过,现予公布,自2018年4月1日起施行。', '张小强', '037166889955');
INSERT INTO `xt_gw_js` VALUES ('3', '411200', null, '关于加强行政执法监督工作的通知', '豫政2018[096]号', '河南省人民政府', 'TZ', '20180905', '20180912', '/upload/gw_js/2018111601.pdf', '在监督中，对制定的规范性文件与法律、法规、上级人民政府制定的规范性文件相抵触的，通知其限期改正，逾期不改的，责令其修改、废止或撤销；对行政执法主体不合法的，责令其停止行政执法活动，并建议有权处理的机关依法处理；对主要事实不清、证据不足、适用法律、法规、规章错误或违反法定程序的具体行政行为，当事人未申请行政复议或未提起行政诉讼的，通知其改正，拒不改正的，予以撤销；对行政执法机关和行政执法人员在行政执法活动中，因故意或者过失，作出的违法或明显不当的具体行政行为，以及不履行法定职责的不作为行为，按照《贵州省行政执法过错责任追究办法》相关规定和程序处理。\r\n', '刘凤', '037166889955');
INSERT INTO `xt_gw_js` VALUES ('4', '411200', null, '河南省人民政府关于濮阳市2018年度第六批乡镇建设征收土地的批复', '豫政土 〔2018〕 902号', '河南省人民政府', 'PF', '20180905', '20180912', '/upload/gw_js/2018111602.pdf', null, null, null);

-- ----------------------------
-- Table structure for `xt_gw_step`
-- ----------------------------
DROP TABLE IF EXISTS `xt_gw_step`;
CREATE TABLE `xt_gw_step` (
  `STEP_GUID` char(60) NOT NULL COMMENT '流程编码',
  `ORG_ID` varchar(20) DEFAULT NULL COMMENT '单位编码',
  `GW_ID` char(60) DEFAULT NULL COMMENT '公文编号',
  `GW_LX` varchar(10) DEFAULT NULL COMMENT '公文类型',
  `FLOW_ID` varchar(10) DEFAULT NULL COMMENT '流程编号',
  `CLS_ID` int(11) DEFAULT NULL COMMENT '流程类型',
  `START_USER_ID` varchar(12) DEFAULT NULL COMMENT '创建人员',
  `START_TIME` varchar(14) NOT NULL COMMENT '创建时间',
  `READ_FLAG` int(11) DEFAULT NULL COMMENT '读取标志',
  `READ_TIME` varchar(14) DEFAULT NULL COMMENT '读取日期',
  `FINISH_USER_ID` varchar(12) DEFAULT NULL COMMENT '审批用户',
  `FINISH_TIME` varchar(14) DEFAULT NULL COMMENT '审批时间',
  `FLOW_STATUS` int(11) DEFAULT NULL COMMENT '审批意见',
  `FLOW_CONTENT` varchar(200) DEFAULT NULL COMMENT '审批内容',
  `IS_COMPLETE` int(11) DEFAULT NULL COMMENT '审批标志',
  PRIMARY KEY (`STEP_GUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_gw_step
-- ----------------------------
INSERT INTO `xt_gw_step` VALUES ('1', '411200', '20181116140000100000120', 'TZ', '0', null, '41120051', '20181116080020', null, '20181120', '41120051', '20181116140000', null, 'OK', null);
INSERT INTO `xt_gw_step` VALUES ('10', '411200', '003', 'TZ', '0', '1', '41120001', '20181118151800', null, null, '41120001', null, '0', '258', '0');
INSERT INTO `xt_gw_step` VALUES ('2', '411200', '20181116140000100000120', 'TZ', '1', '1', '41120051', '20181116140000', null, null, '41120002', '20181116163000', '0', null, '0');
INSERT INTO `xt_gw_step` VALUES ('3', '411200', '20181116140000100000120', 'TZ', '1', '2', '41120002', '20181116163000', null, null, '41120001', null, '0', '369', '0');
INSERT INTO `xt_gw_step` VALUES ('4', '411200', '004', 'TZ', '0', '0', '41120001', '20181118173000', null, null, '41120001', '20181118173000', '0', null, '0');
INSERT INTO `xt_gw_step` VALUES ('7', '411200', '002', 'TZ', '0', '1', '41120051', '20181116163000', null, null, '41120051', '20181116163000', '0', null, '0');
INSERT INTO `xt_gw_step` VALUES ('8', '411200', '002', 'TZ', '2', '1', '41120051', '20181116140000', null, null, '41120002', null, '0', null, '0');
INSERT INTO `xt_gw_step` VALUES ('9', '411200', '003', 'TZ', '0', '1', '41120001', '20181118151800', null, null, '41120001', null, '0', '258', '0');

-- ----------------------------
-- Table structure for `xt_gw_wf`
-- ----------------------------
DROP TABLE IF EXISTS `xt_gw_wf`;
CREATE TABLE `xt_gw_wf` (
  `WF_ID` varchar(10) NOT NULL COMMENT '工作流ID',
  `ORG_ID` varchar(20) DEFAULT NULL COMMENT '单位编码',
  `WF_NAME` varchar(100) NOT NULL COMMENT '流程编码',
  `GW_LX` varchar(10) NOT NULL COMMENT '公文类型',
  `WF_DESC` varchar(200) DEFAULT NULL COMMENT '流程描述',
  `CREATE_DATE` char(8) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`WF_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_gw_wf
-- ----------------------------
INSERT INTO `xt_gw_wf` VALUES ('PXW_01', '411200', '???', 'H', '????', '20181120');
INSERT INTO `xt_gw_wf` VALUES ('SXW_01', '411200', '上行文', 'HB', '请示汇报', '20180121');
INSERT INTO `xt_gw_wf` VALUES ('SXW_02', '411200', '上行文', 'SQ', '申请资金', '20180221');
INSERT INTO `xt_gw_wf` VALUES ('XXW_01', '411200', '下行文', 'TZ', '通知', '20180201');

-- ----------------------------
-- Table structure for `xt_interface`
-- ----------------------------
DROP TABLE IF EXISTS `xt_interface`;
CREATE TABLE `xt_interface` (
  `INTERFACE_URL` varchar(100) NOT NULL COMMENT '接口地址',
  `INTERFACE_DESC` varchar(100) DEFAULT NULL COMMENT '接口描述',
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
  `ID` varchar(60) NOT NULL COMMENT '文书编码',
  `ORG_ID` varchar(20) DEFAULT NULL COMMENT '单位编码',
  `CLS_ID` varchar(30) DEFAULT NULL COMMENT '文书类型',
  `TITLE` varchar(300) DEFAULT NULL COMMENT '文书标题',
  `PAGE_HTML` text COMMENT '文书内容',
  `PUBLISH` varchar(200) DEFAULT NULL COMMENT '发文机关',
  `PUBLISH_DATE` varchar(20) DEFAULT NULL COMMENT '发文时间',
  `CREATE_DATE` char(8) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_law_inf
-- ----------------------------
INSERT INTO `xt_law_inf` VALUES ('1', '411200', '1111', '中华人民共和国测绘法', '中华人民共和国测绘法\r\n作者：法规处信息员   来源：政策法规处    时间：2017-07-06   浏览： 900 人次\r\n中华人民共和国测绘法\r\n\r\n（1992年12月28日第七届全国人民代表大会常务委员会第二十九次会议通过 2002年8月29日第九届全国人民代表大会常务委员会第二十九次会议第一次修订 2017年4月27日第十二届全国人民代表大会常务委员会第二十七次会议第二次修订）\r\n\r\n \r\n\r\n目录\r\n\r\n    第一章 总则\r\n\r\n    第二章 测绘基准和测绘系统\r\n\r\n    第三章 基础测绘\r\n\r\n    第四章 界线测绘和其他测绘\r\n\r\n    第五章 测绘资质资格\r\n\r\n    第六章 测绘成果\r\n\r\n    第七章 测量标志保护\r\n\r\n    第八章 监督管理\r\n\r\n    第九章 法律责任\r\n\r\n    第十章 附则\r\n\r\n第一章 总   则\r\n\r\n    第一条 为了加强测绘管理，促进测绘事业发展，保障测绘事业为经济建设、国防建设、社会发展和生态保护服务，维护国家地理信息安全，制定本法。\r\n\r\n    第二条 在中华人民共和国领域和中华人民共和国管辖的其他海域从事测绘活动，应当遵守本法。\r\n\r\n    本法所称测绘，是指对自然地理要素或者地表人工设施的形状、大小、空间位置及其属性等进行测定、采集、表述，以及对获取的数据、信息、成果进行处理和提供的活动。\r\n\r\n    第三条 测绘事业是经济建设、国防建设、社会发展的基础性事业。各级人民政府应当加强对测绘工作的领导。\r\n\r\n    第四条 国务院测绘地理信息主管部门负责全国测绘工作的统一监督管理。国务院其他有关部门按照国务院规定的职责分工，负责本部门有关的测绘工作。\r\n\r\n    县级以上地方人民政府测绘地理信息主管部门负责本行政区域测绘工作的统一监督管理。县级以上地方人民政府其他有关部门按照本级人民政府规定的职责分工，负责本部门有关的测绘工作。\r\n\r\n    军队测绘部门负责管理军事部门的测绘工作，并按照国务院、中央军事委员会规定的职责分工负责管理海洋基础测绘工作。\r\n\r\n    第五条 从事测绘活动，应当使用国家规定的测绘基准和测绘系统，执行国家规定的测绘技术规范和标准。\r\n\r\n    第六条 国家鼓励测绘科学技术的创新和进步，采用先进的技术和设备，提高测绘水平，推动军民融合，促进测绘成果的应用。国家加强测绘科学技术的国际交流与合作。\r\n\r\n    对在测绘科学技术的创新和进步中做出重要贡献的单位和个人，按照国家有关规定给予奖励。\r\n\r\n    第七条 各级人民政府和有关部门应当加强对国家版图意识的宣传教育，增强公民的国家版图意识。新闻媒体应当开展国家版图意识的宣传。教育行政部门、学校应当将国家版图意识教育纳入中小学教学内容，加强爱国主义教育。\r\n\r\n    第八条 外国的组织或者个人在中华人民共和国领域和中华人民共和国管辖的其他海域从事测绘活动，应当经国务院测绘地理信息主管部门会同军队测绘部门批准，并遵守中华人民共和国有关法律、行政法规的规定。\r\n\r\n    外国的组织或者个人在中华人民共和国领域从事测绘活动，应当与中华人民共和国有关部门或者单位合作进行，并不得涉及国家秘密和危害国家安全。\r\n\r\n第二章 测绘基准和测绘系统\r\n\r\n    第九条 国家设立和采用全国统一的大地基准、高程基准、深度基准和重力基准，其数据由国务院测绘地理信息主管部门审核，并与国务院其他有关部门、军队测绘部门会商后，报国务院批准。\r\n\r\n    第十条 国家建立全国统一的大地坐标系统、平面坐标系统、高程系统、地心坐标系统和重力测量系统，确定国家大地测量等级和精度以及国家基本比例尺地图的系列和基本精度。具体规范和要求由国务院测绘地理信息主管部门会同国务院其他有关部门、军队测绘部门制定。\r\n\r\n    第十一条 因建设、城市规划和科学研究的需要，国家重大工程项目和国务院确定的大城市确需建立相对独立的平面坐标系统的，由国务院测绘地理信息主管部门批准；其他确需建立相对独立的平面坐标系统的，由省、自治区、直辖市人民政府测绘地理信息主管部门批准。\r\n\r\n    建立相对独立的平面坐标系统，应当与国家坐标系统相联系。\r\n\r\n    第十二条 国务院测绘地理信息主管部门和省、自治区、直辖市人民政府测绘地理信息主管部门应当会同本级人民政府其他有关部门，按照统筹建设、资源共享的原则，建立统一的卫星导航定位基准服务系统，提供导航定位基准信息公共服务。\r\n\r\n    第十三条 建设卫星导航定位基准站的，建设单位应当按照国家有关规定报国务院测绘地理信息主管部门或者省、自治区、直辖市人民政府测绘地理信息主管部门备案。国务院测绘地理信息主管部门应当汇总全国卫星导航定位基准站建设备案情况，并定期向军队测绘部门通报。\r\n\r\n    本法所称卫星导航定位基准站，是指对卫星导航信号进行长期连续观测，并通过通信设施将观测数据实时或者定时传送至数据中心的地面固定观测站。\r\n\r\n    第十四条 卫星导航定位基准站的建设和运行维护应当符合国家标准和要求，不得危害国家安全。\r\n\r\n    卫星导航定位基准站的建设和运行维护单位应当建立数据安全保障制度，并遵守保密法律、行政法规的规定。\r\n\r\n    县级以上人民政府测绘地理信息主管部门应当会同本级人民政府其他有关部门，加强对卫星导航定位基准站建设和运行维护的规范和指导。\r\n\r\n第三章 基础测绘\r\n\r\n    第十五条 基础测绘是公益性事业。国家对基础测绘实行分级管理。\r\n\r\n    本法所称基础测绘，是指建立全国统一的测绘基准和测绘系统，进行基础航空摄影，获取基础地理信息的遥感资料，测制和更新国家基本比例尺地图、影像图和数字化产品，建立、更新基础地理信息系统。\r\n\r\n    第十六条 国务院测绘地理信息主管部门会同国务院其他有关部门、军队测绘部门组织编制全国基础测绘规划，报国务院批准后组织实施。\r\n\r\n    县级以上地方人民政府测绘地理信息主管部门会同本级人民政府其他有关部门，根据国家和上一级人民政府的基础测绘规划及本行政区域的实际情况，组织编制本行政区域的基础测绘规划，报本级人民政府批准后组织实施。\r\n\r\n    第十七条 军队测绘部门负责编制军事测绘规划，按照国务院、中央军事委员会规定的职责分工负责编制海洋基础测绘规划，并组织实施。\r\n\r\n    第十八条 县级以上人民政府应当将基础测绘纳入本级国民经济和社会发展年度计划，将基础测绘工作所需经费列入本级政府预算。\r\n\r\n    国务院发展改革部门会同国务院测绘地理信息主管部门，根据全国基础测绘规划编制全国基础测绘年度计划。\r\n\r\n    县级以上地方人民政府发展改革部门会同本级人民政府测绘地理信息主管部门，根据本行政区域的基础测绘规划编制本行政区域的基础测绘年度计划，并分别报上一级部门备案。\r\n\r\n    第十九条 基础测绘成果应当定期更新，经济建设、国防建设、社会发展和生态保护急需的基础测绘成果应当及时更新。\r\n\r\n    基础测绘成果的更新周期根据不同地区国民经济和社会发展的需要确定。\r\n\r\n第四章 界线测绘和其他测绘\r\n\r\n    第二十条 中华人民共和国国界线的测绘，按照中华人民共和国与相邻国家缔结的边界条约或者协定执行，由外交部组织实施。中华人民共和国地图的国界线标准样图，由外交部和国务院测绘地理信息主管部门拟定，报国务院批准后公布。\r\n\r\n    第二十一条 行政区域界线的测绘，按照国务院有关规定执行。省、自治区、直辖市和自治州、县、自治县、市行政区域界线的标准画法图，由国务院民政部门和国务院测绘地理信息主管部门拟定，报国务院批准后公布。\r\n\r\n    第二十二条 县级以上人民政府测绘地理信息主管部门应当会同本级人民政府不动产登记主管部门，加强对不动产测绘的管理。\r\n\r\n    测量土地、建筑物、构筑物和地面其他附着物的权属界址线，应当按照县级以上人民政府确定的权属界线的界址点、界址线或者提供的有关登记资料和附图进行。权属界址线发生变化的，有关当事人应当及时进行变更测绘。\r\n\r\n    第二十三条 城乡建设领域的工程测量活动，与房屋产权、产籍相关的房屋面积的测量，应当执行由国务院住房城乡建设主管部门、国务院测绘地理信息主管部门组织编制的测量技术规范。\r\n\r\n    水利、能源、交通、通信、资源开发和其他领域的工程测量活动，应当执行国家有关的工程测量技术规范。\r\n\r\n    第二十四条 建立地理信息系统，应当采用符合国家标准的基础地理信息数据。\r\n\r\n    第二十五条 县级以上人民政府测绘地理信息主管部门应当根据突发事件应对工作需要，及时提供地图、基础地理信息数据等测绘成果，做好遥感监测、导航定位等应急测绘保障工作。\r\n\r\n    第二十六条 县级以上人民政府测绘地理信息主管部门应当会同本级人民政府其他有关部门依法开展地理国情监测，并按照国家有关规定严格管理、规范使用地理国情监测成果。\r\n\r\n    各级人民政府应当采取有效措施，发挥地理国情监测成果在政府决策、经济社会发展和社会公众服务中的作用。\r\n\r\n第五章 测绘资质资格\r\n\r\n    第二十七条 国家对从事测绘活动的单位实行测绘资质管理制度。\r\n\r\n    从事测绘活动的单位应当具备下列条件，并依法取得相应等级的测绘资质证书，方可从事测绘活动：\r\n\r\n    （一）有法人资格；\r\n\r\n    （二）有与从事的测绘活动相适应的专业技术人员；\r\n\r\n    （三）有与从事的测绘活动相适应的技术装备和设施；\r\n\r\n    （四）有健全的技术和质量保证体系、安全保障措施、信息安全保密管理制度以及测绘成果和资料档案管理制度。\r\n\r\n    第二十八条 国务院测绘地理信息主管部门和省、自治区、直辖市人民政府测绘地理信息主管部门按照各自的职责负责测绘资质审查、发放测绘资质证书。具体办法由国务院测绘地理信息主管部门商国务院其他有关部门规定。\r\n\r\n    军队测绘部门负责军事测绘单位的测绘资质审查。\r\n\r\n    第二十九条 测绘单位不得超越资质等级许可的范围从事测绘活动，不得以其他测绘单位的名义从事测绘活动，不得允许其他单位以本单位的名义从事测绘活动。\r\n\r\n    测绘项目实行招投标的，测绘项目的招标单位应当依法在招标公告或者投标邀请书中对测绘单位资质等级作出要求，不得让不具有相应测绘资质等级的单位中标，不得让测绘单位低于测绘成本中标。\r\n\r\n    中标的测绘单位不得向他人转让测绘项目。\r\n\r\n    第三十条 从事测绘活动的专业技术人员应当具备相应的执业资格条件。具体办法由国务院测绘地理信息主管部门会同国务院人力资源社会保障主管部门规定。\r\n\r\n    第三十一条 测绘人员进行测绘活动时，应当持有测绘作业证件。\r\n\r\n    任何单位和个人不得阻碍测绘人员依法进行测绘活动。\r\n\r\n    第三十二条 测绘单位的测绘资质证书、测绘专业技术人员的执业证书和测绘人员的测绘作业证件的式样，由国务院测绘地理信息主管部门统一规定。\r\n\r\n第六章 测绘成果\r\n\r\n    第三十三条 国家实行测绘成果汇交制度。国家依法保护测绘成果的知识产权。\r\n\r\n    测绘项目完成后，测绘项目出资人或者承担国家投资的测绘项目的单位，应当向国务院测绘地理信息主管部门或者省、自治区、直辖市人民政府测绘地理信息主管部门汇交测绘成果资料。属于基础测绘项目的，应当汇交测绘成果副本；属于非基础测绘项目的，应当汇交测绘成果目录。负责接收测绘成果副本和目录的测绘地理信息主管部门应当出具测绘成果汇交凭证，并及时将测绘成果副本和目录移交给保管单位。测绘成果汇交的具体办法由国务院规定。\r\n\r\n    国务院测绘地理信息主管部门和省、自治区、直辖市人民政府测绘地理信息主管部门应当及时编制测绘成果目录，并向社会公布。\r\n\r\n    第三十四条 县级以上人民政府测绘地理信息主管部门应当积极推进公众版测绘成果的加工和编制工作，通过提供公众版测绘成果、保密技术处理等方式，促进测绘成果的社会化应用。\r\n\r\n    测绘成果保管单位应当采取措施保障测绘成果的完整和安全，并按照国家有关规定向社会公开和提供利用。\r\n\r\n    测绘成果属于国家秘密的，适用保密法律、行政法规的规定；需要对外提供的，按照国务院和中央军事委员会规定的审批程序执行。\r\n\r\n    测绘成果的秘密范围和秘密等级，应当依照保密法律、行政法规的规定，按照保障国家秘密安全、促进地理信息共享和应用的原则确定并及时调整、公布。\r\n\r\n    第三十五条 使用财政资金的测绘项目和涉及测绘的其他使用财政资金的项目，有关部门在批准立项前应当征求本级人民政府测绘地理信息主管部门的意见；有适宜测绘成果的，应当充分利用已有的测绘成果，避免重复测绘。\r\n\r\n    第三十六条 基础测绘成果和国家投资完成的其他测绘成果，用于政府决策、国防建设和公共服务的，应当无偿提供。\r\n\r\n    除前款规定情形外，测绘成果依法实行有偿使用制度。但是，各级人民政府及有关部门和军队因防灾减灾、应对突发事件、维护国家安全等公共利益的需要，可以无偿使用。\r\n\r\n    测绘成果使用的具体办法由国务院规定。\r\n\r\n    第三十七条 中华人民共和国领域和中华人民共和国管辖的其他海域的位置、高程、深度、面积、长度等重要地理信息数据，由国务院测绘地理信息主管部门审核，并与国务院其他有关部门、军队测绘部门会商后，报国务院批准，由国务院或者国务院授权的部门公布。\r\n\r\n    第三十八条 地图的编制、出版、展示、登载及更新应当遵守国家有关地图编制标准、地图内容表示、地图审核的规定。\r\n\r\n    互联网地图服务提供者应当使用经依法审核批准的地图，建立地图数据安全管理制度，采取安全保障措施，加强对互联网地图新增内容的核校，提高服务质量。\r\n\r\n    县级以上人民政府和测绘地理信息主管部门、网信部门等有关部门应当加强对地图编制、出版、展示、登载和互联网地图服务的监督管理，保证地图质量，维护国家主权、安全和利益。\r\n\r\n    地图管理的具体办法由国务院规定。\r\n\r\n    第三十九条 测绘单位应当对完成的测绘成果质量负责。县级以上人民政府测绘地理信息主管部门应当加强对测绘成果质量的监督管理。\r\n\r\n    第四十条 国家鼓励发展地理信息产业，推动地理信息产业结构调整和优化升级，支持开发各类地理信息产品，提高产品质量，推广使用安全可信的地理信息技术和设备。\r\n\r\n    县级以上人民政府应当建立健全政府部门间地理信息资源共建共享机制，引导和支持企业提供地理信息社会化服务，促进地理信息广泛应用。\r\n\r\n    县级以上人民政府测绘地理信息主管部门应当及时获取、处理、更新基础地理信息数据，通过地理信息公共服务平台向社会提供地理信息公共服务，实现地理信息数据开放共享。\r\n\r\n第七章 测量标志保护\r\n\r\n    第四十一条 任何单位和个人不得损毁或者擅自移动永久性测量标志和正在使用中的临时性测量标志，不得侵占永久性测量标志用地，不得在永久性测量标志安全控制范围内从事危害测量标志安全和使用效能的活动。\r\n\r\n    本法所称永久性测量标志，是指各等级的三角点、基线点、导线点、军用控制点、重力点、天文点、水准点和卫星定位点的觇标和标石标志，以及用于地形测图、工程测量和形变测量的固定标志和海底大地点设施。\r\n\r\n    第四十二条 永久性测量标志的建设单位应当对永久性测量标志设立明显标记，并委托当地有关单位指派专人负责保管。\r\n\r\n    第四十三条 进行工程建设，应当避开永久性测量标志；确实无法避开，需要拆迁永久性测量标志或者使永久性测量标志失去使用效能的，应当经省、自治区、直辖市人民政府测绘地理信息主管部门批准；涉及军用控制点的，应当征得军队测绘部门的同意。所需迁建费用由工程建设单位承担。\r\n\r\n    第四十四条 测绘人员使用永久性测量标志，应当持有测绘作业证件，并保证测量标志的完好。\r\n\r\n    保管测量标志的人员应当查验测量标志使用后的完好状况。\r\n\r\n    第四十五条 县级以上人民政府应当采取有效措施加强测量标志的保护工作。\r\n\r\n    县级以上人民政府测绘地理信息主管部门应当按照规定检查、维护永久性测量标志。\r\n\r\n    乡级人民政府应当做好本行政区域内的测量标志保护工作。\r\n\r\n第八章 监督管理\r\n\r\n    第四十六条 县级以上人民政府测绘地理信息主管部门应当会同本级人民政府其他有关部门建立地理信息安全管理制度和技术防控体系，并加强对地理信息安全的监督管理。\r\n\r\n    第四十七条 地理信息生产、保管、利用单位应当对属于国家秘密的地理信息的获取、持有、提供、利用情况进行登记并长期保存，实行可追溯管理。\r\n\r\n    从事测绘活动涉及获取、持有、提供、利用属于国家秘密的地理信息，应当遵守保密法律、行政法规和国家有关规定。\r\n\r\n    地理信息生产、利用单位和互联网地图服务提供者收集、使用用户个人信息的，应当遵守法律、行政法规关于个人信息保护的规定。\r\n\r\n    第四十八条 县级以上人民政府测绘地理信息主管部门应当对测绘单位实行信用管理，并依法将其信用信息予以公示。\r\n\r\n    第四十九条 县级以上人民政府测绘地理信息主管部门应当建立健全随机抽查机制，依法履行监督检查职责，发现涉嫌违反本法规定行为的，可以依法采取下列措施：\r\n\r\n    （一）查阅、复制有关合同、票据、账簿、登记台账以及其他有关文件、资料；\r\n\r\n    （二）查封、扣押与涉嫌违法测绘行为直接相关的设备、工具、原材料、测绘成果资料等。\r\n\r\n    被检查的单位和个人应当配合，如实提供有关文件、资料，不得隐瞒、拒绝和阻碍。\r\n\r\n    任何单位和个人对违反本法规定的行为，有权向县级以上人民政府测绘地理信息主管部门举报。接到举报的测绘地理信息主管部门应当及时依法处理。\r\n\r\n第九章 法律责任\r\n\r\n    第五十条 违反本法规定，县级以上人民政府测绘地理信息主管部门或者其他有关部门工作人员利用职务上的便利收受他人财物、其他好处或者玩忽职守，对不符合法定条件的单位核发测绘资质证书，不依法履行监督管理职责，或者发现违法行为不予查处的，对负有责任的领导人员和直接责任人员，依法给予处分；构成犯罪的，依法追究刑事责任。\r\n\r\n    第五十一条 违反本法规定，外国的组织或者个人未经批准，或者未与中华人民共和国有关部门、单位合作，擅自从事测绘活动的，责令停止违法行为，没收违法所得、测绘成果和测绘工具，并处十万元以上五十万元以下的罚款；情节严重的，并处五十万元以上一百万元以下的罚款，限期出境或者驱逐出境；构成犯罪的，依法追究刑事责任。\r\n\r\n    第五十二条 违反本法规定，未经批准擅自建立相对独立的平面坐标系统，或者采用不符合国家标准的基础地理信息数据建立地理信息系统的，给予警告，责令改正，可以并处五十万元以下的罚款；对直接负责的主管人员和其他直接责任人员，依法给予处分。\r\n\r\n    第五十三条 违反本法规定，卫星导航定位基准站建设单位未报备案的，给予警告，责令限期改正；逾期不改正的，处十万元以上三十万元以下的罚款；对直接负责的主管人员和其他直接责任人员，依法给予处分。\r\n\r\n    第五十四条 违反本法规定，卫星导航定位基准站的建设和运行维护不符合国家标准、要求的，给予警告，责令限期改正，没收违法所得和测绘成果，并处三十万元以上五十万元以下的罚款；逾期不改正的，没收相关设备；对直接负责的主管人员和其他直接责任人员，依法给予处分；构成犯罪的，依法追究刑事责任。\r\n\r\n    第五十五条 违反本法规定，未取得测绘资质证书，擅自从事测绘活动的，责令停止违法行为，没收违法所得和测绘成果，并处测绘约定报酬一倍以上二倍以下的罚款；情节严重的，没收测绘工具。\r\n\r\n    以欺骗手段取得测绘资质证书从事测绘活动的，吊销测绘资质证书，没收违法所得和测绘成果，并处测绘约定报酬一倍以上二倍以下的罚款；情节严重的，没收测绘工具。\r\n\r\n    第五十六条 违反本法规定，测绘单位有下列行为之一的，责令停止违法行为，没收违法所得和测绘成果，处测绘约定报酬一倍以上二倍以下的罚款，并可以责令停业整顿或者降低测绘资质等级；情节严重的，吊销测绘资质证书：\r\n\r\n    （一）超越资质等级许可的范围从事测绘活动；\r\n\r\n    （二）以其他测绘单位的名义从事测绘活动；\r\n\r\n    （三）允许其他单位以本单位的名义从事测绘活动。\r\n\r\n    第五十七条 违反本法规定，测绘项目的招标单位让不具有相应资质等级的测绘单位中标，或者让测绘单位低于测绘成本中标的，责令改正，可以处测绘约定报酬二倍以下的罚款。招标单位的工作人员利用职务上的便利，索取他人财物，或者非法收受他人财物为他人谋取利益的，依法给予处分；构成犯罪的，依法追究刑事责任。\r\n\r\n    第五十八条 违反本法规定，中标的测绘单位向他人转让测绘项目的，责令改正，没收违法所得，处测绘约定报酬一倍以上二倍以下的罚款，并可以责令停业整顿或者降低测绘资质等级；情节严重的，吊销测绘资质证书。\r\n\r\n    第五十九条 违反本法规定，未取得测绘执业资格，擅自从事测绘活动的，责令停止违法行为，没收违法所得和测绘成果，对其所在单位可以处违法所得二倍以下的罚款；情节严重的，没收测绘工具；造成损失的，依法承担赔偿责任。\r\n\r\n    第六十条 违反本法规定，不汇交测绘成果资料的，责令限期汇交；测绘项目出资人逾期不汇交的，处重测所需费用一倍以上二倍以下的罚款；承担国家投资的测绘项目的单位逾期不汇交的，处五万元以上二十万元以下的罚款，并处暂扣测绘资质证书，自暂扣测绘资质证书之日起六个月内仍不汇交的，吊销测绘资质证书；对直接负责的主管人员和其他直接责任人员，依法给予处分。\r\n\r\n    第六十一条 违反本法规定，擅自发布中华人民共和国领域和中华人民共和国管辖的其他海域的重要地理信息数据的，给予警告，责令改正，可以并处五十万元以下的罚款；对直接负责的主管人员和其他直接责任人员，依法给予处分；构成犯罪的，依法追究刑事责任。\r\n\r\n    第六十二条 违反本法规定，编制、出版、展示、登载、更新的地图或者互联网地图服务不符合国家有关地图管理规定的，依法给予行政处罚、处分；构成犯罪的，依法追究刑事责任。\r\n\r\n    第六十三条 违反本法规定，测绘成果质量不合格的，责令测绘单位补测或者重测；情节严重的，责令停业整顿，并处降低测绘资质等级或者吊销测绘资质证书；造成损失的，依法承担赔偿责任。\r\n\r\n    第六十四条 违反本法规定，有下列行为之一的，给予警告，责令改正，可以并处二十万元以下的罚款；对直接负责的主管人员和其他直接责任人员，依法给予处分；造成损失的，依法承担赔偿责任；构成犯罪的，依法追究刑事责任：\r\n\r\n    （一）损毁、擅自移动永久性测量标志或者正在使用中的临时性测量标志；\r\n\r\n    （二）侵占永久性测量标志用地；\r\n\r\n    （三）在永久性测量标志安全控制范围内从事危害测量标志安全和使用效能的活动；\r\n\r\n    （四）擅自拆迁永久性测量标志或者使永久性测量标志失去使用效能，或者拒绝支付迁建费用；\r\n\r\n    （五）违反操作规程使用永久性测量标志，造成永久性测量标志毁损。\r\n\r\n    第六十五条 违反本法规定，地理信息生产、保管、利用单位未对属于国家秘密的地理信息的获取、持有、提供、利用情况进行登记、长期保存的，给予警告，责令改正，可以并处二十万元以下的罚款；泄露国家秘密的，责令停业整顿，并处降低测绘资质等级或者吊销测绘资质证书；构成犯罪的，依法追究刑事责任。\r\n\r\n    违反本法规定，获取、持有、提供、利用属于国家秘密的地理信息的，给予警告，责令停止违法行为，没收违法所得，可以并处违法所得二倍以下的罚款；对直接负责的主管人员和其他直接责任人员，依法给予处分；造成损失的，依法承担赔偿责任；构成犯罪的，依法追究刑事责任。\r\n\r\n    第六十六条 本法规定的降低测绘资质等级、暂扣测绘资质证书、吊销测绘资质证书的行政处罚，由颁发测绘资质证书的部门决定；其他行政处罚，由县级以上人民政府测绘地理信息主管部门决定。\r\n\r\n    本法第五十一条规定的限期出境和驱逐出境由公安机关依法决定并执行。\r\n\r\n第十章 附   则\r\n\r\n    第六十七条 军事测绘管理办法由中央军事委员会根据本法规定。\r\n\r\n    第六十八条 本法自2017年7月1日起施行。', '国务院', '20051121', '20181121');
INSERT INTO `xt_law_inf` VALUES ('2', '411200', '1111', '中华人民共和国立法法', '中华人民共和国立法法\r\n\r\n   \r\n\r\n（2000年3月15日第九届全国人民代表大会第三次会议通过 根据2015年3月15日第十二届全国人民代表大会第三次会议《关于修改〈中华人民共和国立法法〉的决定》修正）\r\n\r\n   \r\n\r\n \r\n\r\n    目录\r\n\r\n第一章 总则\r\n\r\n第二章 法律\r\n\r\n第一节 立法权限\r\n\r\n第二节 全国人民代表大会立法程序\r\n\r\n第三节 全国人民代表大会常务委员会立法程序\r\n\r\n第四节 法律解释\r\n\r\n第五节 其他规定\r\n\r\n第三章 行政法规\r\n\r\n第四章 地方性法规、自治条例和单行条例、规章\r\n\r\n第一节 地方性法规、自治条例和单行条例\r\n\r\n第二节 规章\r\n\r\n第五章 适用与备案审查\r\n\r\n第六章 附则\r\n\r\n第一章 总则\r\n\r\n第一条为了规范立法活动，健全国家立法制度，提高立法质量，完善中国特色社会主义法律体系，发挥立法的引领和推动作用，保障和发展社会主义民主，全面推进依法治国，建设社会主义法治国家，根据宪法，制定本法。\r\n\r\n第二条 法律、行政法规、地方性法规、自治条例和单行条例的制定、修改和废止，适用本法。\r\n\r\n国务院部门规章和地方政府规章的制定、修改和废止，依照本法的有关规定执行。\r\n\r\n第三条立法应当遵循宪法的基本原则，以经济建设为中心，坚持社会主义道路、坚持人民民主专政、坚持中国共产党的领导、坚持马克思列宁主义毛泽东思想邓小平理论，坚持改革开放。\r\n\r\n第四条 立法应当依照法定的权限和程序，从国家整体利益出发，维护社会主义法制的统一和尊严。\r\n\r\n第五条 立法应当体现人民的意志，发扬社会主义民主，坚持立法公开，保障人民通过多种途径参与立法活动。\r\n\r\n第六条立法应当从实际出发，适应经济社会发展和全面深化改革的要求，科学合理地规定公民、法人和其他组织的权利与义务、国家机关的权力与责任。\r\n\r\n法律规范应当明确、具体，具有针对性和可执行性。\r\n\r\n第二章 法律\r\n\r\n第一节 立法权限\r\n\r\n第七条 全国人民代表大会和全国人民代表大会常务委员会行使国家立法权。\r\n\r\n全国人民代表大会制定和修改刑事、民事、国家机构的和其他的基本法律。\r\n\r\n全国人民代表大会常务委员会制定和修改除应当由全国人民代表大会制定的法律以外的其他法律；在全国人民代表大会闭会期间，对全国人民代表大会制定的法律进行部分补充和修改，但是不得同该法律的基本原则相抵触。\r\n\r\n第八条 下列事项只能制定法律：\r\n\r\n（一）国家主权的事项；\r\n\r\n（二）各级人民代表大会、人民政府、人民法院和人民检察院的产生、组织和职权；\r\n\r\n（三）民族区域自治制度、特别行政区制度、基层群众自治制度；\r\n\r\n（四）犯罪和刑罚；\r\n\r\n（五）对公民政治权利的剥夺、限制人身自由的强制措施和处罚；\r\n\r\n（六）税种的设立、税率的确定和税收征收管理等税收基本制度；\r\n\r\n（七）对非国有财产的征收、征用；\r\n\r\n（八）民事基本制度；\r\n\r\n（九）基本经济制度以及财政、海关、金融和外贸的基本制度；\r\n\r\n（十）诉讼和仲裁制度；\r\n\r\n（十一）必须由全国人民代表大会及其常务委员会制定法律的其他事项。\r\n\r\n第九条本法第八条规定的事项尚未制定法律的，全国人民代表大会及其常务委员会有权作出决定，授权国务院可以根据实际需要，对其中的部分事项先制定行政法规，但是有关犯罪和刑罚、对公民政治权利的剥夺和限制人身自由的强制措施和处罚、司法制度等事项除外。\r\n\r\n第十条 授权决定应当明确授权的目的、事项、范围、期限以及被授权机关实施授权决定应当遵循的原则等。\r\n\r\n授权的期限不得超过五年，但是授权决定另有规定的除外。\r\n\r\n被授权机关应当在授权期限届满的六个月以前，向授权机关报告授权决定实施的情况，并提出是否需要制定有关法律的意见；需要继续授权的，可以提出相关意见，由全国人民代表大会及其常务委员会决定。\r\n\r\n第十一条授权立法事项，经过实践检验，制定法律的条件成熟时，由全国人民代表大会及其常务委员会及时制定法律。法律制定后，相应立法事项的授权终止。\r\n\r\n第十二条 被授权机关应当严格按照授权决定行使被授予的权力。\r\n\r\n被授权机关不得将被授予的权力转授给其他机关。\r\n\r\n第十三条全国人民代表大会及其常务委员会可以根据改革发展的需要，决定就行政管理等领域的特定事项授权在一定期限内在部分地方暂时调整或者暂时停止适用法律的部分规定。\r\n\r\n第二节 全国人民代表大会立法程序\r\n\r\n第十四条 全国人民代表大会主席团可以向全国人民代表大会提出法律案，由全国人民代表大会会议审议。\r\n\r\n全国人民代表大会常务委员会、国务院、中央军事委员会、最高人民法院、最高人民检察院、全国人民代表大会各专门委员会，可以向全国人民代表大会提出法律案，由主席团决定列入会议议程。\r\n\r\n第十五条一个代表团或者三十名以上的代表联名，可以向全国人民代表大会提出法律案，由主席团决定是否列入会议议程，或者先交有关的专门委员会审议、提出是否列入会议议程的意见，再决定是否列入会议议程。\r\n\r\n专门委员会审议的时候，可以邀请提案人列席会议，发表意见。\r\n\r\n第十六条向全国人民代表大会提出的法律案，在全国人民代表大会闭会期间，可以先向常务委员会提出，经常务委员会会议依照本法第二章第三节规定的有关程序审议后，决定提请全国人民代表大会审议，由常务委员会向大会全体会议作说明，或者由提案人向大会全体会议作说明。\r\n\r\n常务委员会依照前款规定审议法律案，应当通过多种形式征求全国人民代表大会代表的意见，并将有关情况予以反馈；专门委员会和常务委员会工作机构进行立法调研，可以邀请有关的全国人民代表大会代表参加。\r\n\r\n第十七条 常务委员会决定提请全国人民代表大会会议审议的法律案，应当在会议举行的一个月前将法律草案发给代表。\r\n\r\n第十八条 列入全国人民代表大会会议议程的法律案，大会全体会议听取提案人的说明后，由各代表团进行审议。\r\n\r\n各代表团审议法律案时，提案人应当派人听取意见，回答询问。\r\n\r\n各代表团审议法律案时，根据代表团的要求，有关机关、组织应当派人介绍情况。\r\n\r\n第十九条列入全国人民代表大会会议议程的法律案，由有关的专门委员会进行审议，向主席团提出审议意见，并印发会议。\r\n\r\n第二十条列入全国人民代表大会会议议程的法律案，由法律委员会根据各代表团和有关的专门委员会的审议意见，对法律案进行统一审议，向主席团提出审议结果报告和法律草案修改稿，对重要的不同意见应当在审议结果报告中予以说明，经主席团会议审议通过后，印发会议。\r\n\r\n第二十一条列入全国人民代表大会会议议程的法律案，必要时，主席团常务主席可以召开各代表团团长会议，就法律案中的重大问题听取各代表团的审议意见，进行讨论，并将讨论的情况和意见向主席团报告。\r\n\r\n主席团常务主席也可以就法律案中的重大的专门性问题，召集代表团推选的有关代表进行讨论，并将讨论的情况和意见向主席团报告。\r\n\r\n第二十二条列入全国人民代表大会会议议程的法律案，在交付表决前，提案人要求撤回的，应当说明理由，经主席团同意，并向大会报告，对该法律案的审议即行终止。\r\n\r\n第二十三条法律案在审议中有重大问题需要进一步研究的，经主席团提出，由大会全体会议决定，可以授权常务委员会根据代表的意见进一步审议，作出决定，并将决定情况向全国人民代表大会下次会议报告；也可以授权常务委员会根据代表的意见进一步审议，提出修改方案，提请全国人民代表大会下次会议审议决定。\r\n\r\n第二十四条法律草案修改稿经各代表团审议，由法律委员会根据各代表团的审议意见进行修改，提出法律草案表决稿，由主席团提请大会全体会议表决，由全体代表的过半数通过。\r\n\r\n第二十五条 全国人民代表大会通过的法律由国家主席签署主席令予以公布。\r\n\r\n第三节 全国人民代表大会常务委员会立法程序\r\n\r\n第二十六条 委员长会议可以向常务委员会提出法律案，由常务委员会会议审议。\r\n\r\n国务院、中央军事委员会、最高人民法院、最高人民检察院、全国人民代表大会各专门委员会，可以向常务委员会提出法律案，由委员长会议决定列入常务委员会会议议程，或者先交有关的专门委员会审议、提出报告，再决定列入常务委员会会议议程。如果委员长会议认为法律案有重大问题需要进一步研究，可以建议提案人修改完善后再向常务委员会提出。\r\n\r\n第二十七条常务委员会组成人员十人以上联名，可以向常务委员会提出法律案，由委员长会议决定是否列入常务委员会会议议程，或者先交有关的专门委员会审议、提出是否列入会议议程的意见，再决定是否列入常务委员会会议议程。不列入常务委员会会议议程的，应当向常务委员会会议报告或者向提案人说明。\r\n\r\n专门委员会审议的时候，可以邀请提案人列席会议，发表意见。\r\n\r\n第二十八条 列入常务委员会会议议程的法律案，除特殊情况外，应当在会议举行的七日前将法律草案发给常务委员会组成人员。\r\n\r\n常务委员会会议审议法律案时，应当邀请有关的全国人民代表大会代表列席会议。\r\n\r\n第二十九条 列入常务委员会会议议程的法律案，一般应当经三次常务委员会会议审议后再交付表决。\r\n\r\n常务委员会会议第一次审议法律案，在全体会议上听取提案人的说明，由分组会议进行初步审议。\r\n\r\n常务委员会会议第二次审议法律案，在全体会议上听取法律委员会关于法律草案修改情况和主要问题的汇报，由分组会议进一步审议。\r\n\r\n常务委员会会议第三次审议法律案，在全体会议上听取法律委员会关于法律草案审议结果的报告，由分组会议对法律草案修改稿进行审议。\r\n\r\n常务委员会审议法律案时，根据需要，可以召开联组会议或者全体会议，对法律草案中的主要问题进行讨论。\r\n\r\n第三十条列入常务委员会会议议程的法律案，各方面意见比较一致的，可以经两次常务委员会会议审议后交付表决；调整事项较为单一或者部分修改的法律案，各方面的意见比较一致的，也可以经一次常务委员会会议审议即交付表决。\r\n\r\n第三十一条 常务委员会分组会议审议法律案时，提案人应当派人听取意见，回答询问。\r\n\r\n常务委员会分组会议审议法律案时，根据小组的要求，有关机关、组织应当派人介绍情况。\r\n\r\n第三十二条 列入常务委员会会议议程的法律案，由有关的专门委员会进行审议，提出审议意见，印发常务委员会会议。\r\n\r\n有关的专门委员会审议法律案时，可以邀请其他专门委员会的成员列席会议，发表意见。\r\n\r\n第三十三条列入常务委员会会议议程的法律案，由法律委员会根据常务委员会组成人员、有关的专门委员会的审议意见和各方面提出的意见，对法律案进行统一审议，提出修改情况的汇报或者审议结果报告和法律草案修改稿，对重要的不同意见应当在汇报或者审议结果报告中予以说明。对有关的专门委员会的审议意见没有采纳的，应当向有关的专门委员会反馈。\r\n\r\n法律委员会审议法律案时，应当邀请有关的专门委员会的成员列席会议，发表意见。\r\n\r\n第三十四条 专门委员会审议法律案时，应当召开全体会议审议，根据需要，可以要求有关机关、组织派有关负责人说明情况。\r\n\r\n第三十五条 专门委员会之间对法律草案的重要问题意见不一致时，应当向委员长会议报告。\r\n\r\n第三十六条列入常务委员会会议议程的法律案，法律委员会、有关的专门委员会和常务委员会工作机构应当听取各方面的意见。听取意见可以采取座谈会、论证会、听证会等多种形式。\r\n\r\n法律案有关问题专业性较强，需要进行可行性评价的，应当召开论证会，听取有关专家、部门和全国人民代表大会代表等方面的意见。论证情况应当向常务委员会报告。\r\n\r\n法律案有关问题存在重大意见分歧或者涉及利益关系重大调整，需要进行听证的，应当召开听证会，听取有关基层和群体代表、部门、人民团体、专家、全国人民代表大会代表和社会有关方面的意见。听证情况应当向常务委员会报告。\r\n\r\n常务委员会工作机构应当将法律草案发送相关领域的全国人民代表大会代表、地方人民代表大会常务委员会以及有关部门、组织和专家征求意见。\r\n\r\n第三十七条列入常务委员会会议议程的法律案，应当在常务委员会会议后将法律草案及其起草、修改的说明等向社会公布，征求意见，但是经委员长会议决定不公布的除外。向社会公布征求意见的时间一般不少于三十日。征求意见的情况应当向社会通报。\r\n\r\n第三十八条列入常务委员会会议议程的法律案，常务委员会工作机构应当收集整理分组审议的意见和各方面提出的意见以及其他有关资料，分送法律委员会和有关的专门委员会，并根据需要，印发常务委员会会议。\r\n\r\n第三十九条拟提请常务委员会会议审议通过的法律案，在法律委员会提出审议结果报告前，常务委员会工作机构可以对法律草案中主要制度规范的可行性、法律出台时机、法律实施的社会效果和可能出现的问题等进行评估。评估情况由法律委员会在审议结果报告中予以说明。\r\n\r\n第四十条列入常务委员会会议议程的法律案，在交付表决前，提案人要求撤回的，应当说明理由，经委员长会议同意，并向常务委员会报告，对该法律案的审议即行终止。\r\n\r\n第四十一条法律草案修改稿经常务委员会会议审议，由法律委员会根据常务委员会组成人员的审议意见进行修改，提出法律草案表决稿，由委员长会议提请常务委员会全体会议表决，由常务委员会全体组成人员的过半数通过。\r\n\r\n法律草案表决稿交付常务委员会会议表决前，委员长会议根据常务委员会会议审议的情况，可以决定将个别意见分歧较大的重要条款提请常务委员会会议单独表决。\r\n\r\n单独表决的条款经常务委员会会议表决后，委员长会议根据单独表决的情况，可以决定将法律草案表决稿交付表决，也可以决定暂不付表决，交法律委员会和有关的专门委员会进一步审议。\r\n\r\n第四十二条列入常务委员会会议审议的法律案，因各方面对制定该法律的必要性、可行性等重大问题存在较大意见分歧搁置审议满两年的，或者因暂不付表决经过两年没有再次列入常务委员会会议议程审议的，由委员长会议向常务委员会报告，该法律案终止审议。\r\n\r\n第四十三条对多部法律中涉及同类事项的个别条款进行修改，一并提出法律案的，经委员长会议决定，可以合并表决，也可以分别表决。\r\n\r\n第四十四条 常务委员会通过的法律由国家主席签署主席令予以公布。\r\n\r\n第四节 法律解释\r\n\r\n第四十五条 法律解释权属于全国人民代表大会常务委员会。\r\n\r\n法律有以下情况之一的，由全国人民代表大会常务委员会解释：\r\n\r\n（一）法律的规定需要进一步明确具体含义的；\r\n\r\n（二）法律制定后出现新的情况，需要明确适用法律依据的。\r\n\r\n第四十六条国务院、中央军事委员会、最高人民法院、最高人民检察院和全国人民代表大会各专门委员会以及省、自治区、直辖市的人民代表大会常务委员会可以向全国人民代表大会常务委员会提出法律解释要求。\r\n\r\n第四十七条 常务委员会工作机构研究拟订法律解释草案，由委员长会议决定列入常务委员会会议议程。\r\n\r\n第四十八条法律解释草案经常务委员会会议审议，由法律委员会根据常务委员会组成人员的审议意见进行审议、修改，提出法律解释草案表决稿。\r\n\r\n第四十九条 法律解释草案表决稿由常务委员会全体组成人员的过半数通过，由常务委员会发布公告予以公布。\r\n\r\n第五十条 全国人民代表大会常务委员会的法律解释同法律具有同等效力。\r\n\r\n第五节 其他规定\r\n\r\n第五十一条 全国人民代表大会及其常务委员会加强对立法工作的组织协调，发挥在立法工作中的主导作用。\r\n\r\n第五十二条全国人民代表大会常务委员会通过立法规划、年度立法计划等形式，加强对立法工作的统筹安排。编制立法规划和年度立法计划，应当认真研究代表议案和建议，广泛征集意见，科学论证评估，根据经济社会发展和民主法治建设的需要，确定立法项目，提高立法的及时性、针对性和系统性。立法规划和年度立法计划由委员长会议通过并向社会公布。\r\n\r\n全国人民代表大会常务委员会工作机构负责编制立法规划和拟订年度立法计划，并按照全国人民代表大会常务委员会的要求，督促立法规划和年度立法计划的落实。\r\n\r\n第五十三条全国人民代表大会有关的专门委员会、常务委员会工作机构应当提前参与有关方面的法律草案起草工作；综合性、全局性、基础性的重要法律草案，可以由有关的专门委员会或者常务委员会工作机构组织起草。\r\n\r\n专业性较强的法律草案，可以吸收相关领域的专家参与起草工作，或者委托有关专家、教学科研单位、社会组织起草。\r\n\r\n第五十四条提出法律案，应当同时提出法律草案文本及其说明，并提供必要的参阅资料。修改法律的，还应当提交修改前后的对照文本。法律草案的说明应当包括制定或者修改法律的必要性、可行性和主要内容，以及起草过程中对重大分歧意见的协调处理情况。\r\n\r\n第五十五条 向全国人民代表大会及其常务委员会提出的法律案，在列入会议议程前，提案人有权撤回。\r\n\r\n第五十六条交付全国人民代表大会及其常务委员会全体会议表决未获得通过的法律案，如果提案人认为必须制定该法律，可以按照法律规定的程序重新提出，由主席团、委员长会议决定是否列入会议议程；其中，未获得全国人民代表大会通过的法律案，应当提请全国人民代表大会审议决定。\r\n\r\n第五十七条 法律应当明确规定施行日期。\r\n\r\n第五十八条 签署公布法律的主席令载明该法律的制定机关、通过和施行日期。\r\n\r\n法律签署公布后，及时在全国人民代表大会常务委员会公报和中国人大网以及在全国范围内发行的报纸上刊载。\r\n\r\n在常务委员会公报上刊登的法律文本为标准文本。\r\n\r\n第五十九条 法律的修改和废止程序，适用本章的有关规定。\r\n\r\n法律被修改的，应当公布新的法律文本。\r\n\r\n法律被废止的，除由其他法律规定废止该法律的以外，由国家主席签署主席令予以公布。\r\n\r\n第六十条法律草案与其他法律相关规定不一致的，提案人应当予以说明并提出处理意见，必要时应当同时提出修改或者废止其他法律相关规定的议案。\r\n\r\n法律委员会和有关的专门委员会审议法律案时，认为需要修改或者废止其他法律相关规定的，应当提出处理意见。\r\n\r\n第六十一条 法律根据内容需要，可以分编、章、节、条、款、项、目。\r\n\r\n编、章、节、条的序号用中文数字依次表述，款不编序号，项的序号用中文数字加括号依次表述，目的序号用阿拉伯数字依次表述。\r\n\r\n法律标题的题注应当载明制定机关、通过日期。经过修改的法律，应当依次载明修改机关、修改日期。\r\n\r\n第六十二条法律规定明确要求有关国家机关对专门事项作出配套的具体规定的，有关国家机关应当自法律施行之日起一年内作出规定，法律对配套的具体规定制定期限另有规定的，从其规定。有关国家机关未能在期限内作出配套的具体规定的，应当向全国人民代表大会常务委员会说明情况。\r\n\r\n第六十三条全国人民代表大会有关的专门委员会、常务委员会工作机构可以组织对有关法律或者法律中有关规定进行立法后评估。评估情况应当向常务委员会报告。\r\n\r\n第六十四条 全国人民代表大会常务委员会工作机构可以对有关具体问题的法律询问进行研究予以答复，并报常务委员会备案。\r\n\r\n第三章 行政法规\r\n\r\n第六十五条 国务院根据宪法和法律，制定行政法规。\r\n\r\n行政法规可以就下列事项作出规定：\r\n\r\n（一）为执行法律的规定需要制定行政法规的事项；\r\n\r\n（二）宪法第八十九条规定的国务院行政管理职权的事项。\r\n\r\n应当由全国人民代表大会及其常务委员会制定法律的事项，国务院根据全国人民代表大会及其常务委员会的授权决定先制定的行政法规，经过实践检验，制定法律的条件成熟时，国务院应当及时提请全国人民代表大会及其常务委员会制定法律。\r\n\r\n第六十六条国务院法制机构应当根据国家总体工作部署拟订国务院年度立法计划，报国务院审批。国务院年度立法计划中的法律项目应当与全国人民代表大会常务委员会的立法规划和年度立法计划相衔接。国务院法制机构应当及时跟踪了解国务院各部门落实立法计划的情况，加强组织协调和督促指导。\r\n\r\n国务院有关部门认为需要制定行政法规的，应当向国务院报请立项。\r\n\r\n第六十七条行政法规由国务院有关部门或者国务院法制机构具体负责起草，重要行政管理的法律、行政法规草案由国务院法制机构组织起草。行政法规在起草过程中，应当广泛听取有关机关、组织、人民代表大会代表和社会公众的意见。听取意见可以采取座谈会、论证会、听证会等多种形式。\r\n\r\n行政法规草案应当向社会公布，征求意见，但是经国务院决定不公布的除外。\r\n\r\n第六十八条行政法规起草工作完成后，起草单位应当将草案及其说明、各方面对草案主要问题的不同意见和其他有关资料送国务院法制机构进行审查。\r\n\r\n国务院法制机构应当向国务院提出审查报告和草案修改稿，审查报告应当对草案主要问题作出说明。\r\n\r\n第六十九条 行政法规的决定程序依照中华人民共和国国务院组织法的有关规定办理。\r\n\r\n第七十条 行政法规由总理签署国务院令公布。\r\n\r\n有关国防建设的行政法规，可以由国务院总理、中央军事委员会主席共同签署国务院、中央军事委员会令公布。\r\n\r\n第七十一条 行政法规签署公布后，及时在国务院公报和中国政府法制信息网以及在全国范围内发行的报纸上刊载。\r\n\r\n在国务院公报上刊登的行政法规文本为标准文本。\r\n\r\n第四章 地方性法规、自治条例和单行条例、规章\r\n\r\n第一节 地方性法规、自治条例和单行条例\r\n\r\n第七十二条省、自治区、直辖市的人民代表大会及其常务委员会根据本行政区域的具体情况和实际需要，在不同宪法、法律、行政法规相抵触的前提下，可以制定地方性法规。\r\n\r\n设区的市的人民代表大会及其常务委员会根据本市的具体情况和实际需要，在不同宪法、法律、行政法规和本省、自治区的地方性法规相抵触的前提下，可以对城乡建设与管理、环境保护、历史文化保护等方面的事项制定地方性法规，法律对设区的市制定地方性法规的事项另有规定的，从其规定。设区的市的地方性法规须报省、自治区的人民代表大会常务委员会批准后施行。省、自治区的人民代表大会常务委员会对报请批准的地方性法规，应当对其合法性进行审查，同宪法、法律、行政法规和本省、自治区的地方性法规不抵触的，应当在四个月内予以批准。\r\n\r\n省、自治区的人民代表大会常务委员会在对报请批准的设区的市的地方性法规进行审查时，发现其同本省、自治区的人民政府的规章相抵触的，应当作出处理决定。\r\n\r\n除省、自治区的人民政府所在地的市，经济特区所在地的市和国务院已经批准的较大的市以外，其他设区的市开始制定地方性法规的具体步骤和时间，由省、自治区的人民代表大会常务委员会综合考虑本省、自治区所辖的设区的市的人口数量、地域面积、经济社会发展情况以及立法需求、立法能力等因素确定，并报全国人民代表大会常务委员会和国务院备案。\r\n\r\n自治州的人民代表大会及其常务委员会可以依照本条第二款规定行使设区的市制定地方性法规的职权。自治州开始制定地方性法规的具体步骤和时间，依照前款规定确定。\r\n\r\n省、自治区的人民政府所在地的市，经济特区所在地的市和国务院已经批准的较大的市已经制定的地方性法规，涉及本条第二款规定事项范围以外的，继续有效。\r\n\r\n第七十三条 地方性法规可以就下列事项作出规定：\r\n\r\n（一）为执行法律、行政法规的规定，需要根据本行政区域的实际情况作具体规定的事项；\r\n\r\n（二）属于地方性事务需要制定地方性法规的事项。\r\n\r\n除本法第八条规定的事项外，其他事项国家尚未制定法律或者行政法规的，省、自治区、直辖市和设区的市、自治州根据本地方的具体情况和实际需要，可以先制定地方性法规。在国家制定的法律或者行政法规生效后，地方性法规同法律或者行政法规相抵触的规定无效，制定机关应当及时予以修改或者废止。\r\n\r\n设区的市、自治州根据本条第一款、第二款制定地方性法规，限于本法第七十二条第二款规定的事项。\r\n\r\n制定地方性法规，对上位法已经明确规定的内容，一般不作重复性规定。\r\n\r\n第七十四条经济特区所在地的省、市的人民代表大会及其常务委员会根据全国人民代表大会的授权决定，制定法规，在经济特区范围内实施。\r\n\r\n第七十五条民族自治地方的人民代表大会有权依照当地民族的政治、经济和文化的特点，制定自治条例和单行条例。自治区的自治条例和单行条例，报全国人民代表大会常务委员会批准后生效。自治州、自治县的自治条例和单行条例，报省、自治区、直辖市的人民代表大会常务委员会批准后生效。\r\n\r\n自治条例和单行条例可以依照当地民族的特点，对法律和行政法规的规定作出变通规定，但不得违背法律或者行政法规的基本原则，不得对宪法和民族区域自治法的规定以及其他有关法律、行政法规专门就民族自治地方所作的规定作出变通规定。\r\n\r\n第七十六条 规定本行政区域特别重大事项的地方性法规，应当由人民代表大会通过。\r\n\r\n第七十七条地方性法规案、自治条例和单行条例案的提出、审议和表决程序，根据中华人民共和国地方各级人民代表大会和地方各级人民政府组织法，参照本法第二章第二节、第三节、第五节的规定，由本级人民代表大会规定。\r\n\r\n地方性法规草案由负责统一审议的机构提出审议结果的报告和草案修改稿。\r\n\r\n第七十八条 省、自治区、直辖市的人民代表大会制定的地方性法规由大会主席团发布公告予以公布。\r\n\r\n省、自治区、直辖市的人民代表大会常务委员会制定的地方性法规由常务委员会发布公告予以公布。\r\n\r\n设区的市、自治州的人民代表大会及其常务委员会制定的地方性法规报经批准后，由设区的市、自治州的人民代表大会常务委员会发布公告予以公布。\r\n\r\n自治条例和单行条例报经批准后，分别由自治区、自治州、自治县的人民代表大会常务委员会发布公告予以公布。\r\n\r\n第七十九条地方性法规、自治区的自治条例和单行条例公布后，及时在本级人民代表大会常务委员会公报和中国人大网、本地方人民代表大会网站以及在本行政区域范围内发行的报纸上刊载。\r\n\r\n在常务委员会公报上刊登的地方性法规、自治条例和单行条例文本为标准文本。\r\n\r\n第二节 规章\r\n\r\n第八十条国务院各部、委员会、中国人民银行、审计署和具有行政管理职能的直属机构，可以根据法律和国务院的行政法规、决定、命令，在本部门的权限范围内，制定规章。\r\n\r\n部门规章规定的事项应当属于执行法律或者国务院的行政法规、决定、命令的事项。没有法律或者国务院的行政法规、决定、命令的依据，部门规章不得设定减损公民、法人和其他组织权利或者增加其义务的规范，不得增加本部门的权力或者减少本部门的法定职责。\r\n\r\n第八十一条 涉及两个以上国务院部门职权范围的事项，应当提请国务院制定行政法规或者由国务院有关部门联合制定规章。\r\n\r\n第八十二条省、自治区、直辖市和设区的市、自治州的人民政府，可以根据法律、行政法规和本省、自治区、直辖市的地方性法规，制定规章。\r\n\r\n地方政府规章可以就下列事项作出规定：\r\n\r\n（一）为执行法律、行政法规、地方性法规的规定需要制定规章的事项；\r\n\r\n（二）属于本行政区域的具体行政管理事项。\r\n\r\n设区的市、自治州的人民政府根据本条第一款、第二款制定地方政府规章，限于城乡建设与管理、环境保护、历史文化保护等方面的事项。已经制定的地方政府规章，涉及上述事项范围以外的，继续有效。\r\n\r\n除省、自治区的人民政府所在地的市，经济特区所在地的市和国务院已经批准的较大的市以外，其他设区的市、自治州的人民政府开始制定规章的时间，与本省、自治区人民代表大会常务委员会确定的本市、自治州开始制定地方性法规的时间同步。\r\n\r\n应当制定地方性法规但条件尚不成熟的，因行政管理迫切需要，可以先制定地方政府规章。规章实施满两年需要继续实施规章所规定的行政措施的，应当提请本级人民代表大会或者其常务委员会制定地方性法规。\r\n\r\n没有法律、行政法规、地方性法规的依据，地方政府规章不得设定减损公民、法人和其他组织权利或者增加其义务的规范。\r\n\r\n第八十三条 国务院部门规章和地方政府规章的制定程序，参照本法第三章的规定，由国务院规定。\r\n\r\n第八十四条 部门规章应当经部务会议或者委员会会议决定。\r\n\r\n地方政府规章应当经政府常务会议或者全体会议决定。\r\n\r\n第八十五条 部门规章由部门首长签署命令予以公布。\r\n\r\n地方政府规章由省长、自治区主席、市长或者自治州州长签署命令予以公布。\r\n\r\n第八十六条 部门规章签署公布后，及时在国务院公报或者部门公报和中国政府法制信息网以及在全国范围内发行的报纸上刊载。\r\n\r\n地方政府规章签署公布后，及时在本级人民政府公报和中国政府法制信息网以及在本行政区域范围内发行的报纸上刊载。\r\n\r\n在国务院公报或者部门公报和地方人民政府公报上刊登的规章文本为标准文本。\r\n\r\n第五章 适用与备案审查\r\n\r\n第八十七条 宪法具有最高的法律效力，一切法律、行政法规、地方性法规、自治条例和单行条例、规章都不得同宪法相抵触。\r\n\r\n第八十八条 法律的效力高于行政法规、地方性法规、规章。\r\n\r\n行政法规的效力高于地方性法规、规章。\r\n\r\n第八十九条 地方性法规的效力高于本级和下级地方政府规章。\r\n\r\n省、自治区的人民政府制定的规章的效力高于本行政区域内的设区的市、自治州的人民政府制定的规章。\r\n\r\n第九十条 自治条例和单行条例依法对法律、行政法规、地方性法规作变通规定的，在本自治地方适用自治条例和单行条例的规定。\r\n\r\n经济特区法规根据授权对法律、行政法规、地方性法规作变通规定的，在本经济特区适用经济特区法规的规定。\r\n\r\n第九十一条 部门规章之间、部门规章与地方政府规章之间具有同等效力，在各自的权限范围内施行。\r\n\r\n第九十二条同一机关制定的法律、行政法规、地方性法规、自治条例和单行条例、规章，特别规定与一般规定不一致的，适用特别规定；新的规定与旧的规定不一致的，适用新的规定。\r\n\r\n第九十三条法律、行政法规、地方性法规、自治条例和单行条例、规章不溯及既往，但为了更好地保护公民、法人和其他组织的权利和利益而作的特别规定除外。\r\n\r\n第九十四条法律之间对同一事项的新的一般规定与旧的特别规定不一致，不能确定如何适用时，由全国人民代表大会常务委员会裁决。\r\n\r\n行政法规之间对同一事项的新的一般规定与旧的特别规定不一致，不能确定如何适用时，由国务院裁决。\r\n\r\n第九十五条 地方性法规、规章之间不一致时，由有关机关依照下列规定的权限作出裁决：\r\n\r\n（一）同一机关制定的新的一般规定与旧的特别规定不一致时，由制定机关裁决；\r\n\r\n（二）地方性法规与部门规章之间对同一事项的规定不一致，不能确定如何适用时，由国务院提出意见，国务院认为应当适用地方性法规的，应当决定在该地方适用地方性法规的规定；认为应当适用部门规章的，应当提请全国人民代表大会常务委员会裁决；\r\n\r\n（三）部门规章之间、部门规章与地方政府规章之间对同一事项的规定不一致时，由国务院裁决。\r\n\r\n根据授权制定的法规与法律规定不一致，不能确定如何适用时，由全国人民代表大会常务委员会裁决。\r\n\r\n第九十六条法律、行政法规、地方性法规、自治条例和单行条例、规章有下列情形之一的，由有关机关依照本法第九十七条规定的权限予以改变或者撤销：\r\n\r\n（一）超越权限的；\r\n\r\n（二）下位法违反上位法规定的；\r\n\r\n（三）规章之间对同一事项的规定不一致，经裁决应当改变或者撤销一方的规定的；\r\n\r\n（四）规章的规定被认为不适当，应当予以改变或者撤销的；\r\n\r\n（五）违背法定程序的。\r\n\r\n第九十七条 改变或者撤销法律、行政法规、地方性法规、自治条例和单行条例、规章的权限是：\r\n\r\n（一）全国人民代表大会有权改变或者撤销它的常务委员会制定的不适当的法律，有权撤销全国人民代表大会常务委员会批准的违背宪法和本法第七十五条第二款规定的自治条例和单行条例；\r\n\r\n（二）全国人民代表大会常务委员会有权撤销同宪法和法律相抵触的行政法规，有权撤销同宪法、法律和行政法规相抵触的地方性法规，有权撤销省、自治区、直辖市的人民代表大会常务委员会批准的违背宪法和本法第七十五条第二款规定的自治条例和单行条例；\r\n\r\n（三）国务院有权改变或者撤销不适当的部门规章和地方政府规章；\r\n\r\n（四）省、自治区、直辖市的人民代表大会有权改变或者撤销它的常务委员会制定的和批准的不适当的地方性法规；\r\n\r\n（五）地方人民代表大会常务委员会有权撤销本级人民政府制定的不适当的规章；\r\n\r\n（六）省、自治区的人民政府有权改变或者撤销下一级人民政府制定的不适当的规章；\r\n\r\n（七）授权机关有权撤销被授权机关制定的超越授权范围或者违背授权目的的法规，必要时可以撤销授权。\r\n\r\n第九十八条 行政法规、地方性法规、自治条例和单行条例、规章应当在公布后的三十日内依照下列规定报有关机关备案：\r\n\r\n（一）行政法规报全国人民代表大会常务委员会备案；\r\n\r\n（二）省、自治区、直辖市的人民代表大会及其常务委员会制定的地方性法规，报全国人民代表大会常务委员会和国务院备案；设区的市、自治州的人民代表大会及其常务委员会制定的地方性法规，由省、自治区的人民代表大会常务委员会报全国人民代表大会常务委员会和国务院备案；\r\n\r\n（三）自治州、自治县的人民代表大会制定的自治条例和单行条例，由省、自治区、直辖市的人民代表大会常务委员会报全国人民代表大会常务委员会和国务院备案；自治条例、单行条例报送备案时，应当说明对法律、行政法规、地方性法规作出变通的情况；\r\n\r\n（四）部门规章和地方政府规章报国务院备案；地方政府规章应当同时报本级人民代表大会常务委员会备案；设区的市、自治州的人民政府制定的规章应当同时报省、自治区的人民代表大会常务委员会和人民政府备案；\r\n\r\n（五）根据授权制定的法规应当报授权决定规定的机关备案；经济特区法规报送备案时，应当说明对法律、行政法规、地方性法规作出变通的情况。\r\n\r\n第九十九条国务院、中央军事委员会、最高人民法院、最高人民检察院和各省、自治区、直辖市的人民代表大会常务委员会认为行政法规、地方性法规、自治条例和单行条例同宪法或者法律相抵触的，可以向全国人民代表大会常务委员会书面提出进行审查的要求，由常务委员会工作机构分送有关的专门委员会进行审查、提出意见。\r\n\r\n前款规定以外的其他国家机关和社会团体、企业事业组织以及公民认为行政法规、地方性法规、自治条例和单行条例同宪法或者法律相抵触的，可以向全国人民代表大会常务委员会书面提出进行审查的建议，由常务委员会工作机构进行研究，必要时，送有关的专门委员会进行审查、提出意见。\r\n\r\n有关的专门委员会和常务委员会工作机构可以对报送备案的规范性文件进行主动审查。\r\n\r\n第一百条全国人民代表大会专门委员会、常务委员会工作机构在审查、研究中认为行政法规、地方性法规、自治条例和单行条例同宪法或者法律相抵触的，可以向制定机关提出书面审查意见、研究意见；也可以由法律委员会与有关的专门委员会、常务委员会工作机构召开联合审查会议，要求制定机关到会说明情况，再向制定机关提出书面审查意见。制定机关应当在两个月内研究提出是否修改的意见，并向全国人民代表大会法律委员会和有关的专门委员会或者常务委员会工作机构反馈。\r\n\r\n全国人民代表大会法律委员会、有关的专门委员会、常务委员会工作机构根据前款规定，向制定机关提出审查意见、研究意见，制定机关按照所提意见对行政法规、地方性法规、自治条例和单行条例进行修改或者废止的，审查终止。\r\n\r\n全国人民代表大会法律委员会、有关的专门委员会、常务委员会工作机构经审查、研究认为行政法规、地方性法规、自治条例和单行条例同宪法或者法律相抵触而制定机关不予修改的，应当向委员长会议提出予以撤销的议案、建议，由委员长会议决定提请常务委员会会议审议决定。\r\n\r\n第一百零一条全国人民代表大会有关的专门委员会和常务委员会工作机构应当按照规定要求，将审查、研究情况向提出审查建议的国家机关、社会团体、企业事业组织以及公民反馈，并可以向社会公开。\r\n\r\n第一百零二条其他接受备案的机关对报送备案的地方性法规、自治条例和单行条例、规章的审查程序，按照维护法制统一的原则，由接受备案的机关规定。\r\n\r\n第六章 附则\r\n\r\n第一百零三条 中央军事委员会根据宪法和法律，制定军事法规。\r\n\r\n中央军事委员会各总部、军兵种、军区、中国人民武装警察部队，可以根据法律和中央军事委员会的军事法规、决定、命令，在其权限范围内，制定军事规章。\r\n\r\n军事法规、军事规章在武装力量内部实施。\r\n\r\n军事法规、军事规章的制定、修改和废止办法，由中央军事委员会依照本法规定的原则规定。\r\n\r\n第一百零四条最高人民法院、最高人民检察院作出的属于审判、检察工作中具体应用法律的解释，应当主要针对具体的法律条文，并符合立法的目的、原则和原意。遇有本法第四十五条第二款规定情况的，应当向全国人民代表大会常务委员会提出法律解释的要求或者提出制定、修改有关法律的议案。\r\n\r\n最高人民法院、最高人民检察院作出的属于审判、检察工作中具体应用法律的解释，应当自公布之日起三十日内报全国人民代表大会常务委员会备案。\r\n\r\n最高人民法院、最高人民检察院以外的审判机关和检察机关，不得作出具体应用法律的解释。\r\n\r\n第一百零五条 本法自2000年7月1日起施行。\r\n\r\n ', '国务院', '20051121', '20181121');
INSERT INTO `xt_law_inf` VALUES ('3', '411200', '1111', '中华人民共和国行政强制法\r\n', '中华人民共和国主席令\r\n\r\n　　第四十九号\r\n\r\n　　《中华人民共和国行政强制法》已由中华人民共和国第十一届全国人民代表大会常务委员会第二十一次会议于2011年6月30日通过，现予公布，自2012年1月1日起施行。\r\n\r\n　　中华人民共和国主席 胡锦涛\r\n\r\n　　2011年6月30日\r\n\r\n　　中华人民共和国行政强制法\r\n\r\n　　（2011年6月30日第十一届全国人民代表大会常务委员会第二十一次会议通过）\r\n\r\n　　第一章　总　　则\r\n\r\n　　第一条　为了规范行政强制的设定和实施，保障和监督行政机关依法履行职责，维护公共利益和社会秩序，保护公民、法人和其他组织的合法权益，根据宪法，制定本法。\r\n\r\n　　第二条　本法所称行政强制，包括行政强制措施和行政强制执行。\r\n\r\n　　行政强制措施，是指行政机关在行政管理过程中，为制止违法行为、防止证据损毁、避免危害发生、控制危险扩大等情形，依法对公民的人身自由实施暂时性限制，或者对公民、法人或者其他组织的财物实施暂时性控制的行为。\r\n\r\n　　行政强制执行，是指行政机关或者行政机关申请人民法院，对不履行行政决定的公民、法人或者其他组织，依法强制履行义务的行为。\r\n\r\n　　第三条　行政强制的设定和实施，适用本法。\r\n\r\n　　发生或者即将发生自然灾害、事故灾难、公共卫生事件或者社会安全事件等突发事件，行政机关采取应急措施或者临时措施，依照有关法律、行政法规的规定执行。\r\n\r\n　　行政机关采取金融业审慎监管措施、进出境货物强制性技术监控措施，依照有关法律、行政法规的规定执行。\r\n\r\n　　第四条　行政强制的设定和实施，应当依照法定的权限、范围、条件和程序。\r\n\r\n　　第五条　行政强制的设定和实施，应当适当。采用非强制手段可以达到行政管理目的的，不得设定和实施行政强制。\r\n\r\n　　第六条　实施行政强制，应当坚持教育与强制相结合。\r\n\r\n　　第七条　行政机关及其工作人员不得利用行政强制权为单位或者个人谋取利益。\r\n\r\n　　第八条　公民、法人或者其他组织对行政机关实施行政强制，享有陈述权、申辩权；有权依法申请行政复议或者提起行政诉讼；因行政机关违法实施行政强制受到损害的，有权依法要求赔偿。\r\n\r\n　　公民、法人或者其他组织因人民法院在强制执行中有违法行为或者扩大强制执行范围受到损害的，有权依法要求赔偿。\r\n\r\n　　第二章　行政强制的种类和设定\r\n\r\n　　第九条　行政强制措施的种类：\r\n\r\n　　（一）限制公民人身自由；\r\n\r\n　　（二）查封场所、设施或者财物；\r\n\r\n　　（三）扣押财物；\r\n\r\n　　（四）冻结存款、汇款；\r\n\r\n　　（五）其他行政强制措施。\r\n\r\n　　第十条　行政强制措施由法律设定。\r\n\r\n　　尚未制定法律，且属于国务院行政管理职权事项的，行政法规可以设定除本法第九条第一项、第四项和应当由法律规定的行政强制措施以外的其他行政强制措施。\r\n\r\n　　尚未制定法律、行政法规，且属于地方性事务的，地方性法规可以设定本法第九条第二项、第三项的行政强制措施。\r\n\r\n　　法律、法规以外的其他规范性文件不得设定行政强制措施。\r\n\r\n　　第十一条　法律对行政强制措施的对象、条件、种类作了规定的，行政法规、地方性法规不得作出扩大规定。\r\n\r\n　　法律中未设定行政强制措施的，行政法规、地方性法规不得设定行政强制措施。但是，法律规定特定事项由行政法规规定具体管理措施的，行政法规可以设定除本法第九条第一项、第四项和应当由法律规定的行政强制措施以外的其他行政强制措施。\r\n\r\n　　第十二条　行政强制执行的方式：\r\n\r\n　　（一）加处罚款或者滞纳金；\r\n\r\n　　（二）划拨存款、汇款；\r\n\r\n　　（三）拍卖或者依法处理查封、扣押的场所、设施或者财物；\r\n\r\n　　（四）排除妨碍、恢复原状；\r\n\r\n　　（五）代履行；\r\n\r\n　　（六）其他强制执行方式。\r\n\r\n　　第十三条　行政强制执行由法律设定。\r\n\r\n　　法律没有规定行政机关强制执行的，作出行政决定的行政机关应当申请人民法院强制执行。\r\n\r\n　　第十四条　起草法律草案、法规草案，拟设定行政强制的，起草单位应当采取听证会、论证会等形式听取意见，并向制定机关说明设定该行政强制的必要性、可能产生的影响以及听取和采纳意见的情况。\r\n\r\n　　第十五条　行政强制的设定机关应当定期对其设定的行政强制进行评价，并对不适当的行政强制及时予以修改或者废止。\r\n\r\n　　行政强制的实施机关可以对已设定的行政强制的实施情况及存在的必要性适时进行评价，并将意见报告该行政强制的设定机关。\r\n\r\n　　公民、法人或者其他组织可以向行政强制的设定机关和实施机关就行政强制的设定和实施提出意见和建议。有关机关应当认真研究论证，并以适当方式予以反馈。\r\n\r\n　　第三章　行政强制措施实施程序\r\n\r\n　　第一节　一般规定\r\n\r\n　　第十六条　行政机关履行行政管理职责，依照法律、法规的规定，实施行政强制措施。\r\n\r\n　　违法行为情节显著轻微或者没有明显社会危害的，可以不采取行政强制措施。\r\n\r\n　　第十七条　行政强制措施由法律、法规规定的行政机关在法定职权范围内实施。行政强制措施权不得委托。\r\n\r\n　　依据《中华人民共和国行政处罚法》的规定行使相对集中行政处罚权的行政机关，可以实施法律、法规规定的与行政处罚权有关的行政强制措施。\r\n\r\n　　行政强制措施应当由行政机关具备资格的行政执法人员实施，其他人员不得实施。\r\n\r\n　　第十八条　行政机关实施行政强制措施应当遵守下列规定：\r\n\r\n　　（一）实施前须向行政机关负责人报告并经批准；\r\n\r\n　　（二）由两名以上行政执法人员实施；\r\n\r\n　　（三）出示执法身份证件；\r\n\r\n　　（四）通知当事人到场；\r\n\r\n　　（五）当场告知当事人采取行政强制措施的理由、依据以及当事人依法享有的权利、救济途径；\r\n\r\n　　（六）听取当事人的陈述和申辩；\r\n\r\n　　（七）制作现场笔录；\r\n\r\n　　（八）现场笔录由当事人和行政执法人员签名或者盖章，当事人拒绝的，在笔录中予以注明；\r\n\r\n　　（九）当事人不到场的，邀请见证人到场，由见证人和行政执法人员在现场笔录上签名或者盖章；\r\n\r\n　　（十）法律、法规规定的其他程序。\r\n\r\n　　第十九条　情况紧急，需要当场实施行政强制措施的，行政执法人员应当在二十四小时内向行政机关负责人报告，并补办批准手续。行政机关负责人认为不应当采取行政强制措施的，应当立即解除。\r\n\r\n　　第二十条　依照法律规定实施限制公民人身自由的行政强制措施，除应当履行本法第十八条规定的程序外，还应当遵守下列规定：\r\n\r\n　　（一）当场告知或者实施行政强制措施后立即通知当事人家属实施行政强制措施的行政机关、地点和期限；\r\n\r\n　　（二）在紧急情况下当场实施行政强制措施的，在返回行政机关后，立即向行政机关负责人报告并补办批准手续；\r\n\r\n　　（三）法律规定的其他程序。\r\n\r\n　　实施限制人身自由的行政强制措施不得超过法定期限。实施行政强制措施的目的已经达到或者条件已经消失，应当立即解除。\r\n\r\n　　第二十一条　违法行为涉嫌犯罪应当移送司法机关的，行政机关应当将查封、扣押、冻结的财物一并移送，并书面告知当事人。\r\n\r\n　　第二节　查封、扣押\r\n\r\n　　第二十二条　查封、扣押应当由法律、法规规定的行政机关实施，其他任何行政机关或者组织不得实施。\r\n\r\n　　第二十三条　查封、扣押限于涉案的场所、设施或者财物，不得查封、扣押与违法行为无关的场所、设施或者财物；不得查封、扣押公民个人及其所扶养家属的生活必需品。\r\n\r\n　　当事人的场所、设施或者财物已被其他国家机关依法查封的，不得重复查封。\r\n\r\n　　第二十四条　行政机关决定实施查封、扣押的，应当履行本法第十八条规定的程序，制作并当场交付查封、扣押决定书和清单。\r\n\r\n　　查封、扣押决定书应当载明下列事项：\r\n\r\n　　（一）当事人的姓名或者名称、地址；\r\n\r\n　　（二）查封、扣押的理由、依据和期限；\r\n\r\n　　（三）查封、扣押场所、设施或者财物的名称、数量等；\r\n\r\n　　（四）申请行政复议或者提起行政诉讼的途径和期限；\r\n\r\n　　（五）行政机关的名称、印章和日期。\r\n\r\n　　查封、扣押清单一式二份，由当事人和行政机关分别保存。\r\n\r\n　　第二十五条　查封、扣押的期限不得超过三十日；情况复杂的，经行政机关负责人批准，可以延长，但是延长期限不得超过三十日。法律、行政法规另有规定的除外。\r\n\r\n　　延长查封、扣押的决定应当及时书面告知当事人，并说明理由。\r\n\r\n　　对物品需要进行检测、检验、检疫或者技术鉴定的，查封、扣押的期间不包括检测、检验、检疫或者技术鉴定的期间。检测、检验、检疫或者技术鉴定的期间应当明确，并书面告知当事人。检测、检验、检疫或者技术鉴定的费用由行政机关承担。\r\n\r\n　　第二十六条　对查封、扣押的场所、设施或者财物，行政机关应当妥善保管，不得使用或者损毁；造成损失的，应当承担赔偿责任。\r\n\r\n　　对查封的场所、设施或者财物，行政机关可以委托第三人保管，第三人不得损毁或者擅自转移、处置。因第三人的原因造成的损失，行政机关先行赔付后，有权向第三人追偿。\r\n\r\n　　因查封、扣押发生的保管费用由行政机关承担。\r\n\r\n　　第二十七条　行政机关采取查封、扣押措施后，应当及时查清事实，在本法第二十五条规定的期限内作出处理决定。对违法事实清楚，依法应当没收的非法财物予以没收；法律、行政法规规定应当销毁的，依法销毁；应当解除查封、扣押的，作出解除查封、扣押的决定。\r\n\r\n　　第二十八条　有下列情形之一的，行政机关应当及时作出解除查封、扣押决定：\r\n\r\n　　（一）当事人没有违法行为；\r\n\r\n　　（二）查封、扣押的场所、设施或者财物与违法行为无关；\r\n\r\n　　（三）行政机关对违法行为已经作出处理决定，不再需要查封、扣押；\r\n\r\n　　（四）查封、扣押期限已经届满；\r\n\r\n　　（五）其他不再需要采取查封、扣押措施的情形。\r\n\r\n　　解除查封、扣押应当立即退还财物；已将鲜活物品或者其他不易保管的财物拍卖或者变卖的，退还拍卖或者变卖所得款项。变卖价格明显低于市场价格，给当事人造成损失的，应当给予补偿。\r\n\r\n　　第三节　冻　　结\r\n\r\n　　第二十九条　冻结存款、汇款应当由法律规定的行政机关实施，不得委托给其他行政机关或者组织；其他任何行政机关或者组织不得冻结存款、汇款。\r\n\r\n　　冻结存款、汇款的数额应当与违法行为涉及的金额相当；已被其他国家机关依法冻结的，不得重复冻结。\r\n\r\n　　第三十条　行政机关依照法律规定决定实施冻结存款、汇款的，应当履行本法第十八条第一项、第二项、第三项、第七项规定的程序，并向金融机构交付冻结通知书。\r\n\r\n　　金融机构接到行政机关依法作出的冻结通知书后，应当立即予以冻结，不得拖延，不得在冻结前向当事人泄露信息。\r\n\r\n　　法律规定以外的行政机关或者组织要求冻结当事人存款、汇款的，金融机构应当拒绝。\r\n\r\n　　第三十一条　依照法律规定冻结存款、汇款的，作出决定的行政机关应当在三日内向当事人交付冻结决定书。冻结决定书应当载明下列事项：\r\n\r\n　　（一）当事人的姓名或者名称、地址；\r\n\r\n　　（二）冻结的理由、依据和期限；\r\n\r\n　　（三）冻结的账号和数额；\r\n\r\n　　（四）申请行政复议或者提起行政诉讼的途径和期限；\r\n\r\n　　（五）行政机关的名称、印章和日期。\r\n\r\n　　第三十二条　自冻结存款、汇款之日起三十日内，行政机关应当作出处理决定或者作出解除冻结决定；情况复杂的，经行政机关负责人批准，可以延长，但是延长期限不得超过三十日。法律另有规定的除外。\r\n\r\n　　延长冻结的决定应当及时书面告知当事人，并说明理由。\r\n\r\n　　第三十三条　有下列情形之一的，行政机关应当及时作出解除冻结决定：\r\n\r\n　　（一）当事人没有违法行为；\r\n\r\n　　（二）冻结的存款、汇款与违法行为无关；\r\n\r\n　　（三）行政机关对违法行为已经作出处理决定，不再需要冻结；\r\n\r\n　　（四）冻结期限已经届满；\r\n\r\n　　（五）其他不再需要采取冻结措施的情形。\r\n\r\n　　行政机关作出解除冻结决定的，应当及时通知金融机构和当事人。金融机构接到通知后，应当立即解除冻结。\r\n\r\n　　行政机关逾期未作出处理决定或者解除冻结决定的，金融机构应当自冻结期满之日起解除冻结。\r\n\r\n　　第四章　行政机关强制执行程序\r\n\r\n　　第一节　一般规定\r\n\r\n　　第三十四条　行政机关依法作出行政决定后，当事人在行政机关决定的期限内不履行义务的，具有行政强制执行权的行政机关依照本章规定强制执行。\r\n\r\n　　第三十五条　行政机关作出强制执行决定前，应当事先催告当事人履行义务。催告应当以书面形式作出，并载明下列事项：\r\n\r\n　　（一）履行义务的期限；\r\n\r\n　　（二）履行义务的方式；\r\n\r\n　　（三）涉及金钱给付的，应当有明确的金额和给付方式；\r\n\r\n　　（四）当事人依法享有的陈述权和申辩权。\r\n\r\n　　第三十六条　当事人收到催告书后有权进行陈述和申辩。行政机关应当充分听取当事人的意见，对当事人提出的事实、理由和证据，应当进行记录、复核。当事人提出的事实、理由或者证据成立的，行政机关应当采纳。\r\n\r\n　　第三十七条　经催告，当事人逾期仍不履行行政决定，且无正当理由的，行政机关可以作出强制执行决定。\r\n\r\n　　强制执行决定应当以书面形式作出，并载明下列事项：\r\n\r\n　　（一）当事人的姓名或者名称、地址；\r\n\r\n　　（二）强制执行的理由和依据；\r\n\r\n　　（三）强制执行的方式和时间；\r\n\r\n　　（四）申请行政复议或者提起行政诉讼的途径和期限；\r\n\r\n　　（五）行政机关的名称、印章和日期。\r\n\r\n　　在催告期间，对有证据证明有转移或者隐匿财物迹象的，行政机关可以作出立即强制执行决定。\r\n\r\n　　第三十八条　催告书、行政强制执行决定书应当直接送达当事人。当事人拒绝接收或者无法直接送达当事人的，应当依照《中华人民共和国民事诉讼法》的有关规定送达。\r\n\r\n　　第三十九条　有下列情形之一的，中止执行：\r\n\r\n　　（一）当事人履行行政决定确有困难或者暂无履行能力的；\r\n\r\n　　（二）第三人对执行标的主张权利，确有理由的；\r\n\r\n　　（三）执行可能造成难以弥补的损失，且中止执行不损害公共利益的；\r\n\r\n　　（四）行政机关认为需要中止执行的其他情形。\r\n\r\n　　中止执行的情形消失后，行政机关应当恢复执行。对没有明显社会危害，当事人确无能力履行，中止执行满三年未恢复执行的，行政机关不再执行。\r\n\r\n　　第四十条　有下列情形之一的，终结执行：\r\n\r\n　　（一）公民死亡，无遗产可供执行，又无义务承受人的；\r\n\r\n　　（二）法人或者其他组织终止，无财产可供执行，又无义务承受人的；\r\n\r\n　　（三）执行标的灭失的；\r\n\r\n　　（四）据以执行的行政决定被撤销的；\r\n\r\n　　（五）行政机关认为需要终结执行的其他情形。\r\n\r\n　　第四十一条　在执行中或者执行完毕后，据以执行的行政决定被撤销、变更，或者执行错误的，应当恢复原状或者退还财物；不能恢复原状或者退还财物的，依法给予赔偿。\r\n\r\n　　第四十二条　实施行政强制执行，行政机关可以在不损害公共利益和他人合法权益的情况下，与当事人达成执行协议。执行协议可以约定分阶段履行；当事人采取补救措施的，可以减免加处的罚款或者滞纳金。\r\n\r\n　　执行协议应当履行。当事人不履行执行协议的，行政机关应当恢复强制执行。\r\n\r\n　　第四十三条　行政机关不得在夜间或者法定节假日实施行政强制执行。但是，情况紧急的除外。\r\n\r\n　　行政机关不得对居民生活采取停止供水、供电、供热、供燃气等方式迫使当事人履行相关行政决定。\r\n\r\n　　第四十四条　对违法的建筑物、构筑物、设施等需要强制拆除的，应当由行政机关予以公告，限期当事人自行拆除。当事人在法定期限内不申请行政复议或者提起行政诉讼，又不拆除的，行政机关可以依法强制拆除。\r\n\r\n　　第二节　金钱给付义务的执行\r\n\r\n　　第四十五条　行政机关依法作出金钱给付义务的行政决定，当事人逾期不履行的，行政机关可以依法加处罚款或者滞纳金。加处罚款或者滞纳金的标准应当告知当事人。\r\n\r\n　　加处罚款或者滞纳金的数额不得超出金钱给付义务的数额。\r\n\r\n　　第四十六条　行政机关依照本法第四十五条规定实施加处罚款或者滞纳金超过三十日，经催告当事人仍不履行的，具有行政强制执行权的行政机关可以强制执行。\r\n\r\n　　行政机关实施强制执行前，需要采取查封、扣押、冻结措施的，依照本法第三章规定办理。\r\n\r\n　　没有行政强制执行权的行政机关应当申请人民法院强制执行。但是，当事人在法定期限内不申请行政复议或者提起行政诉讼，经催告仍不履行的，在实施行政管理过程中已经采取查封、扣押措施的行政机关，可以将查封、扣押的财物依法拍卖抵缴罚款。\r\n\r\n　　第四十七条　划拨存款、汇款应当由法律规定的行政机关决定，并书面通知金融机构。金融机构接到行政机关依法作出划拨存款、汇款的决定后，应当立即划拨。\r\n\r\n　　法律规定以外的行政机关或者组织要求划拨当事人存款、汇款的，金融机构应当拒绝。\r\n\r\n　　第四十八条　依法拍卖财物，由行政机关委托拍卖机构依照《中华人民共和国拍卖法》的规定办理。\r\n\r\n　　第四十九条　划拨的存款、汇款以及拍卖和依法处理所得的款项应当上缴国库或者划入财政专户。任何行政机关或者个人不得以任何形式截留、私分或者变相私分。\r\n\r\n　　第三节　代履行\r\n\r\n　　第五十条　行政机关依法作出要求当事人履行排除妨碍、恢复原状等义务的行政决定，当事人逾期不履行，经催告仍不履行，其后果已经或者将危害交通安全、造成环境污染或者破坏自然资源的，行政机关可以代履行，或者委托没有利害关系的第三人代履行。\r\n\r\n　　第五十一条　代履行应当遵守下列规定：\r\n\r\n　　（一）代履行前送达决定书，代履行决定书应当载明当事人的姓名或者名称、地址，代履行的理由和依据、方式和时间、标的、费用预算以及代履行人；\r\n\r\n　　（二）代履行三日前，催告当事人履行，当事人履行的，停止代履行；\r\n\r\n　　（三）代履行时，作出决定的行政机关应当派员到场监督；\r\n\r\n　　（四）代履行完毕，行政机关到场监督的工作人员、代履行人和当事人或者见证人应当在执行文书上签名或者盖章。\r\n\r\n　　代履行的费用按照成本合理确定，由当事人承担。但是，法律另有规定的除外。\r\n\r\n　　代履行不得采用暴力、胁迫以及其他非法方式。\r\n\r\n　　第五十二条　需要立即清除道路、河道、航道或者公共场所的遗洒物、障碍物或者污染物，当事人不能清除的，行政机关可以决定立即实施代履行；当事人不在场的，行政机关应当在事后立即通知当事人，并依法作出处理。\r\n\r\n　　第五章　申请人民法院强制执行\r\n\r\n　　第五十三条　当事人在法定期限内不申请行政复议或者提起行政诉讼，又不履行行政决定的，没有行政强制执行权的行政机关可以自期限届满之日起三个月内，依照本章规定申请人民法院强制执行。\r\n\r\n　　第五十四条　行政机关申请人民法院强制执行前，应当催告当事人履行义务。催告书送达十日后当事人仍未履行义务的，行政机关可以向所在地有管辖权的人民法院申请强制执行；执行对象是不动产的，向不动产所在地有管辖权的人民法院申请强制执行。\r\n\r\n　　第五十五条　行政机关向人民法院申请强制执行，应当提供下列材料：\r\n\r\n　　（一）强制执行申请书；\r\n\r\n　　（二）行政决定书及作出决定的事实、理由和依据；\r\n\r\n　　（三）当事人的意见及行政机关催告情况；\r\n\r\n　　（四）申请强制执行标的情况；\r\n\r\n　　（五）法律、行政法规规定的其他材料。\r\n\r\n　　强制执行申请书应当由行政机关负责人签名，加盖行政机关的印章，并注明日期。\r\n\r\n　　第五十六条　人民法院接到行政机关强制执行的申请，应当在五日内受理。\r\n\r\n　　行政机关对人民法院不予受理的裁定有异议的，可以在十五日内向上一级人民法院申请复议，上一级人民法院应当自收到复议申请之日起十五日内作出是否受理的裁定。\r\n\r\n　　第五十七条　人民法院对行政机关强制执行的申请进行书面审查，对符合本法第五十五条规定，且行政决定具备法定执行效力的，除本法第五十八条规定的情形外，人民法院应当自受理之日起七日内作出执行裁定。\r\n\r\n　　第五十八条　人民法院发现有下列情形之一的，在作出裁定前可以听取被执行人和行政机关的意见：\r\n\r\n　　（一）明显缺乏事实根据的；\r\n\r\n　　（二）明显缺乏法律、法规依据的；\r\n\r\n　　（三）其他明显违法并损害被执行人合法权益的。\r\n\r\n　　人民法院应当自受理之日起三十日内作出是否执行的裁定。裁定不予执行的，应当说明理由，并在五日内将不予执行的裁定送达行政机关。\r\n\r\n　　行政机关对人民法院不予执行的裁定有异议的，可以自收到裁定之日起十五日内向上一级人民法院申请复议，上一级人民法院应当自收到复议申请之日起三十日内作出是否执行的裁定。\r\n\r\n　　第五十九条　因情况紧急，为保障公共安全，行政机关可以申请人民法院立即执行。经人民法院院长批准，人民法院应当自作出执行裁定之日起五日内执行。\r\n\r\n　　第六十条　行政机关申请人民法院强制执行，不缴纳申请费。强制执行的费用由被执行人承担。\r\n\r\n　　人民法院以划拨、拍卖方式强制执行的，可以在划拨、拍卖后将强制执行的费用扣除。\r\n\r\n　　依法拍卖财物，由人民法院委托拍卖机构依照《中华人民共和国拍卖法》的规定办理。\r\n\r\n　　划拨的存款、汇款以及拍卖和依法处理所得的款项应当上缴国库或者划入财政专户，不得以任何形式截留、私分或者变相私分。\r\n\r\n　　第六章　法律责任\r\n\r\n　　第六十一条　行政机关实施行政强制，有下列情形之一的，由上级行政机关或者有关部门责令改正，对直接负责的主管人员和其他直接责任人员依法给予处分：\r\n\r\n　　（一）没有法律、法规依据的；\r\n\r\n　　（二）改变行政强制对象、条件、方式的；\r\n\r\n　　（三）违反法定程序实施行政强制的；\r\n\r\n　　（四）违反本法规定，在夜间或者法定节假日实施行政强制执行的；\r\n\r\n　　（五）对居民生活采取停止供水、供电、供热、供燃气等方式迫使当事人履行相关行政决定的；\r\n\r\n　　（六）有其他违法实施行政强制情形的。\r\n\r\n　　第六十二条　违反本法规定，行政机关有下列情形之一的，由上级行政机关或者有关部门责令改正，对直接负责的主管人员和其他直接责任人员依法给予处分：\r\n\r\n　　（一）扩大查封、扣押、冻结范围的；\r\n\r\n　　（二）使用或者损毁查封、扣押场所、设施或者财物的；\r\n\r\n　　（三）在查封、扣押法定期间不作出处理决定或者未依法及时解除查封、扣押的；\r\n\r\n　　（四）在冻结存款、汇款法定期间不作出处理决定或者未依法及时解除冻结的。\r\n\r\n　　第六十三条　行政机关将查封、扣押的财物或者划拨的存款、汇款以及拍卖和依法处理所得的款项，截留、私分或者变相私分的，由财政部门或者有关部门予以追缴；对直接负责的主管人员和其他直接责任人员依法给予记大过、降级、撤职或者开除的处分。\r\n\r\n　　行政机关工作人员利用职务上的便利，将查封、扣押的场所、设施或者财物据为己有的，由上级行政机关或者有关部门责令改正，依法给予记大过、降级、撤职或者开除的处分。\r\n\r\n　　第六十四条　行政机关及其工作人员利用行政强制权为单位或者个人谋取利益的，由上级行政机关或者有关部门责令改正，对直接负责的主管人员和其他直接责任人员依法给予处分。\r\n\r\n　　第六十五条　违反本法规定，金融机构有下列行为之一的，由金融业监督管理机构责令改正，对直接负责的主管人员和其他直接责任人员依法给予处分：\r\n\r\n　　（一）在冻结前向当事人泄露信息的；\r\n\r\n　　（二）对应当立即冻结、划拨的存款、汇款不冻结或者不划拨，致使存款、汇款转移的；\r\n\r\n　　（三）将不应当冻结、划拨的存款、汇款予以冻结或者划拨的；\r\n\r\n　　（四）未及时解除冻结存款、汇款的。\r\n\r\n　　第六十六条　违反本法规定，金融机构将款项划入国库或者财政专户以外的其他账户的，由金融业监督管理机构责令改正，并处以违法划拨款项二倍的罚款；对直接负责的主管人员和其他直接责任人员依法给予处分。\r\n\r\n　　违反本法规定，行政机关、人民法院指令金融机构将款项划入国库或者财政专户以外的其他账户的，对直接负责的主管人员和其他直接责任人员依法给予处分。\r\n\r\n　　第六十七条　人民法院及其工作人员在强制执行中有违法行为或者扩大强制执行范围的，对直接负责的主管人员和其他直接责任人员依法给予处分。\r\n\r\n　　第六十八条　违反本法规定，给公民、法人或者其他组织造成损失的，依法给予赔偿。\r\n\r\n　　违反本法规定，构成犯罪的，依法追究刑事责任。\r\n\r\n　　第七章　附　　则\r\n\r\n　　第六十九条　本法中十日以内期限的规定是指工作日，不含法定节假日。\r\n\r\n　　第七十条　法律、行政法规授权的具有管理公共事务职能的组织在法定授权范围内，以自己的名义实施行政强制，适用本法有关行政机关的规定。\r\n\r\n　　第七十一条　本法自2012年1月1日起施行。', '国务院', '20051121', '20181121');

-- ----------------------------
-- Table structure for `xt_machine`
-- ----------------------------
DROP TABLE IF EXISTS `xt_machine`;
CREATE TABLE `xt_machine` (
  `DEVICE_ID` varchar(20) NOT NULL COMMENT '设备编码',
  `ORG_ID` varchar(20) DEFAULT NULL COMMENT '单位编码',
  `DEVICE_TYPE` int(11) DEFAULT NULL COMMENT '设备类型',
  `DEVICE_IP` varchar(20) DEFAULT NULL COMMENT '设备IP地址',
  `DEVICE_USER` varchar(36) DEFAULT NULL COMMENT '账号',
  `DEVICE_PASS` varchar(36) DEFAULT NULL COMMENT '密码',
  `DEVICE_STATUS` int(11) DEFAULT NULL COMMENT '设备状态',
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
  `ID` varchar(60) NOT NULL COMMENT '文书编码',
  `ORG_ID` varchar(20) NOT NULL COMMENT '单位编码',
  `CLS_ID` varchar(36) NOT NULL COMMENT '类型编码',
  `TITLE` varchar(300) DEFAULT NULL COMMENT '文书标题',
  `PAGE_HTML` text COMMENT '文书内容',
  `CREATE_DATE` char(8) DEFAULT NULL COMMENT '创建时间',
  `FILE_LIST` varchar(600) DEFAULT NULL COMMENT '文件地址',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_news
-- ----------------------------
INSERT INTO `xt_news` VALUES ('001', '411200', 'GZDT', '张兴辽到南阳市国土资源局调研指导工作', '为深入贯彻落实省委、省政府优化营商环境工作部署，日前，省国土资源厅党组印发了《关于进一步优化营商环境服务高质量发展的实施意见》（以下简称《实施意见》），就进一步推进全省国土资源“放管服”改革，优化营商环境，助推高质量发展作出全面部署。\r\n\r\n《实施意见》强调，以更大范围、更深层次、更有力举措推动国土资源“放管服”改革向纵深发展，以对标一流、敢闯敢试、鼎故革新的勇气，持续探索优化营商环境新实践，着重在减少审批事项，精简审批材料、压缩审批时限，优化办事服务，提高办事效率，加强综合监管等方面创新举措，推动审批服务理念、制度、作风全方位深层次变革，集中解决突出问题，为企业发展提供优质高效便利的服务，持续提升企业、群众到国土资源部门办事的获得感和幸福感。\r\n\r\n《实施意见》部署了十四项重点任务。突出强调要深入推进“一网通办”条件下的“最多跑一次”改革，按照“一网通办”和审批服务事项“三级十同”工作要求，建立全省国土资源系统统一的审批服务标准，编制审批服务标准化工作规程，优化完善审批服务事项办事指南，优化再造“一件事”办事流程，确保审批时限较法定时限减少50%以上，申请材料减少30%以上。扎实开展不动产登记改革，整合窗口设置，推行不动产交易、税费缴纳、登记“一窗受理、集成服务”，确保不动产交易登记事项实现从受理申请到办结“只上一张网、只进一扇门、最多跑一次”，做到一般业务7个工作日内办结，抵押类登记业务3个工作日内办结。持续深化“放管服”改革，对标先进省份，12月底前再下放一批行政审批事项；全面清理各项证明材料、各类收费项目，有法定依据保留的，列出清单并向社会公布。探索建立容缺办理机制，从实施条件、容缺范围、办理程序、办结条件、容错免责等方面建立实施路径，进一步方便企业和群众办事，提高服务效能。推进国土资源社会信用体系建设，建立涵盖土地、矿业权、测绘地理信息、规划、自然资源确权登记、国土资源中介服务、国土资源工程项目等内容的全省统一的信用评价体系，实时对接信用中国（河南）和国家企业信用信息公示系统（河南）平台，制定并实施守信联合激励和失信联合惩戒措施。\r\n\r\n《实施意见》要求，全省各级国土资源部门要提高政治站位，把抓好“放管服”改革，优化营商环境，助推高质量发展作为一项重大政治责任，主要负责同志作为第一责任人要亲自研究部署和组织推进，确保各项工作落到实处。要主动寻标对标达标创标，进一步提质、提速、提能、转变作风，以更有效的监管、更优质的服务，助推全省经济高质量发展。（厅办公室）', '20181115', '/upload/news/2018111602.pdf');
INSERT INTO `xt_news` VALUES ('002', '411200', 'GZDT', '河南省2018年例行督察意见反馈视频会在郑州召开', '9月30日上午，河南省国土资源厅召开学习贯彻习近平生态文明思想集中学习研讨会，强调要进一步提高政治站位，深入学习贯彻习近平生态文明思想和新发展理念，以更强的责任担当、更硬的工作举措、更实的工作作风，抓好生态文明建设各项工作有效落实。厅党组成员、副厅长张兴辽出席会议并讲话。', '20181115', '');
INSERT INTO `xt_news` VALUES ('324234', '411200', 'GZDT', '我省正式发布全国首个省级绿色矿山建设系列地方标准', '9月30日上午，河南省国土资源厅召开学习贯彻习近平生态文明思想集中学习研讨会，强调要进一步提高政治站位，深入学习贯彻习近平生态文明思想和新发展理念，以更强的责任担当、更硬的工作举措、更实的工作作风，抓好生态文明建设各项工作有效落实。厅党组成员、副厅长张兴辽出席会议并讲话。\r\n\r\n \r\n\r\n\r\n\r\n \r\n\r\n张兴辽强调，生态文明思想是习近平新时代中国特色社会主义思想的重要组成部分，它指明了生态文明建设的方向、目标、途径和原则，也为履行自然资源管理职责提供了重要遵循，各级各部门要从三个方面抓好落实。\r\n\r\n \r\n\r\n\r\n\r\n \r\n\r\n一是进一步深化思想认识。要认真学习领会习近平生态文明思想的丰富内涵和精髓要义，深刻把握绿水青山就是金山银山的重要发展理念，深刻把握良好生态环境是最普惠民生福祉的宗旨精神，深刻把握山水林田湖草是生命共同体的系统思想，提高生态环境保护工作的科学性、有效性。要自觉用省委书记王国生提出的四个“看一看”来审视对生态文明建设的认识，进一步提高政治站位，切实把思想认识统一到习近平生态文明思想上来，进一步增强推动生态文明建设和生态环境保护的思想自觉和行动自觉，真正做到学思用贯通、知信行合一。\r\n\r\n二是强力推动各项工作落实。要按照全省生态环境保护大会部署，及省厅结合巡视整改围绕生态文明建设出台的系列文件要求，突出完善国土空间规划体系，落实差别化供地政策，加快绿色矿山建设和矿山地质环境保护与治理恢复，积极推进山水林田湖草生态修复综合治理试点；要着手编制山水林田湖草生态保护修复规划，启动《河南省地质环境保护条例》修订，加快推进永城、济源矿山地质环境治理示范工程和焦作资源枯竭型城市矿山地质环境治理重点工程实施。\r\n\r\n三是切实加强党对生态文明建设的领导。各单位主要负责人要履行好第一责任人职责，各相关部门和单位要履行好具体职责，按照党政同责、一岗双责要求，积极履职、主动作为；要注重增强绿色发展本领，树立绿色发展理念，对违规违法审批、开发造成生态严重破坏的，要依纪依规严肃问责；要不断增强忧患意识，突出问题导向，坚持不懈地推进生态文明建设和环境保护工作，努力助推把资源优势、生态优势转化为经济优势、发展优势，为中原更加出彩作出新的更大贡献。\r\n\r\n会议还传达了习近平总书记在中央全面依法治国委员会第一次会议上的重要讲话精神及有关文件、通报，明确了第四季度的10项重点工作，并对开展10月份主题党日活动和确保廉洁、文明、安全过节提出要求。\r\n\r\n来自厅机关各处室、厅属单位的15个党支部（党委）紧密结合工作实际，围绕学习贯彻习近平生态文明思想进行交流和研讨。\r\n\r\n厅有关领导，厅机关各处室、厅属单位副处级以上干部参加会议。（《资源导刊》杂志社 张中强  郝亚儒  乔源）', '20181115', null);
INSERT INTO `xt_news` VALUES ('66', '411200', 'YWDT', '2018年部省工作会商会议', '11月15日，科学技术部、河南省人民政府在郑州举行2018年部省工作会商会议暨新一轮会商制度议定书签字仪式。会议深入学习贯彻习近平新时代中国特色社会主义思想和党的十九大精神，贯彻落实习近平总书记视察指导河南时的重要讲话和指示精神，研究深化部省科技合作、进一步发挥科技创新核心作用、推动河南高质量发展、共推创新型国家建设等事宜。科技部部长王志刚、省委书记王国生、省长陈润儿出席并讲话。\r\n\r\n　　王志刚对河南省深入践行新发展理念、积极实施创新驱动发展战略、推动创新型河南建设取得的成绩表示肯定。王志刚就本次部省工作会商议定的优化区域创新战略布局，加快创新引领型企业、平台、人才、机构建设，实施转型升级创新专项等，进行深入解读。他说，部省开展工作会商，旨在共同落实习近平总书记关于科技创新的重要论述，落实党中央的决策部署，把握事关全局的大势，做实一件件具体的要事，推动以科技创新为核心的全面创新，加快经济高质量发展步伐。科技部将与河南省一道，围绕贯彻落实习近平总书记视察指导河南时的重要讲话和指示精神，积极对接河南省重大安排和工作需求，为推动河南经济高质量发展提供服务和支持。希望河南省切实把创新摆在发展全局的核心位置，用好难得机遇、突出创新重点、优化创新布局、加强政策引领，奋力建设中西部科技创新高地，为创新型国家建设作出应有贡献。\r\n\r\n　　王国生代表省委、省政府，向科技部长期以来对河南发展给予的支持帮助表示感谢。他说，这次部省工作会商是把党的十九大精神和习近平总书记关于科技创新的重要论述往深里学、往深里领、往实处落的具体行动，是加快河南创新发展、推动经济发展高质量的一件大事，必将为我们打好创新驱动发展牌提供强大动力。我们将把部省工作会商议定的任务作为大事要事来抓，转变思维方式和工作方式，真正把创新作为激活高质量发展的第一动力，深化科技体制改革，着力构建以企业为主体、以市场为导向、产学研深度融合的技术创新体系，充分发挥郑洛新国家自主创新示范区等战略平台作用，着力在抓好创新载体、壮大创新主体、完善创新机制、强化人才支撑上下更大功夫，加强对中小企业创新的支持，促进科技成果转化，依靠创新驱动塑造优势、赢得未来。\r\n\r\n　　陈润儿指出，2007年以来，科技部先后五次与我省开展部省工作会商。第五次部省工作会商以来，我们按照习近平总书记打好“四张牌”的要求，以加快郑洛新国家自主创新示范区建设为龙头，着力推进“四个一批”“四个融合”，创新资源加速汇聚，创新实力整体提升，创新引领作用增强。实践证明，建立部省工作会商机制，是促进部省互动、服务国家战略的重要举措和提升河南创新能力、推进高质量发展的重要支撑。当前，结构性矛盾已成为制约河南高质量发展的突出症结，迫切需要依靠创新驱动来加快转型发展。期望科技部在河南更好利用创新平台、放大创新效益，汇聚创新资源、增强创新能力，壮大创新主体、建设创新中心，突出创新重点、实施创新专项等方面给予更多指导帮助，双方携手让部省合作路子越走越宽、成果越结越多。\r\n\r\n　　王志刚、陈润儿共同签署《科学技术部、河南省人民政府部省工作会商制度议定书（2018—2022年）》。双方议定，集中精力推动郑洛新国家自主创新示范区建设，培育创新引领型企业、平台、人才、机构，促进科技金融、军工民用、国家地方、院所产业融合发展，强化重大创新项目带动，进一步释放科技创新潜能，夯实建设现代化经济体系的战略支撑。\r\n\r\n　　省委常委、常务副省长黄强主持会议。副省长霍金花介绍了第五次部省会商工作落实情况，对推动本次会商事项有关情况作了说明。科技部副部长徐南平介绍了对推动本次会商事项的有关意见。\r\n\r\n　　当天上午，王志刚、陈润儿等先后到宇通客车、中铁装备、中国电科27所进行了调研。（记者 朱殿勇 屈芳）', '20181116', null);
INSERT INTO `xt_news` VALUES ('6870', '411200', 'YWDT', '陈润儿赴信阳、驻马店实地察看并召开会议听取大别山革命老区引淮供水灌溉工程、洪汝河治理工程、宿鸭湖水库清淤扩容工程规划方案意见', '11月11日，省长陈润儿到位于大别山区的信阳市、驻马店市，就大别山革命老区引淮供水灌溉工程、洪汝河治理工程、宿鸭湖水库清淤扩容工程规划建设进行调研并召开会议，听取意见建议，就深入贯彻习近平生态文明思想，统筹治理淮河上游水资源、水生态、水环境、水灾害提出要求。\r\n\r\n　　陈润儿到息县、新蔡县等地工程项目现场察看，详细了解规划方案，与水利专家探讨交流。他叮嘱信阳市、驻马店市负责同志，淮河上游工程性缺水问题突出，要加大水库建设力度、放大治水兴利效益，利用好淮河水资源，改变“住在淮河边没水用、守着淮河水没水喝”的局面。要通过堤防加固、河道疏浚等提高淮河下游排涝能力，防范减少洪涝灾害，回应百姓热切期盼。\r\n\r\n　　下午，陈润儿主持召开专题会议，听取工程相关市县、有关省直部门意见，与大家一起座谈。他说，淮河上游两岸水资源分布不均、水生态严重退化、水工程建设滞后、水灾害频繁发生，省委、省政府高度重视治淮工作，这三大工程，是具有战略意义的防洪减灾工程、扶贫脱困工程、生态环境工程、民生保障工程，有利于这一区域提高城市供水能力、保障饮用水质安全，完善流域工程体系、减少洪涝自然灾害，增加农田灌溉面积、提高旱涝保收能力，改善区域生态环境、促进经济社会发展。我们一定要精心组织、加快实施，早日惠及大别山革命老区人民。\r\n\r\n　　陈润儿强调，推进淮河治理，必须深入贯彻落实习近平生态文明思想，运用系统思维方式、辩证治水理念，实施“四水同治”。要科学谋划，通过创新思维、转变观念，化水害为水利，变水患为水益。要统筹推进，着力实现水系“内连外通”、水渠“旱引涝排”、水态“上灌下补”。要优化布局，做好上游源头防洪排涝文章，做到“上控下排中调”。要放大效益，综合考虑防灾、灌溉、航运、生态、供水等，满足沿淮人民的新需求、新期盼。', '20181112', null);
INSERT INTO `xt_news` VALUES ('80', '411200', 'YWDT', '狠抓落实确保全年工业增长目标完成\r\n', '11月9日，省政府召开全省工业经济运行电视电话会议，分析研判当前工业经济运行形势，进一步强化部门协同、上下联动，冲刺后两个月，确保完成全年工业经济各项目标任务。副省长刘伟出席并讲话。\r\n\r\n　　进入三季度以来，在内外矛盾交织叠加影响下，我省工业经济运行稳中有变，下行压力明显加大。省工信委、省发改委、省银保监局在会上分析了原因，并提出了相应的对策。郑州市、新乡市介绍了促进工业增长的举措和下一步打算。\r\n\r\n　　刘伟强调，要认清形势，坚定信心，坚定不移抓好工业经济的稳定运行和转型发展；要强化金融、用地、用工、能源等要素保障，进一步抓好工业投资和“三大改造”，做好企业服务和营商环境优化；要形成合力，狠抓落实，树立全省一盘棋思想，相关部门要协调联动，凝聚合力，确保中央和省里近期出台的政策有效落实，确保完成全年既定目标任务。（记者 陈辉）', '20181110', null);

-- ----------------------------
-- Table structure for `xt_notice`
-- ----------------------------
DROP TABLE IF EXISTS `xt_notice`;
CREATE TABLE `xt_notice` (
  `NOTICE_ID` char(30) NOT NULL,
  `USER_ID` char(8) DEFAULT NULL,
  `NOTICE_CONTENT` text,
  `NOTICE_DATE` char(14) DEFAULT NULL,
  `NOTICE_STRUCT` varchar(50) DEFAULT NULL,
  `NOTICE_TITLE` varchar(50) DEFAULT NULL,
  `ISACTIVE` int(11) DEFAULT NULL,
  PRIMARY KEY (`NOTICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_notice
-- ----------------------------
INSERT INTO `xt_notice` VALUES ('1', '41120051', '标题', '20181116144600', '无', '内容', '1');

-- ----------------------------
-- Table structure for `xt_page_dict`
-- ----------------------------
DROP TABLE IF EXISTS `xt_page_dict`;
CREATE TABLE `xt_page_dict` (
  `DICT_ID` char(30) NOT NULL COMMENT '字典编码',
  `DICT_SQL` varchar(300) DEFAULT NULL COMMENT '字典SQL',
  `DEF_VAL` char(30) DEFAULT NULL COMMENT '字典默认值',
  PRIMARY KEY (`DICT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_page_dict
-- ----------------------------
INSERT INTO `xt_page_dict` VALUES ('ORG_LIST', 'SELECT ORG_ID AS KEYVALUE,ORG_NAME AS KEYTEXT FROM S_ORG_INF', null);

-- ----------------------------
-- Table structure for `xt_phone_book`
-- ----------------------------
DROP TABLE IF EXISTS `xt_phone_book`;
CREATE TABLE `xt_phone_book` (
  `ID` varchar(30) NOT NULL COMMENT 'ID',
  `USER_ID` varchar(12) DEFAULT NULL COMMENT '用户编码',
  `TELNO` varchar(30) DEFAULT NULL COMMENT '电话号码',
  `USER_NAME` varchar(30) DEFAULT NULL COMMENT '姓名',
  `UNIT_NAME` varchar(300) DEFAULT NULL COMMENT '单位',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='办公系统--通讯录(XT_PHONE_BOOK)';

-- ----------------------------
-- Records of xt_phone_book
-- ----------------------------
INSERT INTO `xt_phone_book` VALUES ('1', '41120051', '15713814998', '张玺', '单位');
INSERT INTO `xt_phone_book` VALUES ('2', '41120051', '15712358789', '杨洋', '单位');

-- ----------------------------
-- Table structure for `xt_push`
-- ----------------------------
DROP TABLE IF EXISTS `xt_push`;
CREATE TABLE `xt_push` (
  `ID` char(60) NOT NULL COMMENT '推送GUID',
  `USER_ID` varchar(12) DEFAULT NULL COMMENT '用户编码',
  `PUSH_FLAG` int(11) DEFAULT NULL COMMENT '推送标志',
  `PUSH_TEXT` varchar(600) DEFAULT NULL COMMENT '推送内容',
  `PUSH_TIME` char(14) DEFAULT NULL COMMENT '推送时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_push
-- ----------------------------

-- ----------------------------
-- Table structure for `xt_type`
-- ----------------------------
DROP TABLE IF EXISTS `xt_type`;
CREATE TABLE `xt_type` (
  `CLS_ID` varchar(36) NOT NULL COMMENT '类型编码',
  `CLS_NAME` varchar(100) DEFAULT NULL COMMENT '类型名称',
  `TYPE_ID` varchar(36) DEFAULT NULL COMMENT '类型分类',
  `ORDERBY` int(11) DEFAULT NULL COMMENT '排序',
  `ISACTIVE` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`CLS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_type
-- ----------------------------
INSERT INTO `xt_type` VALUES ('LAW_INF', '法律法规', '0', '1', '1');
INSERT INTO `xt_type` VALUES ('ZWGK', '政务公开', '0', '1', '1');

-- ----------------------------
-- Table structure for `xt_upload`
-- ----------------------------
DROP TABLE IF EXISTS `xt_upload`;
CREATE TABLE `xt_upload` (
  `FILE_ID` varchar(36) NOT NULL COMMENT 'FILE_ID',
  `FILE_NAME` varchar(100) DEFAULT NULL COMMENT 'FILE_NAME',
  `FILE_URL` varchar(200) DEFAULT NULL COMMENT 'FILE_URL',
  `UPDATE_TIME` varchar(12) DEFAULT NULL COMMENT 'UPDATE_TIME',
  PRIMARY KEY (`FILE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xt_upload
-- ----------------------------

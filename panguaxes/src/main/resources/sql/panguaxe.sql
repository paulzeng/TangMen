/*
Navicat MySQL Data Transfer

Source Server         : panguaxe
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : panguaxe

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-07-16 21:32:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ly_r_configure
-- ----------------------------
DROP TABLE IF EXISTS `ly_r_configure`;
CREATE TABLE `ly_r_configure` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `configName` varchar(30) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '配置名称',
  `configValue` varchar(360) DEFAULT NULL COMMENT '配置值',
  `state` int(1) DEFAULT '1' COMMENT '是否启用：0未启用，1启用',
  `depict` varchar(60) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '描述',
  `createDate` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `updateDate` varchar(32) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_r_configure
-- ----------------------------
INSERT INTO `ly_r_configure` VALUES ('22D1ABBAE2FC4C33833EF5824242CE5B', 'weChat.mchKey', 'NVXYI07ZTRYIYXY96FV0XOL50EHAUQFN', '1', '微信商户API密钥', '2019-06-17 18:00:00', null);
INSERT INTO `ly_r_configure` VALUES ('49F967A74D5340EF90D5E0E106E9AE17', 'weChat.appSecret', '4d28f85ef41b5fcb576ea5dc93816a64', '1', '微信公众号接口密码AppSecret', '2019-06-17 18:00:00', null);
INSERT INTO `ly_r_configure` VALUES ('646C33E8120F4FBF9910FF522607853E', 'weChat.appid', 'wx478564310cb6ba0f', '1', '微信商户账号appid', '2019-06-17 18:00:00', null);
INSERT INTO `ly_r_configure` VALUES ('6F754DF03DC6458FBA0C48E34942A161', 'weChat.mchid', '1509889421', '1', '微信支付分配的商户号', '2019-06-17 18:00:00', null);
INSERT INTO `ly_r_configure` VALUES ('AF36B2FD621E4612B152AECF8C912688', 'weChat.publicKey', 'MIIBCgKCAQEAwPyqspnNPgqmwDDpJLcF7+xBmVMonAwBwToCX/Yu8F9ztAZUVPFIWNkUyClSBj95ME8WBUcC6mhRu9C/OHyuG81oYyufUgdf+BCdc35NP2y8GO/almlhZhymIDUqf97m/Tec/ML5bq+e8GdCxGSJ/CvDQEwuCD977d7ZN01MNkA5ADWQrU0QRHvK4Mranm5W0ltkeJ2j1y0u6CCjVzNe89UiKHDFwj8sR+oDmpAXzs7R2g4a+0hGYS7dzyWhayxCErDrLhBy8JeiZR/jXXiKwA9ZSB00s+Mj4zBrwK06cfHV1NzHe4g9E1SnPS4Eei5Hz3frM5RdDnYX93xbY7qxmwIDAQAB', '1', '微信支付公钥', '2019-06-17 18:00:00', null);
INSERT INTO `ly_r_configure` VALUES ('C000EF76FA834BBD822FF724364A2AB5', 'weChat.cert', '/etc/pki/weixin/weixin.p12', '1', '微信支付证书路径', '2019-06-17 18:00:00', null);
INSERT INTO `ly_r_configure` VALUES ('C54B9DDB84E643ABB251374181C39F25', 'weChat.payAppid', 'wx478564310cb6ba0f', '1', '微信支付统一下单appid', '2019-06-17 18:00:00', null);
INSERT INTO `ly_r_configure` VALUES ('CE83AC3AFC424D36BF6EF296C48AE614', 'weChat.notifyUrl', 'http://webapp.zgzngj.com/api/weChatPayNotifyCallback.wm', '1', '微信支付通知回调地址', '2019-06-17 18:00:00', null);
INSERT INTO `ly_r_configure` VALUES ('CE83AC3AFC424D36BF6EF296C48AE615', 'weChat.payIP', '60.205.190.200', '1', '微信支付统一下单终端IP', '2019-06-17 18:00:00', null);

-- ----------------------------
-- Table structure for ly_r_earnings
-- ----------------------------
DROP TABLE IF EXISTS `ly_r_earnings`;
CREATE TABLE `ly_r_earnings` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `accountId` varchar(36) DEFAULT NULL COMMENT '收益人',
  `amount` decimal(11,3) DEFAULT '0.000' COMMENT '收益金额',
  `withdrawAble` decimal(11,3) DEFAULT '0.000' COMMENT '可提现金额',
  `openid` varchar(60) DEFAULT NULL COMMENT '微信openid',
  `memo` varchar(150) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注',
  `createDate` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `updateDate` varchar(32) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `earnings_userInfoId` (`accountId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_r_earnings
-- ----------------------------

-- ----------------------------
-- Table structure for ly_r_earningsclassify
-- ----------------------------
DROP TABLE IF EXISTS `ly_r_earningsclassify`;
CREATE TABLE `ly_r_earningsclassify` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `accountId` varchar(32) DEFAULT NULL COMMENT '收益人',
  `money` decimal(18,3) DEFAULT NULL COMMENT '收益金额',
  `profitType` varchar(10) DEFAULT NULL COMMENT '收益类型： 1: 拼手气; 2 普通',
  `extend` varchar(20) DEFAULT NULL COMMENT '扩展字段',
  `createDate` varchar(36) DEFAULT NULL COMMENT '创建时间',
  `updateDate` varchar(36) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_r_earningsclassify
-- ----------------------------

-- ----------------------------
-- Table structure for ly_r_imgresource
-- ----------------------------
DROP TABLE IF EXISTS `ly_r_imgresource`;
CREATE TABLE `ly_r_imgresource` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `redBagId` varchar(32) DEFAULT NULL COMMENT '红包ID',
  `type` varchar(10) DEFAULT NULL COMMENT '类型：IMG 图片；V 视频。',
  `resourceUrl` varchar(255) DEFAULT NULL COMMENT '资源路径',
  `width` int(11) DEFAULT NULL COMMENT '宽度',
  `height` int(11) DEFAULT NULL COMMENT '高度',
  `extend` varchar(32) DEFAULT NULL COMMENT '扩展字段',
  `createDate` varchar(32) DEFAULT NULL COMMENT '提现、创建时间',
  `updateDate` varchar(32) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_r_imgresource
-- ----------------------------

-- ----------------------------
-- Table structure for ly_r_income
-- ----------------------------
DROP TABLE IF EXISTS `ly_r_income`;
CREATE TABLE `ly_r_income` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `accountId` varchar(32) DEFAULT NULL COMMENT '收益人ID',
  `incomeName` varchar(16) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '收益人昵称',
  `incomeMobile` varchar(11) DEFAULT NULL COMMENT '收益人手机',
  `incomeMoney` decimal(11,3) DEFAULT NULL COMMENT '收益金额',
  `incomeType` int(3) DEFAULT NULL COMMENT '收益类型：1 拼手气; 2 普通',
  `incomeDesc` varchar(30) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '收益描述',
  `businessId` varchar(32) DEFAULT NULL COMMENT '业务ID：红包详情ID',
  `senderId` varchar(32) DEFAULT NULL COMMENT '发送者ID',
  `senderName` varchar(16) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '发送者昵称',
  `senderMobile` varchar(11) DEFAULT NULL COMMENT '发送者手机',
  `state` int(1) DEFAULT '1' COMMENT '状态：1 正常',
  `memo` varchar(250) DEFAULT NULL COMMENT '备注',
  `createDate` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `updateDate` varchar(32) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `in_userInfoId` (`accountId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_r_income
-- ----------------------------

-- ----------------------------
-- Table structure for ly_r_incometype
-- ----------------------------
DROP TABLE IF EXISTS `ly_r_incometype`;
CREATE TABLE `ly_r_incometype` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `incomeType` int(3) DEFAULT NULL COMMENT '收益类型：1 拼手气; 2 普通; 可扩展',
  `incomeExplain` varchar(30) DEFAULT NULL COMMENT '收益说明',
  `state` int(1) DEFAULT '1' COMMENT '状态：1 启用；0 禁用',
  `memo` varchar(30) DEFAULT NULL COMMENT '备注',
  `createDate` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `updateDate` varchar(32) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_r_incometype
-- ----------------------------
INSERT INTO `ly_r_incometype` VALUES ('B0AF0CADD36F45E3A78A57D55B2BA12E', '1', '拼手气红包', '1', '拼手气红包', '2019-04-25 17:25:56', null);
INSERT INTO `ly_r_incometype` VALUES ('F3DDFD9EA98A496C977D9518E21A02C9', '2', '普通红包', '1', '普通红包', '2019-04-25 17:25:56', null);

-- ----------------------------
-- Table structure for ly_r_redbag
-- ----------------------------
DROP TABLE IF EXISTS `ly_r_redbag`;
CREATE TABLE `ly_r_redbag` (
  `id` varchar(32) NOT NULL COMMENT '红包ID',
  `accountId` varchar(32) DEFAULT NULL COMMENT '发送者',
  `openid` varchar(36) DEFAULT NULL COMMENT '发送人微信openid',
  `nickName` varchar(30) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '发送者昵称',
  `telephone` varchar(11) DEFAULT NULL COMMENT '发送者电话',
  `headPortrait` varchar(350) DEFAULT NULL COMMENT '发送者头像',
  `amount` decimal(11,3) DEFAULT NULL COMMENT '红包金额',
  `num` int(11) DEFAULT NULL COMMENT '红包个数',
  `sendTime` varchar(32) DEFAULT NULL COMMENT '发送时间',
  `unclaimed` int(11) DEFAULT NULL COMMENT '未领取个数：默认发送时的个数',
  `alreadyTake` int(11) DEFAULT '0' COMMENT '已领取个数：领取一个,此值+1',
  `redBagType` varchar(10) DEFAULT NULL COMMENT '红包类型: LUCK - 拼手气; GENERAL - 普通',
  `payType` varchar(10) DEFAULT '' COMMENT '支付方式：Wap、IOS、Android、JSAPI',
  `payState` int(1) DEFAULT NULL COMMENT '支付状态：1 成功; 0 失败',
  `redbagDesc` varchar(150) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '红包描述：如：大吉大利',
  `showRange` varchar(10) DEFAULT NULL COMMENT '展示范围',
  `province` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '省',
  `city` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '市/区',
  `longitude` decimal(25,8) DEFAULT NULL COMMENT '经度',
  `latitude` decimal(25,8) DEFAULT NULL COMMENT '纬度',
  `createDate` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `updateDate` varchar(32) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `red_userInfoId` (`accountId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_r_redbag
-- ----------------------------
INSERT INTO `ly_r_redbag` VALUES ('46AC605E4E9E477BA0114A0DE9DBB717', 'ka2r8exFeGad49WLiKY', 'oaASb1Q18_BQhQi2wGWDpSWMquBc', 'Panguaxe', '18300665808', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo74QWxFOpRB7lu4icp9S1puGcphjVYZ21Yg4Zz6qtuic65OiadK2QZ6oCMlibibqNnAs6QRiavzb8D0YNA/132', '6.000', '6', '2019-07-16 21:29:42', '6', '0', 'LUCK', 'JSAPI', '-1', '红包大吉大利', '30', null, null, '113.67602500', '34.75229300', '2019-07-16 21:29:42', null);

-- ----------------------------
-- Table structure for ly_r_redbagdetails
-- ----------------------------
DROP TABLE IF EXISTS `ly_r_redbagdetails`;
CREATE TABLE `ly_r_redbagdetails` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '红包ID',
  `redBagId` varchar(32) DEFAULT NULL COMMENT '红包大包ID',
  `redBagType` varchar(10) DEFAULT NULL COMMENT '红包类型: LUCK - 拼手气; GENERAL - 普通',
  `accountId` varchar(32) DEFAULT NULL COMMENT '发送者',
  `nickName` varchar(30) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '发送者昵称',
  `telephone` varchar(11) DEFAULT NULL COMMENT '发送者电话',
  `headPortrait` varchar(350) DEFAULT NULL COMMENT '发送者头像',
  `money` decimal(18,3) DEFAULT NULL COMMENT '红包金额',
  `receiverId` varchar(32) DEFAULT NULL COMMENT '领取人',
  `receiverName` varchar(30) DEFAULT NULL COMMENT '领取人昵称',
  `receiverPhone` varchar(11) DEFAULT NULL COMMENT '领取人电话',
  `receiverHead` varchar(150) DEFAULT NULL COMMENT '领取人头像',
  `getTime` varchar(36) DEFAULT NULL COMMENT '领取时间',
  `redBagState` int(1) DEFAULT '0' COMMENT '红包状态：默认0 未领取； 1 已领取；2 回收',
  `longitude` decimal(25,8) DEFAULT NULL COMMENT '经度',
  `latitude` decimal(25,8) DEFAULT NULL COMMENT '纬度',
  `redbagDesc` varchar(400) DEFAULT NULL COMMENT '红包描述：如：大吉大利',
  `createDate` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `updateDate` varchar(32) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `red_userInfoId` (`accountId`) USING BTREE,
  KEY `red_receiverId` (`receiverId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_r_redbagdetails
-- ----------------------------

-- ----------------------------
-- Table structure for ly_r_redbagtype
-- ----------------------------
DROP TABLE IF EXISTS `ly_r_redbagtype`;
CREATE TABLE `ly_r_redbagtype` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `typeCode` varchar(32) DEFAULT NULL COMMENT '红包类型CODE',
  `typeName` varchar(255) DEFAULT NULL COMMENT '红包类型名称',
  `maxMoney` decimal(11,3) DEFAULT NULL COMMENT '红包最大金额',
  `minMoney` decimal(11,3) DEFAULT NULL COMMENT '红包最小金额',
  `singleMin` decimal(11,3) DEFAULT NULL,
  `state` int(1) DEFAULT '1' COMMENT '是否启用：0未启用，1启用',
  `createDate` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `updateDate` varchar(32) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_r_redbagtype
-- ----------------------------
INSERT INTO `ly_r_redbagtype` VALUES ('0C5D3ECBACEE463AB5F522AC97838D71', 'LUCK', '拼手气红包', '2000.000', '0.010', '0.010', '1', '2019-06-17 18:00:00', null);
INSERT INTO `ly_r_redbagtype` VALUES ('EBC3A810B32F4D23B24D5B5284E8DC19', 'GENERAL', '普通红包', '2000.000', '0.010', '0.010', '1', '2019-06-17 18:00:00', null);

-- ----------------------------
-- Table structure for ly_r_withdraw
-- ----------------------------
DROP TABLE IF EXISTS `ly_r_withdraw`;
CREATE TABLE `ly_r_withdraw` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `accountId` varchar(32) DEFAULT NULL COMMENT '提现人ID',
  `nickName` varchar(16) DEFAULT NULL COMMENT '提现人昵称',
  `telephone` varchar(11) DEFAULT NULL COMMENT '提现人手机',
  `headPhoto` varchar(100) DEFAULT NULL COMMENT '提现人头像',
  `amount` decimal(18,3) DEFAULT NULL COMMENT '提现金额',
  `orderNo` varchar(32) DEFAULT NULL COMMENT '提现订单号',
  `state` int(1) DEFAULT '1' COMMENT '提现状态：1 成功；0 失败；',
  `returnCode` varchar(20) DEFAULT NULL COMMENT '返回码',
  `returnMsg` varchar(200) DEFAULT NULL COMMENT '返回信息',
  `createDate` varchar(32) DEFAULT NULL COMMENT '提现/创建时间',
  `updateDate` varchar(32) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_r_withdraw
-- ----------------------------

-- ----------------------------
-- Table structure for ly_s_account
-- ----------------------------
DROP TABLE IF EXISTS `ly_s_account`;
CREATE TABLE `ly_s_account` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `userName` varchar(32) DEFAULT NULL COMMENT '账户名',
  `nickName` varchar(50) DEFAULT NULL COMMENT '昵称',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '盐池',
  `telephone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `isEnable` int(1) DEFAULT NULL COMMENT '账户状态',
  `isEmployee` int(1) DEFAULT '0' COMMENT '是否员工：1 是；0 不是',
  `gender` int(1) DEFAULT NULL COMMENT '性别',
  `birthday` varchar(10) DEFAULT NULL COMMENT '生日',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(26) DEFAULT NULL COMMENT '邮箱',
  `motto` varchar(150) DEFAULT NULL COMMENT '座右铭',
  `openId` varchar(50) DEFAULT NULL COMMENT '微信ID',
  `nation` varchar(10) DEFAULT NULL COMMENT '民族',
  `province` varchar(32) DEFAULT NULL COMMENT '省',
  `city` varchar(32) DEFAULT NULL COMMENT '市',
  `district` varchar(32) DEFAULT NULL COMMENT '区县',
  `lastLogin` varchar(19) DEFAULT NULL COMMENT '最后登录时间',
  `createDate` varchar(19) DEFAULT NULL COMMENT '创建日期',
  `updateDate` varchar(19) DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `accountName` (`userName`),
  UNIQUE KEY `account_mobile` (`telephone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='账户表';

-- ----------------------------
-- Records of ly_s_account
-- ----------------------------
INSERT INTO `ly_s_account` VALUES ('23906D0156E6462FB8F91EB0F89C46CD', '19937755858', '19937755858', '5c7145ff8044387a1996b0f010723f1f', 'ae9218176e64fbb49b7a111f5e9f7273', '19937755858', null, '0', '1', null, null, null, null, null, null, null, null, null, '2019-07-16 21:10:39', '2019-07-13 12:04:45', null);
INSERT INTO `ly_s_account` VALUES ('ka2r8exFeGad49WLiKY', '18300665808', '殷耀峰', '453bdd046e06465a36f61c4fb87693d1', '522e2c4aff3aa42c6a08518ef8969c3c', '18300665808', '1', '0', '1', '10-10', '31', null, null, 'oaASb1Q18_BQhQi2wGWDpSWMquBc', '汉族', null, null, null, '2019-07-13 10:28:32', '2018-06-05 13:28:34', null);

-- ----------------------------
-- Table structure for ly_s_identify
-- ----------------------------
DROP TABLE IF EXISTS `ly_s_identify`;
CREATE TABLE `ly_s_identify` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `accountId` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `realName` varchar(20) DEFAULT NULL COMMENT '姓名',
  `idCard` varchar(100) DEFAULT NULL COMMENT '身份证号',
  `gender` int(1) DEFAULT NULL COMMENT '性别',
  `laterDigits` varchar(6) CHARACTER SET utf8 DEFAULT NULL COMMENT '身份证后6位',
  `census` varchar(30) DEFAULT NULL COMMENT '户籍',
  `licAuth` varchar(50) DEFAULT NULL COMMENT '发展机关',
  `nation` varchar(10) DEFAULT NULL COMMENT '民族',
  `isPass` int(1) DEFAULT NULL COMMENT '是否通过实名认证',
  `createDate` varchar(19) DEFAULT NULL COMMENT '创建日期',
  `updateDate` varchar(19) DEFAULT NULL COMMENT '最后修改日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `identity_cardNo` (`idCard`) USING BTREE,
  UNIQUE KEY `identity_user` (`accountId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='实名认证表';

-- ----------------------------
-- Records of ly_s_identify
-- ----------------------------
INSERT INTO `ly_s_identify` VALUES ('CWTFtV9EhSsowrhhVJ4', 'ka2r8exFeGad49WLiKY', '殷耀峰', '410482198810107731', '1', '7731', '河南省汝州市', '汝州市公安局', '汉族', '1', '2018-06-25 12:25:19', null);

-- ----------------------------
-- Table structure for ly_s_verificode
-- ----------------------------
DROP TABLE IF EXISTS `ly_s_verificode`;
CREATE TABLE `ly_s_verificode` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `telephone` varchar(11) DEFAULT NULL COMMENT '手机',
  `smsCode` varchar(8) DEFAULT NULL COMMENT '短信验证码',
  `smsSort` int(6) DEFAULT NULL COMMENT '短信分类: 1 注册; 2 验证码登陆；……',
  `validTime` int(6) DEFAULT NULL COMMENT '有效时长',
  `createDate` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '提现/创建时间',
  `updateDate` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_telephone` (`telephone`,`smsSort`) USING BTREE COMMENT '手机号唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ly_s_verificode
-- ----------------------------
INSERT INTO `ly_s_verificode` VALUES ('1DE6CF24B67C47D2B36CB739E8DC9C9A', '19937755858', '4719', '1', '3', '2019-07-13 12:03:25', '2019-07-16 21:10:32');
INSERT INTO `ly_s_verificode` VALUES ('2EBDB6AE43A74A7FA1306532C260857F', '18300665808', '0635', '1', '2', '2019-07-14 13:23:24', null);

-- ----------------------------
-- Table structure for ly_s_verificodeconfig
-- ----------------------------
DROP TABLE IF EXISTS `ly_s_verificodeconfig`;
CREATE TABLE `ly_s_verificodeconfig` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `module` varchar(20) DEFAULT NULL COMMENT '模块：账户：ACC; 语音：VOICE; 核心：CORE……',
  `moduleName` varchar(32) DEFAULT NULL COMMENT '模块名',
  `smsSort` int(6) DEFAULT NULL COMMENT '验证码分类',
  `digit` int(1) DEFAULT NULL COMMENT '验证码长度',
  `moduleDesc` varchar(150) DEFAULT NULL COMMENT '模块描述',
  `validTime` int(6) DEFAULT NULL COMMENT '有效时长',
  `createDate` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '提现/创建时间',
  `updateDate` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ly_s_verificodeconfig
-- ----------------------------
INSERT INTO `ly_s_verificodeconfig` VALUES ('0347387C787A4892B732E83BD6563A64', 'ACC', '用户模块', '1', '4', '用户注册、动态登录、修改密码、重置密码【获取验证码】', '3', null, null);
INSERT INTO `ly_s_verificodeconfig` VALUES ('1CA484CB7C05430F9C531DA598F987FA', 'VOICE', '语音验证码', '2', '6', '所有用到语音验证码的接口【获取验证码】', '2', null, null);
INSERT INTO `ly_s_verificodeconfig` VALUES ('34F60D075AFF46589712C5BCC81314F4', 'CORE', '核心业务', '3', '4', '代还、套现【获取验证码】', '5', null, null);

-- ----------------------------
-- Table structure for ly_s_wechat
-- ----------------------------
DROP TABLE IF EXISTS `ly_s_wechat`;
CREATE TABLE `ly_s_wechat` (
  `id` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '主键',
  `accountId` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '账户ID',
  `mobile` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '手机号',
  `openid` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '微信openid',
  `headPture` varchar(256) CHARACTER SET utf8 DEFAULT NULL COMMENT '头像',
  `nickName` varchar(50) DEFAULT NULL COMMENT '昵称',
  `province` varchar(32) DEFAULT NULL COMMENT '省',
  `city` varchar(32) DEFAULT NULL COMMENT '市',
  `unionid` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT 'unionid微信唯一标识',
  `status` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '状态',
  `createDate` varchar(19) CHARACTER SET utf8 DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `wxuser_openid` (`openid`),
  UNIQUE KEY `wxuser_unionid` (`unionid`) USING BTREE,
  UNIQUE KEY `wxuser_userInfoId` (`accountId`) USING BTREE,
  KEY `wxuser_mobile` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

-- ----------------------------
-- Records of ly_s_wechat
-- ----------------------------
INSERT INTO `ly_s_wechat` VALUES ('8584ae7e08b649fba5f2212729ad7e61', 'ka2r8exFeGad49WLiKY', '18300665808', 'oaASb1Q18_BQhQi2wGWDpSWMquBc', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo74QWxFOpRB7lu4icp9S1puGcphjVYZ21Yg4Zz6qtuic65OiadK2QZ6oCMlibibqNnAs6QRiavzb8D0YNA/132', 'Panguaxe', '浙江', '杭州', 'o0xoR1WkQHKnaRiUg98cbF4OJLOE', null, '2018-09-15 17:20:13');

/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50558
Source Host           : localhost:3306
Source Database       : xiaomi

Target Server Type    : MYSQL
Target Server Version : 50558
File Encoding         : 65001

Date: 2018-11-05 14:49:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `number` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `subtoatl` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `care_goods_id-goods_goods_id` (`goods_id`),
  KEY `care_users_id-user_user_id` (`user_id`),
  CONSTRAINT `care_goods_id-goods_goods_id` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `care_users_id-user_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10300621 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('10300608', '10300603', '1245', '2', '4998');
INSERT INTO `cart` VALUES ('10300609', '10300603', '1245', '2', '4998');
INSERT INTO `cart` VALUES ('10300619', '10408011', '1245', '1', '1499');

-- ----------------------------
-- Table structure for color
-- ----------------------------
DROP TABLE IF EXISTS `color`;
CREATE TABLE `color` (
  `color_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '颜色ID',
  `color_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '颜色名称',
  PRIMARY KEY (`color_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of color
-- ----------------------------
INSERT INTO `color` VALUES ('1', '白色');
INSERT INTO `color` VALUES ('2', '黑色');
INSERT INTO `color` VALUES ('3', '金色');

-- ----------------------------
-- Table structure for edition
-- ----------------------------
DROP TABLE IF EXISTS `edition`;
CREATE TABLE `edition` (
  `edition_id` int(11) NOT NULL AUTO_INCREMENT,
  `edition_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`edition_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of edition
-- ----------------------------
INSERT INTO `edition` VALUES ('1', '标配版 3GB内存+32GB容量');
INSERT INTO `edition` VALUES ('2', '高配版 3GB内存+64GB容量');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `describe` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `goods_price` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `pic_path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`goods_id`),
  KEY `goods_type_id-type_id` (`type_id`),
  CONSTRAINT `goods_type_id-type_id` FOREIGN KEY (`type_id`) REFERENCES `goods_type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10418009 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('10100000', '小米MIX 2S', null, '2399元起', './images/xiaomix2s.jpg', '#', '1');
INSERT INTO `goods` VALUES ('10100001', '小米Max', '', '1299', './images/index_drop_prod1.jpg', '#', '1');
INSERT INTO `goods` VALUES ('10100002', '小米8', null, '2699元起', './images/xiaomi8.jpg', '#', '1');
INSERT INTO `goods` VALUES ('10100003', '小米8 SE', null, '1799元起', './images/xiaomi8se.jpg', '#', '1');
INSERT INTO `goods` VALUES ('10100004', '小米Max 3', null, '1699元起', './images/xiaomimax3.jpg', '#', '1');
INSERT INTO `goods` VALUES ('10100005', '红米6 Pro', null, '999元起', './images/hongmi6pro.jpg', '#', '2');
INSERT INTO `goods` VALUES ('10100006', '红米6', null, '799元', './images/hongmi6.jpg', '#', '2');
INSERT INTO `goods` VALUES ('10100007', '红米6A', null, '599元', './images/hongmi6A.jpg', '#', '2');
INSERT INTO `goods` VALUES ('10100008', '红米Note 5', null, '1099元起', './images/hongminote5.jpg', '#', '2');
INSERT INTO `goods` VALUES ('10100009', '红米S2', null, '999元起', './images/hongmis2.jpg', '#', '2');
INSERT INTO `goods` VALUES ('10100010', '小米平板', null, '1099元起', './images/xiaopingban.jpg', '#', '3');
INSERT INTO `goods` VALUES ('10100011', '小米笔记本 15.6\'\'', null, '4199元起', './images/xiaomibjb1.jpg', '#', '3');
INSERT INTO `goods` VALUES ('10100012', '小米游戏本 8代', null, '6699元起', './images/xiaomibjb2.jpg', '#', '3');
INSERT INTO `goods` VALUES ('10100013', '小米笔记本Pro 15.6\'\' GTX版', null, '6299元起', './images/xiaomibjb3.jpg', '#', '3');
INSERT INTO `goods` VALUES ('10100014', '小米笔记本 Air 系列', null, '3599元起', './images/xiaomibjb4.jpg', '#', '3');
INSERT INTO `goods` VALUES ('10100015', '小米电视4C 40英寸', null, '1299元', './images/xiaoTv1.jpg', '#', '4');
INSERT INTO `goods` VALUES ('10100016', '小米电视4A 32英寸', null, '899元', './images/xiaoTv2.jpg', '#', '4');
INSERT INTO `goods` VALUES ('10100017', '小米电视4A 43英寸 青春版', null, '1499元', './images/xiaoTv3.jpg', '#', '4');
INSERT INTO `goods` VALUES ('10100018', '小米电视4A 50英寸', null, '1999元', './images/xiaoTv4.jpg', '#', '4');
INSERT INTO `goods` VALUES ('10100019', '小米电视4A 55英寸', null, '2499元', './images/xiaoTv5.jpg', '#', '4');
INSERT INTO `goods` VALUES ('10100020', '小米盒子3', null, '249元', './images/index_drop_box1.jpg', '#', '5');
INSERT INTO `goods` VALUES ('10100021', '小米手环3 NFC版', null, '199元', './images/xp1.jpg', '#', '5');
INSERT INTO `goods` VALUES ('10100022', '小米米家小白智能摄像机增强版', null, '399元', './images/xp4.jpg', '#', '5');
INSERT INTO `goods` VALUES ('10100023', '小米小爱智能闹钟', null, '149元', './images/xp5.jpg', '#', '5');
INSERT INTO `goods` VALUES ('10100024', '小米双单元半入耳式耳机', null, '99元', './images/xp6.jpg', '#', '5');
INSERT INTO `goods` VALUES ('10100025', '小米路由器 4', null, '199元', './images/lu1.jpg', '#', '6');
INSERT INTO `goods` VALUES ('10100026', '小米路由器 4Q', null, '89元', './images/lu2.jpg', '#', '6');
INSERT INTO `goods` VALUES ('10100027', '小米路由器 3A', null, '139元', './images/lu3.jpg', '#', '6');
INSERT INTO `goods` VALUES ('10100028', '小米路由器 3G', null, '219元', './images/lu4.jpg', '#', '6');
INSERT INTO `goods` VALUES ('10100029', '小米路由器 HD/Pro', null, '449元起', './images/lu5.jpg', '#', '6');
INSERT INTO `goods` VALUES ('10100030', '小米净水器', null, '1299元起', './images/index_drop_hard1.jpg', '#', '7');
INSERT INTO `goods` VALUES ('10100031', '米家空气净化器Pro', null, '1499元起', './images/zi1.jpg', '#', '7');
INSERT INTO `goods` VALUES ('10100032', '米家扫地机器人', null, '1699元起', './images/zi3.jpg', '#', '7');
INSERT INTO `goods` VALUES ('10100033', '米家压力IH电饭煲', null, '999元起', './images/zi4.jpg', '#', '7');
INSERT INTO `goods` VALUES ('10100034', '米家电动剃须刀', null, '199元起', './images/zi2.jpg', '#', '7');
INSERT INTO `goods` VALUES ('10100035', '小米Max 3 智能保护套', '智能唤醒 / 黄金角度 \r\n适用于 小米Max3', '59元', './images/pj/pj1.jpg', '#', '20');
INSERT INTO `goods` VALUES ('10100036', '小米自拍杆（线控版）', '一体成型270°旋转设计\r\n', '19元', './images/pj/pj2.jpg', '#', '20');
INSERT INTO `goods` VALUES ('10100037', '小米8 标准钢化玻璃膜', '清透的屏幕色彩，抗磨的屏幕保护', '29元', './images/pj/pj3.jpg', '#', '20');
INSERT INTO `goods` VALUES ('10100038', '红米 5 Plus 标准钢化玻璃膜', '清晰高透 / 全面防护 / 轻松贴合', '29元', './images/pj/pj4.jpg', '#', '20');
INSERT INTO `goods` VALUES ('10100039', '红米4标准版 标准高透贴膜', '硬度大于3H / 高透光，低雾度', '49元', './images/pj/pj5.jpg', '#', '20');
INSERT INTO `goods` VALUES ('10100040', '小米WIFI扩张器', '走到哪里都是wifi的存在', '19元', './images/pj/pj6.jpg', '#', '20');
INSERT INTO `goods` VALUES ('10210211', '小米无线充电器(通用快充版)', '很不错 超级方便 在家没电放上去就行了', '149', 'dp1.jpg', '#', '31');
INSERT INTO `goods` VALUES ('10210212', '小米AI音箱', '>很棒 还想再买好多 能不能给个优惠劵呢?嘿嘿', '299', 'dp2.jpg', '#', '31');
INSERT INTO `goods` VALUES ('10210213', '新小米移动电源2(10000mAh)', '好评', '79', 'dp3.jpg', '#', '31');
INSERT INTO `goods` VALUES ('10210214', '小米移动电源2C(20000mAh)', '完美', '129', 'dp4.jpg', '#', '31');
INSERT INTO `goods` VALUES ('10210215', '小米USB充电器快充版(18W)', '和红米5Plus配在一起充电很快', '29.9', 'dp5.jpg', '#', '31');
INSERT INTO `goods` VALUES ('10210216', '小米移动电源高配版(10000mA...', '买第二个了，非常好用', '149', 'dp6.jpg', '#', '31');
INSERT INTO `goods` VALUES ('10210217', '1MORE四单元圈铁耳机', '小米为发烧而生音质毋庸置疑', '1299', 'dp7.jpg', '#', '31');
INSERT INTO `goods` VALUES ('10210218', '小米头戴式耳机 轻松版', '音质非常好，很震撼！！美美美！', '199', 'dp8.jpg', '#', '31');
INSERT INTO `goods` VALUES ('10210219', '小米双单元半入耳式耳机', '音质非常好，很震撼！！美美美！', '69', 'dp9.jpg', '#', '32');
INSERT INTO `goods` VALUES ('10210220', '小米蓝牙项圈耳机 黑色', '音质非常好，很震撼！！美美美！', '299', 'dp10.jpg', '#', '32');
INSERT INTO `goods` VALUES ('10210221', '小米圈铁耳机2', '音质非常好，很震撼！！美美美！', '99', 'dp11.jpg', '#', '32');
INSERT INTO `goods` VALUES ('10210222', '小米随身蓝牙音箱', '音质非常好，很震撼！！美美美！', '69', 'dp12.jpg', '#', '32');
INSERT INTO `goods` VALUES ('10210223', '小米蓝牙耳机青春版', '音质非常好，很震撼！！美美美！', '59', 'dp13.jpg', '#', '32');
INSERT INTO `goods` VALUES ('10210224', '小米运动蓝牙耳机mini', '音质非常好，很震撼！！美美美！', '169', 'dp14.jpg', '#', '32');
INSERT INTO `goods` VALUES ('10210225', '小米蓝牙音频接收器', '音质非常好，很震撼！！美美美！', '99', 'dp15.jpg', '#', '32');
INSERT INTO `goods` VALUES ('10210226', '1MORE头戴式耳机', '音质非常好，很震撼！！美美美！', '299', 'dp16.jpg', '#', '32');
INSERT INTO `goods` VALUES ('10210227', '小米移动电源10000mAh高配版', '音质非常好，很震撼！！美美美！', '149', 'dp17.jpg', '#', '33');
INSERT INTO `goods` VALUES ('10210228', '小米移动电源2C 20000mAh', '音质非常好，很震撼！！美美美！', '129', 'dp18.jpg', '#', '33');
INSERT INTO `goods` VALUES ('10210229', '小米移动电源5000mAh', '音质非常好，很震撼！！美美美！', '49', 'dp19.jpg', '#', '33');
INSERT INTO `goods` VALUES ('10210230', '小米电源线收纳盒', '音质非常好，很震撼！！美美美！', '49', 'dp20.jpg', '#', '33');
INSERT INTO `goods` VALUES ('10210231', '10000mAh小米移动电源2', '音质非常好，很震撼！！美美美！', '79', 'dp21.jpg', '#', '33');
INSERT INTO `goods` VALUES ('10210232', '小米二合一数据线', '音质非常好，很震撼！！美美美！', '19.9', 'dp22.jpg', '#', '33');
INSERT INTO `goods` VALUES ('10210233', 'USB Type-C充电套装', '音质非常好，很震撼！！美美美！', '15', 'dp23.jpg', '#', '33');
INSERT INTO `goods` VALUES ('10210234', 'ZMI双模智能充电器+充电宝', '音质非常好，很震撼！！美美美！', '109', 'dp24.jpg', '#', '33');
INSERT INTO `goods` VALUES ('10210235', 'SanDisk 32GB存储卡(U3,100...', '音质非常好，很震撼！！美美美！', '129', 'dp25.jpg', '#', '34');
INSERT INTO `goods` VALUES ('10210236', '小米USB充电器(24口)', '音质非常好，很震撼！！美美美！', '39', 'dp26.jpg', '#', '34');
INSERT INTO `goods` VALUES ('10210237', '彩虹5号电池(10粒装)', '音质非常好，很震撼！！美美美！', '9.9', 'dp27.jpg', '#', '34');
INSERT INTO `goods` VALUES ('10210238', '睿米一分二点烟器', '音质非常好，很震撼！！美美美！', '79', 'dp28.jpg', '#', '34');
INSERT INTO `goods` VALUES ('10210239', '小米USB充电器(4口)', '音质非常好，很震撼！！美美美！', '59', 'dp29.jpg', '#', '34');
INSERT INTO `goods` VALUES ('10210240', '小米USB充电器快充版(18W)', '音质非常好，很震撼！！美美美！', '29.9', 'dp30.jpg', '#', '34');
INSERT INTO `goods` VALUES ('10210241', '小米车载充电器', '音质非常好，很震撼！！美美美！', '49', 'dp31.jpg', '#', '34');
INSERT INTO `goods` VALUES ('10210242', '小米USB充电器60W快充版(6口)', '音质非常好，很震撼！！美美美！', '129', 'dp32.jpg', '#', '34');
INSERT INTO `goods` VALUES ('10210243', '米兔定位电话', '非常好用，孩子使用防止沉迷于电话影响学习。做工很好，定位基本准确，通话清晰。如果加入时间显示就更完美...', '169', 'rpcp1.jpg', '#', '23');
INSERT INTO `goods` VALUES ('10210244', '小米插线板', '东西真心不错，用过最好用的插线板，做工外观没得挑剔，3个USB接口很实用，充电快，建议不包邮的应该在....', '49', 'rpcp2.jpg', '#', '23');
INSERT INTO `goods` VALUES ('10210245', '米家压力IH电饭煲', '包装很让人感动，式样也很可爱，做出的饭全家人都爱吃，超爱五星！手机控制还是不太熟练，最主要是没有连接...', '999', 'rpcp3.jpg', '#', '23');
INSERT INTO `goods` VALUES ('10210246', '米兔智能故事机', '非常可爱，一拿到小宝宝还没享受，一帮大宝宝先high了一把，同事也想买，希望早点大卖', '199', 'rpcp4.jpg', '#', '23');
INSERT INTO `goods` VALUES ('10210248', '哈利·波特与被诅咒的孩子', '“哈利·波特”第八个故事中文版震撼来<br>袭！特别彩排版剧本！ ', '29.37元', 'content1.png', '#', '24');
INSERT INTO `goods` VALUES ('10210249', '蚁人2', '小米主题和迪士尼首度合作，打造精<br>品漫威系列主题', '', 'content2.png', '#', '24');
INSERT INTO `goods` VALUES ('10210250', '米柚手游模拟器', '在电脑上玩遍小米所有手游', '', 'content3.png', '#', '24');
INSERT INTO `goods` VALUES ('10210251', '2017金米奖', '最优秀的应用和游戏', '', 'content4.png', '#', '24');
INSERT INTO `goods` VALUES ('10300001', '小米路由器3', '四天线设计，更安全更稳定', '119', 'znyj1.jpg', '#', '19');
INSERT INTO `goods` VALUES ('10300002', '小米路由器3', '四天线设计，更安全更稳定', '129', 'znyj2.jpg', '#', '19');
INSERT INTO `goods` VALUES ('10300003', '小米路由器3', '四天线设计，更安全更稳定', '139', 'znyj3.jpg', '#', '19');
INSERT INTO `goods` VALUES ('10300004', '小米路由器3', '四天线设计，更安全更稳定', '149', 'znyj4.jpg', '#', '19');
INSERT INTO `goods` VALUES ('10300005', '小米路由器3', '四天线设计，更安全更稳定', '159', 'znyj5.jpg', '#', '19');
INSERT INTO `goods` VALUES ('10300006', '小米路由器3', '四天线设计，更安全更稳定', '169', 'znyj6.jpg', '#', '19');
INSERT INTO `goods` VALUES ('10300007', '小米路由器3', '四天线设计，更安全更稳定', '179', 'znyj7.jpg', '#', '19');
INSERT INTO `goods` VALUES ('10300008', '小米路由器3', '四天线设计，更安全更稳定', '189', 'znyj8.png', '#', '19');
INSERT INTO `goods` VALUES ('10300101', '小米电视3S 43英寸', '4GB内存+128GB闪存，陶瓷版', '2199', 'single1.png', '#', '17');
INSERT INTO `goods` VALUES ('10300102', '小米电视3S 43英寸', '4GB内存+128GB闪存，陶瓷版', '2299', 'single2.png', '#', '17');
INSERT INTO `goods` VALUES ('10300103', '小米电视3S 43英寸', '4GB内存+128GB闪存，陶瓷版', '2399', 'single3.png', '#', '17');
INSERT INTO `goods` VALUES ('10300104', '小米电视3S 43英寸', '4GB内存+128GB闪存，陶瓷版', '5499', 'single4.png', '#', '17');
INSERT INTO `goods` VALUES ('10300105', '小米电视3S 43英寸', '4GB内存+128GB闪存，陶瓷版', '4599', 'single5.jpg', '#', '17');
INSERT INTO `goods` VALUES ('10300106', '小米电视3S 43英寸', '4GB内存+128GB闪存，陶瓷版', '1699', 'single6.png', '#', '17');
INSERT INTO `goods` VALUES ('10300107', '小米电视3S 43英寸', '4GB内存+128GB闪存，陶瓷版', '1799', 'single7.png', '#', '17');
INSERT INTO `goods` VALUES ('10300108', '小米电视3S 43英寸', '4GB内存+128GB闪存，陶瓷版', '1899', 'single8.png', '#', '17');
INSERT INTO `goods` VALUES ('10300109', '小米电视3S 43英寸', '4GB内存+128GB闪存，陶瓷版', '1999', 'single9.jpg', '#', '17');
INSERT INTO `goods` VALUES ('10300110', '小米电视3S 43英寸', '4GB内存+128GB闪存，陶瓷版', '2099', 'single10.png', '#', '17');
INSERT INTO `goods` VALUES ('10300201', '小米路由器3', '9000人好评', '199', 'wntj1.jpg', '#', '22');
INSERT INTO `goods` VALUES ('10300202', '小米路由器3', '9000人好评', '209', 'wntj2.jpg', '#', '22');
INSERT INTO `goods` VALUES ('10300203', '小米路由器3', '9000人好评', '219', 'wntj3.jpg', '#', '22');
INSERT INTO `goods` VALUES ('10300204', '小米路由器3', '9000人好评', '149', 'wntj4.jpg', '#', '22');
INSERT INTO `goods` VALUES ('10300205', '小米路由器3', '9000人好评', '149', 'wntj5.jpg', '#', '22');
INSERT INTO `goods` VALUES ('10300206', '小米路由器3', '9000人好评', '149', 'wntj6.jpg', '#', '22');
INSERT INTO `goods` VALUES ('10300207', '小米路由器3', '9000人好评', '149', 'wntj7.jpg', '#', '22');
INSERT INTO `goods` VALUES ('10300208', '小米路由器3', '9000人好评', '149', 'wntj8.jpg', '#', '22');
INSERT INTO `goods` VALUES ('10300209', '小米路由器3', '9000人好评', '149', 'wntj9.jpg', '#', '22');
INSERT INTO `goods` VALUES ('10300210', '小米路由器3', '9000人好评', '149', 'wntj10.jpg', '#', '22');
INSERT INTO `goods` VALUES ('10300301', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb1.jpg', '#', '26');
INSERT INTO `goods` VALUES ('10300302', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb2.jpg', '#', '26');
INSERT INTO `goods` VALUES ('10300303', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb3.jpg', '#', '26');
INSERT INTO `goods` VALUES ('10300304', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb4.jpg', '#', '26');
INSERT INTO `goods` VALUES ('10300305', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb5.jpg', '#', '26');
INSERT INTO `goods` VALUES ('10300306', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb6.jpg', '#', '26');
INSERT INTO `goods` VALUES ('10300307', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb6.jpg', '#', '27');
INSERT INTO `goods` VALUES ('10300308', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb5.jpg', '#', '27');
INSERT INTO `goods` VALUES ('10300309', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb4.jpg', '#', '27');
INSERT INTO `goods` VALUES ('10300310', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb3.jpg', '#', '27');
INSERT INTO `goods` VALUES ('10300311', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb2.jpg', '#', '27');
INSERT INTO `goods` VALUES ('10300312', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb1.jpg', '#', '27');
INSERT INTO `goods` VALUES ('10300313', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb5.jpg', '#', '28');
INSERT INTO `goods` VALUES ('10300314', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb1.jpg', '#', '28');
INSERT INTO `goods` VALUES ('10300315', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb3.jpg', '#', '28');
INSERT INTO `goods` VALUES ('10300316', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb2.jpg', '#', '28');
INSERT INTO `goods` VALUES ('10300317', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb4.jpg', '#', '28');
INSERT INTO `goods` VALUES ('10300318', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb6.jpg', '#', '28');
INSERT INTO `goods` VALUES ('10300319', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb1.jpg', '#', '29');
INSERT INTO `goods` VALUES ('10300320', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb5.jpg', '#', '29');
INSERT INTO `goods` VALUES ('10300321', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb4.jpg', '#', '29');
INSERT INTO `goods` VALUES ('10300322', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb6.jpg', '#', '29');
INSERT INTO `goods` VALUES ('10300323', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb2.jpg', '#', '29');
INSERT INTO `goods` VALUES ('10300324', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb3.jpg', '#', '29');
INSERT INTO `goods` VALUES ('10300325', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb3.jpg', '#', '30');
INSERT INTO `goods` VALUES ('10300326', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb4.jpg', '#', '30');
INSERT INTO `goods` VALUES ('10300327', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb6.jpg', '#', '30');
INSERT INTO `goods` VALUES ('10300328', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb5.jpg', '#', '30');
INSERT INTO `goods` VALUES ('10300329', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb1.jpg', '#', '30');
INSERT INTO `goods` VALUES ('10300330', '小米路由器3', '四天线设计，更安全更稳定', '149', 'zb2.jpg', '#', '30');
INSERT INTO `goods` VALUES ('10300601', '小米6', '小米6全网通6GB内存+64GB 亮黑色', '2499', 'xiaomiqingchun-320.jpg', '#', '1');
INSERT INTO `goods` VALUES ('10300602', '小米6', '小米6全网通6GB内存+64GB 亮黑色', '2499', 'xiaomix2s.jpg', '#', '1');
INSERT INTO `goods` VALUES ('10300603', '小米6', '小米6全网通6GB内存+64GB 亮黑色', '2499', 'xiaomiqingchun-320.jpg', '#', '1');
INSERT INTO `goods` VALUES ('10300604', '小米6', '小米6全网通6GB内存+64GB 亮黑色', '2499', 'xiaomiqingchun-320.jpg', '#', '1');
INSERT INTO `goods` VALUES ('10408001', '小米8青春版', null, null, 'index_sidenav_img1.png', '#', '8');
INSERT INTO `goods` VALUES ('10408002', '小米8屏幕指纹版', null, null, 'index_sidenav_img2.png', '#', '8');
INSERT INTO `goods` VALUES ('10408003', '小米8', null, null, 'index_sidenav_img3.png', '#', '8');
INSERT INTO `goods` VALUES ('10408004', '小米8 SE', null, null, 'index_sidenav_img4.png', '#', '8');
INSERT INTO `goods` VALUES ('10408005', '小米MIX 2S', null, null, 'index_sidenav_img5.png', '#', '8');
INSERT INTO `goods` VALUES ('10408006', '小米Max 3', null, null, 'index_sidenav_img6.png', '#', '8');
INSERT INTO `goods` VALUES ('10408007', '小米6X', null, null, 'index_sidenav_img7.png', '#', '8');
INSERT INTO `goods` VALUES ('10408008', '黑鲨游戏手机', null, null, 'index_sidenav_img8.png', '#', '8');
INSERT INTO `goods` VALUES ('10408009', '小米MIX 2', null, null, 'index_sidenav_img9.png', '#', '8');
INSERT INTO `goods` VALUES ('10408010', '小米Max 2', null, null, 'index_sidenav_img10.png', '#', '8');
INSERT INTO `goods` VALUES ('10408011', '红米6 Pro', '红米6 Pro 标配版 3GB内存+32GB白色', '1499', 'images/detail_main1.jpg', '#', '8');
INSERT INTO `goods` VALUES ('10408012', '红米6', null, null, 'index_sidenav_img12.png', '#', '8');
INSERT INTO `goods` VALUES ('10409001', '小米笔记本 15.6\"', null, null, 'index_sidenav_notebook1.png', '#', '9');
INSERT INTO `goods` VALUES ('10409002', '小米笔记本 13.3\"', null, null, 'index_sidenav_notebook2.png', '#', '9');
INSERT INTO `goods` VALUES ('10409003', '小米笔记本 12.5\"', null, null, 'index_sidenav_notebook3.png', '#', '9');
INSERT INTO `goods` VALUES ('10409004', '小米游戏本', null, null, 'index_sidenav_notebook4.png', '#', '9');
INSERT INTO `goods` VALUES ('10409005', '小米平板4', null, null, 'index_sidenav_notebook5.png', '#', '9');
INSERT INTO `goods` VALUES ('10409006', '键盘', null, null, 'index_sidenav_notebook6.png', '#', '9');
INSERT INTO `goods` VALUES ('10409007', '鼠标／鼠标垫', null, null, 'index_sidenav_notebook7.png', '#', '9');
INSERT INTO `goods` VALUES ('10409008', '转接器', null, null, 'index_sidenav_notebook8.png', '#', '9');
INSERT INTO `goods` VALUES ('10410001', '路由器', null, null, 'index_sidenav_vr1.png', '#', '10');
INSERT INTO `goods` VALUES ('10410002', '对讲机', null, null, 'index_sidenav_vr2.png', '#', '10');
INSERT INTO `goods` VALUES ('10410003', '智能家庭', null, null, 'index_sidenav_vr3.png', '#', '10');
INSERT INTO `goods` VALUES ('10410004', '无人机', null, null, 'index_sidenav_vr4.png', '#', '10');
INSERT INTO `goods` VALUES ('10410005', '摄像机', null, null, 'index_sidenav_vr5.png', '#', '10');
INSERT INTO `goods` VALUES ('10411001', '移动电源', null, null, 'index_sidenav_power1.jpg', '#', '11');
INSERT INTO `goods` VALUES ('10411002', '数据线', null, null, 'index_sidenav_power2.jpg', '#', '11');
INSERT INTO `goods` VALUES ('10411003', '车充', null, null, 'index_sidenav_power3.jpg', '#', '11');
INSERT INTO `goods` VALUES ('10411004', '充电器', null, null, 'index_sidenav_power4.jpg', '#', '11');
INSERT INTO `goods` VALUES ('10411005', '无线充', null, null, 'index_sidenav_power5.jpg', '#', '11');
INSERT INTO `goods` VALUES ('10411006', '电池', null, null, 'index_sidenav_power6.jpg', '#', '11');
INSERT INTO `goods` VALUES ('10411007', '自拍杆', null, null, 'index_sidenav_power7.jpg', '#', '11');
INSERT INTO `goods` VALUES ('10411008', '存储卡', null, null, 'index_sidenav_power8.jpg', '#', '11');
INSERT INTO `goods` VALUES ('10411009', '手机壳', null, null, 'index_sidenav_power9.jpg', '#', '11');
INSERT INTO `goods` VALUES ('10411010', '手机贴膜', null, null, 'index_sidenav_power10.jpg', '#', '11');
INSERT INTO `goods` VALUES ('10411011', '手机支架', null, null, 'index_sidenav_power11.jpg', '#', '11');
INSERT INTO `goods` VALUES ('10411012', '平板配件', null, null, 'index_sidenav_power12.jpg', '#', '11');
INSERT INTO `goods` VALUES ('10412001', '线控耳机', null, null, 'index_sidenav_earphone1.jpg', '#', '12');
INSERT INTO `goods` VALUES ('10412002', '蓝牙耳机', null, null, 'index_sidenav_earphone2.jpg', '#', '12');
INSERT INTO `goods` VALUES ('10412003', '头戴耳机', null, null, 'index_sidenav_earphone3.jpg', '#', '12');
INSERT INTO `goods` VALUES ('10412004', '品牌耳机', null, null, 'index_sidenav_earphone4.jpg', '#', '12');
INSERT INTO `goods` VALUES ('10412005', '蓝牙音箱', null, null, 'index_sidenav_earphone5.jpg', '#', '12');
INSERT INTO `goods` VALUES ('10413001', '保护套 保护壳', null, null, 'index_sidenav_protect1.jpg', '#', '13');
INSERT INTO `goods` VALUES ('10413002', '保护套 保护壳', null, null, 'index_sidenav_protect1.jpg', '#', '13');
INSERT INTO `goods` VALUES ('10414001', '自拍杆', null, null, 'index_sidenav_pole1.jpg', '#', '14');
INSERT INTO `goods` VALUES ('10414002', '黑鲨配件', null, null, 'index_sidenav_pole2.jpg', '#', '14');
INSERT INTO `goods` VALUES ('10414003', '其他配件', null, null, 'index_sidenav_pole3.jpg', '#', '14');
INSERT INTO `goods` VALUES ('10415001', '米兔', null, null, 'index_sidenav_rubit1.jpg', '#', '15');
INSERT INTO `goods` VALUES ('10416001', '双肩包', null, null, 'index_sidenav_bag1.jpg', '#', '16');
INSERT INTO `goods` VALUES ('10416002', '钱包', null, null, 'index_sidenav_bag2.jpg', '#', '16');
INSERT INTO `goods` VALUES ('10416003', '口罩', null, null, 'index_sidenav_bag3.jpg', '#', '16');
INSERT INTO `goods` VALUES ('10416004', '收纳包', null, null, 'index_sidenav_bag4.jpg', '#', '16');
INSERT INTO `goods` VALUES ('10416005', '旅行箱', null, null, 'index_sidenav_bag5.jpg', '#', '16');
INSERT INTO `goods` VALUES ('10418001', '米家激光投影电视', null, null, 'index_sidenav_tv1.png', '#', '18');
INSERT INTO `goods` VALUES ('10418002', '小米电视4A 32英寸', null, null, 'index_sidenav_tv2.png', '#', '18');
INSERT INTO `goods` VALUES ('10418003', '小米电视4A 40英寸', null, null, 'index_sidenav_tv3.png', '#', '18');
INSERT INTO `goods` VALUES ('10418004', '小米电视4A 43英寸青春版', null, null, 'index_sidenav_tv4.png', '#', '18');
INSERT INTO `goods` VALUES ('10418005', '小米电视4A 50英寸', null, null, 'index_sidenav_tv5.png', '#', '18');
INSERT INTO `goods` VALUES ('10418006', '小米电视4A 55英寸', null, null, 'index_sidenav_tv6.png', '#', '18');
INSERT INTO `goods` VALUES ('10418007', '小米电视4A 58英寸', null, null, 'index_sidenav_tv7.png', '#', '18');
INSERT INTO `goods` VALUES ('10418008', '小米盒子', null, null, 'index_sidenav_tv8.png', '#', '18');

-- ----------------------------
-- Table structure for goods_color
-- ----------------------------
DROP TABLE IF EXISTS `goods_color`;
CREATE TABLE `goods_color` (
  `goods_id` int(11) NOT NULL,
  `color_id` int(11) NOT NULL,
  PRIMARY KEY (`goods_id`,`color_id`),
  KEY `goods_color_color_id-color_id` (`color_id`),
  CONSTRAINT `goods_color_color_id-color_id` FOREIGN KEY (`color_id`) REFERENCES `color` (`color_id`),
  CONSTRAINT `good_color_goods_id-goods_id` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of goods_color
-- ----------------------------
INSERT INTO `goods_color` VALUES ('10100005', '1');
INSERT INTO `goods_color` VALUES ('10408011', '1');
INSERT INTO `goods_color` VALUES ('10100005', '2');
INSERT INTO `goods_color` VALUES ('10408011', '2');
INSERT INTO `goods_color` VALUES ('10100005', '3');
INSERT INTO `goods_color` VALUES ('10408011', '3');

-- ----------------------------
-- Table structure for goods_edition
-- ----------------------------
DROP TABLE IF EXISTS `goods_edition`;
CREATE TABLE `goods_edition` (
  `goods_id` int(11) NOT NULL COMMENT '商品id',
  `edition_id` int(11) NOT NULL COMMENT '版本id',
  `price_id` int(11) NOT NULL,
  PRIMARY KEY (`goods_id`,`edition_id`),
  KEY `hoods_edition_edition_id-edition_id` (`edition_id`),
  KEY `fk_price_id` (`price_id`),
  CONSTRAINT `fk_price_id` FOREIGN KEY (`price_id`) REFERENCES `goods_price` (`id`),
  CONSTRAINT `goods_edition_goods_id-goods_id` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `hoods_edition_edition_id-edition_id` FOREIGN KEY (`edition_id`) REFERENCES `edition` (`edition_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of goods_edition
-- ----------------------------
INSERT INTO `goods_edition` VALUES ('10100005', '1', '1');
INSERT INTO `goods_edition` VALUES ('10408011', '1', '1');
INSERT INTO `goods_edition` VALUES ('10100005', '2', '2');
INSERT INTO `goods_edition` VALUES ('10408011', '2', '2');

-- ----------------------------
-- Table structure for goods_price
-- ----------------------------
DROP TABLE IF EXISTS `goods_price`;
CREATE TABLE `goods_price` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of goods_price
-- ----------------------------
INSERT INTO `goods_price` VALUES ('1', '1499');
INSERT INTO `goods_price` VALUES ('2', '1999');

-- ----------------------------
-- Table structure for goods_type
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型ID',
  `type_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of goods_type
-- ----------------------------
INSERT INTO `goods_type` VALUES ('1', '小米手机');
INSERT INTO `goods_type` VALUES ('2', '红米');
INSERT INTO `goods_type` VALUES ('3', '平板笔记本');
INSERT INTO `goods_type` VALUES ('4', '电视');
INSERT INTO `goods_type` VALUES ('5', '盒子影音');
INSERT INTO `goods_type` VALUES ('6', '路由器');
INSERT INTO `goods_type` VALUES ('7', '智能硬件nva');
INSERT INTO `goods_type` VALUES ('8', '手机平板电话');
INSERT INTO `goods_type` VALUES ('9', '笔记本');
INSERT INTO `goods_type` VALUES ('10', '路由器智能硬件');
INSERT INTO `goods_type` VALUES ('11', '移动电源电池');
INSERT INTO `goods_type` VALUES ('12', '耳机音箱');
INSERT INTO `goods_type` VALUES ('13', '保护套后盖');
INSERT INTO `goods_type` VALUES ('14', '贴膜其他配件');
INSERT INTO `goods_type` VALUES ('15', '米兔服装');
INSERT INTO `goods_type` VALUES ('16', '箱包其他周边');
INSERT INTO `goods_type` VALUES ('17', '小米明星单品');
INSERT INTO `goods_type` VALUES ('18', '电视盒子');
INSERT INTO `goods_type` VALUES ('19', '智能硬件');
INSERT INTO `goods_type` VALUES ('20', '\r\n配件');
INSERT INTO `goods_type` VALUES ('22', '\r\n为你推荐');
INSERT INTO `goods_type` VALUES ('23', '热评产品');
INSERT INTO `goods_type` VALUES ('24', '\r\n内容');
INSERT INTO `goods_type` VALUES ('25', '\r\n视频');
INSERT INTO `goods_type` VALUES ('26', '\r\n\r\n周边热门');
INSERT INTO `goods_type` VALUES ('27', '\r\n周边服装');
INSERT INTO `goods_type` VALUES ('28', '\r\n周边米兔');
INSERT INTO `goods_type` VALUES ('29', '\r\n周边生活周边');
INSERT INTO `goods_type` VALUES ('30', '\r\n周边箱包');
INSERT INTO `goods_type` VALUES ('31', '搭配热门');
INSERT INTO `goods_type` VALUES ('32', '搭配耳机音象');
INSERT INTO `goods_type` VALUES ('33', '搭配电源');
INSERT INTO `goods_type` VALUES ('34', '搭配电池存储卡');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品ID',
  `order_number` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '订单编号',
  `price` varchar(222) COLLATE utf8_bin DEFAULT NULL COMMENT '价格',
  `trading_hour` date DEFAULT NULL COMMENT '交易时间',
  `state_id` int(11) DEFAULT NULL COMMENT '状态ID',
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_state_id-state_id` (`state_id`),
  KEY `order_goods_id-state_id` (`goods_id`),
  KEY `order_user_id-user_id` (`user_id`),
  CONSTRAINT `order_goods_id-state_id` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `order_state_id-state_id` FOREIGN KEY (`state_id`) REFERENCES `trading_state` (`trading_id`),
  CONSTRAINT `order_user_id-user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10300524 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '10100000', '1', '￥2499.00', '2018-10-24', '1', '1');
INSERT INTO `orders` VALUES ('2', '10100001', '1', '￥2499.00', '2018-10-24', '1', '1');
INSERT INTO `orders` VALUES ('5', '10100002', '1', '￥2499.00', '2018-10-24', '1', '1');
INSERT INTO `orders` VALUES ('10300501', '10300601', '181023001045567', '2499', '2018-10-23', '1', '1245');
INSERT INTO `orders` VALUES ('10300502', '10300602', '181023001026545', '2499', '2018-10-22', '1', '1245');
INSERT INTO `orders` VALUES ('10300507', '10300602', '53f12167-788e-4929-9e45-a53b4242865e', '2499', '2018-11-01', '1', '1245');
INSERT INTO `orders` VALUES ('10300508', '10300604', '7c874666-4c79-43ff-9a0c-29c7b60ced45', '12495', '2018-11-01', '1', '1245');
INSERT INTO `orders` VALUES ('10300509', '10300603', 'fe98f2d5-be68-4564-83c9-228a2d422f70', '4998', '2018-11-01', '1', '1245');
INSERT INTO `orders` VALUES ('10300510', '10300604', '4522144a-e5c9-4d42-87ce-1c3e0fd3000a', '12495', '2018-11-01', '1', '1245');
INSERT INTO `orders` VALUES ('10300511', '10300604', '94c20050-70f9-4553-b8b2-dd89809c5501', '12495', '2018-11-01', '1', '1245');
INSERT INTO `orders` VALUES ('10300512', '10300604', '985dfaa1-5161-4dfa-bc66-78caec354460', '12495', '2018-11-01', '1', '1245');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `picture_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片路径',
  `uploadtime` date DEFAULT NULL COMMENT '上传时间',
  `goods_id` int(11) DEFAULT NULL,
  `no` int(11) DEFAULT NULL,
  PRIMARY KEY (`picture_id`),
  KEY `pic_goods_id-goods_id` (`goods_id`),
  CONSTRAINT `pic_goods_id-goods_id` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES ('1', './images/detail_slider1.jpg', '2018-11-01', '10100005', '1');
INSERT INTO `picture` VALUES ('2', './images/detail_slider2.jpg', null, '10100005', '2');
INSERT INTO `picture` VALUES ('3', './images/detail_slider3.jpg', null, '10100005', '3');
INSERT INTO `picture` VALUES ('4', './images/detail_slider4.jpg', '2018-11-01', '10100005', '4');
INSERT INTO `picture` VALUES ('7', 'images/realize1.jpg', null, '10100005', '5');
INSERT INTO `picture` VALUES ('8', 'images/protect1.jpg', null, '10100005', '6');
INSERT INTO `picture` VALUES ('9', 'images/realize1.jpg', null, '10100005', '7');

-- ----------------------------
-- Table structure for trading_state
-- ----------------------------
DROP TABLE IF EXISTS `trading_state`;
CREATE TABLE `trading_state` (
  `trading_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '状态ID',
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`trading_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of trading_state
-- ----------------------------
INSERT INTO `trading_state` VALUES ('1', '未支付');
INSERT INTO `trading_state` VALUES ('2', '未接单');
INSERT INTO `trading_state` VALUES ('3', '未发货');
INSERT INTO `trading_state` VALUES ('4', '已发货');
INSERT INTO `trading_state` VALUES ('5', '已签收');
INSERT INTO `trading_state` VALUES ('6', '已完成');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_account` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户帐号',
  `user_nickname` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号码',
  `personalized_signature` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '个性签名',
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `hobby` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '爱好',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '收货地址',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10400011 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '没鸡的男人', '123456', '123456', null, null, '篮球', '广东省陆丰市');
INSERT INTO `user` VALUES ('1245', 'system', '张三1', '123456', '1342156132', '您还没设置个性签名', '2439490223', '看直播', '广东广州');
INSERT INTO `user` VALUES ('10402', '1', '2', '3', '4', '5', null, '6', '7');
INSERT INTO `user` VALUES ('10400001', '123', '张三', '123456', '13417661263', null, null, '', '广东');
INSERT INTO `user` VALUES ('10400002', '123', '张三', '123456', '13417661263', null, null, '', '广东');
INSERT INTO `user` VALUES ('10400003', null, '201602100432', '123456', null, null, null, null, null);
INSERT INTO `user` VALUES ('10400004', null, '张学良', '123456', null, null, null, null, null);
INSERT INTO `user` VALUES ('10400005', null, '2016', '123456', null, null, null, null, null);
INSERT INTO `user` VALUES ('10400006', null, '123456', '123456', null, null, null, null, null);
INSERT INTO `user` VALUES ('10400007', null, '张学良', '123456', null, null, null, null, null);
INSERT INTO `user` VALUES ('10400008', null, '201602100432', '123456', null, null, null, null, null);
INSERT INTO `user` VALUES ('10400009', null, '张学良', '123456', null, null, null, null, null);
INSERT INTO `user` VALUES ('10400010', 'admin123', '李四', '123456', '1341451533', '您还没设置个性签名', '2439490223@qq.com', '国足是我的信仰', '广东');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `uploadtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of video
-- ----------------------------

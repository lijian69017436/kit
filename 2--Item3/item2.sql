/*
MySQL Data Transfer
Source Host: localhost
Source Database: item2
Target Host: localhost
Target Database: item2
Date: 2014/10/8 17:42:53
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for buydocument
-- ----------------------------
CREATE TABLE `buydocument` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `orderid` varchar(50) DEFAULT NULL,
  `codes` varchar(50) DEFAULT NULL,
  `providername` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `linkman` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `times` varchar(50) DEFAULT NULL,
  `checks` varchar(50) DEFAULT NULL,
  `emails` varchar(50) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `types` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for clientmanagement
-- ----------------------------
CREATE TABLE `clientmanagement` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `names` varchar(50) DEFAULT NULL,
  `propertys` varchar(50) DEFAULT NULL,
  `deliver` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `supply` varchar(50) DEFAULT NULL,
  `review` varchar(50) DEFAULT NULL,
  `contractcode` varchar(50) DEFAULT NULL,
  `charter` varchar(50) DEFAULT NULL,
  `payment` varchar(50) DEFAULT NULL,
  `appointment` varchar(50) DEFAULT NULL,
  `express` varchar(50) DEFAULT NULL,
  `contractleave` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for exportclient
-- ----------------------------
CREATE TABLE `exportclient` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `clientnumber` varchar(50) DEFAULT NULL,
  `clientaddress` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `dates` varchar(50) DEFAULT NULL,
  `names` varchar(50) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `sales` varchar(50) DEFAULT NULL,
  `linkman` varchar(50) DEFAULT NULL,
  `checks` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for guestorder
-- ----------------------------
CREATE TABLE `guestorder` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `guestcode` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `times` varchar(50) DEFAULT NULL,
  `froms` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `linkman` varchar(50) DEFAULT NULL,
  `checks` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for instoredocument
-- ----------------------------
CREATE TABLE `instoredocument` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `intime` varchar(50) DEFAULT NULL,
  `storetype` varchar(50) DEFAULT NULL,
  `inman` varchar(50) DEFAULT NULL,
  `notes` varchar(50) DEFAULT NULL,
  `documentname` varchar(50) DEFAULT NULL,
  `checks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for outstoredocument
-- ----------------------------
CREATE TABLE `outstoredocument` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `outtime` varchar(50) DEFAULT NULL,
  `storetype` varchar(50) DEFAULT NULL,
  `outman` varchar(50) DEFAULT NULL,
  `notes` varchar(50) DEFAULT NULL,
  `documentname` varchar(50) DEFAULT NULL,
  `checks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for paymentincase
-- ----------------------------
CREATE TABLE `paymentincase` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `plid` varchar(50) DEFAULT NULL,
  `companycode` varchar(50) DEFAULT NULL,
  `clientcode` varchar(50) DEFAULT NULL,
  `numbers` varchar(50) DEFAULT NULL,
  `suttle` varchar(50) DEFAULT NULL,
  `grossweight` varchar(50) DEFAULT NULL,
  `sizes` varchar(50) DEFAULT NULL,
  `documentname` varchar(50) DEFAULT NULL,
  `checks` varchar(50) DEFAULT NULL,
  `times` varchar(50) DEFAULT NULL,
  `getid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for produceproduct
-- ----------------------------
CREATE TABLE `produceproduct` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `orderid` varchar(50) DEFAULT NULL,
  `productcode` varchar(50) DEFAULT NULL,
  `productname` varchar(50) DEFAULT NULL,
  `guige` varchar(50) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `totals` varchar(50) DEFAULT NULL,
  `unit` varchar(50) DEFAULT NULL,
  `moneytype` varchar(50) DEFAULT NULL,
  `suttle` varchar(50) DEFAULT NULL,
  `discount` varchar(50) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  `money` varchar(50) DEFAULT NULL,
  `fullmoney` varchar(50) DEFAULT NULL,
  `sizes` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for storymanagement
-- ----------------------------
CREATE TABLE `storymanagement` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `names` varchar(50) DEFAULT NULL,
  `types` varchar(50) DEFAULT NULL,
  `discrib` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `buydocument` VALUES ('4', '1', '3', '3', '3', '132', '3', '33232', null, '123', '3', '132');
INSERT INTO `buydocument` VALUES ('5', '2', '3', '3', '3', '3', '3', '3', null, '3', '3', '3');
INSERT INTO `buydocument` VALUES ('6', 'p01', 'dd', '北京', '密云', '2', '1500106225', '2014-10-1', null, '22@qq。com', '2', '2');
INSERT INTO `clientmanagement` VALUES ('1', '大大', 'Others', '司', '的', '的', '2014-10-2', 'con', 'dd', '五', null, '无', '我', '北京');
INSERT INTO `clientmanagement` VALUES ('2', '3', '3', '3', '3', '3', '3', null, '3', '3', '3', '3', '3', '2');
INSERT INTO `clientmanagement` VALUES ('3', '3', 'Others', '3', '3', 'dd', '3', null, '', 'd', 'd', 'd', 'd', 'd');
INSERT INTO `clientmanagement` VALUES ('4', '4', 'Brands', '4', '4', '4', '4', null, '', 'con', '4', '4', '4', 'dddd');
INSERT INTO `clientmanagement` VALUES ('6', '3', 'Others', '3', '3', '3', '3', 'con', '3', '3', null, '3', '3', '3');
INSERT INTO `exportclient` VALUES ('1', '李健', '北京', '100', '2014-10-1', '哈利波特', '22', '33', '你好', null);
INSERT INTO `exportclient` VALUES ('2', '3', '', '3', '3', '3', '3', '3', '3', null);
INSERT INTO `exportclient` VALUES ('3', '3      ', '3', '3', '3', '3', '3', '3', '2', null);
INSERT INTO `exportclient` VALUES ('4', '3333333', '3', '3', '3', '3', '3', '3', '3', null);
INSERT INTO `exportclient` VALUES ('6', '2 ', '2', '3', '32', '3', '3', '3', '3', null);
INSERT INTO `exportclient` VALUES ('7', '5', '5', '5', '5', '5', '5', '5', '5', null);
INSERT INTO `exportclient` VALUES ('9', '2 ', '', '2', '2', '2', '2', '33', '2', null);
INSERT INTO `guestorder` VALUES ('2', '2', '2', '22', '22', '3', '3', '3', '3');
INSERT INTO `guestorder` VALUES ('3', '2', '3', '3', '3', '3', '3', '3', '3');
INSERT INTO `guestorder` VALUES ('5', '3', '5', '5', '5', '5', '5', '李健', null);
INSERT INTO `guestorder` VALUES ('8', '4', '4', '4', '4', '4', '4', '4', null);
INSERT INTO `guestorder` VALUES ('10', '3', '3', '3', '3', '3', '3', '3', null);
INSERT INTO `instoredocument` VALUES ('4', '4', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('5', '5', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('6', '6', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('7', '7', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('8', '8', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('9', '9', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('10', '10', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('11', '11', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('12', '12', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('13', '13', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('14', '14', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('15', '15', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('16', '16', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('17', '17', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('18', '18', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('19', '19', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('20', '20', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('21', '21', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('22', '22', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('23', '23', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('24', '24', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('25', '25', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('26', '26', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('27', '27', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('28', '28', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('29', '29', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('30', '30', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('31', '31', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('32', '32', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('33', '33', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('34', '34', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('35', '35', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('36', '36', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('37', '37', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('38', '38', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('39', '39', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('40', '40', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('41', '41', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('42', '42', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('43', '43', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('44', '44', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('45', '45', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('46', '46', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('47', '47', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('48', '48', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('49', '49', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `instoredocument` VALUES ('50', '50', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('4', '4', 'B', 'e', 't', 'r', 'ss');
INSERT INTO `outstoredocument` VALUES ('5', '5', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('6', '6', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('7', '7', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('8', '8', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('9', '9', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('10', '10', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('11', '11', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('12', '12', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('13', '13', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('14', '14', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('15', '15', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('16', '16', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('17', '17', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('18', '18', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('19', '19', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('20', '20', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('21', '21', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('22', '22', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('23', '23', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('24', '24', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('25', '25', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('26', '26', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('27', '27', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('28', '28', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('29', '29', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('30', '30', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('31', '31', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('32', '32', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('33', '33', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('34', '34', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('35', '35', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('36', '36', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('37', '37', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('38', '38', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('39', '39', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('40', '40', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('41', '41', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('42', '42', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('43', '43', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('44', '44', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('45', '45', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('46', '46', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('47', '47', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('48', '48', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('49', '49', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `outstoredocument` VALUES ('50', '50', 'A', 'e', 'r', 't', 'ss');
INSERT INTO `paymentincase` VALUES ('1', '2', '2', '2', '2', '2', '3', '3', '3j', 'k3h', 'j3h', 'h3kj');
INSERT INTO `paymentincase` VALUES ('3', null, null, 'kjh3', 'h3', 'kj3h', 'kj3h', 'k3h', 'k3h', 'k3', 'jkh3', null);
INSERT INTO `paymentincase` VALUES ('5', null, ';l', 'lk', 'klk', 'lk', 'lk', 'lk', 'k', 'lk', 'lk', 'klk');
INSERT INTO `paymentincase` VALUES ('6', 'k', 'lklk', 'l', 'lk', 'lk', 'lk', 'lk', 'klk', 'lk', 'lk', 'lk');
INSERT INTO `paymentincase` VALUES ('7', 'k', 'lk', 'klk', null, 'n', 'nm', null, null, 'yiu', 'oi', 'po');
INSERT INTO `paymentincase` VALUES ('8', null, 'kj', 'kn', 'j', null, 'h', 'h', 'j', 'hj', 'kj', null);
INSERT INTO `paymentincase` VALUES ('9', '23', '3', '3', '3', '3', '3', '3', '', null, null, null);
INSERT INTO `paymentincase` VALUES ('10', '3', '3', '3', '3', '3', '3', '3', '', null, null, null);
INSERT INTO `produceproduct` VALUES ('1', '2', '23', '3', '你好', '3', '3', '3', '3', '3', '3', '33', '', '', '22');
INSERT INTO `produceproduct` VALUES ('2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3');
INSERT INTO `produceproduct` VALUES ('4', '4', '5', '5', '5', '5', '3', '3', '3', '3', '3', '3', '3', '3', '3');
INSERT INTO `produceproduct` VALUES ('5', '5', '4', '4', '4', '4', '', '4', '4', '4', '4', '4', '', '', '');
INSERT INTO `produceproduct` VALUES ('6', '6', '4', '4', 'r', 'r', '', 'r', '', '', '', '', '', '', '');
INSERT INTO `produceproduct` VALUES ('7', 'q01', 'i09', '衣服', '2o', '紫色', '的', '北极光', 'rmb', '100k', '4', '2000', '2000', '号', '的');
INSERT INTO `storymanagement` VALUES ('4', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('5', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('6', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('7', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('8', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('9', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('10', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('11', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('12', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('13', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('14', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('15', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('16', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('17', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('18', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('19', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('20', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('21', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('22', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('23', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('24', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('25', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('26', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('27', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('28', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('29', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('30', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('31', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('32', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('33', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('34', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('35', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('36', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('37', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('38', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('39', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('40', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('41', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('42', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('43', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('44', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('45', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('46', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('47', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('48', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('49', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('50', 'aa', 'A', 'o');
INSERT INTO `storymanagement` VALUES ('51', 'cc', 'C', 'cc');

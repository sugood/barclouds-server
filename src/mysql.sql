--创建数据库barclouds
create database barclouds;
--应用数据库
use barclouds;
--创建user表
create table user(
  `userId` int(10) unsigned NOT NULL auto_increment,
  `uid` varchar(20) NOT NULL default '',
  `password` varchar(30) NOT NULL default '',
  `realName` varchar(20) NOT NULL default '',
  `gender` tinyint(1) unsigned NOT NULL default '0',
  `email` varchar(50) NOT NULL default '',
  `tel` varchar(15) default NULL,
  `question` varchar(50) default NULL,
  `validateCode` varchar(20) NOT NULL default '',
  `answer` varchar(50) NOT NULL default '',
  `loginNum` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`userId`),
  UNIQUE KEY `Index_uid` USING BTREE (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--创建data表
create table data(
  `dataId` int(10) unsigned NOT NULL auto_increment,
  `uid` varchar(20) NOT NULL default '',
  `field0` varchar(60) NOT NULL default '',
  `field1` varchar(60) NOT NULL default '',
  `field2` varchar(60) NOT NULL default '',
  `field3` varchar(60) NOT NULL default '',
  `field4` varchar(60) NOT NULL default '',
  `field5` varchar(60) NOT NULL default '',
  `field6` varchar(60) NOT NULL default '',
  `field7` varchar(60) NOT NULL default '',
  `field8` varchar(60) NOT NULL default '',
  `field9` varchar(60) NOT NULL default '',
  PRIMARY KEY  (`dataId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--创建info表
create table info(
  `infoId` int(10) unsigned NOT NULL auto_increment,
  `uid` varchar(20) NOT NULL default '',
  `field0` varchar(60) NOT NULL default '',
  `field1` varchar(60) NOT NULL default '',
  `field2` varchar(60) NOT NULL default '',
  `field3` varchar(60) NOT NULL default '',
  `field4` varchar(60) NOT NULL default '',
  `field5` varchar(60) NOT NULL default '',
  `field6` varchar(60) NOT NULL default '',
  `field7` varchar(60) NOT NULL default '',
  `field8` varchar(60) NOT NULL default '',
  `field9` varchar(60) NOT NULL default '',
  PRIMARY KEY  (`infoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--创建infoIndex表
create table infoIndex(
  `infoIndexId` int(10) unsigned NOT NULL auto_increment,
  `uid` varchar(20) NOT NULL default '',
  `fieldName0` varchar(60) NOT NULL default '',
  `fieldName1` varchar(60) NOT NULL default '',
  `fieldName2` varchar(60) NOT NULL default '',
  `fieldName3` varchar(60) NOT NULL default '',
  `fieldName4` varchar(60) NOT NULL default '',
  `fieldName5` varchar(60) NOT NULL default '',
  `fieldName6` varchar(60) NOT NULL default '',
  `fieldName7` varchar(60) NOT NULL default '',
  `fieldName8` varchar(60) NOT NULL default '',
  `fieldName9` varchar(60) NOT NULL default '',
  PRIMARY KEY  (`infoIndexId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

select * from user;

--Oracle中的表
select * from email_config;

--连接数据库
mysql -uroot -pmysqladmin

set names 'gbk'; 
--它相当于下面的三句指令： 
set character_set_client = gbk; 
set character_set_results = gbk; 
set character_set_connection = gbk; 

--显示数据表表的编码
 show create table t_user;
 
 --修改数据库编码为gbk
 alter database steven character set gbk; 
 
--修改表默认用gbk
alter table t_user character set gbk;

--修改userName字段编码为utf8
alter table t_user modify userName varchar(100) CHARACTER SET gbk; 
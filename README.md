对接中心
===

对接中心, 用于适配对接外部第三方系统服务。

|版本|日期|说明|联系人|
|-|-|-|-|
|1.0|2021-06-25|基于盐城项目对接普元SSO初创|朱钟雷|

### 模块说明

#### bridge-common`基础`

基础公共包，定义所有模块都会使用到的抽象类、工具及接口

#### bridge-datasource`基础`

数据源接入模块，提供数据库、缓存统一接入能力。提供上层模块依赖使用

#### bridge-configure

配置模块，提供对接的第三方系统应用编码、应用密钥等信息存储

#### bridge-outside

封装第三方接口对接，提供封装服务

#### bridge-server

对接系统 WEB 工程服务

#### bridge-server-client

对接系统提供服务能力封装，提供依赖系统使用

```SQL
CREATE TABLE `A_TEST` (
  `TEST_ID` varchar(32) NOT NULL COMMENT '主键',
  `TEST_TITLE` varchar(32) DEFAULT NULL COMMENT '标题',
  `TEST_CONTENT` varchar(32) DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`TEST_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='事务测试表';

CREATE TABLE `B_TEST` (
    `TEST_ID` varchar(32) NOT NULL COMMENT '主键',
    `TEST_TITLE` varchar(32) DEFAULT NULL COMMENT '标题',
    `TEST_CONTENT` varchar(32) DEFAULT NULL COMMENT '内容',
    PRIMARY KEY (`TEST_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='事务测试表';
```


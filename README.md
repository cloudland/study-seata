Seata学习样例
===

|版本|日期|说明|联系人|
|-|-|-|-|
|1.0|2021-08-01|学习使用|未小雨|

### 模块说明

#### seata-micro-a-server`微服务(A)`

提供基于服务A的编辑

#### seata-micro-b-server`微服务(B)`

提供基于服务B的编辑

#### seata-micro-server-client`微服务FeignClient`

提供微服务A、B的调用接口

#### seata-server

业务服务，调用服务A、服务B。测试分布式事务。

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


CREATE DATABASE IF NOT EXISTS test;

USE test;

CREATE TABLE IF NOT EXISTS tb_company (
  id          INT UNSIGNED AUTO_INCREMENT
  COMMENT '企业id，主键',
  name        VARCHAR(50) UNIQUE
  COMMENT '企业名称，唯一',
  address     VARCHAR(100) COMMENT '企业地址',
  create_time TIMESTAMP    DEFAULT now(),
  is_deleted  BOOLEAN      DEFAULT FALSE,
  PRIMARY KEY (id)
)
  CHARSET = utf8;

CREATE TABLE IF NOT EXISTS tb_user (
  id          INT UNSIGNED AUTO_INCREMENT
  COMMENT '用户id，主键',
  account     VARCHAR(50) UNIQUE
  COMMENT '账号，唯一',
  password    VARCHAR(50) NOT NULL
  COMMENT '密码',
  salt        CHAR(32)    NOT NULL
  COMMENT '盐',
  name        VARCHAR(20) COMMENT '用户名',
  age         TINYINT UNSIGNED COMMENT '年龄',
  sex         TINYINT UNSIGNED COMMENT '性别， 1：男 2：女 3：其他',
  company_id  INT UNSIGNED COMMENT '外键关联企业表',
  create_time TIMESTAMP    DEFAULT now(),
  is_deleted  BOOLEAN      DEFAULT FALSE,
  PRIMARY KEY (id),
  FOREIGN KEY (company_id) REFERENCES tb_company (id)
)
  CHARSET = utf8;
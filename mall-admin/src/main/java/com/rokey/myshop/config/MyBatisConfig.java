package com.rokey.myshop.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.rokey.myshop.mapper","com.rokey.myshop.dao"})
public class MyBatisConfig {
}

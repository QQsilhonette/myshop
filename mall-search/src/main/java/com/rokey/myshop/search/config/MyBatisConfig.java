package com.rokey.myshop.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan({"com.rokey.myshop.mapper","com.rokey.myshop.search.dao"})
public class MyBatisConfig {
}

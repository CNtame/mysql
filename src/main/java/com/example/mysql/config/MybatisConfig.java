package com.example.mysql.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author liu
 * @version 1.0
 * @description
 * @createDate 2020/11/11
 */
@Component
@EnableTransactionManagement
@MapperScan({"com.example.mysql.dao"})
public class MybatisConfig {
}

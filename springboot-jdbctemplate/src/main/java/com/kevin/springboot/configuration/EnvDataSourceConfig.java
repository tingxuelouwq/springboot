//package com.kevin.springboot.configuration;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class EnvDataSourceConfig {
//
//    @Autowired
//    private Environment env;
//
//    @Bean
//    public DataSource datasource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(env.getProperty("spring.datasource.spring.datasource.driver-class-name"));
//        dataSource.setUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password"));
//        dataSource.setInitialSize(Integer.valueOf(env.getProperty("spring.datasource.initialSize")));
//        dataSource.setMinIdle(Integer.valueOf(env.getProperty("spring.datasource.minIdle")));
//        dataSource.setMaxActive(Integer.valueOf(env.getProperty("spring.datasource.maxActive")));
//        dataSource.setMaxWait(Long.valueOf(env.getProperty("spring.datasource.maxWait")));
//        dataSource.setMinEvictableIdleTimeMillis(Long.valueOf(env.getProperty("spring.datasource.minEvictableIdleTimeMillis")));
//        dataSource.setTimeBetweenEvictionRunsMillis(Long.valueOf(env.getProperty("spring.datasource.timeBetweenEvictionRunsMillis")));
//        dataSource.setTestWhileIdle(Boolean.valueOf(env.getProperty("spring.datasource.testWhileIdle")));
//        dataSource.setValidationQuery(env.getProperty("spring.datasource.validationQuery"));
//        return dataSource;
//    }
//}

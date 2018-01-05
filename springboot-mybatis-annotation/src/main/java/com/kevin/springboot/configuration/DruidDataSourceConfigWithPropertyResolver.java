//package com.kevin.springboot.configuration;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.boot.bind.RelaxedPropertyResolver;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
//import javax.sql.DataSource;
//
//@Configuration
//@MapperScan(basePackages = "com.kevin.springboot.dao")
//public class DruidDataSourceConfigWithPropertyResolver implements EnvironmentAware {
//
//    private RelaxedPropertyResolver propertyResolver;
//
//    @Override
//    public void setEnvironment(Environment environment) {
//        this.propertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(propertyResolver.getProperty("driver-class-name"));
//        dataSource.setUrl(propertyResolver.getProperty("url"));
//        dataSource.setUsername(propertyResolver.getProperty("username"));
//        dataSource.setPassword(propertyResolver.getProperty("password"));
//        dataSource.setInitialSize(Integer.valueOf(propertyResolver.getProperty("initialSize")));
//        dataSource.setMinIdle(Integer.valueOf(propertyResolver.getProperty("minIdle")));
//        dataSource.setMaxActive(Integer.valueOf(propertyResolver.getProperty("maxActive")));
//        dataSource.setMaxWait(Long.valueOf(propertyResolver.getProperty("maxWait")));
//        dataSource.setMinEvictableIdleTimeMillis(Long.valueOf(propertyResolver.getProperty("minEvictableIdleTimeMillis")));
//        dataSource.setTimeBetweenEvictionRunsMillis(Long.valueOf(propertyResolver.getProperty("timeBetweenEvictionRunsMillis")));
//        dataSource.setTestWhileIdle(Boolean.valueOf(propertyResolver.getProperty("testWhileIdle")));
//        dataSource.setValidationQuery(propertyResolver.getProperty("validationQuery"));
//        return dataSource;
//    }
//}

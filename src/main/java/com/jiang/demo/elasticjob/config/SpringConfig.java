package com.jiang.demo.elasticjob.config;

import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration("springConfig")
@ConfigurationProperties(prefix = "my.datasource")
public class SpringConfig {

    private String driverClassName;
    private String url;
    private String username;
    private String password;



    @Bean
    public DataSource mysql(){
        org.springframework.jdbc.datasource.DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setPassword(password);
        ds.setUsername(username);
        ds.setUrl(url);
        return ds;
    }

    @Bean
    public SqlSessionFactoryBean SqlSesionFactoryBean(@Autowired DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean  = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 设置单独的日志类
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        // 此处需要传一个Class<? extends Log> (以确定具体的日志实现)
        // org.apache.ibatis.logging.log4j2.Log4j2Impl
        // org.apache.ibatis.logging.log4j.Log4jImpl
        // org.apache.ibatis.logging.jdk14.Jdk14LoggingImpl jul默认不会输出info以下级别的日志
        configuration.setLogImpl(Log4j2Impl.class);
        // 开启驼峰转 "-"
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean;
    }



    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
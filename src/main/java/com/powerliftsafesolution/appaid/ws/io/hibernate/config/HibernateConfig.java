package com.powerliftsafesolution.appaid.ws.io.hibernate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.hibernate.cfg.Environment.*;

import java.util.Properties;


@Configuration
@PropertySource("classpath:awsrds-appaid-live.properties")
@EnableTransactionManagement
@ComponentScan("com.powerliftsafesolution.appaid.ws.io.hibernate.dao")
public class HibernateConfig {

    @Value("${mysql.username}")
    private String userName;
    @Value("${mysql.password}")
    private String password;
    @Value("${mysql.dbUrl}")
    private String dbUrl;
    @Value("${mysql.dbDriver}")
    private String dbDriver;

    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;
    @Value("${hibernate.dialect}")
    private String hibernateDialect;

    @Value("${hibernate.c3p0.min_size}")
    private String hibernateC3p0MinSize;
    @Value("${hibernate.c3p0.max_size}")
    private String hibernateC3p0MaxSize;
    @Value("${hibernate.c3p0.acquire_increment}")
    private String hibernateC3p0AcquireIncrement;
    @Value("${hibernate.c3p0.timeout}")
    private String hibernateC3p0Timeout;
    @Value("${hibernate.c3p0.max_statements}")
    private String hibernateC3p0MaxStatements;

    public HibernateConfig(){}

    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        Properties props = new Properties();

        props.put(DRIVER, this.dbDriver);
        props.put(URL, this.dbUrl);
        props.put(USER, this.userName);
        props.put(PASS, this.password);

        props.put(SHOW_SQL, this.hibernateShowSql);
        props.put(DIALECT, this.hibernateDialect);

        props.put(C3P0_MIN_SIZE, this.hibernateC3p0MinSize);
        props.put(C3P0_MAX_SIZE, this.hibernateC3p0MaxSize);
        props.put(C3P0_ACQUIRE_INCREMENT, this.hibernateC3p0AcquireIncrement);
        props.put(C3P0_TIMEOUT, this.hibernateC3p0Timeout);
        props.put(C3P0_MAX_STATEMENTS, this.hibernateC3p0MaxStatements);

        factoryBean.setHibernateProperties(props);
        factoryBean.setPackagesToScan("com.powerliftsafesolution.appaid.ws.io.hibernate.entity");

        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(this.getSessionFactory().getObject());
        return transactionManager;
    }
}

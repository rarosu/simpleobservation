package com.rarosu.simpleobservation.service;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
    @Bean
    public LocalSessionFactoryBean resolveSessionFactory() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "none");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(resolveSessionFactoryDataSource());
        sessionFactory.setMappingResources("taxon.hbm.xml");
        sessionFactory.setHibernateProperties(hibernateProperties);
        
        return sessionFactory;
    }
    
    @Bean
    public DataSource resolveSessionFactoryDataSource() {
        Config config = ConfigFactory.load();

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(config.getString("database.url"));
        dataSource.setUsername(config.getString("database.username"));
        dataSource.setPassword(config.getString("database.password"));
        
        return dataSource;
    }
    
    @Bean
    public PlatformTransactionManager resolveHibernateTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(resolveSessionFactory().getObject());
        return transactionManager;
    }
    
    @Bean
    @Autowired
    public JinqJPAStreamProvider resolveJinqJpaStreamProvider(SessionFactory sessionFactory) {
        return new JinqJPAStreamProvider(sessionFactory);
    }
}

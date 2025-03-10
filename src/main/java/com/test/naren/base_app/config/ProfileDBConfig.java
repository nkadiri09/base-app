package com.test.naren.base_app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.test.naren.base_app.profilerepo",
    entityManagerFactoryRef = "profileEntityManagerFactory",
    transactionManagerRef = "profileTransactionManager"
)
public class ProfileDBConfig {

    @Autowired
    private ProfileDataSource profileds;

    @Bean
    public DataSource secondDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(profileds.getDriverClassName());
        dataSource.setJdbcUrl(profileds.getUrl());
        dataSource.setUsername(profileds.getUsername());
        dataSource.setPassword(profileds.getPassword());
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean profileEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(secondDataSource());
        em.setPackagesToScan("com.test.naren.base_app.entity");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        em.setJpaProperties(properties);

        return em;
    }

    @Bean
    public JpaTransactionManager profileTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(profileEntityManagerFactory().getObject());
        return transactionManager;
    }
}
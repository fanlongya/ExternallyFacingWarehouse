package com.fan.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Guest1config {
    @Bean(name = "db1")
    @ConfigurationProperties("spring.datasource.db1")
    public DataSource ds1() {
        DataSource dataSource = DataSourceBuilder.create().build();
        return dataSource;
    }

    @Bean(name = "db2")
    @ConfigurationProperties("spring.datasource.db2")
    public DataSource ds2() {
        DataSource dataSource = DataSourceBuilder.create().build();
        return dataSource;
    }
}

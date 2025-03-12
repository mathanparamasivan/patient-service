package com.app.patient.service.config;

import com.app.patient.service.aws.AwsSecretsPropertySource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;

import javax.sql.DataSource;

@Configuration
public class MySQLConfig {

    private final Environment environment;

    public MySQLConfig(ConfigurableEnvironment environment) {
        this.environment = environment;

        // Load secrets from AWS Secrets Manager
        String accessKey = environment.getProperty("aws.credentials.accessKey");
        String secretKey = environment.getProperty("aws.credentials.secretKey");

        if (accessKey == null || secretKey == null) {
            throw new IllegalStateException("AWS credentials are missing from properties!");
        }

        // Add AWS Secrets Manager properties
        MutablePropertySources propertySources = ((ConfigurableEnvironment) environment).getPropertySources();
        propertySources.addFirst(new AwsSecretsPropertySource("awsSecrets", "my-app/db-credentials", accessKey, secretKey));
    }

    @Bean
    public DataSource dataSource() {
        String url = environment.getProperty("spring.datasource.url");
        String username = environment.getProperty("username");  // Fetched from AWS Secrets
        String password = environment.getProperty("password");  // Fetched from AWS Secrets

        if (username == null || password == null) {
            throw new IllegalStateException("Database credentials are missing from AWS Secrets!");
        }

        return DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}

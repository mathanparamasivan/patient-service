package com.app.patient.service.aws;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Configuration
public class AwsSecretsInitializer implements ApplicationRunner {

    private final ConfigurableEnvironment environment;

    public AwsSecretsInitializer(ConfigurableEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public void run(ApplicationArguments args) {
        // Fetch AWS credentials from Environment
        String accessKey = environment.getProperty("aws.credentials.accessKey");
        String secretKey = environment.getProperty("aws.credentials.secretKey");

        if (accessKey == null || secretKey == null) {
            throw new IllegalStateException("AWS credentials are missing from properties!");
        }

        // Initialize the custom property source
        MutablePropertySources propertySources = environment.getPropertySources();
        propertySources.addFirst(new AwsSecretsPropertySource("awsSecrets", "my-app/db-credentials", accessKey, secretKey));
    }
}

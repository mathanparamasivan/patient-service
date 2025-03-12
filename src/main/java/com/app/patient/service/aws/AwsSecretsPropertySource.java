package com.app.patient.service.aws;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.env.PropertySource;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

import java.util.Map;

public class AwsSecretsPropertySource extends PropertySource<String> {

    private final Map<String, String> secrets;

    public AwsSecretsPropertySource(String name, String secretName, String accessKey, String secretKey) {
        super(name);
        this.secrets = fetchSecret(secretName, accessKey, secretKey);
    }

    private Map<String, String> fetchSecret(String secretName, String accessKey, String secretKey) {
        SecretsManagerClient client = SecretsManagerClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey)))
                .build();

        GetSecretValueResponse response = client.getSecretValue(GetSecretValueRequest.builder()
                .secretId(secretName)
                .build());

        try {
            return new ObjectMapper().readValue(response.secretString(), Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse AWS secret", e);
        }
    }

    @Override
    public Object getProperty(String name) {
        return secrets.get(name);
    }
}

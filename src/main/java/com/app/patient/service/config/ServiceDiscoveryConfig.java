package com.app.patient.service.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ServiceDiscoveryConfig {
    @Bean
    @LoadBalanced  // Enables service discovery in WebClient
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}

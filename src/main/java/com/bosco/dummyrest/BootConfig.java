package com.bosco.dummyrest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BootConfig {

    @Bean(name="restClient")
    RestTemplate getRestClient(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean(name="objectMapper")
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}

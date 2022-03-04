package com.bosco.dummyrest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BootConfig {

    @Bean(name="restClient")
    public RestTemplate getRestClient(RestTemplateBuilder builder) {
        return builder.build();
    }

}

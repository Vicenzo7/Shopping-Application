package com.vicenzo.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    // creates a bean with method name

    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }

}

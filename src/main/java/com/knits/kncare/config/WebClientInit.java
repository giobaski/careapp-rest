package com.knits.kncare.config;

import com.google.common.net.HttpHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientInit {
    @Bean
    public WebClient getWebClient(){
        return WebClient
                .builder()
                .baseUrl("http://localhost:9000")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}

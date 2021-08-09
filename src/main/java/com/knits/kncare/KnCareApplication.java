package com.knits.kncare;

import com.google.common.net.HttpHeaders;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@OpenAPIDefinition(info=@Info(title = "KnCare api", version = "1.0"))
@SpringBootApplication
public class KnCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnCareApplication.class, args);
	}



}

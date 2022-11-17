package com.eauction.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition(info = @Info(title = "Seller API", version = "2.0", description = "Seller Information"))
public class SellerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellerServiceApplication.class, args);
        System.out.println("Seller Service are app");
    }

}

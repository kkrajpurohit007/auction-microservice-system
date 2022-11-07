package com.eauction.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Seller API", version = "2.0", description = "Seller Information"))
public class SellerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellerServiceApplication.class, args);
        System.out.println("Seller Service are app");
    }

}

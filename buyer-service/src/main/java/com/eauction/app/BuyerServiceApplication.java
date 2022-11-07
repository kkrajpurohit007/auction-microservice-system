package com.eauction.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Buyer API", version = "2.0", description = "Buyer Information"))
public class BuyerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuyerServiceApplication.class, args);
        System.out.println("Buyer Service are app");
    }

}

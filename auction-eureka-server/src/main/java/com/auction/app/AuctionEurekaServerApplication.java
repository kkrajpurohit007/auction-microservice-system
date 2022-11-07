package com.auction.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AuctionEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuctionEurekaServerApplication.class, args);
    }

}

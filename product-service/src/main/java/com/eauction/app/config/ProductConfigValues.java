package com.eauction.app.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "product")
@Configuration("productConfigValues")
@Getter @Setter
public class ProductConfigValues {
    private String msg;
    private String buildVersion;

}

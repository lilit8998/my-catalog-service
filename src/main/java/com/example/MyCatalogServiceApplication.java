package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class MyCatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCatalogServiceApplication.class, args);
    }

}

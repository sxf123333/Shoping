package com.it.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@SpringBootApplication
public class ShopingApplication {

    public static void main(String[] args) {

        SpringApplication.run(ShopingApplication.class, args);
        WebMvcConfg webMvcConfg = new WebMvcConfg();

    }

}

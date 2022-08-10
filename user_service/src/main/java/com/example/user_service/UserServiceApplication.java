package com.example.user_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient

public class UserServiceApplication {

    @Value("${department.service.url}")
    private String departmentServiceUrl;
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}

package com.resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.resource.mapper")
public class ResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class);
    }
}
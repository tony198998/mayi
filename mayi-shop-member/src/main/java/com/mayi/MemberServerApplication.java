package com.mayi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MemberServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberServerApplication.class,args);
    }
}

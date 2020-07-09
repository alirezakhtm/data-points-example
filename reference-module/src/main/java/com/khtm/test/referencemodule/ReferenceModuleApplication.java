package com.khtm.test.referencemodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableJpaAuditing
public class ReferenceModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReferenceModuleApplication.class, args);
    }

}

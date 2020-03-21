package com.waes.scalableweb.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaRepositories("com.waes.scalableweb.repository")
@EntityScan("com.waes.scalableweb.model")
@ComponentScan("com.waes.scalableweb.service")
@SpringBootApplication
public class ScalableWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScalableWebApplication.class, args);
    }

}

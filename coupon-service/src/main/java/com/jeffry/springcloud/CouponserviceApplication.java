package com.jeffry.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class CouponserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CouponserviceApplication.class, args);
    }

}

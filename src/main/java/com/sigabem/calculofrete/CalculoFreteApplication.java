package com.sigabem.calculofrete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@SpringBootApplication(scanBasePackages={"com.sigabem.calculofrete"})
public class CalculoFreteApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalculoFreteApplication.class, args);
    }
}



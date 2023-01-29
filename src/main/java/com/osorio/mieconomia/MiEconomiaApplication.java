package com.osorio.mieconomia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.osorio.developer.commons.models"})
public class MiEconomiaApplication {
   public static void main(String[] args) {
        SpringApplication.run(MiEconomiaApplication.class, args);
    }

}

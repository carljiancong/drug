package com.harmonycloud.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.harmonycloud")
@EnableMongoRepositories("com.harmonycloud.monRepository")
@EnableJpaRepositories("com.harmonycloud.oraRepository")
@EntityScan("com.harmonycloud.entity")
public class DrugApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrugApplication.class, args);
    }

}


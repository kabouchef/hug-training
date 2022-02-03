package com.example.hugtrainning;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Hug Training Application
 *
 * @author fkabouche
 * @version 1.0.0
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Hug Trainning Application"))
public class HugTrainningApplication {

    public static void main(String[] args) {
        SpringApplication.run(HugTrainningApplication.class, args);
    }

}

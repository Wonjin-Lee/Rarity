package io.dapsimni.rarity.app.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"io.dapsimni.rarity"})
@EntityScan(basePackages = "io.dapsimni.rarity")
@EnableJpaRepositories(basePackages = {"io.dapsimni.rarity"})
public class RarityApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RarityApiApplication.class, args);
    }
}

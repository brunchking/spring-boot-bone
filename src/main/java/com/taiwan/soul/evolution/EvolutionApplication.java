package com.taiwan.soul.evolution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.taiwan.soul.evolution.controller.model"})
public class EvolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvolutionApplication.class, args);
	}

}

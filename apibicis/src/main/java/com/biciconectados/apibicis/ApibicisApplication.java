package com.biciconectados.apibicis;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.biciconectados.apibicis.Models")
public class ApibicisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApibicisApplication.class, args);
	}

}

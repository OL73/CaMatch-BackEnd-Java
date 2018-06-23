package com.dvlk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EntityScan("com.dvlk.p10.bean")
@EnableJpaAuditing
@SpringBootApplication
public class Projet10Application {

	public static void main(String[] args) {
		SpringApplication.run(Projet10Application.class, args);
	}
}

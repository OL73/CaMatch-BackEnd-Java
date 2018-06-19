package com.dvlk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.dvlk.p10.bean")
@SpringBootApplication
public class Projet10Application {

	public static void main(String[] args) {
		SpringApplication.run(Projet10Application.class, args);
	}
}

package com.dvlk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.dvlk.p10.filter.SecurityFilter;

@EntityScan("com.dvlk.p10.bean")
@EnableJpaAuditing
@SpringBootApplication
public class Projet10Application extends SpringBootServletInitializer {

	/**
	 * Methode issue de SpringBootServletInitializer. Permet de deployer son
	 * application de manière standard (un WAR).
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Projet10Application.class);
	}

	public SecurityFilter securityFilter() {
		return new SecurityFilter();
	}

	@Bean
	public FilterRegistrationBean someFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(securityFilter());
		registration.addUrlPatterns("/api/salons");
		return registration;
	}

	public static void main(String[] args) {
		SpringApplication.run(Projet10Application.class, args);
	}

}

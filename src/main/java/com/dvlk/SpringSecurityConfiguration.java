package com.dvlk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Configuration sous la forme d'une classe Java. <br/>
 *
 * Ce fichier ne concerne que Spring Security.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	private static final Logger LOG = LogManager.getLogger();

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		SpringSecurityConfiguration.LOG.debug("Chargement des regles de securisations");
		http.authorizeRequests().antMatchers("/salons").permitAll();
		http.authorizeRequests().antMatchers("/profil/**").access("hasRole('ROLE_UTILISATEUR')");
		http.authorizeRequests().anyRequest().authenticated();
	}

}

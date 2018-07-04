package com.dvlk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
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

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		SpringSecurityConfiguration.LOG.debug("Chargement des Utilisateurs locaux");
		// Ne pas indiquer ROLE_, c'est ajoute automatiquement
		final InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> memory = auth.inMemoryAuthentication();
		memory.withUser("admin").password("admin").roles("ADMIN", "USER");
		// Un autre
		memory.withUser("guest").password("guest").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		SpringSecurityConfiguration.LOG.debug("Chargement des regles de securisations");
		http.authorizeRequests().antMatchers("/**").permitAll();
		http.authorizeRequests().and().csrf().disable();
	}
}

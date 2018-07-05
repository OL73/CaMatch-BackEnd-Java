package com.dvlk.p10.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dvlk.Projet10ApplicationTests;
import com.dvlk.p10.bean.Utilisateur;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
public class UtilisateurControllerMockTest extends Projet10ApplicationTests {

	private static final Logger LOG = LogManager.getLogger();

	private static final String UTILISATEUR_URL = "/api/inscription";

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void testcreationUtilisateurOk() throws Exception {
		UtilisateurControllerMockTest.LOG.trace("Dans Test testcreationUtilisateurOk");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date date = null;
		try {
			date = sdf.parse("1973/04/20");
		} catch (ParseException e) {
			UtilisateurControllerMockTest.LOG.error("Erreur parsing date, ne doit pas arriver", e);
		}

		Utilisateur user = new Utilisateur();
		user.setNom("lambin");
		user.setPrenom("olivier");
		user.setAdresse("grand place - Lille");
		user.setDateNaissance(date);
		user.setPseudo("Bgdu62");
		user.setEmail("bgdu62@gmail.com");

		ObjectMapper mapper = new ObjectMapper();

		String unUserAsJson = mapper.writeValueAsString(user);

		ResultActions result = this.mockMvc
				.perform(MockMvcRequestBuilders.put(UtilisateurControllerMockTest.UTILISATEUR_URL)
						.contentType(MediaType.APPLICATION_JSON).content(unUserAsJson));

		result.andExpect(MockMvcResultMatchers.status().isOk());
		UtilisateurControllerMockTest.LOG.debug("Flux {}", result.andReturn().getResponse().getContentAsString());

	}

}

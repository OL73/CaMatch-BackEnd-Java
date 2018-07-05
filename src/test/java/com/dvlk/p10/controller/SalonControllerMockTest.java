package com.dvlk.p10.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dvlk.Projet10ApplicationTests;


@WebAppConfiguration
public class SalonControllerMockTest extends Projet10ApplicationTests {
	private static final Logger LOG = LogManager.getLogger();

	private static final String SALONS_URL = "/api/salons";

	private static final String SALONID_URL = "/api/salon";

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	/**
	 * Fabrication de notre mock MVC
	 */
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	/**
	 * Usage des mock.
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetSalonsOk() throws Exception {
		SalonControllerMockTest.LOG.trace("Test - testGetSalonsOk");
		// LoginBean loginBean = new LoginBean();
		// loginBean.setLogin("df");
		// loginBean.setPassword("df");
		// Objet -> Json en Jackson
		// ObjectMapper mapper = new ObjectMapper();
		// String loginBeanAsJSon = mapper.writeValueAsString(loginBean);
		// SalonControllerMockTest.LOG.debug(loginBeanAsJSon);

		// On appelle le web service en POST, en envoyant du JSON
		// Attention : il n'y a plus d'URL complet (http://....)
		// Juste l'URL du web service <=> @RequestMapping
		ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(SalonControllerMockTest.SALONS_URL));
		// .contentType(MediaType.APPLICATION_JSON).content(loginBeanAsJSon));
		// On test que le resultat est bien 200
		result.andExpect(MockMvcResultMatchers.status().isOk());
		// Avec un flux JSON qui contient une propriete id qui vaut 1
		// SalonControllerMockTest.LOG.debug("Flux {}",
		// result.andReturn().getResponse().getContentAsString());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.salons").exists());
		// Dans le flux, je prends la premiere case et je regarde si son id = 1
		result.andExpect(MockMvcResultMatchers.jsonPath("$.salons[0].id").value(Integer.valueOf(1)));
	}

	@Test
	public void testGetSalonsOk2() throws Exception {
		SalonControllerMockTest.LOG.trace("DANS LE TEST - testgetSalonOk 2");

		ResultActions result = this.mockMvc
				.perform(MockMvcRequestBuilders.get(SalonControllerMockTest.SALONID_URL + "/1"));
		result.andExpect(MockMvcResultMatchers.status().isOk());
		SalonControllerMockTest.LOG.debug("Flux {}", result.andReturn().getResponse().getContentAsString());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.lstutilisateurDTO").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.lstutilisateurDTO[0].id").value(Integer.valueOf(30)));
	}

}

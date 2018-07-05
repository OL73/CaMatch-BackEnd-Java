package com.dvlk.p10.controller;

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
import com.dvlk.p10.bean.Role;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
public class RoleControllerMockTest extends Projet10ApplicationTests {

	private static final Logger LOG = LogManager.getLogger();

	private static final String ROLE_URL = "/api/role";

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

	@Test
	public void testsaveRoleOk() throws Exception {
		RoleControllerMockTest.LOG.trace("Dans le test testsaveRoleOk");

		Role unRole = new Role();
		unRole.setLibelle("admin");

		ObjectMapper mapper = new ObjectMapper();
		String unRoleAsJson = mapper.writeValueAsString(unRole);

		ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.post(RoleControllerMockTest.ROLE_URL)
				.contentType(MediaType.APPLICATION_JSON).content(unRoleAsJson));

		result.andExpect(MockMvcResultMatchers.status().isOk());
		RoleControllerMockTest.LOG.debug("Flux {}", result.andReturn().getResponse().getContentAsString());
	}

}

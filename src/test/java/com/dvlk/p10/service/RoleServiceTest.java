package com.dvlk.p10.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dvlk.Projet10ApplicationTests;
import com.dvlk.p10.bean.Role;


public class RoleServiceTest extends Projet10ApplicationTests {

	@Autowired
	private IRoleService service;

	@Test
	public void testSaveOne() {
		Role role = new Role();
		role.setLibelle("admin");
		this.service.saveOne(role);
		Assert.assertNotNull("l'Id du role ne doit pas etre null", role);
	}
}

package com.dvlk.p10.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dvlk.Projet10ApplicationTests;
import com.dvlk.p10.bean.Role;
import com.dvlk.p10.service.IRoleService;


public class RoleServiceTest extends Projet10ApplicationTests {

	@Autowired
	private IRoleService service;

	@Test
	public void testSaveOne() {
		Role role = new Role();
		role.setId(2);
		role.setLibelle("utilisateur");
		this.service.saveOne(role);
		Assert.assertNotNull("l'Id du role ne doit pas etre null", role);
		Assert.assertEquals(" Le libelle du role doit etre utilisateur", "utilisateur", role.getLibelle());
	}
}

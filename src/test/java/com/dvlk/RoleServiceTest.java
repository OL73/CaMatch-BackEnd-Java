package com.dvlk;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dvlk.p10.bean.Role;
import com.dvlk.p10.service.IRoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Projet10Application.class)
@Rollback(true)
@Transactional
public class RoleServiceTest {

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

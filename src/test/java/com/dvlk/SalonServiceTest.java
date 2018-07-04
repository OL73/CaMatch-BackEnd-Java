package com.dvlk;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dvlk.p10.bean.Salon;
import com.dvlk.p10.service.ISalonService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Projet10Application.class)
@Rollback(true)
@Transactional // En spring boot il faut le remettre sur la classe de test (meme si le service
// l'est deja)
public class SalonServiceTest {

	@Autowired
	private ISalonService service;

	@Test
	public void testFindAllSalons() {
		List<Salon> lstSalons = this.service.findAllSalons();
		Assert.assertNotNull("la liste de salon ne doit pas être null", lstSalons);
	}

	@Test
	public void testfindSalon() {
		Salon salon = this.service.findSalon(10);
		Assert.assertNotNull("le salon ne doit pas être null", salon);
		Integer intObj = new Integer(10);
		Assert.assertEquals("L'Id doit être le même que l'Id salon", intObj, salon.getId());
	}

}

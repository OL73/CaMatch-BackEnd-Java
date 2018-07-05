package com.dvlk.p10.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dvlk.Projet10ApplicationTests;
import com.dvlk.p10.bean.Salon;
import com.dvlk.p10.service.ISalonService;


public class SalonServiceTest extends Projet10ApplicationTests {

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

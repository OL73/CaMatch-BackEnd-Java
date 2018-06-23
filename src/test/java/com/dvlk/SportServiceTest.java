package com.dvlk;

import org.junit.Assert;
import org.junit.Test;

import com.dvlk.p10.bean.Sport;
import com.dvlk.p10.service.ISportService;

public class SportServiceTest {
	
	private ISportService service;
	
	@Test
	public void testSaveOne() {
		Sport sport = new Sport();
		sport.setNom("volley");
		sport.setDescription("du volley");
		this.service.saveOne(sport);
		Assert.assertEquals("Le nom du sport doit être volley", "volley", sport.getNom() );
		Assert.assertEquals("La description du sport doit être du volley", "du volley", sport.getDescription() );
	}

}

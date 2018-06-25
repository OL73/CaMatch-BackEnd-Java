package com.dvlk;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dvlk.p10.bean.Sport;
import com.dvlk.p10.service.ISportService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Projet10Application.class)
@Rollback(true)
public class SportServiceTest {

	@Autowired
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

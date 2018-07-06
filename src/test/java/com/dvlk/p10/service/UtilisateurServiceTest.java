package com.dvlk.p10.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dvlk.Projet10ApplicationTests;
import com.dvlk.p10.bean.Utilisateur;

public class UtilisateurServiceTest extends Projet10ApplicationTests {
	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private IUtilisateurService utilisateurService;

	@Test
	public void testsaveOne() {
		UtilisateurServiceTest.LOG.info("Dans la methode testsaveOne");
		Utilisateur user = new Utilisateur();
		// Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date date = null;
		try {
			date = sdf.parse("1973/12/25");
		} catch (ParseException e) {
			UtilisateurServiceTest.LOG.error("Erreur parsing date, ne doit pas arriver", e);
		}

		// date.setYear(1973);

		user.setNom("chuck");
		user.setPrenom("norris");
		user.setAdresse("grand place - lille");
		user.setDateNaissance(date);
		user.setPseudo("chucky");
		user.setEmail("test@test.fr");
		this.utilisateurService.saveOne(user);
		user = this.utilisateurService.findOneByPseudo(user.getPseudo());
		Assert.assertNotNull("l'id ne doit pas etre null", user.getId());
		Assert.assertEquals("le nom doit etre égal à chuck", "chuck", user.getNom());
		Assert.assertEquals("l'adresse doit etre égale à grand place - lille", "grand place - lille",
				user.getAdresse());
	}

	@Test
	public void testfindOne() {
		UtilisateurServiceTest.LOG.info("Dans la methode testfindOne");
		Utilisateur user = new Utilisateur();
		Integer id = 1;
		user = this.utilisateurService.findOne(id);
		Assert.assertEquals("l id 1 doit exister", 1, user.getId().intValue());
	}

	@Test
	public void testfindOneByPseudo() {
		UtilisateurServiceTest.LOG.info("Dans la methode testfindOneByPseudo");
		Utilisateur user = new Utilisateur();
		String pseudo = "-50";
		user = this.utilisateurService.findOneByPseudo(pseudo);
		Assert.assertNotNull("le peusdo ne doit pas être null", user.getPseudo());
		Assert.assertEquals("le pseudo doit etre égal à bgdu59", "-50", user.getPseudo());
	}

}

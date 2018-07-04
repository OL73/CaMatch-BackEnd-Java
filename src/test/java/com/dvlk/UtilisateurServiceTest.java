package com.dvlk;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dvlk.p10.bean.Utilisateur;
import com.dvlk.p10.service.IUtilisateurService;

public class UtilisateurServiceTest extends Projet10ApplicationTests {

	@Autowired
	private IUtilisateurService utilisateurService;

	@Test
	public void saveOne() {
		Utilisateur user = new Utilisateur();
		Date date = new Date();
		date.setYear(1973);

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

}

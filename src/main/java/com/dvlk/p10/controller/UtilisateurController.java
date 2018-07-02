package com.dvlk.p10.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvlk.p10.bean.Utilisateur;
import com.dvlk.p10.dto.UtilisateurDTO;
import com.dvlk.p10.service.IUtilisateurService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class UtilisateurController {
	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private IUtilisateurService service;

	@PostMapping("/inscription")
	public UtilisateurDTO creationUtilisateur(@RequestBody Utilisateur utilisateur) {
		UtilisateurController.LOG.info("Dans la méthode POST UtilisateurController, PSEUDO : {} ,DATE : {}",
				utilisateur.getPseudo(), utilisateur.getDateNaissance());
		UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
		utilisateurDTO.setId(utilisateur.getId());
		utilisateurDTO.setNiveau(utilisateur.getNiveau());
		utilisateurDTO.setNom(utilisateur.getNom());
		utilisateurDTO.setNote(utilisateur.getNote());
		utilisateurDTO.setPenalite(utilisateur.getPenalite());
		utilisateurDTO.setPrenom(utilisateur.getPrenom());
		utilisateurDTO.setPseudo(utilisateur.getPseudo());
		this.service.saveOne(utilisateur);
		return utilisateurDTO;
	}

}

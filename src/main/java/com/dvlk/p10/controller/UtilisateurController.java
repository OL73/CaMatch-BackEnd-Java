package com.dvlk.p10.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
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

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PutMapping("/inscription")
	public ResponseEntity<Object> creationUtilisateur(@RequestBody Utilisateur utilisateur) {
		UtilisateurController.LOG.info("Dans la méthode POST UtilisateurController, PSEUDO : {} ,DATE : {}",
				utilisateur.getPseudo(), utilisateur.getDateNaissance());
		UtilisateurDTO utilisateurDTO = new UtilisateurDTO(utilisateur);
		utilisateurDTO.setEmail(utilisateur.getEmail());
		utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		this.service.saveOne(utilisateur);
		return new ResponseEntity<Object>(utilisateurDTO, HttpStatus.ACCEPTED);
	}

}

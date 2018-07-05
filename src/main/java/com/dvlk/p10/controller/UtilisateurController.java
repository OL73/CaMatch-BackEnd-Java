package com.dvlk.p10.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvlk.p10.bean.Utilisateur;
import com.dvlk.p10.dto.UtilisateurDTO;
import com.dvlk.p10.service.IUtilisateurService;
import com.dvlk.p10.service.i.ex.MauvaisMotdepasseException;
import com.dvlk.p10.service.i.ex.UtilisateurInconnuException;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class UtilisateurController {
	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private IUtilisateurService service;


	@PutMapping("/inscription")
	public ResponseEntity<Object> creationUtilisateur(@RequestBody Utilisateur utilisateur) {
		UtilisateurController.LOG.info("Dans la méthode POST UtilisateurController, PSEUDO : {} ,DATE : {}",
				utilisateur.getPseudo(), utilisateur.getDateNaissance());
		UtilisateurDTO utilisateurDTO = new UtilisateurDTO(utilisateur);
		utilisateurDTO.setEmail(utilisateur.getEmail());
		utilisateur.setPassword((utilisateur.getPassword()));
		this.service.saveOne(utilisateur);
		return new ResponseEntity<Object>(utilisateurDTO, HttpStatus.ACCEPTED);
	}

	@GetMapping("/profil/{id}")
	public ResponseEntity<Object> voirUtilisateur(@PathVariable("id") Integer id) {
		Utilisateur user = this.service.findOne(id);
		UtilisateurDTO utilisateurDTO = new UtilisateurDTO(user);
		return new ResponseEntity<Object>(utilisateurDTO, HttpStatus.ACCEPTED);
	}

	@PutMapping("/connexion")
	public ResponseEntity<Object> authentification(@PathVariable("pseudo") String pseudo,
			@PathVariable("password") String password, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		Utilisateur user = null;
		try {
			user = this.service.findByPseudoAndPassword(pseudo, password);
		} catch (UtilisateurInconnuException e) {
			e.printStackTrace();
		} catch (MauvaisMotdepasseException e) {
			e.printStackTrace();
		}
		session.setAttribute("pseudo", user.getPseudo());
		return new ResponseEntity<Object>(user, HttpStatus.ACCEPTED);
	}

}

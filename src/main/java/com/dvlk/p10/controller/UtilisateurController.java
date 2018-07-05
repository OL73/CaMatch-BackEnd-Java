package com.dvlk.p10.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
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
import com.dvlk.p10.dto.AuthenticationDTO;
import com.dvlk.p10.dto.ErreurDTO;
import com.dvlk.p10.dto.UtilisateurDTO;
import com.dvlk.p10.service.IUtilisateurService;
import com.dvlk.p10.service.i.ex.MauvaisMotdepasseException;
import com.dvlk.p10.service.i.ex.UtilisateurInconnuException;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class UtilisateurController extends AbstractController {
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
		return new ResponseEntity<Object>(utilisateurDTO, HttpStatus.OK);
	}

	@GetMapping("/profil/{id}")
	public ResponseEntity<Object> voirUtilisateur(@PathVariable("id") Integer id, HttpSession session) {
		Utilisateur user = this.service.findOne(id);
		if(user.getPseudo().equals(session.getAttribute("pseudo"))) {
			return new ResponseEntity<Object>(new ErreurDTO("Page non autorisée"), HttpStatus.ACCEPTED);
		}
		UtilisateurDTO utilisateurDTO = new UtilisateurDTO(user);
		return new ResponseEntity<Object>(utilisateurDTO, HttpStatus.OK);
	}

	@PutMapping("/connexion")
	public ResponseEntity<Object> authentification(@RequestBody AuthenticationDTO auth, HttpSession session,
			HttpServletResponse response) {
		if (isAuthenticate(session)) {
			try {
				response.sendRedirect("/api/salons");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Utilisateur user = null;
		try {
			user = this.service.findByPseudoAndPassword(auth.getPseudo(), auth.getPassword());
		} catch (UtilisateurInconnuException e) {
			e.printStackTrace();
		} catch (MauvaisMotdepasseException e) {
			e.printStackTrace();
		}
		Cookie cookie = new Cookie("pseudo", auth.getPseudo());
		response.addCookie(cookie);
		session.setAttribute("authentifie", user.getPseudo());
		return new ResponseEntity<Object>(auth, HttpStatus.ACCEPTED);
	}

}

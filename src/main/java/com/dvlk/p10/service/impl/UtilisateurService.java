package com.dvlk.p10.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvlk.p10.bean.Utilisateur;
import com.dvlk.p10.repository.IUtilisateurRepository;
import com.dvlk.p10.service.IUtilisateurService;
import com.dvlk.p10.service.i.ex.MauvaisMotdepasseException;
import com.dvlk.p10.service.i.ex.UtilisateurInconnuException;

@Service
public class UtilisateurService implements IUtilisateurService {
	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private IUtilisateurRepository utilisateurRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveOne(Utilisateur utilisateur) {
		this.utilisateurRepository.save(utilisateur);
	}

	@Override
	public Utilisateur findOne(Integer id) {
		Utilisateur user = this.utilisateurRepository.findOne(id);
		return user;
	}

	@Override
	public Utilisateur findOneByPseudo(String pseudo) {
		Utilisateur user = this.utilisateurRepository.findUtilisateurByPseudo(pseudo);
		return user;
	}

	@Override
	public Utilisateur findByPseudoAndPassword(String pseudo, String password)
			throws UtilisateurInconnuException, MauvaisMotdepasseException {
		if (pseudo == null || pseudo.trim().length() == 0) {
			UtilisateurService.LOG.debug("Le login est incorrect");
			throw new IllegalArgumentException("login");
		}
		if (password == null || password.trim().length() == 0) {
			UtilisateurService.LOG.debug("Le mot de passe est incorrect");
			throw new IllegalArgumentException("password");
		}
		Utilisateur user = this.utilisateurRepository.findUtilisateurByPseudoAndPassword(pseudo, password);
		if (user == null) {
			throw new UtilisateurInconnuException();
		}
		if (!password.equals(user.getPassword())) {
			throw new MauvaisMotdepasseException();
		}
		UtilisateurService.LOG.debug("Authentification reussi, Resultat = {} ", user);
		return user;
	}

}

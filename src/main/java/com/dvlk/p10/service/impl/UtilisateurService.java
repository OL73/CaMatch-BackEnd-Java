package com.dvlk.p10.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvlk.p10.bean.Utilisateur;
import com.dvlk.p10.repository.IUtilisateurRepository;
import com.dvlk.p10.service.IUtilisateurService;

@Service
public class UtilisateurService implements IUtilisateurService {
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

}

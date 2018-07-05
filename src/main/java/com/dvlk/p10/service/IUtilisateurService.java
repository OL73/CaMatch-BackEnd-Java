package com.dvlk.p10.service;

import com.dvlk.p10.bean.Utilisateur;
import com.dvlk.p10.service.i.ex.MauvaisMotdepasseException;
import com.dvlk.p10.service.i.ex.UtilisateurInconnuException;

public interface IUtilisateurService {

	public abstract void saveOne(Utilisateur utilisateur);

	public abstract Utilisateur findOne(Integer id);

	public abstract Utilisateur findOneByPseudo(String pseudo);

	public abstract Utilisateur findByPseudoAndPassword(String pseudo, String password)
			throws UtilisateurInconnuException, MauvaisMotdepasseException;
}

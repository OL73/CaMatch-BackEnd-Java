package com.dvlk.p10.service;

import com.dvlk.p10.bean.Utilisateur;

public interface IUtilisateurService {

	public abstract void saveOne(Utilisateur utilisateur);

	public abstract Utilisateur findOne(Integer id);

	public abstract Utilisateur findOneByPseudo(String pseudo);

}

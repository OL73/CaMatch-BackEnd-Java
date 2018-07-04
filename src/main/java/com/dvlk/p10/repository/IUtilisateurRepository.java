package com.dvlk.p10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dvlk.p10.bean.Utilisateur;

@Repository
public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

	public Utilisateur findUtilisateurByPseudo(String pseudo);
}

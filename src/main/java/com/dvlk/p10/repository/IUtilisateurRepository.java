package com.dvlk.p10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dvlk.p10.bean.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

	@Query("FROM Utilisateur user WHERE :aSalonId = SalonRoleUtilisateur.")
	public List<Utilisateur> findAllUtilisateurBySalonId(@Param("aSalonId") int aSalonId);

}

package com.dvlk.p10.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvlk.p10.bean.Salon;
import com.dvlk.p10.bean.SalonRoleUtilisateur;
import com.dvlk.p10.bean.Utilisateur;
import com.dvlk.p10.dto.AccueilDTO;
import com.dvlk.p10.dto.PageSalonDTO;
import com.dvlk.p10.dto.SalonDTO;
import com.dvlk.p10.dto.UtilisateurDTO;
import com.dvlk.p10.service.ISalonService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class SalonController extends AbstractController {
	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private ISalonService service;

	@GetMapping("/salons")
	public AccueilDTO getSalons() {

		List<Salon> lstSalons = this.service.findAllSalons();

		List<SalonDTO> mesSalons = new ArrayList<>(lstSalons.size());
		for (Salon salon : lstSalons) {
			SalonDTO sdto = new SalonDTO();
			sdto.setIdLieu(salon.getTerrain().getLieu().getId());
			sdto.setLibelleLieu(salon.getTerrain().getLieu().getNom());
			sdto.setDate(salon.getDate());
			sdto.setPrix(salon.getTerrain().getPrix());
			Set<SalonRoleUtilisateur> users = salon.getSalonRoleUtilisateurs();
			// TODO Trop intel pour un controleur
			Utilisateur admin = null;
			for (SalonRoleUtilisateur salonRoleUtilisateur : users) {
				// TODO valider nom des roles
				if ("admin".equals(salonRoleUtilisateur.getRole())) {
					admin = salonRoleUtilisateur.getUtilisateur();
					break;
				}
			}
			if (admin != null) {
				sdto.setFullNameAdminSalon(admin.getNom() + " " + admin.getPrenom());
				sdto.setIdAdminSalon(admin.getId());
			} else {
				// TODO a gerer
			}
			sdto.setId(salon.getId());
			sdto.setJoueurMax(salon.getJoueurMax());
			sdto.setNbJoueurs(users.size());
			sdto.setDescription(salon.getDescription());
			sdto.setSport(salon.getSport().getNom());
			mesSalons.add(sdto);
		}
		AccueilDTO result = new AccueilDTO();
		result.setSalons(mesSalons);
		return result;
	}

	@GetMapping("/salon/{id}")
	public PageSalonDTO getSalon(@PathVariable("id") Integer id) {
		SalonController.LOG.info("Rentré dans le get SalonController");
		PageSalonDTO pSalonDTO = new PageSalonDTO();
		Salon salon = this.service.findSalon(id);
		SalonDTO salonDTO = new SalonDTO();
		salonDTO.setDate(salon.getDate());
		List<UtilisateurDTO> lstUtilisateursDTO = new ArrayList<>();
		Set<SalonRoleUtilisateur> users = salon.getSalonRoleUtilisateurs();
		salonDTO.setJoueurMax(salon.getJoueurMax());

		for (SalonRoleUtilisateur salonRoleutilisateur : users) {
			SalonController.LOG.info("Dans le controller Salon ID, INFO UTILISATEUR : {}",
					salonRoleutilisateur.getUtilisateur());
			UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
			utilisateurDTO.setId(salonRoleutilisateur.getUtilisateur().getId());
			utilisateurDTO.setPseudo(salonRoleutilisateur.getUtilisateur().getPseudo());
			utilisateurDTO.setNiveau(salonRoleutilisateur.getUtilisateur().getNiveau());
			utilisateurDTO.setNom(salonRoleutilisateur.getUtilisateur().getNom());
			utilisateurDTO.setNote(salonRoleutilisateur.getUtilisateur().getNote());
			utilisateurDTO.setPenalite(salonRoleutilisateur.getUtilisateur().getPenalite());
			utilisateurDTO.setPrenom(salonRoleutilisateur.getUtilisateur().getPrenom());
			if ("admin".equals(salonRoleutilisateur.getRole())) {
				salonDTO.setFullNameAdminSalon(salonRoleutilisateur.getUtilisateur().getNom());
			}
			lstUtilisateursDTO.add(utilisateurDTO);
		}

		salonDTO.setNbJoueurs(lstUtilisateursDTO.size());
		pSalonDTO.setLstutilisateurDTO(lstUtilisateursDTO);
		pSalonDTO.setSalon(salonDTO);
		return pSalonDTO;
	}

}

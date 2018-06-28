package com.dvlk.p10.dto;

import java.util.List;

public class PageSalonDTO {
	private SalonDTO salon;
	private List<UtilisateurDTO> lstutilisateurDTO;

	public PageSalonDTO() {
		super();
	}

	public SalonDTO getSalon() {
		return this.salon;
	}

	public void setSalon(SalonDTO salon) {
		this.salon = salon;
	}

	public List<UtilisateurDTO> getLstutilisateurDTO() {
		return this.lstutilisateurDTO;
	}

	public void setLstutilisateurDTO(List<UtilisateurDTO> lstutilisateurDTO) {
		this.lstutilisateurDTO = lstutilisateurDTO;
	}

}

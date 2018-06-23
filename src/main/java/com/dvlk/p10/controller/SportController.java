package com.dvlk.p10.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvlk.p10.bean.Sport;
import com.dvlk.p10.service.ISportService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class SportController {
	
	@Autowired
	private ISportService service;
	
	@PostMapping("/sport")
	public Sport saveSport(String nom, String description) {
		Sport sport = new Sport();
		sport.setNom(nom);
		sport.setDescription(description);
		this.service.saveOne(sport);
		return sport;
	}
}

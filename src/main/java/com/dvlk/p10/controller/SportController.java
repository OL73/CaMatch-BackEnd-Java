package com.dvlk.p10.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvlk.p10.bean.Sport;
import com.dvlk.p10.service.ISportService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class SportController extends AbstractController {

	@Autowired
	private ISportService service;

	@PostMapping("/sport")
	public Sport saveSport(@RequestBody Sport sport) {
		this.service.saveOne(sport);
		return sport;
	}
}

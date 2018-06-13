package com.dvlk.p10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvlk.p10.bean.Salon;
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class SalonController {

	@GetMapping("/salons")
	public Salon getSalons() {
		Salon s = new Salon();
		return s;
	}
	

}

package com.dvlk.p10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvlk.p10.bean.Salon;
import com.dvlk.p10.repository.SalonRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class SalonController {
	@Autowired
	private SalonRepository salonRepository;
	
	@GetMapping("/")
	public List<Salon> getSalons(List<Salon> lstSalons) {
		return lstSalons;
	}

	@GetMapping("/salon/{id}")
	public Salon getSalon(@PathVariable("id") int id, Salon salon) {
		return salon;
	}
	

}

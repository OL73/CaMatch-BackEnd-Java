package com.dvlk.p10.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvlk.p10.bean.Salon;
import com.dvlk.p10.repository.ISalonRepository;
import com.dvlk.p10.service.ISalonService;

@Service
public class SalonService implements ISalonService {

	@Autowired
	private ISalonRepository salonRepository;

	@Override
	public List<Salon> findAllSalons() {
		List<Salon> lstSalons = this.salonRepository.findAll();
		return lstSalons;
	}

	@Override
	public Salon findSalon(Integer id) {
		Salon salon = this.salonRepository.findOne(id);
		return salon;
	}

}

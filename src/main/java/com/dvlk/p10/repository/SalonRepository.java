package com.dvlk.p10.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvlk.p10.bean.Salon;

public interface SalonRepository extends JpaRepository<Salon, Integer> {
	
}

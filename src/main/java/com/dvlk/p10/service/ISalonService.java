package com.dvlk.p10.service;

import java.util.List;

import com.dvlk.p10.bean.Salon;

public interface ISalonService {
	public abstract List<Salon> findAllSalons();

	public abstract Salon findSalon(Integer id);
}

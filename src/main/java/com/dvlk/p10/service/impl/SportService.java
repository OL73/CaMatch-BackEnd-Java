package com.dvlk.p10.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvlk.p10.bean.Sport;
import com.dvlk.p10.repository.ISportRepository;
import com.dvlk.p10.service.ISportService;

@Service
public class SportService implements ISportService{

	@Autowired
	private ISportRepository sportRepository;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void saveOne(Sport sport) {
		this.sportRepository.save(sport);
	}

}

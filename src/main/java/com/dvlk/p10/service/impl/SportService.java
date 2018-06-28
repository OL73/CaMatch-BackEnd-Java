package com.dvlk.p10.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvlk.p10.bean.Sport;
import com.dvlk.p10.repository.ISportRepository;
import com.dvlk.p10.service.ISportService;

@Service
public class SportService implements ISportService{

	@Autowired
	private ISportRepository sportRepository;

	@Override
	// Attention a l'import pour @Transactional = vient du Spring !
	@Transactional(rollbackFor = Exception.class)
	public void saveOne(Sport sport) {
		this.sportRepository.save(sport);
	}

}

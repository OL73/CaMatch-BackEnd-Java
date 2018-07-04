package com.dvlk.p10.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvlk.p10.bean.Role;
import com.dvlk.p10.repository.IRoleRepository;
import com.dvlk.p10.service.IRoleService;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private IRoleRepository roleRepository;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void saveOne(Role role) {
		this.roleRepository.save(role);
	}

}

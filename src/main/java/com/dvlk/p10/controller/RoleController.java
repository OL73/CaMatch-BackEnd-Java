package com.dvlk.p10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvlk.p10.bean.Role;
import com.dvlk.p10.service.IRoleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class RoleController {
	@Autowired
	private IRoleService service;

	@PostMapping("/role")
	public Role saveRole(@RequestBody Role role) {
		this.service.saveOne(role);
		return role;
	}
}

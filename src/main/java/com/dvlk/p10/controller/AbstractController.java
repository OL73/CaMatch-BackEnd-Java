package com.dvlk.p10.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public abstract class AbstractController {
	protected boolean isAuthenticate(HttpSession session) {
		return session != null && session.getAttribute("authentifie") != null;
	}
}

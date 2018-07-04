package com.dvlk.p10.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dvlk.p10.bean.Role;
import com.dvlk.p10.bean.Utilisateur;
import com.dvlk.p10.repository.IUtilisateurRepository;

@Service
public class UtilisateurDetailsService implements UserDetailsService {

	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private IUtilisateurRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UtilisateurDetailsService.LOG.debug("//  Dans la methode findUser de UtilisateurDetails Service");
		Utilisateur user = repository.findUtilisateurByPseudo(username);
		List<Role> roles = new ArrayList<>(user.getRoles());
		List<GrantedAuthority> lstGranted = new ArrayList<>();
		for (Role role : roles) {
			GrantedAuthority ga = new SimpleGrantedAuthority("ROLE_" + role.getLibelle());
			lstGranted.add(ga);
		}
		User u = new User(user.getPseudo(), user.getPassword(), lstGranted);
		return u;
	}

}

package com.dvlk.p10.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Va gerer la securisation de nos servlet et JSP. <br/>
 *
 * On filtre TOUS les URLs et on fait des if sur les ressources qui ne doivent
 * pas etre filtrees.<br/>
 *
 * Il n'y a plus de gestion dans les servlet et les JSPs, tout ce passe
 * ici.<br/>
 *
 * Une autre maniere de faire : filtrer uniquement les URL qui doivent l'etre
 * (les controleurs sauf login) et placer les JSP dans le repertoire
 * WEB-INF<br/>
 */
public class SecurityFilter implements Filter {
	private static final Logger LOG = LogManager.getLogger();

	/**
	 * Constructeur.
	 */
	public SecurityFilter() {
		super();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		SecurityFilter.LOG.debug("Passage dans le filtre de securite");
		// On passe a la suite
		if (request instanceof HttpServletRequest) {
			((HttpServletRequest) request).getSession();
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		SecurityFilter.LOG.trace("destroy du filtre de securite : Ne fait rien");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		SecurityFilter.LOG.debug("init du filtre de securite : Ne fait rien");
	}

}

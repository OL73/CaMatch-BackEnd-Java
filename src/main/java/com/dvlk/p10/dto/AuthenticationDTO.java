package com.dvlk.p10.dto;

public class AuthenticationDTO {
	private String pseudo;
	private String password;

	public AuthenticationDTO() {
		super();
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

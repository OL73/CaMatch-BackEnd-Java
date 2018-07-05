package com.dvlk.p10.dto;

public class ErreurDTO {
	private String message;
	private String type;

	public ErreurDTO() {
		super();
	}

	public ErreurDTO(String message) {
		this.message = message;
	}

	public ErreurDTO(Exception e) {
		this.message = e.getMessage();
		this.type = e.getClass().getName();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

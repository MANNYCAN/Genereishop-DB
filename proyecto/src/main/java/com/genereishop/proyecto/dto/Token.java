package com.genereishop.proyecto.dto;

public class Token {
	private final String accessToken;

	public Token(String accessToken) {
		this.accessToken = accessToken;
	}// Token contructor

	public String getAccessToken() {
		return accessToken;
	}// getAccessToken
	
}//class Token

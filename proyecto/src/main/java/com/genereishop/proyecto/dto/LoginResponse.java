package com.genereishop.proyecto.dto;

public class LoginResponse {
    private String accessToken;
    private String userName;
    private String email;

    public LoginResponse(String accessToken, String userName, String email) {
        this.accessToken = accessToken;
        this.userName = userName;
        this.email = email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getUserName() {
        return userName;
    }

	public String getEmail() {
		return email;
	}

}

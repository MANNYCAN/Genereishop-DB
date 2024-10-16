package com.genereishop.proyecto.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genereishop.proyecto.config.JwtFilter;
import com.genereishop.proyecto.dto.Token;
import com.genereishop.proyecto.modelo.User;
import com.genereishop.proyecto.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/")
public class LoginController {
	
	private final UserService userService;
	
	
	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}//LoginController constructor
	
	
	@PostMapping
	public Token loginUser(@RequestBody User user) throws ServletException {
		if (userService.validateUser(user)) {
			System.out.println("User válido " + user.getUserEmail());
			return new Token (generateToken(user.getUserEmail()));
		}//validateUSer
		throw new ServletException ("Nombre de user o contraseña incorrectos [" +
				user.getUserEmail() +  "]");
	}//Token loginUser


	private String generateToken(String email) {
		Calendar calendar = Calendar.getInstance(); // Gecha y hora de hoy
		calendar.add(Calendar.HOUR, 12); // Prueba / Desarrollo
		//calendar.add(Calendar.MINUTE, 12);// Produccion
		return Jwts.builder().setSubject(email).claim("role", "user")
				.setIssuedAt(new Date())
				.setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
				.compact();
	}//generateToken
}//class LoginController

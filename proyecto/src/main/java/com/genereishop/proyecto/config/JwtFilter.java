package com.genereishop.proyecto.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean{	
	
	public static String secret = "GenereishopEquipo5";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String authHeader = httpServletRequest.getHeader("Authorization");
		if (  (("POST".equals(httpServletRequest.getMethod())) && 
	            (!httpServletRequest.getRequestURI().contains("/api/users/")))  // Registro
	        ||
	        (("GET".equals(httpServletRequest.getMethod())) && 
	            (!httpServletRequest.getRequestURI().contains("/api/productos/")) &&  // Productos
	            (!httpServletRequest.getRequestURI().contains("/api/users/")))  // GET a users no requiere autorización
	        ||
	        ("PUT".equals(httpServletRequest.getMethod())) ||
	        ("DELETE".equals(httpServletRequest.getMethod()))
	    ) {
	        // Validación del encabezado Authorization
	        if (authHeader == null || !authHeader.startsWith("Bearer")) {
	            System.out.println("1. Invalid Token");
	            throw new ServletException("1. Invalid Token");
	        }
			String token = authHeader.substring(7);
			try {
			Claims claims = Jwts.parser().setSigningKey(secret)
					.parseClaimsJws(token).getBody();
			claims.forEach((key,value)->System.out.println("key: " + key + " value: " + value));
			}catch(SignatureException | MalformedJwtException | ExpiredJwtException e) {
				System.out.println("2. Invalid Token");
				throw new ServletException("2. Invalid Token");
			}//catch
		}//if getMethod
		chain.doFilter(request, response); // esta sera siempre la ultima linea de cualquier 
		//dofilter que se implemente, para continuar con el siguiente filtro aunque no exista
	}//doFilter
}//class JwtFilter

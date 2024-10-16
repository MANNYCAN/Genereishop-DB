package com.genereishop.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.genereishop.proyecto.config.JwtFilter;

@SpringBootApplication
public class ProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}//main
	
	@Bean  //Creo que aqui implementa mi metodo de Filtro
	//Con esto podemos filtrar lo que sea el * es para indicar si es que llega a llevar un *
	public FilterRegistrationBean<JwtFilter> jwtFilter(){
		FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<JwtFilter>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/productos/*");
		registrationBean.addUrlPatterns("/api/users/*");
		return registrationBean;
	}//jwtFilter
	
	
}//class ProyectoApplication

package com.genereishop.proyecto;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.genereishop.proyecto.modelo.Product;


@SpringBootTest
@AutoConfigureMockMvc
class ProyectoApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	private final String token = "Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwcnVlYmFAZ21haWwuY29tIiwicm9sZSI6InVzZXIiLCJpYXQiOjE3MjkxMDk4ODEsImV4cCI6MTcyOTE1MzA4MX0.jlKyiEfOsAzDVBAjQscKaeCtn8bMiWu7eHu3_75bldQ";
	@Test
	@DisplayName("Se prueba el endpoint http://localhost:8080/api/productos/1")
	void pruebaGET() throws Exception {
		this.mockMvc.perform(get ("/api/productos/1"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(
								content().string(containsString("Calcetas Transpirables-Gris")));
	}//pruebaGET
	
	@Test
	@Disabled("Probado la primera vez, deshabilitado despues de la promera vez")
	@DisplayName("Se prueba borrar el producto con id 8 http://localhost:8080/api/productos/8")
	void pruebaDelete() throws Exception {
		this.mockMvc.perform(delete ("/api/productos/8").header("Authorization",token))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(
								content().string(containsString("Pluma y Lapicero Zebra Z-Grip Silver Azul")));
	}//pruebaDelete
	
	
	@Test
	@DisplayName("Se prueba actualizar el producto con id 2 http://localhost:8080/api/productos/2")
	void pruebaPut() throws Exception {
		this.mockMvc.perform(put ("/api/productos/2?productPrice=251").header("Authorization",token))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(
								content().string(containsString("Short")));
	}//pruebaPut
	
	@Test
	@Disabled("Probado la primera vez, deshabilitado despues de la promera vez")
	@DisplayName("Se prueba crear un nuevo producto http://localhost:8080/api/productos/")
	void pruebaPost() throws Exception{
		Product p = new Product();
		p.setProductName("Pluma y Lapicero Zebra Z-Grip Silver Azul");
		p.setProductDescription("Pluma y Lapicero Zebra Z-Grip Silver Azul");
		p.setProductImage("100161506.jpeg");
		p.setProductPrice(79);
		p.setProductStock(0);
		this.mockMvc.perform(
				post ("/api/productos/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(p))
				.header("Authorization",token))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(
								content().string(containsString("Z-Grip Silver"))
								//aqui va cualquier texto que venga dentro del objeto
								);
	}//pruebaPut
	
	
	private static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
	 } // asJsonString
}

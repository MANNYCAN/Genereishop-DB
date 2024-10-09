package com.genereishop.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genereishop.proyecto.modelo.Adress;
import com.genereishop.proyecto.service.AdressService;

@RequestMapping(path="/api/direcciones/")
@RestController
public class AdressController {
	private final AdressService adressService;

	@Autowired
	public AdressController(AdressService adressService) {
		this.adressService = adressService;
	}//constructor
	
	@GetMapping
	public List<Adress> getAdresses(){
		return adressService.getAllAdresses();
	}//getAdresses
	
	@GetMapping(path="{adressId}")
	public Adress getAdress(@PathVariable("adressId") Long adressId) {
		return adressService.getAdress(adressId);
	}//getAdress
	
	@PostMapping
	public Adress addAdress(@RequestBody Adress adress) {
		return adressService.addAdress(adress);
	}//addAdress
	
	@DeleteMapping(path="{adressId}")
	public Adress deleteAdress(@PathVariable("adressId") Long adressId) {
		return adressService.deleteAdress(adressId);
	}//deleteAdress
	
	@PutMapping(path="{adressId}")
	public Adress updateAdress(@RequestBody Adress newAdress, @PathVariable("adressId") Long adressId) {
		return adressService.updateAdress(adressId, newAdress);
	}//updateAdress
	
}//class AdressController

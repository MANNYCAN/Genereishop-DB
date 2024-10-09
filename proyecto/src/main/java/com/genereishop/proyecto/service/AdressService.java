package com.genereishop.proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.genereishop.proyecto.modelo.Adress;

@Service
public class AdressService {
	private final ArrayList<Adress> lista = new ArrayList<Adress>();

	public AdressService() {
		lista.add(new Adress("Yucatán", 97452, "5c", "680", null));
		lista.add(new Adress("Jalisco", 44100, "Calzada Independencia", "456", null));
		lista.add(new Adress("Nuevo León", 64000, "Calle Morelos", "789", "2A"));
		lista.add(new Adress("Puebla", 72000, "Boulevard 5 de Mayo", "101", null));
	}//constructor

	public List<Adress> getAllAdresses() {
		return lista;
	}//getAllAdresses

	public Adress getAdress(Long adressId) {
		Adress direccion = null;
		for (Adress adress : lista) {
			if(adress.getId()==adressId) {
				direccion = adress;
				break;
			}//if
		}//foreach
		return direccion;
	}//getAdress

	public Adress addAdress(Adress adress) {
		lista.add(adress);
		return adress;
	}//addAdress

	public Adress deleteAdress(Long adressId) {
		Adress direccion = null;
		for (Adress adress : lista) {
			if(adress.getId()==adressId) {
				direccion = lista.remove(lista.indexOf(adress));
				break;
			}//if
		}//foreach
		return direccion;
	}//deleteAdress

	public Adress updateAdress(Long adressId, Adress newAdress) {
		Adress direccion = null;
		for (Adress adress : lista) {
			if(adress.getId()==adressId) {
				if(newAdress.getAdressState() != null) adress.setAdressState(newAdress.getAdressState());
				if(newAdress.getAdressZip() != null) adress.setAdressZip(newAdress.getAdressZip());
				if(newAdress.getAdressStreet() != null) adress.setAdressStreet(newAdress.getAdressStreet());
				if(newAdress.getAdressExtNum() != null) adress.setAdressExtNum(newAdress.getAdressExtNum());
				if(newAdress.getAdressIntNum() != null) adress.setAdressIntNum(newAdress.getAdressIntNum());
				direccion = adress;
				break;
			}//if
		}//foreach
		return direccion;
	}//updateAdress
	
}//class AdressService

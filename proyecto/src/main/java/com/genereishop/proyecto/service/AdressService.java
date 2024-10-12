package com.genereishop.proyecto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genereishop.proyecto.modelo.Adress;
import com.genereishop.proyecto.repository.AdressRepository;

@Service
public class AdressService {
	public final AdressRepository adressRepository;

	@Autowired
	public AdressService(AdressRepository adressRepository) {
		this.adressRepository = adressRepository;
	}//constructor

	public List<Adress> getAllAdresses() {
		return adressRepository.findAll();
	}//getAllAdresses

	public Adress getAdress(Long adressId) {
		return adressRepository.findById(adressId).orElseThrow(()-> new IllegalArgumentException("La dirección con el id [" + adressId
				+ "] no existe"));
	}//getAdress

	public Adress addAdress(Adress adress) {
		Optional<Adress> dir = adressRepository.findByAdressId(adress.getId());
		if (dir.isEmpty()) {//No existe la dirección
			return	adressRepository.save(adress);
		}else {		//Si existe la dirección
			System.out.println("La dirección [" + adress.getId()
					+ "] ya se encuentra registrada");
			return null;
			}
	}//addAdress

	public Adress deleteAdress(Long adressId) {
		Adress dir=null;
		if (adressRepository.existsById(adressId)) {
			dir=adressRepository.findById(adressId).get();
			adressRepository.deleteById(adressId);
		}//ifexist
		return dir;
	}//deleteAdress

	public Adress updateAdress(Long adressId, Adress newAdress) {
		Adress direccion=null;
		if (adressRepository.existsById(adressId)) {
			Adress adress = adressRepository.findById(adressId).get();
			if(newAdress.getAdressState() != null) adress.setAdressState(newAdress.getAdressState());
			if(newAdress.getAdressZip() != null) adress.setAdressZip(newAdress.getAdressZip());
			if(newAdress.getAdressStreet() != null) adress.setAdressStreet(newAdress.getAdressStreet());
			if(newAdress.getAdressExtNum() != null) adress.setAdressExtNum(newAdress.getAdressExtNum());
			if(newAdress.getAdressIntNum() != null) adress.setAdressIntNum(newAdress.getAdressIntNum());
				adressRepository.save(adress);
				direccion=adress;
		}//exists
		return direccion;
		
//		Adress direccion = null;
//		for (Adress adress : lista) {
//			if(adress.getId()==adressId) {
//				if(newAdress.getAdressState() != null) adress.setAdressState(newAdress.getAdressState());
//				if(newAdress.getAdressZip() != null) adress.setAdressZip(newAdress.getAdressZip());
//				if(newAdress.getAdressStreet() != null) adress.setAdressStreet(newAdress.getAdressStreet());
//				if(newAdress.getAdressExtNum() != null) adress.setAdressExtNum(newAdress.getAdressExtNum());
//				if(newAdress.getAdressIntNum() != null) adress.setAdressIntNum(newAdress.getAdressIntNum());
//				direccion = adress;
//				break;
//			}//if
//		}//foreach
//		return direccion;
	}//updateAdress
	
}//class AdressService

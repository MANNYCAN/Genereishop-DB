package com.genereishop.proyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genereishop.proyecto.modelo.Adress;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long>{
	Optional<Adress> findByAdressId(Long adressId);
}

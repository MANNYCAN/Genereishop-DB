package com.genereishop.proyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genereishop.proyecto.modelo.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
Optional<Product> findByproductName(String productName);
}

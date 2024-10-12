package com.genereishop.proyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genereishop.proyecto.modelo.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
Optional<Product> findByproductName(String productName);
}

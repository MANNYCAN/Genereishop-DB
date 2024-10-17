package com.genereishop.proyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.genereishop.proyecto.modelo.OrderHasProduct;

@Repository
public interface OrderHasProductRepository extends JpaRepository<OrderHasProduct, Long>{
	Optional<OrderHasProduct> findByOrderHasProductId(Long orderHasProductId);
	Optional<OrderHasProduct> findByOrderOrderIdFk(Long orderOrderIdFk);
	Optional<OrderHasProduct> findByProductProductIdFk(Long productProductIdFk);
}//OrderHasProductRepository

package com.genereishop.proyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genereishop.proyecto.modelo.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	Optional<Order> findByOrderId(Long orderId);
}

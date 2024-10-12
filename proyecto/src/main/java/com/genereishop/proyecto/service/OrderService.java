package com.genereishop.proyecto.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genereishop.proyecto.modelo.Order;
import com.genereishop.proyecto.modelo.User;
import com.genereishop.proyecto.repository.OrderRepository;


@Service
public class OrderService {
	
	public final OrderRepository orderRepository; 
	
	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<Order> gettAllOrders() {
		return orderRepository.findAll();
	}//gettAllOrders

	public Order getOrders(Long orderId) {
		return orderRepository.findById(orderId).orElseThrow( ()-> new IllegalArgumentException("La orden con el id [" + orderId
				+ "] no existe"));
	}//getOrder

	public Order addOrder(Order order) {
		Optional<Order> ord = orderRepository.findByOrderId(order.getOrderId());
		if(ord.isEmpty()) {
			return orderRepository.save(order);
		}
		return null;
	}//addOrder

	public Order deleteOrder(Long orderId) {
		Order order=null;
		if (orderRepository.existsById(orderId)) {
			order = orderRepository.findById(orderId).get();
			orderRepository.deleteById(orderId);
		}//ifExists
		return order;
	}//deleteOrder

	public Order updateService(Long orderId, LocalDate orderDate) {
		Order or=null;
		if(orderRepository.existsById(orderId)) {
			Order order = orderRepository.findById(orderId).get();
			if(orderDate != null) {
				order.setOrderDate(orderDate);
				orderRepository.save(order);
				or=order;
			}
		}//repository
		return or;
	}//updateService
	
	
	
}//OrderService

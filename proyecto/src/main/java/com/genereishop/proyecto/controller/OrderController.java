package com.genereishop.proyecto.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.genereishop.proyecto.modelo.Order;
import com.genereishop.proyecto.service.OrderService;

@RestController
@RequestMapping("/api/orders/")
public class OrderController {
	private final OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService= orderService;
	}// constructor
	
	
	@GetMapping // https:localhost:8080/api/orders
	public List<Order> getOrders(){
		return orderService.gettAllOrders();
	}//getUsuarios
	
	
	@GetMapping(path="{orderId}") //https:localhost:8080/api/orders/1
	public Order getOrders(@PathVariable("orderId")Long orderId) {
		return orderService.getOrders(orderId);
	}//getOrders
	
	@PostMapping
	public Order addOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}//addOrder
	
	@DeleteMapping (path="{orderId}")//https:localhost:8080/api/orders/1
	public Order deleteOrder(@PathVariable ("orderId")Long orderId) {
		return orderService.deleteOrder(orderId);
	}//delteOrder
	
	@PutMapping(path="{orderId}")//https:localhost:8080/api/orders/1
	public Order updateOrder(@PathVariable ("orderId") Long orderId,
							 @RequestParam (required=false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate orderDate){
		return orderService.updateService(orderId, orderDate);
	}//updateOrder
	
}//OrderController

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.genereishop.proyecto.modelo.OrderHasProduct;
import com.genereishop.proyecto.service.OrderHasProductService;

@RestController
@RequestMapping ("/api/ordershasproducts/")
public class OrderHasProductController {
	private final OrderHasProductService orderHasProductService;
	
	
	@Autowired
	public OrderHasProductController(OrderHasProductService orderHasProductService) {
		this.orderHasProductService = orderHasProductService;
	}//OrderHasProductController Constructor
	
	
	@GetMapping //https:localhost:8080/api/ordershasproducts/)
	public List<OrderHasProduct> getOrdersHasProducts(){
		return orderHasProductService.getAllOrdersHasProducts();
	}//getOrdersHasProducts
	
	
	@GetMapping (path="{orderId}")//https:localhost:8080/api/ordershasproducts/1)
	public OrderHasProduct getOrderHasProduct(@PathVariable ("orderId") Long orderId) {
		return orderHasProductService.getOrderHasProduct(orderId);
	}//getOrderHasProduct
	
	
	@PostMapping
	public OrderHasProduct addOrderHasProduct(@RequestBody OrderHasProduct orderHasProduct) {
		return orderHasProductService.addOrderHasProduct(orderHasProduct);
	}//addOrderHasProduct
	
	
	@DeleteMapping (path="{orderId}")//https:localhost:8080/api/ordershasproducts/1)
	public OrderHasProduct deleteOrderHasProduct(@PathVariable ("orderId") Long orderId) {
		return orderHasProductService.deleteOrderHasProduct(orderId);
	}//deleteOrderHasProduct
	
	
	@PutMapping (path="{orderId}")//https:localhost:8080/api/ordershasproducts/1)
	public OrderHasProduct updateOrderHasProduct(@PathVariable ("orderId") Long orderId,
												 @RequestParam (required=false) Long oHPQuantity) {
	return orderHasProductService.updateOrderHasProduct(orderId, oHPQuantity);
	}//updateOrderHasProduct
}//class OrderHasProductController

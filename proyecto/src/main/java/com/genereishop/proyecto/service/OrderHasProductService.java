package com.genereishop.proyecto.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.genereishop.proyecto.modelo.OrderHasProduct;
import com.genereishop.proyecto.repository.OrderHasProductRepository;


@Service
public class OrderHasProductService {

	
	
public final OrderHasProductRepository orderHasProductRepository; 
	
	@Autowired
	public OrderHasProductService(OrderHasProductRepository orderHasProductRepository) {
		this.orderHasProductRepository = orderHasProductRepository;
	}//contructor


	public List<OrderHasProduct> gettAllOrderHasProducts() {
		return orderHasProductRepository.findAll();
	}//gettAllOrders

	
	public OrderHasProduct getOrderHasProduct(Long orderHasProductId) {
		return orderHasProductRepository.findById(orderHasProductId).orElseThrow( ()-> new IllegalArgumentException("La ordenHasProduct con el id [" + orderHasProductId
				+ "] no existe"));
	}//getOrder

	public OrderHasProduct addOrderHasProduct(OrderHasProduct orderHasProduct) {
		Optional<OrderHasProduct> ord = orderHasProductRepository.findByOrderOrderIdFk(orderHasProduct.getOrder_orderId_fk());
		Optional<OrderHasProduct> or = orderHasProductRepository.findByProductProductIdFk(orderHasProduct.getProduct_productId_fk());
		if((ord.isEmpty()) || (or.isEmpty())) {
			return orderHasProductRepository.save(orderHasProduct);
		}
		return null;
	}//addOrder POST

	public OrderHasProduct deleteOrderHasProduct(Long orderHasProductId) {
		OrderHasProduct order=null;
		if (orderHasProductRepository.existsById(orderHasProductId)) {
			order = orderHasProductRepository.findByOrderHasProductId(orderHasProductId).get();
			orderHasProductRepository.deleteById(orderHasProductId);
		}//ifExists
		return order;
	}//deleteOrder

	public OrderHasProduct updateOrderHasProduct(Long orderHasProductId, Long oHPQuantity) {
		OrderHasProduct or=null;
		if(orderHasProductRepository.existsById(orderHasProductId)) {
			OrderHasProduct order = orderHasProductRepository.findById(orderHasProductId).get();
			if(oHPQuantity != null) {
				order.setoHPQuantity(oHPQuantity);
				orderHasProductRepository.save(order);
				or=order;
			}
		}//repository
		return or;
	}//updateService
}// class OrderHasProductService

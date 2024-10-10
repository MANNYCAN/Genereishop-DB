package com.genereishop.proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.genereishop.proyecto.modelo.OrderHasProduct;

@Service
public class OrderHasProductService {
	private final ArrayList<OrderHasProduct> lista = new ArrayList<OrderHasProduct>();
	public OrderHasProductService(){
		lista.add(new OrderHasProduct(Long.valueOf(50L)));
		lista.add(new OrderHasProduct(Long.valueOf(13L)));
	}//constructor OrderHasProductService
	
	
	public List<OrderHasProduct> getAllOrdersHasProducts() {
		return lista;
	}//getAllOrdersHasProducts
	
	public OrderHasProduct getOrderHasProduct(Long orderId) {
		OrderHasProduct or=null;
		for (OrderHasProduct order : lista) {
			if (order.getOrderId()==orderId) {
				or=order;
				break;
			}//if
		}//foreach
		return or;
	}//getOrderHasProduct

	public OrderHasProduct addOrderHasProduct(OrderHasProduct orderHasProduct) {
		OrderHasProduct or=null;
		boolean flag = false;
		//Agregar la validacion, cuando intente agregar el mismpo usaurio me regresara null
		for (OrderHasProduct order : lista) {
		 if(order.getOrderId().equals(orderHasProduct.getOrderId())){
		     flag=true;
		    break;
		} //if
		}//forEach
		if(!flag){
		lista.add(orderHasProduct);
		or=orderHasProduct;
		 }//!flag
		return or;
	}//addOrderHasProduct


	public OrderHasProduct deleteOrderHasProduct(Long orderId) {
		OrderHasProduct or=null;
		for (OrderHasProduct order : lista) {
			if (order.getOrderId()==orderId) {
				or=lista.remove(lista.indexOf(order));
				break;
			}//if
		}//foreach
		return or;
	}//deleteOrderHasProduct


	public OrderHasProduct updateOrderHasProduct(Long orderId, Long oHPQuantity) {
		OrderHasProduct or=null; //Por si no lo encuentro
		for (OrderHasProduct order : lista) {
			if(order.getOrderId()==orderId) {
				if(oHPQuantity!=null) order.setoHPQuantity(oHPQuantity); 
				or=order;
				break;
			}//if
		}//foreach
		return or;
	}//updateOrderHasProduct
}// class OrderHasProductService

package com.genereishop.proyecto.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.genereishop.proyecto.modelo.Order;


@Service
public class OrderService {
	private final ArrayList<Order> lista = new ArrayList<Order>();
	public OrderService() {
		lista.add(new Order (LocalDate.of(2024, 8, 31)));
		lista.add(new Order (LocalDate.of(2024, 6, 19)));
		lista.add(new Order (LocalDate.of(2024, 4, 12)));
		lista.add(new Order (LocalDate.of(2024, 8, 9)));
	}// constructor OrderService
	
	public List<Order> gettAllOrders() {
		return lista;
	}//gettAllOrders

	public Order getOrders(Long orderId) {
		Order or=null;
		for (Order order : lista) {
			if (order.getOrderId()==orderId) {
				or=order;
			}//if
		}//foreach
		return or;
	}//getOrder

	public Order addOrder(Order order) {
		lista.add(order);
		return order;
	}//addOrder

	public Order deleteOrder(Long orderId) {
		Order or=null;
		for (Order order : lista) {
			if (order.getOrderId()==orderId) {
				or=lista.remove(lista.indexOf(order));
				break;
			}//if
		}//foreach
		return or;
	}//deleteOrder

	public Order updateService(Long orderId, LocalDate orderDate) {
		Order or=null;
		for (Order order : lista) {
			if (order.getOrderId().equals(orderId)) {
				if (orderDate != null)order.setOrderDate(orderDate);
				or=order;
				break;
			}//if
		}//for
		return or;
	}//updateService
	
	
	
}//OrderService

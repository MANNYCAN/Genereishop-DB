package com.genereishop.proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.genereishop.proyecto.modelo.Product;

@Service
public class ProductService {

	private final ArrayList<Product> lista = new ArrayList<Product>();
	
	 public ProductService() {
			lista.add(new Product("Calcetas", "Calcetas Transpirables-Gris", 100, 20, "./assets/calcetas 1.jpg"));
		}

	public List<Product> getAllProducts() {
		return lista;
	}

	public Product getProduct(Long productId) {
		Product prod = null;
		for (Product product : lista) {
			if (product.getProductId() == productId) {
				prod = product;
				break;
			}//if
		}//for each
		return prod;
	}//get Product

	public Product addProduct(Product product) {
		lista.add(product);
		return product;
	}// add Product

	public Product deleteProduct(Long productId) {
		Product prod = null;
		for (Product product : lista) {
			if (product.getProductId() == productId) {
				prod = lista.remove(lista.indexOf(product));
				productId= productId-1;
				break;
			}//if
		}//for each
		return prod;
	}//delete Product
	
		
	public Product updateProduct(Long productId, String productName, String productDescription,Float productPrice, Integer productStock, String productImage) {
		Product prod = null;
	 for (Product product : lista) {
		 if (product.getProductId() == productId) {
				if(productName !=null) product.setProductName(productName);
				if(productDescription !=null) product.setProductDescription(productDescription);
				if(productPrice !=null) product.setProductPrice(productPrice.floatValue());
				if(productStock !=null) product.setProductStock(productStock.intValue());
				if(productImage !=null) product.setProductImage(productImage);
				prod = product;
				break;
			}//if
		
	}//for each
		return prod;
	}
	
		
	

}

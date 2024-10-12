package com.genereishop.proyecto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genereishop.proyecto.modelo.Product;
import com.genereishop.proyecto.repository.ProductRepository;

@Service
public class ProductService {
	public final ProductRepository productRepository;

	 @Autowired
	 public ProductService(ProductRepository productRepository) {
		 this.productRepository = productRepository;
		}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProduct(Long productId) {
		return productRepository.findById(productId).orElseThrow(
				()-> new IllegalArgumentException("El producto con el id ["+productId+"] no existe"));
	}// add Product

	public Product deleteProduct(Long productId) {
		Product prod = null;
		if (productRepository.existsById(productId)) {
			prod = productRepository.findById(productId).get();
			productRepository.deleteById(productId);
		}
		return prod;
	}//delete Product
	
		
	public Product updateProduct(Long productId, String productName, String productDescription,Float productPrice, Integer productStock, String productImage) {
		Product prod = null;
		 if (productRepository.existsById(productId)) {
			 Product product = productRepository.findById(productId).get();
				if(productName !=null) product.setProductName(productName);
				if(productDescription !=null) product.setProductDescription(productDescription);
				if(productPrice !=null) product.setProductPrice(productPrice.floatValue());
				if(productStock !=null) product.setProductStock(productStock.intValue());
				if(productImage !=null) product.setProductImage(productImage);
				productRepository.save(product);
				prod = product;
				
			}//if
		return prod;
	}//update Product
	
	public Product addProduct (Product product) {
		Optional<Product> prod=productRepository.findByproductName(product.getProductName());
		if (prod.isEmpty()) {
			return productRepository.save(product);
		}else {
			System.out.println("El producto["+product.getProductName() +"] ya se encuentra registrado");
			return null;
		}
	}	
	

}

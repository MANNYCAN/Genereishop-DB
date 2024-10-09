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

import com.genereishop.proyecto.modelo.Product;
import com.genereishop.proyecto.service.ProductService;

@RestController
@RequestMapping(path = "api/productos/")
public class ProductController {
	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public List<Product> getProducts(){
		return productService.getAllProducts();
	}
	@GetMapping(path= "{productId}")
	public Product getProduct (Long productId) {
		return productService.getProduct(productId);
	}
	
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@DeleteMapping(path= "{productId}")
	public Product deleteProduct (@PathVariable ("productId")Long productId) {
		return productService.deleteProduct(productId);
	}
	
	@PutMapping(path= "{productId}")
	public Product updateProduct(@PathVariable("productId")Long productId,
			@RequestParam(required =  false)String productName,
			@RequestParam(required =  false)String productDescription,
			@RequestParam(required =  false)Float productPrice,
			@RequestParam(required =  false)Integer productStock,
			@RequestParam(required =  false)String productImage) {
		return productService.updateProduct(productId, productName, productDescription, productPrice, productStock, productImage);
	}
	
	
}

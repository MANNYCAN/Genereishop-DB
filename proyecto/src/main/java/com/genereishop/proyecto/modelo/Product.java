package com.genereishop.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productId",unique=true, nullable=false)
	private Long productId;
	private String productName;
	private String productDescription;
	private float productPrice;
	private int productStock;
	private String productImage;
	
	//private static Long  total = Long.valueOf(0);
	
	
	
	public Product(String productName, String productDescription, float productPrice, int productStock,
			String productImage) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.productImage = productImage;
//		Product.total++; 
//		productId = Product.total;
	}//constructor



	public Product () {
//		Product.total++; 
//		productId = Product.total;
		
	}//constructor



	public Long getProductId() {
		return productId;
	}//get productId



	public void setProductId(Long productId) {
		this.productId = productId;
	}//set productId



	public String getProductName() {
		return productName;
	}//get productName



	public void setProductName(String productName) {
		this.productName = productName;
	}//set productName



	public String getProductDescription() {
		return productDescription;
	}//get productDescription



	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}//set productDescription



	public float getProductPrice() {
		return productPrice;
	}//get productPrice



	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}//set productPrice



	public int getProductStock() {
		return productStock;
	}//get productStock



	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}//set productStock



	public String getProductImage() {
		return productImage;
	}//get productImage



	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}//set productImage



	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + ", productStock=" + productStock
				+ ", productImage=" + productImage + "]";
	}//to String
	
	

}

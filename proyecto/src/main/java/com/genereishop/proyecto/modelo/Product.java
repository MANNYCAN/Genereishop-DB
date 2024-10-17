package com.genereishop.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "productProductIdFk", referencedColumnName = "productId")
	List<OrderHasProduct> orderHasProducts = new ArrayList<OrderHasProduct>();
	
	
	
	public List<OrderHasProduct> getOrderHasProducts() {
		return orderHasProducts;
	}//getOrderHasProducts



	public Product(String productName, String productDescription, float productPrice, int productStock,
			String productImage) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.productImage = productImage;
	}//constructor



	public Product () {}//constructor



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

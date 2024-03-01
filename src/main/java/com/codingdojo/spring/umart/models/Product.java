package com.codingdojo.spring.umart.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="products")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotEmpty(message="Title is required")
    @Size(min=10, max=200, message="Title must be between 10 and 200 characters")
	private String title;
	@NotEmpty(message="SKU is required")
    @Size(min=3, max=30, message="SKU must be between 3 and 30 characters")
	private String sku;
	@NotEmpty(message="Description is required")
    @Size(min=10, max=500, message="Description must be between 10 and 500 characters")
	private String description;
	@NotNull(message="Price is required")
    @DecimalMin(value="0.01", message="Price must be greater than $0")
	private Double price;
	@NotNull(message="Quantity is required")
    @Min(value=1, message="Quantity must be greater than 1")
	private Long quantity;
	@NotEmpty(message="Category is required")
    @Size(min=3, max=40, message="Category must be between 3 and 40 characters")
	private String category;
	@NotEmpty(message="Brand is required")
    @Size(min=1, max=40, message="Brand must be between 1 and 40 characters")
	private String brand;
	@Lob
	private byte[] image;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="seller_products",
			joinColumns = @JoinColumn(name = "product_id"), 
	        inverseJoinColumns = @JoinColumn(name = "seller_id")
			)
	private List<Seller> sellers;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private Seller creator;
	
	private String priceId;
	
	public Product() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public List<Seller> getSellers() {
		return sellers;
	}

	public void setSellers(List<Seller> sellers) {
		this.sellers = sellers;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Seller getCreator() {
		return creator;
	}

	public void setCreator(Seller creator) {
		this.creator = creator;
	}

	public String getPriceId() {
		return priceId;
	}

	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}
	
	
	
}

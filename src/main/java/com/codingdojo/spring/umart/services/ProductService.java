package com.codingdojo.spring.umart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.spring.umart.models.Product;
import com.codingdojo.spring.umart.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	public ProductService() {}
	
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
	
}

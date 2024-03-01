package com.codingdojo.spring.umart.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.spring.umart.models.Product;
import com.codingdojo.spring.umart.models.Seller;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long>{
	
	List<Product> findAll();
	
	Optional<Product> findById(Long id);
	
	List<Product> findAllByCreator(Seller seller);
}

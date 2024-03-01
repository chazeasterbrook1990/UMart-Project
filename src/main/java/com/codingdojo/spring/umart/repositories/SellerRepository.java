package com.codingdojo.spring.umart.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.spring.umart.models.Seller;

public interface SellerRepository extends CrudRepository<Seller,Long> {

	Optional<Seller> findByEmail(String email);
	 
	 Optional<Seller> findById(Long id);
	
}

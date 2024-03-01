package com.codingdojo.spring.umart.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.spring.umart.models.LoginSeller;
import com.codingdojo.spring.umart.models.Seller;
import com.codingdojo.spring.umart.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
    private SellerRepository sellerRepo;
    
    public Seller register(Seller newSeller, BindingResult result) {
        String enteredPassword = newSeller.getPassword();
    	
    	Optional<Seller> potentialSeller = sellerRepo.findByEmail(newSeller.getEmail());
    	if(potentialSeller.isPresent()) {
    		result.rejectValue("email", "Seller.exists", "You already have an account!");
    	}
      
        if(!enteredPassword.equals(newSeller.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
       
        if(result.hasErrors()) {
    		return null;
    	}
        
        String hashed = BCrypt.hashpw(newSeller.getPassword(), BCrypt.gensalt());
        newSeller.setPassword(hashed);
        
        return sellerRepo.save(newSeller);
    }
    
        public Seller login(LoginSeller newLoginObject, BindingResult result) {
     
        	String enteredPassword = newLoginObject.getPassword();

        	Optional<Seller> potentialSeller = sellerRepo.findByEmail(newLoginObject.getEmail());

	        if(!potentialSeller.isPresent()) {
	        	result.rejectValue("email", "not.exists", "Seller does not exist!");
	        	return null;
	        }
	        Seller seller = potentialSeller.get();
	
	        if(!BCrypt.checkpw(enteredPassword, seller.getPassword())) {
	            result.rejectValue("password", "Matches", "Invalid Password!");
	        }
	    	if(result.hasErrors()) {
	    		return null;
	    	}
	    	else {
	    		return seller;
	    	}
    }
        
	
}

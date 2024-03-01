package com.codingdojo.spring.umart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.spring.umart.models.Product;
import com.codingdojo.spring.umart.models.Seller;
import com.codingdojo.spring.umart.repositories.ProductRepository;
import com.codingdojo.spring.umart.repositories.SellerRepository;
import com.codingdojo.spring.umart.services.ProductService;
import com.stripe.exception.StripeException;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/umart/seller")
public class SellerController {

	@Autowired
	private SellerRepository sellerRepo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private ProductService productService;
	
	@GetMapping("/home")
	public String sellerHome(Model model, @ModelAttribute("sellerLoggedIn") Seller seller, HttpSession session, @ModelAttribute("product") Product product) {
		 Long id = (Long) session.getAttribute("loggedInSeller");
		 if(id == null) {
			 return "redirect:/";
		 }
		 Seller sellerLoggedIn = sellerRepo.findById(id).get();
		 model.addAttribute("sellerLoggedIn", sellerLoggedIn);
		 List<Product> products = productRepo.findAllByCreator(sellerLoggedIn);
		 model.addAttribute("product", products);
		 return "sellerhome.jsp";
	 }
	
	@GetMapping("/product/create")
	public String createListing(HttpSession session, Model model, @ModelAttribute("product") Product product) {
		 Long id = (Long) session.getAttribute("loggedInSeller");
		 Seller sellerLoggedIn = sellerRepo.findById(id).get();
		 model.addAttribute("sellerLoggedIn", sellerLoggedIn);
		 return "createlisting.jsp";
	}
	
	@GetMapping("/product/{id}/edit")
	public String editProduct(@PathVariable Long id, Model model, HttpSession session) {
		Product product = productRepo.findById(id).orElse(null);
		Seller creator = product.getCreator();
		Long sellerId = sellerRepo.findById((Long) session.getAttribute("loggedInSeller")).get().getId();
		if(creator.getId() == sellerId) {
			model.addAttribute("editproduct", product);
			return "editproduct.jsp";
		}
		return "redirect:/umart/seller/home";
		
	}
	
	@PostMapping("/product/{id}/edit")
	public String editProduct(@Valid @ModelAttribute("editproduct") Product product, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			 return "editproduct.jsp";
		 }
		 productRepo.save(product);
		 return "redirect:/umart/seller/home";
	}
	
	@PostMapping("/product/create")
	public String createListing(@Valid @ModelAttribute("product") Product product, BindingResult result) throws StripeException {
		if(result.hasErrors()) {
			 return "createlisting.jsp";
		 }
//		StripeProduct stripeProduct = new StripeProduct();
//		Long stripePrice = (long) ((product.getPrice())/100);
//		String priceId = stripeProduct.createStripePrice(product.getTitle(), product.getDescription(), stripePrice);
//		product.setPriceId(priceId);
		productService.createProduct(product);
		return "redirect:/umart/seller/home";
	}
	
	@PostMapping("/product/{id}/delete")
	public String deleteListing(@ModelAttribute("deleteproduct") Product product, @PathVariable Long id) {
		 productRepo.deleteById(id);
		 return "redirect:/umart/seller/home";
	}
	
}

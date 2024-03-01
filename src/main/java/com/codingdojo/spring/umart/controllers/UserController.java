package com.codingdojo.spring.umart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.spring.umart.models.Product;
import com.codingdojo.spring.umart.repositories.ProductRepository;
import com.codingdojo.spring.umart.repositories.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/umart")
public class UserController {
	@Autowired
	ProductRepository productRepo;
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/home")
	public String userHome(Model model, HttpSession session) {
		Long id = (Long) session.getAttribute("loggedInUser");
		 if(id == null) {
			 return "redirect:/";
		 }
		 model.addAttribute("products",productRepo.findAll());
		 model.addAttribute("userName", userRepo.findById(id).get().getUserName());
		return "userhome.jsp";
	}
	
	@GetMapping("/product/{id}")
	public String pdp(@PathVariable Long id, Model model, HttpSession session) {
		Long userSessionId = (Long) session.getAttribute("loggedInUser");
		 if(userSessionId == null) {
			 return "redirect:/";
		 }
		 Product product = productRepo.findById(id).get();
		 model.addAttribute("product",product);
		 model.addAttribute("userName", userRepo.findById(userSessionId).get().getUserName());
		 return "pdp.jsp";
	}

}

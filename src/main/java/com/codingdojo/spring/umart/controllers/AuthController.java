package com.codingdojo.spring.umart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.spring.umart.models.LoginSeller;
import com.codingdojo.spring.umart.models.LoginUser;
import com.codingdojo.spring.umart.models.Seller;
import com.codingdojo.spring.umart.models.User;
import com.codingdojo.spring.umart.repositories.SellerRepository;
import com.codingdojo.spring.umart.repositories.UserRepository;
import com.codingdojo.spring.umart.services.SellerService;
import com.codingdojo.spring.umart.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AuthController {
	
	@Autowired
	public UserService userService;
	@Autowired
	public UserRepository userRepo;
	@Autowired
	public SellerService sellerService;
	@Autowired
	public SellerRepository sellerRepo;
	
	 
	 // get requests
	 	//home login & registration
	 @GetMapping("/")
	 public String index(Model model, HttpSession session) {
		 if (session.getAttribute("loggedInUser") != null){
	    	 return "redirect:/umart/home";
		 } else if (session.getAttribute("loggedInSeller") != null){
	    	 return "redirect:/umart/seller/home";
		 }
		 model.addAttribute("newLogin", new LoginUser());
	     model.addAttribute("newSellerLogin", new LoginSeller());
	     return "index.jsp";
	 }
	 // registration splash page
	 @GetMapping("/registration/selection")
	 public String sellerOrBuyer(HttpSession session) {
		 if (session.getAttribute("loggedInUser") != null){
	    	 return "redirect:/umart/home";
		 } else if (session.getAttribute("loggedInSeller") != null){
	    	 return "redirect:/umart/seller/home";
		 }
		 return "registrationselection.jsp";
	 }
	 
	 // user registration
	 @GetMapping("/registration")
	 public String userRegister(Model model, HttpSession session) {
		 if (session.getAttribute("loggedInUser") != null){
	    	 return "redirect:/umart/home";
		 } 
		 model.addAttribute("newUser", new User());
		 return "registration.jsp";
	 }
	 
	// seller registration
	 @GetMapping("/seller/registration")
	 public String sellerRegister(Model model,HttpSession session) {
		 if (session.getAttribute("loggedInSeller") != null){
	    	 return "redirect:/umart/seller/home";
		 }
		 model.addAttribute("newSeller", new Seller());
		 return "sellerregistration.jsp";
	 }
	 
	 	//logout
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.invalidate();
		 return "redirect:/";
	 }
	 
	 // post requests
	 	// registration
	 @PostMapping("/register")
	 public String register(@Valid @ModelAttribute("newUser") User newUser, 
	         BindingResult result, Model model, HttpSession session) {
	     
	     if(result.hasErrors() || userService.register(newUser, result)!=newUser) {
	         model.addAttribute("newLogin", new LoginUser());
	         return "registration.jsp";
	     } else if (session.getAttribute("loggedInUser") != null){
	    	 return "redirect:/umart/home";
	     } else {
	    	 userService.register(newUser, result);
	    	 session.setAttribute("loggedInUser", newUser.getId());
	     }
	     return "redirect:/umart/home";
	 }
	 
	 @PostMapping("/seller/register")
	 public String sellerRegister(@Valid @ModelAttribute("newSeller") Seller newSeller, 
	         BindingResult result, Model model, HttpSession session) {
	     
	     if(result.hasErrors() || sellerService.register(newSeller, result)!=newSeller) {
	         model.addAttribute("newLoginSeller", new LoginSeller());
	         return "sellerregistration.jsp";
	     } else if (session.getAttribute("loggedInSeller") != null){
	    	 return "redirect:/umart/seller/home";
	     } else {
	    	 sellerService.register(newSeller, result);
	    	 session.setAttribute("loggedInSeller", newSeller.getId());
	     }
	     	return "redirect:/umart/seller/home";
	 }
	 	//login
	 @PostMapping("/login")
	 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	         BindingResult result, Model model, HttpSession session) {
	  
		 User user = userService.login(newLogin, result);
	 
	     if(result.hasErrors()) {
	         model.addAttribute("newUser", new User());
	         return "index.jsp";
	     }
	     userService.login(newLogin, result);
	     session.setAttribute("loggedInUser", user.getId());
	     return "redirect:/umart/home";
	 }
	 
	 @PostMapping("/seller/login")
	 public String sellerLogin(@Valid @ModelAttribute("newSellerLogin") LoginSeller loginSeller, 
	         BindingResult result, Model model, HttpSession session) {
	  
		 Seller seller = sellerService.login(loginSeller, result);
	 
	     if(result.hasErrors()) {
	         model.addAttribute("newSellerLogin", new Seller());
	         return "index.jsp";
	     }
	     sellerService.login(loginSeller, result);
	     session.setAttribute("loggedInSeller", seller.getId());
	     return "redirect:/umart/seller/home";
	 }
}

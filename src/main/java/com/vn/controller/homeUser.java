package com.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.service.ProductService;
@Controller
@RequestMapping("/user")
public class homeUser {
	@Autowired
	private ProductService productService;
	@GetMapping("/home")
	public String viewhome(Model model) {
		model.addAttribute("product", productService.readAll());

		return "user/home";
	}

}

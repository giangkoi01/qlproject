package com.vn.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.service.ProductService;

@Controller
@RequestMapping("/web")
public class WebController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/home")
	public String home(Model model) {
		
		model.addAttribute("list", productService.readAll());
		
//		model.addAttribute("obj", productService.readAll().get(0));
		
		model.addAttribute("message", "giang dep trai");

		return "home/index";
	}
}

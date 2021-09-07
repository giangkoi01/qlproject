package com.vn.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vn.service.IpmProductService;
import com.vn.vo.ProductVO;

@Controller
@RequestMapping("/admin")
public class ProductController {
	
	@Autowired
	private IpmProductService productService;
    
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/product")
	public String readAll(Model model) {
		
		model.addAttribute("product", productService.readAll());

		
		return "admin/product";
	}
	@GetMapping("/product/create")
	public String viewCreate(Model model) {
		model.addAttribute("product", new ProductVO());
		return "admin/products/create";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/product/create")
	public String create(@ModelAttribute("product") ProductVO product,Model model) {
		long datenow =System.currentTimeMillis();
		
		Date date=new Date(datenow);
		product.setCreateDate(date);
		productService.create(product);
		return "redirect:/admin/product";
	}
	
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/product/update/{id}")
	public String productViewUpdatePage(@PathVariable(name = "id") String id, Model model) {
		ProductVO product = productService.readById(Integer.parseInt(id));
		model.addAttribute("products", product);
		return "admin/products/update";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/product/update/{id}")
	public String update( @ModelAttribute("products") ProductVO vo, @PathVariable Integer id) {
		vo.setId(id);
		productService.update(vo);
		return "redirect:/admin/product";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/product/delete/{id}")
	public String delete(@PathVariable(name = "id") Integer id,RedirectAttributes red) {
		productService.delete(id);
		red.addFlashAttribute("messeger","dã xóa thanh công");
		return "redirect:/admin/product" ;
	}
	
	@GetMapping("/product/{id}")
	public ProductVO detail(@PathVariable Integer id) {
		return productService.readById(id);
	}
	
}

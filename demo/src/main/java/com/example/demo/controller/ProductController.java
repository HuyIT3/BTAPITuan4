package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	public ProductController() {
		
	}
	
	@GetMapping("/{categoryId}")
	public List<Product> getProductsByCategory(@PathVariable Integer categoryId){
		return this.productService.getProductsByCategory(categoryId);
	}
	@GetMapping({"/top10SellingProducts"})
	public List<Product> getTop10SellingProducts(){
		return this.productService.getTop10SellingProducts();
	}
	@GetMapping({"/top10CreatedWeek"})
	public List<Product> getTop10CreatedWeek(){
		return this.productService.getTop10CreatedWeek();
	}
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping({"/categories"})
public class CategoryController {
	@Autowired
	private CategoryService cateService;
	
	public CategoryController() {
		
	}
	@GetMapping
	public List<Category> getAllCategories(){
		return this.cateService.getAllCategories();
	}
}

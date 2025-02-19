package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository cateRepository;
	
	public ProductService() {
		
	}
	public List<Product> getProductsByCategory(Integer id){
		Category cate=(Category)this.cateRepository.findById(id).orElseThrow(() -> {
			return new RuntimeException("Product not found");
		});
		return this.productRepository.findByCategoryId(id);
	}
	public List<Product> getTop10SellingProducts(){
		return this.productRepository.findTop10SoldQuantity();
	}
	public List<Product> getTop10CreatedWeek(){
		LocalDate weekAgo = LocalDate.now().minusDays(7L);
		String weekAgoString = weekAgo.toString();
		return this.productRepository.findTop10CreatedWeek(weekAgoString);
	}
	
}

package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findByCategoryId(Integer categoryId);
	
	@Query(value ="SELECT * FROM product ORDER BY sold_quantity DESC LIMIT 10",nativeQuery = true)
	List<Product> findTop10SoldQuantity();
	@Query(value ="SELECT * FROM product WHERE created >= :sevenDaysAgo ORDER BY created DESV LIMIT 10", nativeQuery=true)
	List<Product> findTop10CreatedWeek(@Param("sevenDaysAgo") String sevenDaysAgo);
}

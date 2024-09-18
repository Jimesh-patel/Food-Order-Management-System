package com.project.canteen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.canteen.entity.Products;

public interface ProductsDAO extends JpaRepository<Products, Integer> {
    // Add custom query methods if needed
	
}


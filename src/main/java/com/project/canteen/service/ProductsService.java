package com.project.canteen.service;

import java.util.List;
import java.util.Optional;

import com.project.canteen.entity.Products;

public interface ProductsService {
	
	public List<Products> findAll();

	void save(Products product);
	
	public Optional<Products> findById(Integer prod_id);
	
	public void deleteById(Integer prod_id);
}

package com.project.canteen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.canteen.dao.ProductsDAO;
import com.project.canteen.entity.Products;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsDAO productsdao;
	
    public List<Products> getAllProducts() {
        return productsdao.findAll();
    }

	@Override
	@Transactional
	public List<Products> findAll() {
		// TODO Auto-generated method stub
		return productsdao.findAll();
	}
	
	@Override
	@Transactional
	public void save(Products product) {
		// TODO Auto-generated method stub
		productsdao.save(product);
		return;
	}

	@Override
	@Transactional
	public Optional<Products> findById(Integer prod_id) {
		// TODO Auto-generated method stub
		return productsdao.findById(prod_id);
	}

	public void deleteById(Integer prod_id) {
		// TODO Auto-generated method stub
		productsdao.deleteById(prod_id);
		return;
	}
}

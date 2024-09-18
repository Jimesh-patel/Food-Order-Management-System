package com.project.canteen.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.canteen.entity.Products;
import com.project.canteen.service.ProductsServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductsController {
	
    @Autowired
    private ProductsServiceImpl productService;

    @GetMapping("/products")
    public List<Products> listProducts() {
        return productService.findAll(); // return the name of your Thymeleaf template without the ".html" extension
    }
    
    @PostMapping("/products")
    public String addProduct(@RequestBody Products product) {
    	productService.save(product);
    	return "New Product added";
    }
    
    @PutMapping("/products/{prod_id}")
    public String updateProduct(@PathVariable Integer prod_id, @RequestBody Products product) {
    	Optional<Products> findProd = productService.findById(prod_id);
    	if(findProd.isPresent()) {
    		Products thisProd = findProd.get();
    		thisProd.setName(product.getName());
    		thisProd.setPrice(product.getPrice());
    		thisProd.setAvailable(product.isAvailable());
    		thisProd.setImage(product.getImage());
    		thisProd.setStock(product.getStock());
    		productService.save(thisProd);
        	return "Product Deatils with Id " + prod_id + " updated";
    	}else {
    		return "Product Deatils with Id " + prod_id + "NOT FOUND";
    	}

    }
    
    @DeleteMapping("/products/{prod_id}")
    public String deleteProduct(@PathVariable Integer prod_id) {
    	
    	Optional<Products> findProd = productService.findById(prod_id);
    	if(findProd.isPresent()) {
        	productService.deleteById(prod_id);
        	return "Product with id " + prod_id + " DELETED";
    	}else {
    		return "Product with id " + prod_id + " NOT FOUND";
    	}

    }
}

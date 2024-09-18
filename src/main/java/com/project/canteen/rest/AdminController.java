package com.project.canteen.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.canteen.entity.Admin;
import com.project.canteen.service.AdminServiceImpl;


@RestController
@RequestMapping("/api")
public class AdminController {
	
    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping("/admin")
    public List<Admin> listProducts() {
        return adminService.findAll();
    }
    
    @PostMapping("/admin")
    public String addProduct(@RequestBody Admin product) {
    	adminService.save(product);
    	return "New Admin added";
    }
    
    @PutMapping("/admin/{admin_id}")
    public String updateProduct(@PathVariable Integer admin_id, @RequestBody Admin admin) {
    	Optional<Admin> findProd = adminService.findById(admin_id);
    	if(findProd.isPresent()) {
    		Admin thisAdmin = findProd.get();
    		thisAdmin.setName(admin.getName());
    		thisAdmin.setPassword(admin.getPassword());
    		
        	return "Admin Deatils with Id " + admin_id + " updated";
    	}else {
    		return "Admin Deatils with Id " + admin_id + "NOT FOUND";
    	}

    }
    
    @DeleteMapping("/admin/{admin_id}")
    public String deleteProduct(@PathVariable Integer admin_id) {
    	
    	Optional<Admin> findProd = adminService.findById(admin_id);
    	if(findProd.isPresent()) {
        	adminService.deleteById(admin_id);
        	return "Admin with id " + admin_id + " DELETED";
    	}else {
    		return "Admin with id " + admin_id + " NOT FOUND";
    	}

    }
}

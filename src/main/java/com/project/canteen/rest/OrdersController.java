package com.project.canteen.rest;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.project.canteen.entity.*;


import com.project.canteen.service.*;


@RestController
@RequestMapping("/api")
public class OrdersController {
	
	@Autowired 
	private OrdersServiceImpl odersserviceimpl;
	
	
	@Autowired 
	private UserServiceImpl usersserviceimpl;
	
	
	@GetMapping("/all-orders")
	public List<Orders> index(){
		return odersserviceimpl.findAll();
	}
	
	@GetMapping("/orders-id/{id}")
	public Optional<Orders> findById(@PathVariable("id") int id) {
	    return odersserviceimpl.findById(id);
	}
	
	@PostMapping("/add-orders/{id}")
	public Orders addOrders(@RequestBody Orders obj, @PathVariable("id") int id){
		
		User user = usersserviceimpl.findById(id).get();
		obj.setUser(user);
		
		return odersserviceimpl.save(obj);
	}
	
	@DeleteMapping("/delete-all-orders")
	public String delete() {
	    odersserviceimpl.deleteAll();
	    return "Deleted successfully";
	}
	
	@DeleteMapping("/delete-orders/{id}")
	public Optional<Orders> delete(@PathVariable("id") int id) {
	    return odersserviceimpl.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	public String update(@RequestBody Orders new_order, @PathVariable("id") int id){
		
		Optional<Orders> findOrder = odersserviceimpl.findById(id);
    	if(findOrder.isPresent()) {
    		Orders thisOrder = findOrder.get();
    		thisOrder.setName(new_order.getName());
    		thisOrder.setNumber(new_order.getNumber());
    		thisOrder.setMethod(new_order.getMethod());
    		thisOrder.setTotal_price(new_order.getTotal_price());
    		thisOrder.setDate(new_order.getDate());
    		thisOrder.setPayment_status(new_order.getPayment_status());
    		thisOrder.setUser(new_order.getUser());
    		odersserviceimpl.save(thisOrder);
        	return "User Details of Id " + id + " updated";
    	} else
    		return "User Details of Id " + id + " NOT FOUND!";
	}
	
	
	@GetMapping("/orders-date/{date}")
	public List<Orders> findBydate(@PathVariable("date") Date date){
		return odersserviceimpl.findByDate(date);
	}
	
	
	
	
}


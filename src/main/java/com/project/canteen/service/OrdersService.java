package com.project.canteen.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.project.canteen.entity.Orders;
import com.project.canteen.entity.User;

public interface OrdersService {
	public List<Orders> findAll();
	public Optional<Orders> findById(int id);
	public Orders save(Orders obj);
	public void deleteAll();
	public Optional<Orders> deleteById(int id);
	public List<Orders> findByDate(Date date);


}

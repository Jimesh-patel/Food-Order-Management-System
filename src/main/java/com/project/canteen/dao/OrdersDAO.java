package com.project.canteen.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.canteen.entity.Orders;
import com.project.canteen.entity.User;

public interface OrdersDAO extends JpaRepository<Orders, Integer>{

	public List<Orders> findByDate(Date date);
	
}

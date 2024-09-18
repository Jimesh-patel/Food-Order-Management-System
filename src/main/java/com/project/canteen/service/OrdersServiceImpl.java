package com.project.canteen.service;

import java.sql.Date;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.canteen.dao.OrdersDAO;
import com.project.canteen.entity.Orders;
import com.project.canteen.entity.User;

@Service
public class OrdersServiceImpl implements OrdersService{
	@Autowired
	private OrdersDAO ordersdao;

	@Transactional
	public List<Orders> findAll() {
		return ordersdao.findAll();
	}
	
	@Transactional
	public Optional<Orders> findById(int id) {
		return ordersdao.findById(id);
	};
	
	@Transactional
	public Orders save(Orders obj) {
		return ordersdao.save(obj);
	}

	@Transactional
	public Optional<Orders> deleteById(int id) {
		Optional<Orders> od = ordersdao.findById(id);
	    ordersdao.deleteById(id);
	    return od;
	}

	@Transactional
	public void deleteAll() {
		ordersdao.deleteAll();
	}

	@Transactional
	public List<Orders> findByDate(Date date) {
		return ordersdao.findByDate(date);
	}
	
	
	
}

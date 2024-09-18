package com.project.canteen.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.canteen.entity.Orders;
import com.project.canteen.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


@Repository
public abstract class OrdersDAOImpl implements OrdersDAO{
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Orders> findByDate(Date date){
		
		Query theQuery = entityManager.createQuery("from Orders where date=:d");

		List<Orders> orders = (List<Orders>) theQuery.setParameter("d", date);
		
		return orders;
		
	};
	

}

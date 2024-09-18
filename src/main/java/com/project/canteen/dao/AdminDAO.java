package com.project.canteen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.canteen.entity.Admin;

public interface AdminDAO extends JpaRepository<Admin, Integer>{
	// Add custom query methods if needed
	
	
}

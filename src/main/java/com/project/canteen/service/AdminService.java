package com.project.canteen.service;

import java.util.List;
import java.util.Optional;

import com.project.canteen.entity.Admin;

public interface AdminService {

	public List<Admin> findAll();
	
	void save(Admin admin);
	
	public Optional<Admin> findById(Integer admin_id);
	
	public void deleteById(Integer admin_id);

}

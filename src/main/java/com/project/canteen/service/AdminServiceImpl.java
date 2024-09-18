package com.project.canteen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.canteen.dao.AdminDAO;
import com.project.canteen.entity.Admin;
import com.project.canteen.entity.Products;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDAO admindao;
	

	public List<Admin> getAllProducts() {
        return admindao.findAll();
    }

	@Override
	@Transactional
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return admindao.findAll();
	}
	
	@Override
	@Transactional
	public void save(Admin admin) {
		// TODO Auto-generated method stub
		admindao.save(admin);
		return;
	}

	@Override
	@Transactional
	public Optional<Admin> findById(Integer admin_id) {
		// TODO Auto-generated method stub
		return admindao.findById(admin_id);
	}

	public void deleteById(Integer admin_id) {
		// TODO Auto-generated method stub
		admindao.deleteById(admin_id);
		return;
	}
	
}

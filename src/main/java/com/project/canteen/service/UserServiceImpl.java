package com.project.canteen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.canteen.dao.UserDAO;
import com.project.canteen.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userdao;
	

	@Override
	@Transactional
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userdao.findAll();
	}


	@Override
	@Transactional
	public void save(User user) {
		// TODO Auto-generated method stub
		userdao.save(user);
		return ;
	}


	@Override
	@Transactional
	public Optional<User> findById(Integer user_id) {
		// TODO Auto-generated method stub
		
		return userdao.findById(user_id);
	}


	@Override
	public void deleteById(Integer user_id) {
		// TODO Auto-generated method stub
		userdao.deleteById(user_id);
		return;
	}
	
	
}

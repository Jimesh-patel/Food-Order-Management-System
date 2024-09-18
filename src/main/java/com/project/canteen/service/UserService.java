package com.project.canteen.service;


import java.util.List;
import java.util.Optional;

import com.project.canteen.entity.User;

public interface UserService{

	public List<User> findAll();

	public void save(User user);

	public Optional<User> findById(Integer user_id);

	public void deleteById(Integer user_id);
	
}

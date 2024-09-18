package com.project.canteen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.canteen.entity.User;

public interface UserDAO extends JpaRepository<User, Integer>{

}

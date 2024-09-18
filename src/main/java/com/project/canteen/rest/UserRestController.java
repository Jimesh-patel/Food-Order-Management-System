package com.project.canteen.rest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.canteen.entity.User;
import com.project.canteen.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {
    
    @Autowired
    private UserService userService;

    
    public User user;
    
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return password; 
        }
    }
    
    @GetMapping("/users")
    public List<User> listUsers() {
        return userService.findAll(); 
    }
    
    @PostMapping("/users")
    public String addUser(@RequestBody User user) {
    	userService.save(user);
    	return "New user added";
    }
    
    @PutMapping("/users/{user_id}")
    public String updateUser(@PathVariable Integer user_id, @RequestBody User user) {
    	Optional<User> findUser = userService.findById(user_id);
    	if(findUser.isPresent()) {
    		User thisUser = findUser.get();
    		thisUser.setName(user.getName());
    		thisUser.setPassword(user.getPassword());
    		thisUser.setRoll_no(user.getRoll_no());
    		thisUser.setPhone(user.getPhone());
    		userService.save(thisUser);
        	return "User Details of Id " + user_id + " updated";
    	}else {
    		return "User Details of Id " + user_id + " NOT FOUND!";
    	}
    }
    
    @DeleteMapping("/users/{user_id}")
    public String deleteUser(@PathVariable Integer user_id) {
    	Optional<User> findUser = userService.findById(user_id);
    	if(findUser.isPresent()) {
        	userService.deleteById(user_id);
        	return "User with id " + user_id + " DELETED";
    	}else {
    		return "User with id " + user_id + "NOT FOUND";
    	}
    }
    
}

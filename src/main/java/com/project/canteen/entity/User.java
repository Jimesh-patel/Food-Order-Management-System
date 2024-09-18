package com.project.canteen.entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	public String name;
	private String roll_no;
	private String password;
	private String phone;
	
	@OneToMany(mappedBy = "user" ,cascade=CascadeType.ALL)
	private List<Orders> orders = new ArrayList<>();
	
	
	public User() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = hashPassword(password);
	}
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
            // Handle exception (e.g., log error)
            return password; // Return original password if hashing fails
        }
    }
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name" + name + ", roll_no" + roll_no + "]";
	}
	
}


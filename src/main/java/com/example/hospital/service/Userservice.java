package com.example.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.entity.User;
import com.example.hospital.repository.UserRepo;

@Service
public class Userservice {

	@Autowired
	private UserRepo urepo;
	
	public List<User> getAllUsers(){
		return urepo.findAll();
	}

	public User getUserById(long id) {
		return urepo.findById(id).orElse(null);
	}

	public User createUser(User user) {
		return urepo.save(user);
	}

	public User updateUser(long id, User user) {
		User existingUser = getUserById(id);
		if (existingUser !=null) {
			existingUser.setUsername(user.getUsername());
			existingUser.setPassword(user.getPassword());
			existingUser.setRole(user.getRole());
			return urepo.save(existingUser);
		}
		return null;
	}

	public void deleteUser(long id) {
	 urepo.deleteById(id);;
	}
	
	
}

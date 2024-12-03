package com.example.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.hospital.entity.User;
import com.example.hospital.repository.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepo urepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = urepo.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
			
		}
		UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
		builder.username(user.getUsername());
		builder.password(user.getPassword());
		builder.roles(user.getRole());
		
		return builder.build();
	}

}

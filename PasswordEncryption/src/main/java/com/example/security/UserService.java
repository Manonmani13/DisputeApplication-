package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {

	@Autowired
	
    private UserRepository userRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public boolean loginUser(String username,String password) {
		User user=userRepository.findByUsername(username);
		return passwordEncoder.matches(username, user.getPassword());
	}
}

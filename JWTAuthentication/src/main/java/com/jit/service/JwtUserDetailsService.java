package com.jit.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jit.model.User;
//import com.jit.repository.UserRepository;
@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	
	 // @Autowired private final UserRepository repo;
	 
	  //public JwtUserDetailsService(UserRepository repo) { this.repo = repo; }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	 

	
	  
	/*
	 * @Override public User loadUserByUsername(String userName) { User user =
	 * repo.findByUsername(userName) .orElseThrow(() -> new
	 * UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", userName)));
	 * return new User(user.getUserName(), user.getPassword(), new ArrayList<>()); }
	 */

}


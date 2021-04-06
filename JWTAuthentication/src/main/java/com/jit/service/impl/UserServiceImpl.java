package com.jit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jit.model.User;
import com.jit.repository.UserRepository;
import com.jit.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
	private UserRepository repo;
	@Override
	public User createUser(User user) {
		return repo.save(user);
	}

	@Override
	public List<User> fetchUser() {
		List<User> user=repo.findAll();
		return user;
	}
	

}

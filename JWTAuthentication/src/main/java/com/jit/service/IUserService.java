package com.jit.service;

import java.util.List;

import com.jit.model.User;

public interface IUserService {
	public User createUser(User user);
	public List<User> fetchUser();
	

}

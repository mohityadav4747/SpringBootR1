package com.jit.service;

import java.util.List;
import java.util.Optional;

import com.jit.model.User;

public interface IUserService {
	public Integer saveUserData(User user);
	public List<User> fetchUserData();
	public User getOneUserData(Integer userId);
	void deleteUserData(Integer userId);
 Optional<User> findByUserName(String userName);
public User updateUserById(User user, Integer userId);


}

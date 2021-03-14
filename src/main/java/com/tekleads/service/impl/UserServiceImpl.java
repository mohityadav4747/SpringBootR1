
  package com.tekleads.service.impl;
 
  import org.springframework.beans.factory.annotation.Autowired;
  import
  org.springframework.stereotype.Service;
  
  import com.tekleads.model.User;
  import
  com.tekleads.repository.UserRepository;
import com.tekleads.service.IUserService;
  
  @Service public class UserServiceImpl implements IUserService{
  
  @Autowired private UserRepository repo;

@Override
public boolean saveUserData(User user) {
	User us=repo.save(user);

	return true;
	
}
  
  }
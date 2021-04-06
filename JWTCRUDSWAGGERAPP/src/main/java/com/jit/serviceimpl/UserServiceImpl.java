package com.jit.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.jit.model.User;
import com.jit.repository.UserRepository;
import com.jit.service.IUserService;
@Service
public class UserServiceImpl implements IUserService,UserDetailsService 
{
@Autowired
private UserRepository repo;
@Autowired
private BCryptPasswordEncoder pwdEncoder;
//1.
public Integer saveUserData(User user) {
	user.setPassword(pwdEncoder.encode(user.getPassword()));
	return repo.save(user).getUserId(); }
	 

@Override
public Optional<User> findByUserName(String userName) {
	return repo.findByUserName(userName);
}
@Override 
public UserDetails loadUserByUsername(String userName) throws
UsernameNotFoundException {
	Optional<User> opt=findByUserName(userName);
	
	if(opt==null)throw new UsernameNotFoundException("user not exist");
	User user=opt.get(); 
	return new
			org.springframework.security.core.userdetails.User(
					userName,user.getPassword(),user.getRoles().stream().map(role->new
							SimpleGrantedAuthority(role)).collect(Collectors.toList()));
	}


	@Override
	public List<User> fetchUserData() {
		List<User> list=repo.findAll();
		return list;
	}	
	@Override
		public User updateUserById(User user, Integer userId) {
			 User u=repo.getOne(userId);
			return u;
		}

	@Override
	public void deleteUserData(@PathVariable Integer userId) {
		repo.deleteById(userId);
	}
	@Override
	public User getOneUserData(Integer userId) {
		Optional<User> user=repo.findById(userId);
		return user.get();
	}
	
}
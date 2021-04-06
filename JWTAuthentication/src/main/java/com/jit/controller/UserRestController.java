package com.jit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jit.jwtutil.JwtRequest;
import com.jit.jwtutil.JwtResponse;
import com.jit.jwtutil.JwtTokenUtil;
import com.jit.model.User;
import com.jit.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	private IUserService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

	authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

	final UserDetails userDetails = userDetailsService
	.loadUserByUsername(authenticationRequest.getUsername());

	final String token = jwtTokenUtil.generateToken(userDetails);

	return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
	try {
	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	} catch (DisabledException e) {
	throw new Exception("USER_DISABLED", e);
	} catch (BadCredentialsException e){
		e.printStackTrace();
	}
	   //throw new Exception("INVALID_CREDENTIALS", e);
	}
	
	@PostMapping(value = "/create")
	public User createUserData(@RequestBody User user) {
		return service.createUser(user);
		
	}
	@GetMapping(value = "/get")
	public List<User> getUser() {
		List<User> user=service.fetchUser();
		return user;
	}
    
}
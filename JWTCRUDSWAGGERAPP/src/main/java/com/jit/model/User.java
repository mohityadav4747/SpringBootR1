package com.jit.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity

public class User {
	@Id
	@GeneratedValue
	private Integer userId;
	private String userName;
	private Double userSal;
	private String email;
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="roletab",joinColumns = @JoinColumn(name="userId"))
	@Column(name = "roles")
	private Set<String> roles;
	public User() {
		super();
	}
	public User(Integer userId, String userName, Double userSal, String email, String password, Set<String> roles) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userSal = userSal;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Double getUserSal() {
		return userSal;
	}
	public void setUserSal(Double userSal) {
		this.userSal = userSal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userSal=" + userSal + ", email=" + email
				+ ", password=" + password + ", roles=" + roles + "]";
	}
	
}


  package com.tekleads.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
  public class User {
  @Id
  @GeneratedValue 
 private String userId; 
 private String firstName; 
 private
  String lastName;
 private String email; 
 private String phone;
 private String dob;
 private String geder; 
 private String country; 
 private String state;
  private String city;
 private String password; 
 private String active_Sw;
  private String created_Date;
 private String updateted_Date ;
public User() {
	super();
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getGeder() {
	return geder;
}
public void setGeder(String geder) {
	this.geder = geder;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getActive_Sw() {
	return active_Sw;
}
public void setActive_Sw(String active_Sw) {
	this.active_Sw = active_Sw;
}
public String getCreated_Date() {
	return created_Date;
}
public void setCreated_Date(String created_Date) {
	this.created_Date = created_Date;
}
public String getUpdateted_Date() {
	return updateted_Date;
}
public void setUpdateted_Date(String updateted_Date) {
	this.updateted_Date = updateted_Date;
}
@Override
public String toString() {
	return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", phone=" + phone + ", dob=" + dob + ", geder=" + geder + ", country=" + country + ", state=" + state
			+ ", city=" + city + ", password=" + password + ", active_Sw=" + active_Sw + ", created_Date="
			+ created_Date + ", updateted_Date=" + updateted_Date + "]";
}

 
 
  }
  
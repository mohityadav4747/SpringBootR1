package com.tekleads.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tekleads.model.User;
import com.tekleads.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController{
	@Autowired
	private IUserService service;
	@RequestMapping("/register")
	public String userPage() {
		return "UserRegister";
	}
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user,Model model) {
		boolean isSave=service.saveUserData(user);
		if(isSave) {
			model.addAttribute("msg","saved");
		}else {
			model.addAttribute("errmsg", "not saved");
		}
		return "UserRegister";
	}
	
}
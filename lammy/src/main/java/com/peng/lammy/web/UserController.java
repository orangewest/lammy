package com.peng.lammy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peng.lammy.domain.po.User;
import com.peng.lammy.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/checkUser")
	public User checkUser(User user) {
		return userService.getUser(user);
	}
}

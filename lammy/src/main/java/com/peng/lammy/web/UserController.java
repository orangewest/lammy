package com.peng.lammy.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peng.lammy.domain.po.User;

@RestController
public class UserController {

	@PostMapping("/checkUser")
	public void checkUser(User user) {

	}
}

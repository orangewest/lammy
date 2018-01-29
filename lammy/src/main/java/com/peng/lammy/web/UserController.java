package com.peng.lammy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peng.lammy.base.response.Response;
import com.peng.lammy.base.response.ResponseFactory;
import com.peng.lammy.domain.po.User;
import com.peng.lammy.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/checkUser")
	public Response<User> checkUser(User user) {
		return ResponseFactory.creatSuccessResponse(userService.getUser(user));
	}
}

package com.peng.lammy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peng.lammy.base.response.Response;
import com.peng.lammy.base.response.ResponseFactory;
import com.peng.lammy.domain.dto.UserDTO;
import com.peng.lammy.domain.po.User;
import com.peng.lammy.service.UserService;
import com.peng.lammy.util.UserUtils;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/checkUser")
	public Response<User> checkUser(User user) {
		User user2 = userService.getUser(user);
		UserUtils.setUser(user2);
		return ResponseFactory.creatSuccessResponse(user2);
	}

	@GetMapping("/logout")
	public Response<Boolean> logout() {
		UserUtils.removeUser();
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	}

	@GetMapping()
	public Response<User> getUser() {
		return ResponseFactory.creatSuccessResponse(UserUtils.getUser());
	}

	@PutMapping("/reset/{id}")
	public Response<Boolean> updatePassword(@PathVariable Integer id, UserDTO userDto) {
		userDto.setId(id);
		userService.updatePassword(userDto);
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	}
}

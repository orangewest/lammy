package com.peng.lammy.service;

import com.peng.lammy.domain.dto.UserDTO;
import com.peng.lammy.domain.po.User;

public interface UserService {
	User getUser(User user);

	void updatePassword(UserDTO userDto);
}

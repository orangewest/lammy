package com.peng.lammy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peng.lammy.base.exception.BaseRuntimeException;
import com.peng.lammy.dao.UserDao;
import com.peng.lammy.domain.dto.UserDTO;
import com.peng.lammy.domain.po.User;
import com.peng.lammy.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(User user) {
		User user2 = userDao.getUser(user);
		if (user2 == null) {
			throw new BaseRuntimeException("用户名或密码错误！");
		}
		user2.setUsername(user.getUsername());
		return user2;
	}

	@Override
	public void updatePassword(UserDTO userDTO) {
		User user = userDao.getUserById(userDTO.getId());
		if (!user.getPassword().equals(userDTO.getPassword())) {
			throw new BaseRuntimeException("密码输入错误！");
		}
		user.setPassword(userDTO.getRPassword());
		userDao.updatePassword(user);
	}

}

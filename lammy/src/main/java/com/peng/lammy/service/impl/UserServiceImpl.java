package com.peng.lammy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peng.lammy.dao.UserDao;
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
			throw new RuntimeException("用户名或密码错误！");
		}
		return user2;
	}

}

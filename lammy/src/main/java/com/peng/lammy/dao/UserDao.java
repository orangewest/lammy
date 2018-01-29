package com.peng.lammy.dao;

import org.apache.ibatis.annotations.Select;

import com.peng.lammy.domain.po.User;

public interface UserDao {
	@Select("SELECT id FROM `user` a WHERE a.username = #{username} AND a.`password` = #{password}")
	User getUser(User user);
}

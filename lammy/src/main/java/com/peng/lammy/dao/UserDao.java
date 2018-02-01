package com.peng.lammy.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.peng.lammy.domain.po.User;

public interface UserDao {
	@Select("SELECT id FROM `user` a WHERE a.username = #{username} AND a.`password` = #{password}")
	User getUser(User user);

	@Update("update user set PASSWORD = #{password},UPDATE_TIME = #{updateTime} where ID = #{id}")
	void updatePassword(User user);

	@Select("select * from user where ID = #{id}")
	User getUserById(Integer id);
}

package com.peng.lammy.dao;

import org.apache.ibatis.annotations.Insert;

import com.peng.lammy.domain.po.Notepad;

public interface NotepadDao {

	@Insert("insert into LAMMY_NOTEPAD(TITLE,CONTENT,STATE,IS_REMIND,REMIND_TIME,CREATED_TIME,UPDATE_TIME,IS_DELETE) "
			+ "values(#{title},#{content},#{state},#{isRemind},#{remindTime},now(),now(),0)")
	void insert(Notepad notepad);

}

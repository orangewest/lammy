package com.peng.lammy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.peng.lammy.domain.po.Notepad;

public interface NotepadDao {

	@Insert("insert into LAMMY_NOTEPAD(USER_ID,TITLE,CONTENT,STATE,IS_REMIND,REMIND_TIME,CREATED_TIME,UPDATE_TIME,IS_DELETE) "
			+ "values(#{userId},#{title},#{content},0,#{isRemind},#{remindTime},#{createdTime},#{updateTime},0)")
	void insert(Notepad notepad);

	List<Notepad> listNotepad(Notepad notepad);

	@Update("update LAMMY_NOTEPAD set TITLE = #{title},CONTENT = #{content},IS_REMIND = #{isRemind},REMIND_TIME = #{remindTime},UPDATE_TIME = #{updateTime} "
			+ "where ID = #{id}")
	void update(Notepad notepad);

	@Update("update LAMMY_NOTEPAD set STATE = #{state},COMPLETE_TIME = #{completeTime} where ID = #{id}")
	void updateState(Notepad notepad);

	@Delete("update LAMMY_NOTEPAD set IS_DELETE = 1 where ID = #{id}")
	void delete(Integer id);

	@Select("select * from LAMMY_NOTEPAD where ID = #{id}")
	Notepad getNotepadById(Integer id);

}

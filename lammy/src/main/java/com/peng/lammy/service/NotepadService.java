package com.peng.lammy.service;

import java.util.List;

import com.peng.lammy.domain.po.Notepad;

/**
 * 记事本
 * 
 * @author Administrator
 *
 */
public interface NotepadService {
	/**
	 * 新增记事本
	 * 
	 * @param notepad
	 */
	void insert(Notepad notepad);

	/**
	 * 查询记事本列表
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	List<Notepad> listNotepad(Integer page, Integer limit);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * 编辑
	 * 
	 * @param notepad
	 */
	void update(Notepad notepad);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	Notepad getNotepadById(Integer id);

	void updateState(Notepad notepad);
}

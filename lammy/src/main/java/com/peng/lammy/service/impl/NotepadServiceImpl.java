package com.peng.lammy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.peng.lammy.dao.NotepadDao;
import com.peng.lammy.domain.po.Notepad;
import com.peng.lammy.service.NotepadService;
import com.xiaoleilu.hutool.date.DateUtil;

@Service
public class NotepadServiceImpl implements NotepadService {

	@Autowired
	private NotepadDao notepadDao;

	@Override
	public void insert(Notepad notepad) {
		notepad.setCreatedTime(DateUtil.now());
		notepad.setUpdateTime(DateUtil.now());
		notepadDao.insert(notepad);
	}

	@Override
	public List<Notepad> listNotepad(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		List<Notepad> listNotepad = notepadDao.listNotepad();
		return listNotepad;
	}

	@Override
	public void delete(Integer id) {
		notepadDao.delete(id);
	}

	@Override
	public void update(Notepad notepad) {
		notepad.setUpdateTime(DateUtil.now());
		notepadDao.update(notepad);
	}

	@Override
	public Notepad getNotepadById(Integer id) {
		return notepadDao.getNotepadById(id);
	}

	@Override
	public void updateState(Notepad notepad) {
		if (notepad.getState() == 1) {
			notepad.setCompleteTime(DateUtil.now());
		}
		notepadDao.updateState(notepad);
	}

}

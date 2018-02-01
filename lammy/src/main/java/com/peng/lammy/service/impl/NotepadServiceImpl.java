package com.peng.lammy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.peng.lammy.dao.NotepadDao;
import com.peng.lammy.domain.dto.NotepadDTO;
import com.peng.lammy.domain.po.Notepad;
import com.peng.lammy.service.NotepadService;
import com.peng.lammy.util.UserUtils;
import com.xiaoleilu.hutool.date.DateUtil;
import com.xiaoleilu.hutool.util.StrUtil;

@Service
public class NotepadServiceImpl implements NotepadService {

	@Autowired
	private NotepadDao notepadDao;

	@Override
	public void insert(Notepad notepad) {
		notepad.setCreatedTime(DateUtil.now());
		notepad.setUpdateTime(DateUtil.now());
		notepad.setUserId(UserUtils.getUser().getId());
		notepadDao.insert(notepad);
	}

	@Override
	public List<Notepad> listNotepad(NotepadDTO notepadDto) {
		PageHelper.startPage(notepadDto.getPage(), notepadDto.getLimit());
		Notepad notepad = new Notepad();
		notepad.setUserId(UserUtils.getUser().getId());
		if (StrUtil.isNotBlank(notepadDto.getTitle())) {
			notepad.setTitle("%" + notepadDto.getTitle() + "%");
		}
		notepad.setState(notepadDto.getState());
		List<Notepad> listNotepad = notepadDao.listNotepad(notepad);
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

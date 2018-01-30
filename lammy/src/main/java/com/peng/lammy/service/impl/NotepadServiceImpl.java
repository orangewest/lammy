package com.peng.lammy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peng.lammy.dao.NotepadDao;
import com.peng.lammy.domain.po.Notepad;
import com.peng.lammy.service.NotepadService;

@Service
public class NotepadServiceImpl implements NotepadService {

	@Autowired
	private NotepadDao notepadDao;

	@Override
	public void insert(Notepad notepad) {
		notepadDao.insert(notepad);
	}

}

package com.peng.lammy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peng.lammy.dao.DictionaryDao;
import com.peng.lammy.domain.po.Dictionary;
import com.peng.lammy.service.DictionaryService;

@Service
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryDao dictionaryDao;

	@Override
	public List<Dictionary> listDictionaryByType(String dictType) {
		return dictionaryDao.listDictionaryByType(dictType);
	}

}

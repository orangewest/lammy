package com.peng.lammy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peng.lammy.base.exception.BaseRuntimeException;
import com.peng.lammy.dao.DictionaryDao;
import com.peng.lammy.domain.po.Dictionary;
import com.peng.lammy.domain.vo.DictionaryTypeVo;
import com.peng.lammy.domain.vo.DictionaryVo;
import com.peng.lammy.service.DictionaryService;
import com.xiaoleilu.hutool.date.DateUtil;

@Service
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryDao dictionaryDao;

	@Override
	public List<Dictionary> listDictionaryByType(String dictType) {
		return dictionaryDao.listDictionaryByType(dictType);
	}

	@Override
	public List<DictionaryVo> listDictionary(String dictType) {
		return dictionaryDao.listDictionary(dictType);
	}

	@Override
	public Dictionary insert(Dictionary dictionary) {
		dictionary.setCreatedTime(DateUtil.now());
		dictionary.setUpdateTime(DateUtil.now());
		dictionary.setDictAuth(2);
		dictionaryDao.insert(dictionary);
		return dictionary;
	}

	@Override
	public Dictionary update(Dictionary dictionary) {
		dictionary.setUpdateTime(DateUtil.now());
		dictionaryDao.update(dictionary);
		return dictionary;
	}

	@Override
	public void deleteById(Integer id) {
		Dictionary dictionary = getDictionaryById(id);
		if (dictionary.getDictAuth().equals(1)) {
			throw new BaseRuntimeException("系统字典不允许删除！！！");
		}
		dictionaryDao.deleteById(id);
	}

	@Override
	public Dictionary getDictionaryById(Integer id) {
		return dictionaryDao.getDictionaryById(id);
	}

	@Override
	public List<DictionaryTypeVo> listTypeVo() {
		return dictionaryDao.listTypeVo();
	}

	@Override
	public boolean hasSameDictionary(Dictionary dictionary) {
		if (dictionaryDao.getDictionaryByCode(dictionary) != null) {
			return true;
		}
		return false;
	}

}

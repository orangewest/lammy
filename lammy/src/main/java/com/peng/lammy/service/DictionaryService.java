package com.peng.lammy.service;

import java.util.List;

import com.peng.lammy.domain.po.Dictionary;

public interface DictionaryService {
	/**
	 * 根据字典类型查询字典列表
	 * 
	 * @param dictType
	 * @return
	 */
	List<Dictionary> listDictionaryByType(String dictType);
}

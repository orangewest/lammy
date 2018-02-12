package com.peng.lammy.service;

import java.util.List;

import com.peng.lammy.domain.po.Dictionary;
import com.peng.lammy.domain.vo.DictionaryTypeVo;
import com.peng.lammy.domain.vo.DictionaryVo;

public interface DictionaryService {
	/**
	 * 根据字典类型查询字典列表
	 * 
	 * @param dictType
	 * @return
	 */
	List<Dictionary> listDictionaryByType(String dictType);

	List<DictionaryVo> listDictionary(String dictType);

	Dictionary insert(Dictionary dictionary);

	Dictionary update(Dictionary dictionary);

	void deleteById(Integer id);

	Dictionary getDictionaryById(Integer id);

	List<DictionaryTypeVo> listTypeVo();

	boolean hasSameDictionary(Dictionary dictionary);
}

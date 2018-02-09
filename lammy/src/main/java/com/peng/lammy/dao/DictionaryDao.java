package com.peng.lammy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.peng.lammy.domain.po.Dictionary;

public interface DictionaryDao {

	@Select("SELECT DICT_CODE,DICT_NAME FROM LAMMY_DICTIONARY WHERE IS_DELETE = 0 AND DICT_TYPE = #{dictType}")
	List<Dictionary> listDictionaryByType(String dictType);
}

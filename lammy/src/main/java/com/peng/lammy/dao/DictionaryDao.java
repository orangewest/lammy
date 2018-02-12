package com.peng.lammy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.peng.lammy.domain.po.Dictionary;
import com.peng.lammy.domain.vo.DictionaryTypeVo;
import com.peng.lammy.domain.vo.DictionaryVo;

public interface DictionaryDao {

	/**
	 * 根据字典类型查询字典内容
	 * 
	 * @param dictType
	 * @return
	 */
	@Select("SELECT DICT_CODE,DICT_NAME FROM LAMMY_DICTIONARY WHERE IS_DELETE = 0 AND DICT_TYPE = #{dictType}")
	List<Dictionary> listDictionaryByType(String dictType);

	/**
	 * 查询所有字典内容
	 * 
	 * @return
	 */
	List<DictionaryVo> listDictionary(@Param("dictType") String dictType);

	void insert(Dictionary dictionary);

	void update(Dictionary dictionary);

	@Update("DELETE FROM LAMMY_DICTIONARY WHERE ID=#{id}")
	void deleteById(Integer id);

	@Select("SELECT ID,DICT_CODE,DICT_NAME,DICT_TYPE,DICT_AUTH FROM LAMMY_DICTIONARY WHERE ID = #{id}")
	Dictionary getDictionaryById(Integer id);

	@Select("SELECT TYPE_CODE,TYPE_NAME FROM LAMMY_DICTIONARY_TYPE WHERE IS_DELETE=0")
	List<DictionaryTypeVo> listTypeVo();

	@Select("SELECT * FROM LAMMY_DICTIONARY WHERE DICT_CODE = #{dictCode} AND DICT_TYPE = #{dictType} AND IS_DELETE = 0")
	Dictionary getDictionaryByCode(Dictionary dictionary);
}

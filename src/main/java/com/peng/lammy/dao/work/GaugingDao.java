package com.peng.lammy.dao.work;

import java.util.List;

import com.peng.lammy.domain.dto.work.GaugingDTO;
import com.peng.lammy.domain.po.work.Gauging;

public interface GaugingDao {
	/**
	 * 新增
	 * 
	 * @param gauging
	 */
	void insert(Gauging gauging);

	/**
	 * 根据编号查询是否有相同编号
	 * 
	 * @param gaugingNo
	 * @return
	 */
	int countGaugingByNo(String gaugingNo);

	/**
	 * 查询最大编号
	 * 
	 * @return
	 */
	String getMaxGaugingNo();

	/**
	 * 查询检测列表
	 * 
	 * @return
	 */
	List<Gauging> listGauging(GaugingDTO gaugingDTO);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	Gauging getGaugingById(Integer id);

	/**
	 * 更新
	 * 
	 * @param gauging
	 */
	void update(Gauging gauging);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void deleteById(Integer id);
}

package com.peng.lammy.dao.work;

import java.util.List;

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
	 * 查询最近一条编号
	 * 
	 * @return
	 */
	String getGaugingNoOrderByDate();

	/**
	 * 查询检测列表
	 * 
	 * @return
	 */
	List<Gauging> listGauging();

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
}

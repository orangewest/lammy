package com.peng.lammy.dao.work;

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
}

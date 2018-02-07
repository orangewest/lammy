package com.peng.lammy.service.work;

import com.peng.lammy.domain.po.work.Gauging;

/**
 * @Description 检测管理业务层
 * @author jp
 * @time 2018年2月7日 下午2:17:30
 */
public interface GaugingService {
	/**
	 * 插入
	 * 
	 * @param gauging
	 * @return
	 */
	Gauging insert(Gauging gauging);

	/**
	 * 是否有相同编号
	 * 
	 * @param gaugingNo
	 * @return
	 */
	boolean hasSameNo(String gaugingNo);

	/**
	 * 系统生成编号
	 * 
	 * @return
	 */
	String sysProductNo();

}

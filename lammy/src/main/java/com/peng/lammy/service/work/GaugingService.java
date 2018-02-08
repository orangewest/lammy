package com.peng.lammy.service.work;

import java.util.List;

import com.peng.lammy.domain.dto.work.GaugingDTO;
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

	/**
	 * 条件查询列表
	 * 
	 * @param gaugingDTO
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
	Gauging update(Gauging gauging);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void deleteById(Integer id);

	void deleteBatch(Integer[] ids);

	/**
	 * 批量导入插入
	 * 
	 * @param filePath
	 * @return
	 */
	Long insertBatch(String filePath);

}

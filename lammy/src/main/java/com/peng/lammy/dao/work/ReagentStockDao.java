package com.peng.lammy.dao.work;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import com.peng.lammy.domain.po.work.ReagentStock;
import com.peng.lammy.domain.vo.work.ReagentStockVo;

public interface ReagentStockDao {
	/**
	 * 新增
	 * 
	 * @param reagentStock
	 */
	void insert(ReagentStock reagentStock);

	List<ReagentStockVo> listReagentStock();

	@Delete("UPDATE LAMMY_REAGENT_STOCK SET IS_DELETE = 1 WHERE REAGENT_ID = #{reagentId}")
	void deleteByReagentId(Integer reagentId);

}

package com.peng.lammy.service.work;

import java.util.List;

import com.peng.lammy.domain.po.work.Reagent;
import com.peng.lammy.domain.po.work.ReagentStock;
import com.peng.lammy.domain.vo.work.ReagentStockVo;

/**
 * @Description 实验试剂管理
 * @author jp
 * @time 2018年2月7日 下午2:17:30
 */
public interface ReagentService {

	Reagent insert(Reagent reagent);

	List<Reagent> listReagent(Reagent reagent);

	List<ReagentStockVo> listReagentStock();

	void updateStock(ReagentStock reagentStock);

	Reagent getReagentById(Integer id);

	void update(Reagent reagent);

	void delete(Integer id);
}

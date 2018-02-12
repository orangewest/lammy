package com.peng.lammy.service.work.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.peng.lammy.base.exception.BaseRuntimeException;
import com.peng.lammy.dao.work.ReagentDao;
import com.peng.lammy.dao.work.ReagentStockDao;
import com.peng.lammy.domain.po.work.Reagent;
import com.peng.lammy.domain.po.work.ReagentStock;
import com.peng.lammy.domain.vo.work.ReagentStockVo;
import com.peng.lammy.service.work.ReagentService;
import com.peng.lammy.util.CommonUtils;
import com.xiaoleilu.hutool.date.DatePattern;
import com.xiaoleilu.hutool.date.DateUtil;

@Service
public class ReagentServiceImpl implements ReagentService {

	@Autowired
	private ReagentDao reagentDao;

	@Autowired
	private ReagentStockDao reagentStockDao;

	@Override
	@Transactional
	public Reagent insert(Reagent reagent) {
		reagent.setCreatedTime(DateUtil.now());
		reagent.setUpdateTime(DateUtil.now());
		reagentDao.insert(reagent);
		reagentStockDao
				.insert(new ReagentStock(reagent.getId(), 1, DateUtil.format(new Date(), DatePattern.NORM_DATE_FORMAT),
						reagent.getStock(), "初始新增操作", DateUtil.now(), DateUtil.now(), 0));
		return reagent;
	}

	@Override
	public List<Reagent> listReagent(Reagent reagent) {
		reagent.setReagentName(CommonUtils.addPercent(reagent.getReagentName()));
		return reagentDao.listReagent(reagent);
	}

	@Override
	public List<ReagentStockVo> listReagentStock() {
		return reagentStockDao.listReagentStock();
	}

	@Override
	@Transactional
	public void updateStock(ReagentStock reagentStock) {
		Reagent reagent = getReagentById(reagentStock.getReagent_id());
		int newStock = reagent.getStock();
		if (reagentStock.getOperation().equals(1)) {
			newStock = newStock + reagentStock.getCount();
		} else {
			newStock = newStock - reagentStock.getCount();
			if (newStock < 0) {
				throw new BaseRuntimeException("当前库存数量为：" + reagent.getStock() + ",所需出库数量为：" + reagentStock.getCount());
			}
		}
		reagentDao.updateStock(newStock, reagentStock.getReagent_id());
		reagentStock.setCreatedTime(DateUtil.now());
		reagentStock.setUpdateTime(DateUtil.now());
		reagentStockDao.insert(reagentStock);
	}

	@Override
	public Reagent getReagentById(Integer id) {
		return reagentDao.getReagentById(id);
	}

	@Override
	public void update(Reagent reagent) {
		reagent.setUpdateTime(DateUtil.now());
		reagentDao.update(reagent);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		reagentDao.deleteById(id);
		reagentStockDao.deleteByReagentId(id);
	}

}

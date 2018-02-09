package com.peng.lammy.service.work.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peng.lammy.dao.work.ReagentDao;
import com.peng.lammy.domain.po.work.Reagent;
import com.peng.lammy.service.work.ReagentService;
import com.xiaoleilu.hutool.date.DateUtil;

@Service
public class ReagentServiceImpl implements ReagentService {

	@Autowired
	private ReagentDao reagentDao;

	@Override
	public Reagent insert(Reagent reagent) {
		reagent.setCreatedTime(DateUtil.now());
		reagent.setUpdateTime(DateUtil.now());
		reagentDao.insert(reagent);
		return reagent;
	}

}

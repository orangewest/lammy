package com.peng.lammy.service.work.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peng.lammy.dao.work.GaugingDao;
import com.peng.lammy.domain.po.work.Gauging;
import com.peng.lammy.service.work.GaugingService;
import com.xiaoleilu.hutool.date.DateUtil;
import com.xiaoleilu.hutool.util.ReUtil;
import com.xiaoleilu.hutool.util.StrUtil;

@Service
public class GaugingServiceImpl implements GaugingService {

	@Autowired
	private GaugingDao gaugingDao;

	@Override
	public Gauging insert(Gauging gauging) {
		gauging.setCreatedTime(DateUtil.now());
		gauging.setUpdateTime(DateUtil.now());
		gaugingDao.insert(gauging);
		return gauging;
	}

	@Override
	public boolean hasSameNo(String gaugingNo) {
		return gaugingDao.countGaugingByNo(gaugingNo) == 1 ? true : false;
	}

	@Override
	public String sysProductNo() {
		String gaugingNo = gaugingDao.getGaugingNoOrderByDate();
		if (StrUtil.isBlank(gaugingNo) || !ReUtil.isMatch("[w,W]\\d+", gaugingNo)) {
			return "";
		}
		String sysGaugingNo = gaugingNo.substring(1);
		return "W" + (Integer.parseInt(sysGaugingNo) + 1);
	}

}

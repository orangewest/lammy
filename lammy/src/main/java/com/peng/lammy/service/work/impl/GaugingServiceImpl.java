package com.peng.lammy.service.work.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.peng.lammy.dao.work.GaugingDao;
import com.peng.lammy.domain.dto.work.GaugingDTO;
import com.peng.lammy.domain.dto.work.GaugingPoiDTO;
import com.peng.lammy.domain.po.work.Gauging;
import com.peng.lammy.service.work.GaugingService;
import com.xiaoleilu.hutool.date.DatePattern;
import com.xiaoleilu.hutool.date.DateUtil;
import com.xiaoleilu.hutool.util.ReUtil;
import com.xiaoleilu.hutool.util.StrUtil;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GaugingServiceImpl implements GaugingService {

	@Autowired
	private GaugingDao gaugingDao;

	@Override
	public Gauging insert(Gauging gauging) {
		gauging.setCreatedTime(DateUtil.now());
		gauging.setUpdateTime(DateUtil.now());
		gauging.setGaugingNo(gauging.getGaugingNo().toUpperCase());
		gauging.setGaugingNoOrder(Integer.parseInt(gauging.getGaugingNo().substring(1)));
		gaugingDao.insert(gauging);
		return gauging;
	}

	@Override
	public boolean hasSameNo(String gaugingNo) {
		return gaugingDao.countGaugingByNo(gaugingNo) >= 1 ? true : false;
	}

	@Override
	public String sysProductNo() {
		String gaugingNo = gaugingDao.getMaxGaugingNo();
		if (StrUtil.isBlank(gaugingNo) || !ReUtil.isMatch("[w,W]\\d+", gaugingNo)) {
			return "";
		}
		String sysGaugingNo = gaugingNo.substring(1);
		return "W" + (Integer.parseInt(sysGaugingNo) + 1);
	}

	@Override
	public List<Gauging> listGauging(GaugingDTO gaugingDTO) {
		if (gaugingDTO.getPage() > 0 && gaugingDTO.getLimit() > 0) {
			PageHelper.startPage(gaugingDTO.getPage(), gaugingDTO.getLimit());
		}
		if (StrUtil.isNotBlank(gaugingDTO.getGaugingNo())) {
			gaugingDTO.setGaugingNo("%" + gaugingDTO.getGaugingNo() + "%");
		}
		if (StrUtil.isNotBlank(gaugingDTO.getSampleName())) {
			gaugingDTO.setSampleName("%" + gaugingDTO.getSampleName() + "%");
		}
		if (StrUtil.isNotBlank(gaugingDTO.getSendPerson())) {
			gaugingDTO.setSendPerson("%" + gaugingDTO.getSendPerson() + "%");
		}
		if (StrUtil.isBlank(gaugingDTO.getGaugingDate())) {
			if (StrUtil.isBlank(gaugingDTO.getMonth())) {
				if (StrUtil.isNotBlank(gaugingDTO.getYear())) {
					gaugingDTO.setGaugingDate(gaugingDTO.getYear() + "%");
				}
			} else {
				gaugingDTO.setGaugingDate(gaugingDTO.getMonth() + "%");
			}
		}
		return gaugingDao.listGauging(gaugingDTO);
	}

	@Override
	public Gauging getGaugingById(Integer id) {
		return gaugingDao.getGaugingById(id);
	}

	@Override
	public Gauging update(Gauging gauging) {
		gaugingDao.update(gauging);
		return gauging;
	}

	@Override
	public void deleteById(Integer id) {
		gaugingDao.deleteById(id);
	}

	@Override
	public void deleteBatch(Integer[] ids) {
		for (Integer id : ids) {
			gaugingDao.deleteById(id);
		}
	}

	@Override
	public Long insertBatch(String filePath) {
		List<GaugingPoiDTO> list = ExcelImportUtil.importExcel(new File(filePath), GaugingPoiDTO.class,
				new ImportParams());
		Long count = 0L;
		for (GaugingPoiDTO gaugingPoiDTO : list) {
			if (StrUtil.isBlank(gaugingPoiDTO.getSendPerson()) || StrUtil.isBlank(gaugingPoiDTO.getGaugingNo())
					|| !ReUtil.isMatch("[w,W]\\d+", gaugingPoiDTO.getGaugingNo())) {
				continue;
			}
			Gauging gauging = new Gauging();
			BeanUtils.copyProperties(gaugingPoiDTO, gauging);
			try {
				gauging.setGaugingDate(
						DateUtil.format(new Date(gaugingPoiDTO.getGaugingDate()), DatePattern.NORM_DATE_FORMAT));
				insert(gauging);
				count++;
			} catch (Exception e) {
				log.error("插入数据失败", e);
			}
		}
		return count;
	}

}

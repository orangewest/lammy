package com.peng.lammy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.peng.lammy.dao.work.GaugingDao;
import com.peng.lammy.domain.dto.work.GaugingDTO;
import com.peng.lammy.domain.dto.work.GaugingPoiDTO;
import com.peng.lammy.domain.po.work.Gauging;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LammyApplicationTests {

	@Autowired
	private GaugingDao gaugingDao;

	@Test
	public void poiRead() {
		long start = new Date().getTime();
		List<GaugingPoiDTO> list = ExcelImportUtil.importExcel(new File("D:/2015年物化所检测台帐（其他检测）.xls"),
				GaugingPoiDTO.class, new ImportParams());
		System.out.println(new Date().getTime() - start);
		for (GaugingPoiDTO gaugingPoiDTO : list) {
			System.out.println(gaugingPoiDTO);
		}
		System.out.println(list.size());
		System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
	}

	@Test
	public void poiWrite() {
		GaugingDTO gaugingDTO = new GaugingDTO();
		List<Gauging> listGauging = gaugingDao.listGauging(gaugingDTO);
		List<GaugingPoiDTO> gaugingPoiDTOs = new ArrayList<GaugingPoiDTO>();
		for (Gauging gauging : listGauging) {
			GaugingPoiDTO gaugingPoiDTO = new GaugingPoiDTO();
			BeanUtils.copyProperties(gauging, gaugingPoiDTO);
			gaugingPoiDTOs.add(gaugingPoiDTO);
		}
		Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(null, "检测"), GaugingPoiDTO.class,
				gaugingPoiDTOs);
		File savefile = new File("D:/excel/");
		if (!savefile.exists()) {
			savefile.mkdirs();
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("D:/excel/ExcelExportMsgClient.xls");
			workbook.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

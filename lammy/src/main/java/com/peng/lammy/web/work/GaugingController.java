package com.peng.lammy.web.work;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.peng.lammy.base.response.Response;
import com.peng.lammy.base.response.ResponseFactory;
import com.peng.lammy.domain.dto.work.GaugingDTO;
import com.peng.lammy.domain.dto.work.GaugingPoiDTO;
import com.peng.lammy.domain.po.work.Gauging;
import com.peng.lammy.service.work.GaugingService;
import com.peng.lammy.util.FileUtils;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;

@RestController
@RequestMapping("/work/gauging")
public class GaugingController {
	@Autowired
	private GaugingService gaugingService;

	@PostMapping
	public Response<Boolean> insert(Gauging gauging) {
		gaugingService.insert(gauging);
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	}

	@GetMapping("/hasSameNo/{gaugingNo}")
	public Response<Boolean> hasSameNo(@PathVariable String gaugingNo) {
		return ResponseFactory.creatSuccessResponse(gaugingService.hasSameNo(gaugingNo));
	}

	@GetMapping("/sysProductNo")
	public Response<String> sysProductNo() {
		return ResponseFactory.creatSuccessResponse(gaugingService.sysProductNo());
	}

	@GetMapping
	public Response<List<Gauging>> getGaugingList(GaugingDTO gaugingDTO) {
		return ResponseFactory.creatSuccessResponse(gaugingService.listGauging(gaugingDTO));
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Response<Gauging> getGaugingById(@PathVariable Integer id) {
		return ResponseFactory.creatSuccessResponse(gaugingService.getGaugingById(id));
	}

	/**
	 * 更新
	 * 
	 * @param gauging
	 */
	@PutMapping("/{id}")
	public Response<Boolean> update(@PathVariable Integer id, Gauging gauging) {
		gauging.setId(id);
		gaugingService.update(gauging);
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	};

	@DeleteMapping("/{id}")
	public Response<Boolean> delete(@PathVariable Integer id) {
		gaugingService.deleteById(id);
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	}

	@PostMapping("/delete/batch")
	public Response<Boolean> deleteBatch(Integer[] ids) {
		gaugingService.deleteBatch(ids);
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	}

	@PostMapping("/upload")
	public Response<Long> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String fileName = file.getOriginalFilename();
		String filePath = "/fileUpload";
		try {
			FileUtils.uploadFile(file.getBytes(), filePath, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseFactory.creatSuccessResponse(gaugingService.insertBatch(filePath + fileName));
	}

	@GetMapping("/download")
	public void download(GaugingDTO gaugingDTO, ModelMap map, HttpServletRequest request,
			HttpServletResponse response) {
		List<Gauging> listGauging = gaugingService.listGauging(gaugingDTO);
		List<GaugingPoiDTO> gaugingPoiDTOs = new ArrayList<GaugingPoiDTO>();
		for (Gauging gauging : listGauging) {
			GaugingPoiDTO gaugingPoiDTO = new GaugingPoiDTO();
			BeanUtils.copyProperties(gauging, gaugingPoiDTO);
			gaugingPoiDTOs.add(gaugingPoiDTO);
		}
		ExportParams params = new ExportParams(null, "测试", ExcelType.XSSF);
		params.setFreezeCol(1);
		map.put(NormalExcelConstants.DATA_LIST, gaugingPoiDTOs);
		map.put(NormalExcelConstants.CLASS, GaugingPoiDTO.class);
		map.put(NormalExcelConstants.PARAMS, params);
		PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
	}
}

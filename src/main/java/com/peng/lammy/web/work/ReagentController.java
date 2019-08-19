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
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.peng.lammy.base.response.Response;
import com.peng.lammy.base.response.ResponseFactory;
import com.peng.lammy.domain.dto.work.ReagentPoiDTO;
import com.peng.lammy.domain.dto.work.ReagentStockPoiDTO;
import com.peng.lammy.domain.po.work.Reagent;
import com.peng.lammy.domain.po.work.ReagentStock;
import com.peng.lammy.domain.vo.work.ReagentStockVo;
import com.peng.lammy.service.work.ReagentService;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;

@RestController
@RequestMapping("/work/reagent")
public class ReagentController {
	@Autowired
	private ReagentService reagentService;

	@PostMapping
	public Response<Boolean> insert(Reagent reagent) {
		reagentService.insert(reagent);
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	}

	@GetMapping
	public Response<List<Reagent>> getReagentList(int page, int limit, Reagent reagent) {
		PageHelper.startPage(page, limit);
		return ResponseFactory.creatSuccessResponse(reagentService.listReagent(reagent));
	}

	@GetMapping("/operation")
	public Response<List<ReagentStockVo>> getReagentStockList(int page, int limit) {
		PageHelper.startPage(page, limit);
		return ResponseFactory.creatSuccessResponse(reagentService.listReagentStock());
	}

	@PutMapping("/stock/{id}")
	public Response<Boolean> updateStock(@PathVariable Integer id, ReagentStock reagentStock) {
		reagentStock.setReagent_id(id);
		reagentService.updateStock(reagentStock);
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	}

	@GetMapping("/{id}")
	public Response<Reagent> getById(@PathVariable Integer id) {
		return ResponseFactory.creatSuccessResponse(reagentService.getReagentById(id));
	}

	@PutMapping("/{id}")
	public Response<Boolean> update(@PathVariable Integer id, Reagent reagent) {
		reagentService.update(reagent);
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	}

	@DeleteMapping("/{id}")
	public Response<Boolean> delete(@PathVariable Integer id) {
		reagentService.delete(id);
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	}

	@PostMapping("/delete/batch")
	public Response<Boolean> deleteBatch(Integer[] ids) {
		for (Integer id : ids) {
			reagentService.delete(id);
		}
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	}

	@GetMapping("/download")
	public void download(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		List<Reagent> reagentList = reagentService.listReagent(new Reagent());
		List<ReagentPoiDTO> reagentPoiDTOs = new ArrayList<>();
		for (Reagent reagent : reagentList) {
			ReagentPoiDTO reagentPoiDTO = new ReagentPoiDTO();
			BeanUtils.copyProperties(reagent, reagentPoiDTO);
			reagentPoiDTOs.add(reagentPoiDTO);
		}
		ExportParams params = new ExportParams(null, "实验试剂管理", ExcelType.XSSF);
		params.setFreezeCol(1);
		map.put(NormalExcelConstants.DATA_LIST, reagentPoiDTOs);
		map.put(NormalExcelConstants.CLASS, ReagentPoiDTO.class);
		map.put(NormalExcelConstants.PARAMS, params);
		PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
	}

	@GetMapping("/stock/download")
	public void downloadStock(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		List<ReagentStockVo> reagentStockVoList = reagentService.listReagentStock();
		List<ReagentStockPoiDTO> reagentStockPoiDTOs = new ArrayList<>();
		for (ReagentStockVo reagentStockVo : reagentStockVoList) {
			ReagentStockPoiDTO reagentStockPoiDTO = new ReagentStockPoiDTO();
			BeanUtils.copyProperties(reagentStockVo, reagentStockPoiDTO);
			reagentStockPoiDTOs.add(reagentStockPoiDTO);
		}
		ExportParams params = new ExportParams(null, "实验试剂库存管理", ExcelType.XSSF);
		params.setFreezeCol(1);
		map.put(NormalExcelConstants.DATA_LIST, reagentStockPoiDTOs);
		map.put(NormalExcelConstants.CLASS, ReagentStockPoiDTO.class);
		map.put(NormalExcelConstants.PARAMS, params);
		PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
	}

}

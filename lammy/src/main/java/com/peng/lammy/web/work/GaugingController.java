package com.peng.lammy.web.work;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peng.lammy.base.response.Response;
import com.peng.lammy.base.response.ResponseFactory;
import com.peng.lammy.domain.dto.work.GaugingDTO;
import com.peng.lammy.domain.po.work.Gauging;
import com.peng.lammy.service.work.GaugingService;

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
}

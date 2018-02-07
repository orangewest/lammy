package com.peng.lammy.web.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peng.lammy.base.response.Response;
import com.peng.lammy.base.response.ResponseFactory;
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
}

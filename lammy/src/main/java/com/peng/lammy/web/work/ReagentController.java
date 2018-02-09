package com.peng.lammy.web.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peng.lammy.base.response.Response;
import com.peng.lammy.base.response.ResponseFactory;
import com.peng.lammy.domain.po.work.Reagent;
import com.peng.lammy.service.work.ReagentService;

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
}

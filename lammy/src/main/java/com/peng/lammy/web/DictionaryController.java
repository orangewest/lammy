package com.peng.lammy.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peng.lammy.base.response.Response;
import com.peng.lammy.base.response.ResponseFactory;
import com.peng.lammy.domain.po.Dictionary;
import com.peng.lammy.service.DictionaryService;

@RestController
@RequestMapping("/dict")
public class DictionaryController {

	@Autowired
	private DictionaryService dictionaryService;

	@GetMapping("/type/{type}")
	public Response<List<Dictionary>> getDictionaryList(@PathVariable String type) {
		return ResponseFactory.creatSuccessResponse(dictionaryService.listDictionaryByType(type));
	}
}

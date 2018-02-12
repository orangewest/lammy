package com.peng.lammy.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.peng.lammy.domain.po.Dictionary;
import com.peng.lammy.domain.vo.DictionaryTypeVo;
import com.peng.lammy.domain.vo.DictionaryVo;
import com.peng.lammy.service.DictionaryService;

@RestController
@RequestMapping("/dict")
public class DictionaryController {

	@Autowired
	private DictionaryService dictionaryService;

	@GetMapping("/type/{type}")
	public Response<List<Dictionary>> getDictionaryListByType(@PathVariable String type) {
		return ResponseFactory.creatSuccessResponse(dictionaryService.listDictionaryByType(type));
	}

	@GetMapping
	public Response<List<DictionaryVo>> getDictionaryList(int page, int limit, String dictType) {
		PageHelper.startPage(page, limit);
		return ResponseFactory.creatSuccessResponse(dictionaryService.listDictionary(dictType));
	}

	@PostMapping
	public Response<Boolean> insert(Dictionary dictionary) {
		dictionaryService.insert(dictionary);
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	}

	@PutMapping("/{id}")
	public Response<Boolean> update(@PathVariable Integer id, Dictionary dictionary) {
		dictionary.setId(id);
		dictionaryService.update(dictionary);
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	}

	@DeleteMapping("/{id}")
	public Response<Boolean> deleteById(@PathVariable Integer id) {
		dictionaryService.deleteById(id);
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	}

	@GetMapping("/{id}")
	public Response<Dictionary> getDictionaryById(@PathVariable Integer id) {
		return ResponseFactory.creatSuccessResponse(dictionaryService.getDictionaryById(id));
	}

	@GetMapping("/type")
	public Response<List<DictionaryTypeVo>> getDictionaryType() {
		return ResponseFactory.creatSuccessResponse(dictionaryService.listTypeVo());
	}

	@GetMapping("/repeat")
	public Response<Boolean> hasSameDictionary(Dictionary dictionary) {
		return ResponseFactory.creatSuccessResponse(dictionaryService.hasSameDictionary(dictionary));
	}
}

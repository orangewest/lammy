package com.peng.lammy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peng.lammy.base.response.Response;
import com.peng.lammy.base.response.ResponseFactory;
import com.peng.lammy.domain.po.Notepad;
import com.peng.lammy.service.NotepadService;

@RestController
@RequestMapping("/notepad")
public class NotepadController {

	@Autowired
	private NotepadService notepadService;

	@PostMapping
	public Response<Boolean> insert(Notepad notepad) {
		notepadService.insert(notepad);
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	}
}

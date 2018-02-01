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

import com.peng.lammy.base.response.Response;
import com.peng.lammy.base.response.ResponseFactory;
import com.peng.lammy.domain.dto.NotepadDTO;
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

	@GetMapping
	public Response<List<Notepad>> listNotepad(NotepadDTO notepadDto) {
		return ResponseFactory.creatSuccessResponse(notepadService.listNotepad(notepadDto));
	}

	@DeleteMapping("/{id}")
	public Response<Boolean> delete(@PathVariable Integer id) {
		notepadService.delete(id);
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	}

	@PostMapping("/batch")
	public Response<Boolean> deleteBatch(Integer[] ids) {
		for (Integer id : ids) {
			notepadService.delete(id);
		}
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	}

	@PutMapping("/{id}")
	public Response<Boolean> update(@PathVariable Integer id, Notepad notepad) {
		notepadService.update(notepad);
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	}

	@GetMapping("/{id}")
	public Response<Notepad> getById(@PathVariable Integer id) {
		return ResponseFactory.creatSuccessResponse(notepadService.getNotepadById(id));
	}

	@PutMapping("/{id}/state/{state}")
	public Response<Boolean> updateState(@PathVariable("id") Integer id, @PathVariable("state") Integer state) {
		Notepad notepad = new Notepad();
		notepad.setId(id);
		notepad.setState(state);
		notepadService.updateState(notepad);
		return ResponseFactory.creatSuccessResponse(Boolean.TRUE);
	}

}

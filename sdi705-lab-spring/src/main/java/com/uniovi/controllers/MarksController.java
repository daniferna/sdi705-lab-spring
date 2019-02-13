package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Mark;
import com.uniovi.services.MarkServices;

@RestController
public class MarksController {
	
	@Autowired //Inyectamos el servicio
	private MarkServices markService;

	@RequestMapping("/mark/list")
	public String getList() {
		return markService.getMarks().toString();
	}

	@RequestMapping(value = "/mark/add", method = RequestMethod.POST)
	public String setMark(@ModelAttribute Mark mark) {
		markService.addMark(mark);
		return "OK";
	}

	@RequestMapping("/mark/details/{id}")
	public String getDetail(@PathVariable Long id) {
		return markService.getMark(id).toString();
	}
	
	@RequestMapping("/mark/delete/{id}")
	public String deleteMark(@PathVariable Long id) {
		markService.deleteMark(id);
		return "OK";
	}

}

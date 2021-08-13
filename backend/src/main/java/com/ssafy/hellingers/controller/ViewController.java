package com.ssafy.hellingers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {
	@GetMapping("/board/write")
	public String boardWriteForm(Model model) {
		return "view/board/write";
	}
}

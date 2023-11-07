package com.lec.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.quiz.dto.Student;

@Controller
public class MyController {
	@ModelAttribute("cnt")
	public int cnt () {
		return 4;
	}
	@RequestMapping(value = "input", method = RequestMethod.GET)
	public String input(Student student ) {
		return "result";
	}
}

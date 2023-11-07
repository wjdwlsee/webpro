package com.lec.uitest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.uitest.dto.Student;
@Controller
@RequestMapping("/student")
public class MyController {
	@ModelAttribute("cnt")
	public int cnt () {
		return 4;
	}
	@RequestMapping(value = "input", method = RequestMethod.GET)
	public String input() {
		return "student/input";
	}
	@RequestMapping(value = "input", method= RequestMethod.POST)
	public String input(Student student) {
		student.setTot(student.getEng()+student.getMat()+student.getKor());
		student.setEvg(student.getTot()/3.0d);
		return "student/result";
	}
}

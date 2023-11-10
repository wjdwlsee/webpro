package com.lec.ch13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.ch13.dto.Dept;
import com.lec.ch13.dto.Emp;
import com.lec.ch13.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	@ModelAttribute("deptList")
	public List<Dept> deptList(){
		return empService.deptList();
	}
	//emp.do
	@RequestMapping(value = "emp")
	public String emp(@ModelAttribute("schEmp") Emp schEmp, Model model) {
		List<Emp> empList = empService.empList(schEmp);
		model.addAttribute("empList",empList);
		return "emp";
	}
}

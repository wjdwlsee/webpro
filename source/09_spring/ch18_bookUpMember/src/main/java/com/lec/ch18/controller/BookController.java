package com.lec.ch18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch18.service.BookService;
import com.lec.ch18.vo.Book;
@Controller
@RequestMapping(value = "book")
public class BookController {
	@Autowired
	private BookService bookService;
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String register() {
		return "book/register";
	}
	@RequestMapping(value = "register", method=RequestMethod.POST)
	public String register(MultipartHttpServletRequest mRequest, 
			Book book, Model model) {
		model.addAttribute("registerResult", bookService.registerBook(mRequest, book));
		return "redirect:register.do";
	}
}
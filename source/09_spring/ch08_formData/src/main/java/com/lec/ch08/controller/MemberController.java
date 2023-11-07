package com.lec.ch08.controller;

import java.lang.reflect.Member;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.ch08.vo.MemberDto;

@Controller
@RequestMapping("/member")
public class MemberController {
	@ModelAttribute("cnt")
	public int cnt () {
		return 5;
	}
	@ModelAttribute("list")
	public ArrayList<String> list(){
		ArrayList<String>list = new ArrayList<String>();
		list.add("test1"); list.add("test2");
		return list;
	}
	@RequestMapping(value = "join1", method = RequestMethod.POST)
	public String join1(HttpServletRequest request, Model model ) {
		//파라미터들 받아 model 에 add하고 view로
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		model.addAttribute("name",name);
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		model.addAttribute("age",age);
		model.addAttribute("email",email);
		model.addAttribute("address",address);
		return "member/result1";
	}
	@RequestMapping(value = "join2", method = RequestMethod.POST)
	public String join2(@RequestParam("name") String mName,
						@RequestParam("id") String mID,
						@RequestParam("pw") String mPw,
						@RequestParam("age") int mAge,
						@RequestParam("email") String mEmail,
						@RequestParam("address") String mAddress,
						Model model) {
		model.addAttribute("name",mName);
		model.addAttribute("id",mID);
		model.addAttribute("pw",mPw);
		model.addAttribute("age",mAge);
		model.addAttribute("email",mEmail);
		model.addAttribute("address",mAddress);
		return "member/result1";
	}
	@RequestMapping(value = "join3", method = RequestMethod.GET)
	public String join3(String name, String id, String pw, int age, String email, String address, Model model) {
		model.addAttribute("name",name);
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		model.addAttribute("age",age);
		model.addAttribute("email",email);
		model.addAttribute("address",address);
		return "member/result1";
	}
//	@RequestMapping(value = "join4", method = RequestMethod.GET)
//	public String join4(String name, String id, String pw, int age, String email, String address, Model model ) {
//		MemberDto memberDto = new MemberDto();
//		member.setName(name);
//		member.setId(id);
//		member.setPw(pw);
//		member.setAge(age);
//		member.setEmail(email);
//		member.setAddress(address);
//		model.addAttribute("member",member);
//		return "member/result1";
//	}
	@RequestMapping(value = "join4", method = RequestMethod.GET)
	public String join4(MemberDto memberDto, Model model ) { //매개변수 없는 생성자 함수 & setter필요
		model.addAttribute("member",memberDto);
		return "member/result4";
	}
	@RequestMapping(value = "join5", method = RequestMethod.GET)
	public String join5(MemberDto memberDto ) {
		return "member/result5";
	}
	@RequestMapping(value = "join6", method = RequestMethod.GET)
	public String join6(@ModelAttribute("member") MemberDto memberDto) { 
		//파라미터 받아 객체만들어 model에 add(member)
		//model.addAttribute("member",memberDto);
		return "member/result4";
	}
}

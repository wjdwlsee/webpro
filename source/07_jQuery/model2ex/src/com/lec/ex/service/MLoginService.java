package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;

public class MLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.logincheck(mid, mpw);
		if(result == MemberDao.LOGIN_SUCCESS) {
			HttpSession session  = request.getSession();
			MemberDto member = mDao.getMember(mid);
			session.setAttribute("member", member);	
		}else {
			request.setAttribute("loginErrorMsg", "아이디와 비밀번호를 확인하세요");
		}

	}

}

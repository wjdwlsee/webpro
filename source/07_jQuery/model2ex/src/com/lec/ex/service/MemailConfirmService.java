package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;

public class MemailConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String memail = request.getParameter("memial");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.midConfirm(memail);
		if(result == MemberDao.NONEXISTENT) { 
			HttpSession session = request.getSession();
			session.setAttribute("memail", memail);
			request.setAttribute("memailConfirmResult", "사용가능한 emial입니다");
			// 회원가입
		}else { // 가입 불가한 mid
			request.setAttribute("joinErrorMsg", "중복된 email는 회원가입이 불가합니다");
		}

	}

}

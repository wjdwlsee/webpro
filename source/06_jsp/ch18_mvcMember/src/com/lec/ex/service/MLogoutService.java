package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MLogoutService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession sesstion = request.getSession();
		sesstion.invalidate();
		request.setAttribute("logoutMsg", "로그아웃되었습니다"); //alert가능
		
	}
}

package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.MemberDao;

public class MidConformService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.midConfirm(mid);
		if(result == MemberDao.EXISTENT){
			request.setAttribute("confirmResult", "<b>중복된 id입니다</b>");
		}else{
			request.setAttribute("confirmResult", "사용가능한 id입니다");
		
		}


	}

}

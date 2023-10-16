package com.lec.ex.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.Dao;
import com.lec.ex.dto.Dto;

public class MJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int result = Dao.FAIL;
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		String mbirthStr = request.getParameter("mbirth");
		Date mbirth = null;
		if(!mbirthStr.equals("")) {
			mbirth = Date.valueOf(mbirthStr);
		}
		String maddress = request.getParameter("maddress");
		Dao mDao = Dao.getInstance();
		result = mDao.midConfirm(mid);
		if(result == Dao.NONEXISTENT) { 
			Dto newMember = new Dto(mid, mpw, mname, memail, mbirth, maddress, null);
			result = mDao.joinMember(newMember);
			if(result == Dao.SUCCESS) {
				HttpSession session = request.getSession();
				session.setAttribute("mid", mid);
				request.setAttribute("joinResult", "회원가입이 완료되었습니다");				
			}else {
				request.setAttribute("joinErrorMsg", "회원가입 실패");
			}
		
		}else { // 가입 불가한 mid
				request.setAttribute("joinErrorMsg", "중복된 ID는 회원가입이 불가합니다");
		}
	}
}

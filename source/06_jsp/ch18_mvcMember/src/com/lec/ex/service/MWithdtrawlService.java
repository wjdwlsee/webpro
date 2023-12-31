package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;

public class MWithdtrawlService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String mid = null;
		MemberDto sessionMember = (MemberDto) session.getAttribute("member");
		if(sessionMember != null) {
			mid = sessionMember.getMid();
		}
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.withdrawalMember(mid);
		if(result==MemberDao.SUCCESS) {
			request.setAttribute("withdrawalResult", "회우너탈퇴가 완료되었습니다");
			session.invalidate(); //세션 삭제
		}else {
			request.setAttribute("withdrawalResult", "회원 로그인이 되지않앗습니다");
		}
	}

}

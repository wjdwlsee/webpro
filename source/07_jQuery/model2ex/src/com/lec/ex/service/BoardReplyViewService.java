package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;
import com.lec.ex.dto.BoardDto;

public class BoardReplyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fid = Integer.parseInt(request.getParameter("fid"));
		BoardDao boardDao = BoardDao.getInstance();
		BoardDto originBoard = boardDao.ggetBoardNotHitUp(fid);
		request.setAttribute("originBoard", originBoard); // 답변글을 달려는 글의 원글정보
	}

}

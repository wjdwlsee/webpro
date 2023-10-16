package com.lec.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.service.MidConformService;
import com.lec.ex.service.Service;
import com.lec.ex.service.productStockService;

@WebServlet("*.do")
public class FController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
    
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // "/ch18_mvcMember/main.do"
		String conPath = request.getContextPath(); // "/ch18_mvcMember (15글자)
		String command = uri.substring(conPath.length()); // "/main.do" ; 들어온 요청
		String viewPage = null;
		Service service = null;
		if(command.equals("/productStock.do")) {
			service = new productStockService();
			service.execute(request, response);
			viewPage = "2_product/productStock.jsp";
		}else if(command.equals("/midConfirm.do")) {
			service = new MidConformService();
			service.execute(request, response);
			viewPage = "3_member/midConfirm.jsp";
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
				
	}

}

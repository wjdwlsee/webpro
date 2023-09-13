package com.lex.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.scene.chart.PieChart.Data;


@WebServlet("/join")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hiddenPram =request.getParameter("hiddenPram");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String birth = request.getParameter("birth");
		Date birthDate = null;
		if(birth!=null && !birth.equals("")) {
			birthDate = Date.valueOf(birth);
		}
		String hobby = request.getParameter("hobby");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String mailsend = request.getParameter("mailsend");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link href=\"css/join.css\" rel=\"stylesheet\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='joinForm_wrap'>");
		out.println("<div id='join_title'>회원가입정보</div>");
		out.println("<table>");
		if(hiddenPram == null) {
			out.println("<tr><th>hiddenPram:</th><th>"+"XX"+"</th></tr>");
		}	
		out.println("<tr><th>이름:</th><th>"+name+"</th></tr>");
		out.println("<tr><th>아이디:</th><th>"+id+"</th></tr>");
		out.println("<tr><th>비번:</th><th>");
		for(int i=0; i<pw.length(); i++) {
			out.print("*");
		}
		out.println("</th></tr>");
		out.println("<tr><th>생년월일:</th><th>"+birth+"</th></tr>");
		out.println("<tr><th>취미:</th><th>"+hobby+"</th></tr>");
		out.println("<tr><th>성별:</th><th>"+gender+"</th></tr>");
		out.println("<tr><th>메일:</th><th>"+email+"</th></tr>");
		out.println("<tr><th>메일수신동의:</th><th>"+mailsend+"</th></tr>");
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}

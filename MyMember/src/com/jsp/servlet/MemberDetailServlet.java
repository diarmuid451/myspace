package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.MemberVO;
import com.jsp.service.MemberServiceImpl;
import com.jsp.utils.ViewResolver;


@WebServlet("/member/detail")
public class MemberDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면 결정
		String url = "member/detail";	
		//파라미터 처리
		String id = request.getParameter("id");
		//서비스 요청 >> 결과
		MemberVO memberDetail = null;
		try {
			memberDetail = MemberServiceImpl.getInstance().getMember(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
			url = "error/500_error";
			request.setAttribute("exception", e);
			
		}
		
		
		//결과에 따른 화면분할
		request.setAttribute("member", memberDetail);
		// 화면요청
		ViewResolver.view(request, response, url);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

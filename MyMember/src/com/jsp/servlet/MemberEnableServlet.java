package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;
import com.jsp.service.MemberServiceImpl;
import com.jsp.utils.ViewResolver;

/**
 * Servlet implementation class MemberDisableServlet
 */
@WebServlet("/member/enabled")
public class MemberEnableServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/enabled_success";
		
		String id = request.getParameter("id");
	
			try {
				MemberServiceImpl.getInstance().enable(id);
			} catch (SQLException e) {
				url = "member/enabled_fail";
				e.printStackTrace();
			
		}
		
		request.setAttribute("id", id);
		
		ViewResolver.view(request, response, url);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

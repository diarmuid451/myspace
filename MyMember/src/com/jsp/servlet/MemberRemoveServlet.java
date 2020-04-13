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


@WebServlet("/member/remove")
public class MemberRemoveServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/remove_success";
		
		String id = request.getParameter("id");
		
		HttpSession session = request.getSession();
		MemberVO loginUser=(MemberVO)session.getAttribute("loginUser");
		if(id.equals(loginUser.getId())) {
			url = "member/remove_denied";
		} else {
			try {
				MemberServiceImpl.getInstance().remove(id);
			} catch (SQLException e) {
				url = "member/remove_fail";
				e.printStackTrace();
			}
		}
		
		ViewResolver.view(request, response, url);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

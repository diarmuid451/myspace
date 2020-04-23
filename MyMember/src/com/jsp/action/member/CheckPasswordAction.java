package com.jsp.action.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.request.SearchCriteria;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;
import com.jsp.utils.GetUploadPath;

public class CheckPasswordAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String url = null;
		
		String result = null;
	
		String checkPwd = request.getParameter("pwd");

		HttpSession session = request.getSession();
	
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
	
		if(checkPwd.equals(loginUser.getPwd())) {
			result = "SUCCESS";
		}
		
		response.getWriter().print(result);
		
		return url;
	}
	
}

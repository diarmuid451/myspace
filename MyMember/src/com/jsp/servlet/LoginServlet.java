package com.jsp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/common/loginForm.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = MemberServiceImpl.getInstance();
		
		
		String url = "/WEB-INF/views/common/login_success.jsp";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPwd(pwd);
		// 로그인 처리부분
		
		//로그인 실패
		MemberVO memVO = service.login(vo);
		if(memVO == null) {
			request.setAttribute("id", id);
			url = "/WEB-INF/views/common/loginForm.jsp";
		} else {
			
		
		//로그인 성공
		
		System.out.println(memVO.getId());
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", memVO);
		
		
		}
		request.getRequestDispatcher(url).forward(request, response);		
	}

}

package com.jsp.action.member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.request.MemberRegistRequest;
import com.jsp.request.SearchCriteria;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

public class MemberRegistAction implements Action {
	
	private MemberService memberService;	// = MemberServiceImpl.getInstance();
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = "member/regist_success";
		
		String id = request.getParameter("id");
		String pwd= request.getParameter("pwd");
		String email = request.getParameter("email");
		String picture = request.getParameter("picture");
		String authority = request.getParameter("authority");
		String[] phone = request.getParameterValues("phone");
		String name = request.getParameter("name");
		
		MemberRegistRequest memberReq = new MemberRegistRequest(id, pwd, authority,email, phone, picture, name);
		
		MemberVO member = memberReq.toMemberVO();
		
		try {
			memberService.regist(member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			url = "member/regist_fail";
		} 
		
		
		return url;
	}

}

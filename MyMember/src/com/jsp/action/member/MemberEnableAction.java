package com.jsp.action.member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.request.SearchCriteria;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

public class MemberEnableAction implements Action {
	
	private MemberService memberService;	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "member/enabled_success";
		
		String id = request.getParameter("id");
	
			try {
				memberService.enable(id);
			} catch (SQLException e) {
				url = "member/enabled_fail";
				e.printStackTrace();
			
		}
		
		request.setAttribute("id", id);
		
		
		return url;
	}

}

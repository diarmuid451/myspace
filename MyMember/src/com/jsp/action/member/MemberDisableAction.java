package com.jsp.action.member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.request.SearchCriteria;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

public class MemberDisableAction implements Action {
	
	private MemberService memberService;	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "member/disabled_success";
		
		String id = request.getParameter("id");
		
		HttpSession session = request.getSession();
		MemberVO loginUser=(MemberVO)session.getAttribute("loginUser");
		if(id.equals(loginUser.getId())) {
			url = "member/disabled_denied";
		} else {
			try {
				memberService.disable(id);
			} catch (SQLException e) {
				url = "member/disabled_fail";
				e.printStackTrace();
			}
		}
		
		request.setAttribute("id", id);
		
		return url;
	}

}

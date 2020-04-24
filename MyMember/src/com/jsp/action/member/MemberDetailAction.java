package com.jsp.action.member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.request.SearchCriteria;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

public class MemberDetailAction implements Action {
	
	private MemberService memberService;	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "member/detail";	
		//파라미터 처리
		String id = request.getParameter("id");
		//서비스 요청 >> 결과
		MemberVO member = null;
		try {
			member = memberService.getMember(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
			url = "error/500_error";
			request.setAttribute("exception", e);
			
		}
		
		
		//결과에 따른 화면분할
		request.setAttribute("member", member);
		
		return url;
	}

}

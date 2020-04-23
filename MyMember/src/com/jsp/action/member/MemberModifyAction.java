package com.jsp.action.member;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.request.MemberModifyRequest;
import com.jsp.service.BoardService;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;
import com.jsp.utils.GetUploadPath;

public class MemberModifyAction implements Action {
	
	private MemberService memberService;	// = MemberServiceImpl.getInstance();
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "member/modify_success";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String authority = request.getParameter("authority");
		String email = request.getParameter("email");
		String picture = request.getParameter("picture");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		phone = phone.replace("-", "");
		
		MemberModifyRequest memberMod = new MemberModifyRequest(id,pwd,authority,email,phone,picture,name);
		
		MemberVO member = memberMod.toMemberVO();
		
		try {
			memberService.modify(member);
			HttpSession session = request.getSession();
			MemberVO loginUser=(MemberVO)session.getAttribute("loginUser");
			if(member.getId().equals(loginUser.getId())) {
				session.setAttribute("loginUser", member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			url = "member/modify_fail";
			String oldFileName = member.getPicture();
			String uploadPath=GetUploadPath.getUploadPath("member.picture.upload");
			File oldFile=new File(uploadPath+File.separator+oldFileName);
			if(oldFile.exists()) {
				oldFile.delete();
			}
		}
		
		request.setAttribute("id", id);
		
		return url;
	}

}

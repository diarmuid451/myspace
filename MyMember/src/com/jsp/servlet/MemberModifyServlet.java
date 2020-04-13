package com.jsp.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;
import com.jsp.request.MemberModifyRequest;
import com.jsp.service.MemberServiceImpl;
import com.jsp.utils.GetUploadPath;
import com.jsp.utils.ViewResolver;


@WebServlet("/member/modify")
public class MemberModifyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/modify";
		
		String id = request.getParameter("id");
		
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
		String url = "member/modify_success";
		
		String id = request.getParameter("id");
		System.out.println(id);
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
			MemberServiceImpl.getInstance().modify(member);
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
		
		ViewResolver.view(request, response, url);
	}

}

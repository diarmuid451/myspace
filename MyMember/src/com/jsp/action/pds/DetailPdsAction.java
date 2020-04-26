package com.jsp.action.pds;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dto.BoardVO;
import com.jsp.dto.MemberVO;
import com.jsp.dto.PdsVO;
import com.jsp.service.BoardService;
import com.jsp.service.PdsService;

public class DetailPdsAction implements Action {
	
	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String url = "pds/detail";
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		try {
			
			PdsVO pdsVO = pdsService.getPds(pno);
			
			
			if(!(pdsVO.getWriter().equals(loginUser.getId()))) {
				pdsService.read(pno);	
				pdsVO = pdsService.getPds(pno);
			}
			
			request.setAttribute("pds", pdsVO);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "error/500_error";
		}
		
		return url;
	}

}

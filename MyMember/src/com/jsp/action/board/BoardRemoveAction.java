package com.jsp.action.board;

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
import com.jsp.service.BoardService;
import com.jsp.service.BoardServiceImpl;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

public class BoardRemoveAction implements Action {
	
	private BoardService boardService; 
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "board/remove_success";
		
		String no = request.getParameter("bno");
		int bno = Integer.parseInt(no);
		
		
		try {
			boardService.remove(bno);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "board/remove_fail";
		}
		
		
		return url;
	}

}

package com.jsp.action.board;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.BoardVO;
import com.jsp.request.BoardRegistRequest;
import com.jsp.service.BoardService;
import com.jsp.service.BoardServiceImpl;

public class BoardRegistAction implements Action {
	
	private BoardService boardService;	// = BoardServiceImpl.getInstance();
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = "board/regist_success";
		
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		try {
			
			int bno = boardService.seqNextVal();
			BoardRegistRequest boardReg = new BoardRegistRequest(bno, title, writer, content);
			
			BoardVO board = boardReg.toBoardVO();
			boardService.write(board);
			request.setAttribute("board", board);
		} catch (SQLException e) {
			
			e.printStackTrace();
			url = "board/regist_fail";
		} 
		
		
		return url;
	}

}

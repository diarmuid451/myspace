package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jsp.dao.BoardDAO;
import com.jsp.dao.ReplyDAO;
import com.jsp.dto.BoardVO;
import com.jsp.request.PageMaker;
import com.jsp.request.SearchCriteria;

public class BoardServiceImpl implements BoardService {
	
	private BoardDAO boardDAO;
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	private ReplyDAO replyDAO;
	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}
	
	@Override
	public Map<String, Object> getBoardList(SearchCriteria cri) throws SQLException {
		List<BoardVO> boardList = boardDAO.selectBoardCriteria(cri);
		
		for (BoardVO boardVO : boardList) {
			int cnt = replyDAO.countReply(boardVO.getBno());
			boardVO.setReplycnt(cnt);
		}
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardDAO.selectBoardCriteriaTotalCount(cri));
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("boardList", boardList);
		dataMap.put("pageMaker", pageMaker);
		return dataMap;
	}

	@Override
	public BoardVO getBoard(int bno) throws SQLException {
		BoardVO board = boardDAO.selectBoardByBno(bno);
		int cnt = replyDAO.countReply(bno);
		board.setReplycnt(cnt);
		return board;
	}

	@Override
	public BoardVO getBoardForModify(int bno) throws SQLException {
		BoardVO board = boardDAO.selectBoardByBno(bno);
		return board;
	}

	@Override
	public void write(BoardVO board) throws SQLException {
		boardDAO.insertBoard(board);
	}

	@Override
	public void modify(BoardVO board) throws SQLException {
		boardDAO.updateBoard(board);
	}

	@Override
	public void remove(int bno) throws SQLException {
		boardDAO.deleteBoard(bno);
	}
	@Override
	public void viewCnt(int bno) throws SQLException {
		boardDAO.increaseViewCnt(bno);
		
	}
	@Override
	public int seqNextVal() throws SQLException {
		int seq = boardDAO.selectBoardSeqNext();
		return seq;
	}
	
	

}

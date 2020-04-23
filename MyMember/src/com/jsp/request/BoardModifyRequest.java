package com.jsp.request;

import com.jsp.dto.BoardVO;

public class BoardModifyRequest {
	
	private int bno;
	private String title;
	private String content;
	
	public int getBno() {
		return bno;
	}



	public void setBno(int bno) {
		this.bno = bno;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public BoardModifyRequest() {}


	public BoardModifyRequest(int bno, String title, String content) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		
	}

	

	@Override
	public String toString() {
		return "BoardModifyRequest [bno=" + bno + ", title=" + title + ", content=" + content + "]";
	}



	public BoardVO toBoardVO() {
		BoardVO board = new BoardVO();
		board.setBno(bno);
		board.setTitle(title);
		board.setContent(content);
		return board;
	}
}

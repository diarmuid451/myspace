package com.jsp.request;


import com.jsp.dto.BoardVO;

public class BoardRegistRequest {
	
	private int bno;
	private String title;
	private String writer;
	private String content;
	
	public BoardRegistRequest() {}

	public BoardRegistRequest(int bno, String title, String writer, String content) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	@Override
	public String toString() {
		return "BoardRegistRequest [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ "]";
	}
	
	public BoardVO toBoardVO() {
		BoardVO board = new BoardVO();
		board.setBno(bno);
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		return board;
	}
}

package com.jsp.request;


import com.jsp.dto.PdsVO;

public class PdsRegistRequest {
	
	private String title;
	private String writer;
	private String content;
	
	
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public PdsRegistRequest() {}

	public PdsRegistRequest(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	@Override
	public String toString() {
		return "BoardRegistRequest [title=" + title + ", writer=" + writer + ", content=" + content
				+ "]";
	}
	
	public PdsVO toPdsVO() {
		PdsVO pds = new PdsVO();
		pds.setTitle(title);
		pds.setWriter(writer);
		pds.setContent(content);
		return pds;
	}
}

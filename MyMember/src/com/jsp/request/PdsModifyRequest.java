package com.jsp.request;

import com.jsp.dto.PdsVO;

public class PdsModifyRequest {
	
	private int pno;
	private String title;
	private String content;
	
	public int getPno() {
		return pno;
	}



	public void setPno(int pno) {
		this.pno = pno;
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



	public PdsModifyRequest() {}


	public PdsModifyRequest(int pno, String title, String content) {
		this.pno = pno;
		this.title = title;
		this.content = content;
		
	}

	

	@Override
	public String toString() {
		return "BoardModifyRequest [pno=" + pno + ", title=" + title + ", content=" + content + "]";
	}



	public PdsVO toPdsVO() {
		PdsVO pds = new PdsVO();
		pds.setPno(pno);
		pds.setTitle(title);
		pds.setContent(content);
		return pds;
	}
}

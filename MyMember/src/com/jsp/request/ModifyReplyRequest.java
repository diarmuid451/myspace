package com.jsp.request;

import java.util.Date;

import com.jsp.dto.ReplyVO;

/**
 * @author PC-01
 *
 */
public class ModifyReplyRequest {
	
	private int rno;
	private String replytext;
	
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public ModifyReplyRequest(int rno, String replytext) {
		super();
		this.rno = rno;
		this.replytext = replytext;
	}
	
	public ModifyReplyRequest() {
		
	}
	
	@Override
	public String toString() {
		return "ModifyReplyRequest [rno=" + rno + ", replytext=" + replytext + "]";
	}
	
	public ReplyVO toReplyVO() {
		ReplyVO reply = new ReplyVO();
		reply.setRno(rno);
		reply.setReplytext(replytext);
		reply.setUpdatedate(new Date());
		return reply;
	}
	
}

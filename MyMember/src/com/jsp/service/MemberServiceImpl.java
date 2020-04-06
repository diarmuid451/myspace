package com.jsp.service;

import com.jsp.dao.MemberDao;
import com.jsp.dao.MemberDaoImpl;
import com.jsp.dto.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	private static MemberService service;
	private MemberDao dao;
	
	public static MemberService getInstance() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}

	@Override
	public MemberVO login(MemberVO vo) {
		
		return dao.login(vo);
	}
	
	

}

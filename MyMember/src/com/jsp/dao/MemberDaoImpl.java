package com.jsp.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.jsp.dto.MemberVO;
import com.ibatis.config.SqlMapClientFactory;

public class MemberDaoImpl implements MemberDao {
	
	private SqlMapClient client;
	private static MemberDao dao;
	
	private MemberDaoImpl() {
		client = SqlMapClientFactory.getSMClient();
	}
	
	public static MemberDao getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		
		return dao;
	}

	@Override
	public MemberVO login(MemberVO vo) {
		MemberVO mem = new MemberVO();
		try {
			mem = (MemberVO) client.queryForObject("member.login", vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mem;
	}

}

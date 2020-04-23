package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dto.MemberVO;
import com.jsp.request.SearchCriteria;


public class MemberDAOImpl implements MemberDAO {
	
	/*private static MemberDAOImpl instance = new MemberDAOImpl();
	private MemberDAOImpl() {}
	public static MemberDAOImpl getInstance() {
		return instance;
	}*/
	
	
	
	//SqlSessionFactory
	private SqlSessionFactory sessionFactory;
	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
//	= OracleMyBatisSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	
	@Override
	public List<MemberVO> selectMemberList() throws SQLException {
	SqlSession session = sessionFactory.openSession();
	List<MemberVO> memberList = session.selectList("Member-Mapper.selectMemberList",null);
	session.close();
		return memberList;
	}

	@Override
	public int selectMemberListCount() throws SQLException {
		int count = 0;
		SqlSession session = sessionFactory.openSession();
		count = session.selectOne("Member-Mapper.selectMemberListCount",null);
		
		session.close();
		return count;
	}
	
	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		SqlSession session = sessionFactory.openSession();
		MemberVO member = session.selectOne("Member-Mapper.selectMemberById", id);
		session.close();
		return member;
	}

	@Override
	public void insertMember(MemberVO member) throws SQLException {
		SqlSession session = sessionFactory.openSession(true);
		session.update("Member-Mapper.insertMember",member);
		session.close();
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		SqlSession session = sessionFactory.openSession(true);
		session.update("Member-Mapper.updateMember",member);
		session.close();
	}

	@Override
	public void deleteMember(String id) throws SQLException {
		SqlSession session = sessionFactory.openSession(true);
		session.update("Member-Mapper.deleteMember",id);
		session.close();
	}
	@Override
	public void enabledMember(String id) throws SQLException {
		SqlSession session = sessionFactory.openSession(true);
		session.update("Member-Mapper.enabledMember",id);
		session.close();
		
	}
	@Override
	public void disabledMember(String id) throws SQLException {
		SqlSession session = sessionFactory.openSession(true);
		session.update("Member-Mapper.disabledMember",id);
		session.close();
		
	}

	@Override
	public List<MemberVO> selectMemberList(SearchCriteria cri) throws SQLException {
		SqlSession session = sessionFactory.openSession();
		
		//데이터양이 많을경우 처음부터 선별해서 데이터를 제공
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<MemberVO> memberList = null;
		
		memberList = session.selectList("Member-Mapper.selectSearchMemberList",cri,rowBounds);
		session.close();
		
			return memberList;
	}

	@Override
	public int selectMemberListCount(SearchCriteria cri) throws SQLException {
		int count=0;
		SqlSession session = sessionFactory.openSession();
		count = session.selectOne("Member-Mapper.selectSearchMemberListCount",cri);
		
		session.close();
		
		return count;
	}

}

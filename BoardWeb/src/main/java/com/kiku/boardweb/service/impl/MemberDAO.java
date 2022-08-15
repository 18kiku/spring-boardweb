package com.kiku.boardweb.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kiku.boardweb.service.MemberDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public MemberDTO login(MemberDTO dto) {
		System.out.println("===> MemberDAO login");
		return sqlSession.selectOne("MemberDAO.login", dto);
	}
	
	public void join(MemberDTO dto) {
		System.out.println("===> MemberDAO join");
		sqlSession.insert("MemberDAO.insert", dto);
	}
	
	public void update(MemberDTO dto) {
		System.out.println("===> MemberDAO update");
		sqlSession.update("MemberDAO.update", dto);
	}
	
	public void delete(MemberDTO dto) {
		System.out.println("===> MemberDAO delete");
		sqlSession.delete("MemberDAO.delete", dto);
	}
	
	public MemberDTO getMember(MemberDTO dto) {
		System.out.println("===> MemberDAO getMember");
		return sqlSession.selectOne("MemberDAO.getMember", dto);
	}
	
	public List<MemberDTO> getMemberList(MemberDTO dto) {
		System.out.println("===> MemberDAO getMemberList");
		return sqlSession.selectList("MemberDAO.getMemberList", dto);
	}
}

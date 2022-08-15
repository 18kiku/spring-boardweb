package com.kiku.boardweb.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kiku.boardweb.service.CommentDTO;

@Repository
public class CommentDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public void insert(CommentDTO dto) {
		System.out.println("===> CommentDAO insert");
		sqlSession.insert("CommentDAO.insert", dto);
	}

	public void update(CommentDTO dto) {
		System.out.println("===> CommentDAO update");
		sqlSession.update("CommentDAO.update", dto);
	}

	public void delete(CommentDTO dto) {
		System.out.println("===> CommentDAO delete");
		System.out.println(dto);
		sqlSession.delete("CommentDAO.delete", dto);
	}

	public CommentDTO getComment(CommentDTO dto) {
		System.out.println("===> CommentDAO getComment");
		return sqlSession.selectOne("CommentDAO.getComment", dto);
	}

	public List<CommentDTO> getCommentList(CommentDTO dto) {
		System.out.println("===> CommentDAO getCommentList");
		return sqlSession.selectList("CommentDAO.getCommentList", dto);
	}

}

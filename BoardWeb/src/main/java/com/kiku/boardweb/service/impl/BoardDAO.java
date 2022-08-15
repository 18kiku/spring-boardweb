package com.kiku.boardweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kiku.boardweb.service.BlockDTO;
import com.kiku.boardweb.service.BoardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(BoardDTO dto) {
		System.out.println("===> BoardDAO insert");
		sqlSession.insert("BoardDAO.insert", dto);
	}
	
	public void update(BoardDTO dto) {
		System.out.println("===> BoardDAO update");
		sqlSession.update("BoardDAO.update", dto);
	}
	
	public void delete(BoardDTO dto) {
		System.out.println("===> BoardDAO delete");
		sqlSession.delete("BoardDAO.delete", dto);
	}
	
	public void deleteById(BoardDTO dto) {
		System.out.println("===> BoardDAO deleteById");
		sqlSession.delete("BoardDAO.deleteById", dto);
	}
	
	public BoardDTO getBoard(BoardDTO dto) {
		System.out.println("===> BoardDAO getBoard");
		return sqlSession.selectOne("BoardDAO.getBoard", dto);
	}
	
	public List<BoardDTO> getBoardList(BoardDTO dto, BlockDTO block) {
		System.out.println("===> BoardDAO getBoardList");
		
		Map<String, Object> pagingMap = new HashMap<String, Object>();
		pagingMap.put("board", dto);
		System.out.println(block);
		pagingMap.put("block", block);
		
		return sqlSession.selectList("BoardDAO.getBoardListPaging", pagingMap);
	}
	
	public int getBoardListCount(BoardDTO dto) {
		System.out.println("===> BoardDAO getBoardListCount");
		return sqlSession.selectOne("BoardDAO.getBoardListCount", dto);
	}
	
	public void updateCnt(BoardDTO dto) {
		System.out.println("===> BoardDAO updateCnt");
		sqlSession.update("BoardDAO.updateCnt", dto);
	}
}

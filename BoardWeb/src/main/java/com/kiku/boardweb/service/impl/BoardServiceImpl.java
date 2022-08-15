package com.kiku.boardweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kiku.boardweb.service.BlockDTO;
import com.kiku.boardweb.service.BoardDTO;
import com.kiku.boardweb.service.BoardService;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public void insert(BoardDTO dto) {
		System.out.println("==> BoardServiceImpl insert");
		boardDAO.insert(dto);
	}

	@Override
	public void update(BoardDTO dto) {
		System.out.println("==> BoardServiceImpl update");
		boardDAO.update(dto);
	}

	@Override
	public void delete(BoardDTO dto) {
		System.out.println("==> BoardServiceImpl delete");
		boardDAO.delete(dto);
	}
	
	@Override
	public void deleteById(BoardDTO dto) {
		System.out.println("==> BoardServiceImpl deleteById");
		boardDAO.deleteById(dto);
	}
	
	@Transactional(readOnly = true)
	@Override
	public BoardDTO getBoard(BoardDTO dto) {
		System.out.println("==> BoardServiceImpl getBoard");
		boardDAO.updateCnt(dto);
		return boardDAO.getBoard(dto);
	}

	@Transactional(readOnly = true)
	@Override
	public List<BoardDTO> getBoardList(BoardDTO dto, BlockDTO block) {
		System.out.println("==> BoardServiceImpl getBoardList");
		return boardDAO.getBoardList(dto, block);
	}

	@Override
	public int getBoardListCount(BoardDTO dto) {
		System.out.println("==> BoardServiceImpl getBoardListCount");
		return boardDAO.getBoardListCount(dto);
	}
}

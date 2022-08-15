package com.kiku.boardweb.service;

import java.util.List;

public interface BoardService {
	void insert(BoardDTO dto);
	void update(BoardDTO dto);
	void delete(BoardDTO dto);
	void deleteById(BoardDTO dto);
	BoardDTO getBoard(BoardDTO dto);
	List<BoardDTO> getBoardList(BoardDTO dto, BlockDTO block);
	int getBoardListCount(BoardDTO dto);
}

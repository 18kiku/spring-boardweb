package com.kiku.boardweb.service;

import java.util.List;

public interface CommentService {
	void insert(CommentDTO dto);
	void update(CommentDTO dto);
	void delete(CommentDTO dto);
	CommentDTO getComment(CommentDTO dto);
	List<CommentDTO> getCommentList(CommentDTO dto);
}

package com.kiku.boardweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kiku.boardweb.service.CommentDTO;
import com.kiku.boardweb.service.CommentService;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDAO commentDAO;
	
	@Override
	public void insert(CommentDTO dto) {
		System.out.println("==> CommentServiceImpl insert");
		commentDAO.insert(dto);
	}

	@Override
	public void update(CommentDTO dto) {
		System.out.println("==> CommentServiceImpl update");
		commentDAO.update(dto);
	}

	@Override
	public void delete(CommentDTO dto) {
		System.out.println("==> CommentServiceImpl delete");
		commentDAO.delete(dto);
	}

	@Override
	public CommentDTO getComment(CommentDTO dto) {
		System.out.println("==> CommentServiceImpl getComment");
		return commentDAO.getComment(dto);
	}

	@Override
	public List<CommentDTO> getCommentList(CommentDTO dto) {
		System.out.println("==> CommentServiceImpl getCommentList");
		return commentDAO.getCommentList(dto);
	}

}

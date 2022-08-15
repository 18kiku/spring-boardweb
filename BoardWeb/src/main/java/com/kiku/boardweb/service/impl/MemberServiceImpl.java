package com.kiku.boardweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kiku.boardweb.service.BoardDTO;
import com.kiku.boardweb.service.MemberDTO;
import com.kiku.boardweb.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Transactional(readOnly = true)
	@Override
	public MemberDTO login(MemberDTO dto) {
		System.out.println("==> MemberServiceImpl login");
		return memberDAO.login(dto);
	}
	
	@Override
	public void join(MemberDTO dto) {
		System.out.println("==> MemberServiceImpl join");
		memberDAO.join(dto);
	}

	@Override
	public void update(MemberDTO dto) {
		System.out.println("==> MemberServiceImpl update");
		memberDAO.update(dto);
	}

	@Override
	public void delete(MemberDTO dto) {
		System.out.println("==> MemberServiceImpl delete");
		
		BoardDTO board = new BoardDTO();
		board.setWriter(dto.getId());
		boardDAO.deleteById(board);
		memberDAO.delete(dto);
	}

	@Transactional(readOnly = true)
	@Override
	public MemberDTO getMember(MemberDTO dto) {
		System.out.println("==> MemberServiceImpl getMember");
		return memberDAO.getMember(dto);
	}

	@Transactional(readOnly = true)
	@Override
	public List<MemberDTO> getMemberList(MemberDTO dto) {
		System.out.println("==> MemberServiceImpl getMemberList");
		return memberDAO.getMemberList(dto);
	}
	
	

}

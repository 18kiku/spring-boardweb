package com.kiku.boardweb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kiku.boardweb.service.BlockDTO;
import com.kiku.boardweb.service.BoardDTO;
import com.kiku.boardweb.service.BoardService;
import com.kiku.boardweb.service.CommentDTO;
import com.kiku.boardweb.service.CommentService;
import com.kiku.boardweb.service.MemberDTO;
import com.kiku.boardweb.service.PageDTO;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/list")
	public String getBoardList(BoardDTO dto, BlockDTO block, Model model) {
		System.out.println("=> BoardController - list");
		
		// 검색 확인 - searchCondition, searchKeyword가 null일때의 처리
		if(dto.getSearchCondition() == null) dto.setSearchCondition("TITLE");
		if(dto.getSearchKeyword() == null) dto.setSearchKeyword("");
		
		int totalCount = boardService.getBoardListCount(dto);
		
		model.addAttribute("boardList", boardService.getBoardList(dto, block));
		model.addAttribute("pageDTO", new PageDTO(block, totalCount));
		return "board/boardList";
	}

	// 검색 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		System.out.println("=> BoardController - conditionMap");
		
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("TITLE", "TITLE");
		conditionMap.put("WRITER", "WRITER");
		conditionMap.put("CONTENT", "CONTENT");
		
		return conditionMap;
	}
	
	@RequestMapping(value = "/board")
	public String getBoard(BoardDTO board, Model model) {
		System.out.println("=> BoardController - board");
		
		CommentDTO comment = new CommentDTO();
		comment.setBoardId(board.getId());
		model.addAttribute("board", boardService.getBoard(board));
		model.addAttribute("commentList", commentService.getCommentList(comment));
		return "board/board";
	}
	
	@GetMapping(value = "/insert")
	public String insert() {
		System.out.println("=> BoardController - insert(get)");
		return "board/boardInsert";
	}
	
	@PostMapping(value = "/insert")
	public String insert(BoardDTO dto) {
		System.out.println("=> BoardController - insert(post)");
		boardService.insert(dto);
		return "redirect:list";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam("pageNum") int pageNum, BoardDTO dto) {
		System.out.println("=> BoardController - delete");
		boardService.delete(dto);
		return "redirect:list?pageNum=" + pageNum;
	}
	
	@RequestMapping(value = "/update")
	public String update(BoardDTO dto, @RequestParam("pageNum") int pageNum) {
		System.out.println("=> BoardController - update");
		boardService.update(dto);
		return "redirect:list?pageNum=" + pageNum;
	}
	
	@RequestMapping(value = "/insertComment")
	public String insertComment(@RequestParam("pageNum") int pageNum, BoardDTO board, CommentDTO comment, HttpSession session) {
		System.out.println("=> BoardController - insertComment");
		
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		comment.setWriter(member.getId());
		comment.setBoardId(board.getId());
		commentService.insert(comment);
		
		return "redirect:board?id=" + board.getId() + "&pageNum=" + pageNum;
	}
	
	@RequestMapping(value = "/updateComment")
	public String updateComment(@RequestParam("pageNum") int pageNum, BoardDTO board, CommentDTO comment) {
		System.out.println("=> BoardController - updateComment");
		commentService.update(comment);
		return "redirect:board?id=" + board.getId() + "&pageNum=" + pageNum;
	}
	
	@RequestMapping(value = "/deleteComment")
	public String deleteComment(@RequestParam("pageNum") int pageNum, @RequestParam("commentId") int commentId, BoardDTO board, CommentDTO comment) {
		System.out.println("=> BoardController - deleteComment");
		comment.setId(commentId);
		commentService.delete(comment);
		return "redirect:board?id=" + board.getId() + "&pageNum=" + pageNum;
	}
}

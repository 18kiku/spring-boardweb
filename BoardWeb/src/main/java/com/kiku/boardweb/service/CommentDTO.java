package com.kiku.boardweb.service;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CommentDTO {
	
	private int id;
	private int boardId;
	private String writer;
	private String comment;
	
	private Timestamp createDate;
	private Timestamp updateDate;
}

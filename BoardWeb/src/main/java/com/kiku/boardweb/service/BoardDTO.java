package com.kiku.boardweb.service;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardDTO {
	
	private int id;
	private String writer;
	private String title;
	private String content;
	private String cnt;
	
	private Timestamp createDate;
	private Timestamp updateDate;
	
	private String searchCondition;
	private String searchKeyword;
}

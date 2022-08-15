package com.kiku.boardweb.service;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberDTO {
	
	private String id;
	private String password;
	private String name;
	private String email;
	
	private Timestamp createDate;
	private Timestamp updateDate;
}

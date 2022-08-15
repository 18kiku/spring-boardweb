package com.kiku.boardweb.service;

import lombok.Data;

@Data
public class BlockDTO {
	private int pageNum;
	private int amount;
	
	public BlockDTO() {
		this(1, 10);
	}
	
	public BlockDTO(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
}

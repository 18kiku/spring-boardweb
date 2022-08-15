package com.kiku.boardweb.service;

import lombok.Data;

@Data
public class PageDTO {
	private int startPage;
	private int endPage;
	private int lastPage;
	private boolean first, prev, next, last;
	private int total;
	private BlockDTO block;
	private int pages = 5;
	
	public PageDTO(BlockDTO block, int total) {
		this.block = block;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(block.getPageNum() / (double)pages)) * pages;
		this.startPage = this.endPage - (pages - 1);
		
		this.lastPage = (int)(Math.ceil((double)total / block.getAmount()));
		if(this.lastPage < this.endPage) this.endPage = this.lastPage;
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < lastPage;
		
		
	}
}

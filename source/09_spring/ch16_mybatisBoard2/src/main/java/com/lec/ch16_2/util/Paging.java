package com.lec.ch16_2.util;

import lombok.Data;

@Data
public class Paging {
	private int currentPage = 1;
	private int pageSize;
	private int blockSize;
	private int startRow;
	private int endRow;
	private int totCnt;
	private int pageCnt;
	private int startPage;
	private int endPage;
	public Paging(int totCnt, String pageNum, int pageSize, int blockSize) {
		this.totCnt = totCnt;
		if(pageNum!=null) {
			currentPage = Integer.parseInt(pageNum);
		}
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		startRow = (currentPage-1) * pageSize + 1;
		endRow   = startRow + pageSize -1;
		pageCnt = (int) Math.ceil( (double)totCnt / pageSize);
		startPage = ( (currentPage-1) / blockSize) * blockSize + 1;
		startPage = currentPage - (currentPage-1) % blockSize;
		endPage = startPage + blockSize - 1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
}
	public Paging(int totCnt, String pageNum) {
		this.totCnt = totCnt;
		if(pageNum!=null) {
			currentPage = Integer.parseInt(pageNum);
		}
		pageSize = 10; // 페이지 사이즈를 주어지지 않을 경우 기본값
		blockSize = 10; // 블럭사이즈가 주어지지 않았을 경우의 기본값
		startRow = (currentPage-1) * pageSize + 1;
		endRow   = startRow + pageSize -1;
		pageCnt = (int) Math.ceil( (double)totCnt / pageSize);
		startPage = ( (currentPage-1) / blockSize) * blockSize + 1;
		startPage = currentPage - (currentPage-1) % blockSize;
		endPage = startPage + blockSize - 1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		
	}
}


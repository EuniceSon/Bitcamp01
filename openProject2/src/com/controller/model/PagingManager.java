package com.controller.model;

import java.util.List;

public class PagingManager {

	private int recordTotalCount;   //총 게시글 수 
	private int currentPage;        // 현재 페이지 
	private List recordList; 		// 페이징 처리 할 데이터 리스트
	private int pageTotalCount;		// 총페이지수 총게시글 수를  페이지당 담길 게시글로 나눔 
	private int recordCountPerPage; //한 페이지당 담길 게시글
	private int pageDivision; 		// 페이지를  묶는 단위 
	private int firstRow;			// 보여질 페이지 의 레코드 시작 번호
	private int endRow;				// 보여질 페이지 의 레코드 끝 번호
	private int startBlock;
	private int endBlock;
	

	public PagingManager( List recordList, int currentPageNumber,
			int recordCountPerPage ,int pageDivision) {
		
		this.recordList = recordList;
		this.recordTotalCount = recordList.size();
		this.currentPage = currentPageNumber;
		this.recordCountPerPage = recordCountPerPage;
		this.firstRow = (currentPage*recordCountPerPage)-(recordCountPerPage-1);
		this.endRow = (currentPage * recordCountPerPage);
		calculatePageTotalCount();
		// 해당 페이지 블럭을 보여주기 위한 시작블럭
		this.startBlock= (((currentPage-1)/pageDivision)*pageDivision)+1;
		// 해당 페이지 블럭을 보여주기 위한 끝블럭
		this.endBlock= (((currentPage-1)/pageDivision)*pageDivision)+pageDivision;
		if(endBlock>pageTotalCount) {
			endBlock=pageTotalCount;
		}
		
	}

	private void calculatePageTotalCount() {  //총 페이지 갯수 알려줌 
		if (recordTotalCount == 0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
			if (recordTotalCount % recordCountPerPage > 0) {
				pageTotalCount++;
			}
		}
		if(endBlock>pageTotalCount) {
			endBlock=pageTotalCount;
		}
	}
	

	
	public int getRecordTotalCount() { return recordTotalCount; }
	public int getCurrentPage() { return currentPage; }
	public List getRecordList() { return recordList; }
	public int getPageTotalCount() { return pageTotalCount; }
	public int getRecordCountPerPage() { return recordCountPerPage; }
	public int getFirstRow() { return firstRow; }
	public int getEndRow() { return endRow; }
	public int getStarBlock() {return startBlock;}
	public int getEndBlock() {return endBlock;}
	public boolean isEmpty() { return recordTotalCount == 0; }
	

}

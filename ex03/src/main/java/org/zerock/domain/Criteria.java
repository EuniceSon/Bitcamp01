package org.zerock.domain;

public class Criteria {
	private int page; 		//현재 페이지 
	private int perPageNum;  //페이지당 몇개 보여 줄 건지 
	private int startPage;
	
	public Criteria() {
		this.page=1;
		this.perPageNum=10;
	}
	
	 public void setPage(int page) {
		 if(page<=0) { //페이지는 0보다 같거나 작을 수 없고 기본으로 1페이지 설정 
			 this.page=1;
			 return ;
		 }
		 this.page = page;
	 }
	 
	 public void setPerPageNum(int perPageNum) {
		 if(perPageNum <=0||perPageNum>100) {
			 this.perPageNum=10;
			 return;
		 }
		 this.perPageNum=perPageNum;
	 }
	 
	 public int getPage() {
		 return page;
	 }
	 
	 //Method for MyBatis SQL Mapper
	 public int getPageStart() {  //페이지의 시작번호 (블럭에서)
		 this.startPage=(this.page-1)*perPageNum;
		 return startPage;
	 }
	 
	 //Method for My Batis SQL Mapper
	 public int getPerPageNum() {
		 return this.perPageNum;
	 }
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	 
	 

}

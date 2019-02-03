package org.zerock.domain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	private int totalCount ;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int displayPageNum=10;
	private Criteria cri;
	
	public void setCri(Criteria cri) {
		this.cri=cri;
		
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount=totalCount;
		calcDate();
	}
	
	private void calcDate() {
		endPage=(int)(Math.ceil(cri.getPage()/
				(double)displayPageNum)*displayPageNum
				);
		
		startPage=(endPage-displayPageNum)+1;
		
		int tempEndPage =(int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		
		if(endPage>tempEndPage) {
			endPage=tempEndPage;
		}
		
		prev=startPage==1?false:true;
		
		next=endPage*cri.getPerPageNum()>=totalCount?false:true;
	}
	
	public String makeQuery(int page) {
		/*
				아주 간혹 Spring 서버단에서 문자열 URI를 만들어야 할때가 있다.
				그냥 자바 String으로 만들어도 되지만, Spring MVC의 org.springframework.web.util 패키지의
				 UriComponentsBuilder를 사용하면 조금더 쉽고, 명확하게 URI 문자열을 생성 할 수 있다.
				 
		*/
		UriComponents uriComponents=
				UriComponentsBuilder.newInstance()
									.queryParam("page", page)
									.queryParam("perPageNum", cri.getPerPageNum())
									.build();
		return uriComponents.toUriString();
	}
	public String makeSearch(int page) {
		
		UriComponents uriComponents=
				UriComponentsBuilder.newInstance()
									.queryParam("page", page)
									.queryParam("perPageNum", cri.getPerPageNum())
									.queryParam("searchType", ((SearchCriteria)cri).getSearchType())
									.queryParam("keyword", encoding(((SearchCriteria)cri).getKeyword()))
									.build();
		return uriComponents.toUriString();
	}


	
	private String encoding(String keyword) {
		if(keyword==null||keyword.trim().length()==0) {
			return "";
		}
		try {
			return URLEncoder.encode(keyword,"UTF-8");
		}catch (UnsupportedEncodingException e) {
			
			return "";
		}
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public Criteria getCri() {
		return cri;
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
	

}
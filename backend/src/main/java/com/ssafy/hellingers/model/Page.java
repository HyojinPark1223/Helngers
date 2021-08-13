package com.ssafy.hellingers.model;

import lombok.Data;

@Data
public class Page {
	/*필수정보*/
	private int pageNum;	//현재 페이지 번호
	private int rowsPerPage;	//페이지 당 게시물 수
	private int pageCount=10;	//노출 페이지 개수
	private int  totalCount;	//전체 데이터 개수
	
	/*수식정보*/
	private int startPage;	//시작페이지번호
	private int endPage;		//끝페이지 번호
	private int firstPage;	//첫페이지	번호
	private int lastPage;	//마지막페이지번호	
	private int prev;		//이전페이지 번호
	private int next;	//다음페이지 번호

	private int startRowIndex;//시작데이터 
	private  String keyword;//검색어
	

	//기본 생성자
	public Page() {
		this(0,0);
	}
	
	
	public Page(int pageNum, int rowsPerPage) {
		this.pageNum = pageNum;
		this.rowsPerPage = rowsPerPage;
		
		
		this.startPage = ((pageNum-1)/pageCount)*pageCount+1;
		this.endPage = ( ((pageNum-1)/pageCount)+1)*pageCount;
	}
	
	public Page(int pageNum, int rowsPerPage, int pageCount, int totalCount, String keyword) {
		this.pageNum = pageNum;
		this.rowsPerPage = rowsPerPage;
		this.pageCount = pageCount;
		this.totalCount = totalCount;
		this.keyword = keyword;
	
		/* 수식 */
		//시작
		this.startPage=((pageNum-1)/pageCount)*pageCount+1;
		//끝
		this.endPage=((pageNum-1)/pageCount+1)*pageCount;
		//첫페이지
		this.firstPage=1;
		//마지막
		//rowsPerPage
	
		if(totalCount%rowsPerPage==0) {
			this.lastPage=(totalCount/rowsPerPage);
		}
		else
			this.lastPage=(totalCount/rowsPerPage)+1;
		//이전
		this.prev=pageNum-1;
		//다음
		
		this.next=pageNum+1;
		
		//끝>마지막 --> 보정
		if(this.endPage>this.lastPage)
			this.endPage=this.lastPage;
		
		//0부터 시작
		this.startRowIndex =(pageNum-1) * rowsPerPage;
	
	}
}

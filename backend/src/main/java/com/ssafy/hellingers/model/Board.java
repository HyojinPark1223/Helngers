package com.ssafy.hellingers.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data	
public class Board {

	private int rowNo;
	private int boardNo;
	private int userNo;	

	private int groupNo;		//그룹번호
	private int depthNo;		//계층번호
	private int seqNo;			//순서번호
	
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private Date updDate;
	
	private int replyCount;//댓글 개수
	
	private MultipartFile[] file; //파일정보를 배열로 가져옴
}

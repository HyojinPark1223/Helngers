package com.ssafy.hellingers.model;

import java.util.Date;

import lombok.Data;

@Data
public class Reply {	//dto

		private int userNo;	
		private int replyNo;
		private int boardNo;
		private String content;
		private String writer;
		private Date regDate;
		
		private int groupNo;
		private int depthNo;
		private int seqNo;
}

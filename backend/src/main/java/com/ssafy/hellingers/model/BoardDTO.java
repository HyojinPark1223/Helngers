package com.ssafy.hellingers.model;

import java.util.List;

import lombok.Data;


@Data
public class BoardDTO {
	
	private Board board;
	private Page page;
	private List<Board> boardList;
	private List<BoardAttach> attachList;
	private List<Reply> replyList;
	private boolean like;
	private int likeCount;
	
	public BoardDTO() {
		
	}
	
	//글 목록, 페이지
	public BoardDTO(List<Board> boardList, Page page) {
		this.boardList =boardList;
		this.page = page;
	}
	
	//글, 파일 목록, 댓글
	public BoardDTO(Board board, List<BoardAttach> attachList, List<Reply> replyList) {
		this.board = board;
		this.attachList = attachList;
		this.replyList = replyList;
	}
}

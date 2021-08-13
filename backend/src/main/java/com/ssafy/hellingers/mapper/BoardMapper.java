package com.ssafy.hellingers.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.hellingers.model.Board;
import com.ssafy.hellingers.model.BoardAttach;
import com.ssafy.hellingers.model.Like;
import com.ssafy.hellingers.model.Page;
import com.ssafy.hellingers.model.Reply;

@Mapper
public interface BoardMapper {
	// 게시글 쓰기
	public void insert(Board board) throws Exception;

	// 게시글 목록

	public List<Board> list() throws Exception;

	// 게시글 조회
	public Board read(Integer boardNo) throws Exception;

	// 게시글 수정
	public void update(Board board) throws Exception;

	// 게시글 삭제
	public void delete(Integer boardNo) throws Exception;

	// 게시글 검색
	public List<Board> search(String keyword) throws Exception;

	// 전체 게시글 수
	public Integer totalCount() throws Exception;

	// 페이지 게시글 목록
	public List<Board> listWithPage(Page page) throws Exception;

	// 검색어 게시글 수
	public Integer totalCountByKeyword(String keyword) throws Exception;

	// [페이지][검색어] 게시글 검색
	public List<Board> searchWithPage(Page page) throws Exception;

	// 파일 업로드

	public void uploadFile(BoardAttach attach) throws Exception;

	// 파일 목록
	public List<BoardAttach> readFileList(Integer boardNo) throws Exception;

	// 파일 삭제

	public void deleteFile(Integer fileNo) throws Exception;

	// 댓글목록
	public List<Reply> replyList(Integer boardNo) throws Exception;

	// 댓글 등록
	public void replyCreate(Reply reply) throws Exception;
	
	//댓글 수정
	public void replyUpdate (Reply reply) throws Exception;
	
	//댓글 삭제
	public void deleteReply(Reply reply);

	//답글등록
	public void answerCreate(Board board) throws Exception;

	//계층 번호 조회
	public int readDepthNo(Integer boardNo) throws Exception;
	
	//같은 그룹번호인 그룹 번호에 따른 순서번호 MAX 조회
	public int maxSeqNoByGroupNo(Integer groupNo) throws Exception;

	//max(글번호)
	public int maxBoardNo();

	//그룹번호 수정
	public void updateGroupNo(Board board);
	

	public void deleteFiles(Integer boardNo) throws Exception;
	
	//댓글 한건 읽기
	public Reply replyRead(Reply reply) throws Exception;
	
	public void replyRemoveAll (Reply reply) throws Exception;
	
	//파일 읽기
	public BoardAttach readFile(BoardAttach attach);
	
	//좋아요 여부 조회
	public int readLikes(Board board) throws Exception;
	
	//좋아요 개수 조회
	public int readLikeCount(Integer boardNo) throws Exception;
	//좋아요 여부(댓글) 조회

	public int readReplyLikes(Reply reply) throws Exception;
	//좋아요 개수(댓글) 조회

	public int readReplyLikeCount(Integer replyNo) throws Exception;
	
	//좋아요 추가
	public void insertLikes(Like like) throws Exception;
	
	
	//좋아요 취소
	public void deleteLikes(Board board) throws Exception;

	//댓글 계층번호 조회
	public int readReplyDepthNo(int replyNo) throws Exception;
	
	//댓글 그룹 번호 기준MAX(순서번호 최대값)
	public int replyMaxSeqNoByGroupNo(int groupNo) throws Exception;

	
	//댓글의 답글쓰기
	public void replyAnswerCreate(Reply reply) throws Exception;

	//댓글 번호의 최대값 조회
	public int maxReplyNo() throws Exception;
	
	//댓글 그룹 번호 수정.
	public void replyUpdateGroupNo(Reply reply) throws Exception;

	//댓글 그룹 번호 조회
	public int replyReadGroupNo(int replyNo) throws Exception;

	
}

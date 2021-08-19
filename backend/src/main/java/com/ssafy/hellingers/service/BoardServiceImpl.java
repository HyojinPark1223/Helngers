package com.ssafy.hellingers.service;

import java.util.List;

import com.ssafy.hellingers.mapper.BoardMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hellingers.model.Board;
import com.ssafy.hellingers.model.BoardAttach;
import com.ssafy.hellingers.model.Like;
import com.ssafy.hellingers.model.Page;
import com.ssafy.hellingers.model.Reply;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Override
	public void register(Board board) throws Exception {
		mapper.insert(board);

		
		int boardNo = mapper.maxBoardNo();
		board.setGroupNo(boardNo);
		board.setBoardNo(boardNo);
		
		mapper.updateGroupNo(board);
	}

	@Override
	public List<Board> list() throws Exception {
		
		return mapper.list();
	}

	@Override
	public Board read(Integer boardNo) throws Exception {
		
		return mapper.read(boardNo);
	}

	@Override
	public void modify(Board board) throws Exception {
		mapper.update(board);	//매퍼의 update호출,  추가작업 가능.
		
	}

	@Override
	public void remove(Integer boardNo) throws Exception {
		mapper.delete(boardNo);
		
	}

	@Override
	public List<Board> search(String keyword) throws Exception {
		
		return mapper.search(keyword);
	}

	@Override
	public Integer totalCount() throws Exception {
		return mapper.totalCount();
	}

	@Override
	public List<Board> list(Page page) throws Exception {
		
		return mapper.listWithPage(page);
	}

	@Override
	public Integer totalCount(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return mapper.totalCountByKeyword(keyword);
	}

	@Override
	public List<Board> search(Page page) throws Exception {
		// TODO Auto-generated method stub
		return mapper.searchWithPage(page);	//페이지 넘겨줌.
	}

	@Override
	public void uploadFile(BoardAttach attach) throws Exception {
	
			mapper.uploadFile(attach);
	}

	@Override
	public List<BoardAttach> readFileList(Integer boardNo) throws Exception {
		return mapper.readFileList(boardNo);
	}

	@Override
	public void deleteFile(Integer fileNo) throws Exception {
		 mapper.deleteFile(fileNo);
		
	}

	@Override
	public List<Reply> replyList(Integer boardNo) throws Exception {
		return mapper.replyList(boardNo);
	}

	
	@Override
	public void replyRegister(Reply reply) throws Exception {
	
		mapper.replyCreate(reply);
		int replyNo = mapper.maxReplyNo();
		reply.setGroupNo(replyNo);
		reply.setReplyNo(replyNo);
		
		mapper.replyUpdateGroupNo(reply);
	}
	
	@Override
	public void replyModify(Reply reply) throws Exception {
		mapper.replyUpdate(reply);
		
	}

	@Override
	public void replyRemove(Reply reply) throws Exception {
		mapper.deleteReply(reply);
		
	}

	@Override
	public void answerRegister(Board board) throws Exception {
		
		//그룹번호
		
		int groupNo = board.getGroupNo();
		
		
		//계층번호
		int depthNo= mapper.readDepthNo(board.getBoardNo());
		board.setDepthNo(depthNo+1);
		
		//부모글이 최초 부모글인 경우
		
		if(board.getSeqNo()==0) {
			//순서번호 MAX
			int maxSeqNo= mapper.maxSeqNoByGroupNo(groupNo);
			board.setSeqNo(maxSeqNo+1);
		}
		mapper.answerCreate(board);
	}

	@Override
	public void deleteFiles(Integer boardNo) throws Exception {
		
		mapper.deleteFiles(boardNo);
	}

	@Override
	public Reply replyRead(Reply reply) throws Exception {
	
		return mapper.replyRead(reply);
	}

	@Override
	public void replyRemoveAll(Reply reply) throws Exception {
		mapper.replyRemoveAll(reply);
	}

	@Override
	public BoardAttach readFile(BoardAttach attach) throws Exception {
		return mapper.readFile(attach);
	}

	@Override
	public int readLikes(Board board) throws Exception {
		return mapper.readLikes(board);
	}

	@Override
	public int readLikeCount(Integer boardNo) throws Exception {
		return mapper.readLikeCount(boardNo);
	}

	@Override
	public int readReplyLikes(Reply reply) throws Exception {
		return mapper.readReplyLikes(reply);
	}

	@Override
	public int readReplyLikeCount(Integer replyNo) throws Exception {
		return mapper.readReplyLikeCount(replyNo);
	}

	@Override
	public void insertLikes(Like like) throws Exception {
		mapper.insertLikes(like);
		
	}

	@Override
	public void deleteLikes(Board board) throws Exception {
		mapper.deleteLikes(board);
		
	}

	@Override
	public void replyAnswerRegister(Reply reply) throws Exception {
		//그룹번호 
		
		int groupNo = mapper.replyReadGroupNo(reply.getReplyNo());
		

		
		reply.setGroupNo(groupNo);
		
//		int groupNo = reply.getReplyNo(); 	//부모댓글 번호
//		log.info("groupNo : " + groupNo);
		//계층번호
		int detphNo = mapper.readReplyDepthNo(reply.getReplyNo()) +1;
		reply.setDepthNo(detphNo);
		
		
		//부모글이 최초 부모글인 경우
		Reply parent = mapper.replyRead(reply);
		
		if(parent.getSeqNo()==0 ) {
			//순서번호 MAX
			int maxSeqNo = mapper.replyMaxSeqNoByGroupNo(groupNo);
			reply.setSeqNo(maxSeqNo+1);
			
		}
		//부모글이 답글인 경우
		//부모글이 순서번호 --> 답글의 순서번호
		
		else {
			reply.setSeqNo(parent.getSeqNo());		
			}

		mapper.replyAnswerCreate(reply);
	}
}

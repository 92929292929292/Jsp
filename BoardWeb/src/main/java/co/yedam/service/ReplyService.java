package co.yedam.service;

import java.util.List;

import co.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(int boardNo);
	ReplyVO getReply(int replyNo);
	boolean addReply(ReplyVO rvo);
	boolean removeReply(int replyNo);
}

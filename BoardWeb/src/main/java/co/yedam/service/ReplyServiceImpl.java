package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.ReplyMapper;
import co.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
	
	@Override
	public boolean addReply(ReplyVO rvo) {
		return mapper.insertReply(rvo)==1;
	}
	
	@Override
	public ReplyVO getReply(int replyNo) {
		return mapper.selectReply(replyNo);
	}
	
	@Override
	public boolean removeReply(int replyNo) {
		return mapper.deleteReply(replyNo)==1;
	}
	
	@Override
	public List<ReplyVO> replyList(int boardNo) {
		return mapper.selectList(boardNo);
	}
}

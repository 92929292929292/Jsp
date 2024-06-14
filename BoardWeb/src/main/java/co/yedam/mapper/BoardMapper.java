package co.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.yedam.vo.BoardVO;
import co.yedam.vo.SearchVO;

//목록, 등록, 수정, 삭제, 단건조회
public interface BoardMapper {
	List<BoardVO> boardList(); //전체 목록
	List<BoardVO> boardListPaging(SearchVO search); //페이지별로 5건씩
	int getTotalCnt(SearchVO search);
	int insertBoard(BoardVO bvo);
	int updateBoard(BoardVO bvo);
	int deleteBoard(int bno);
	BoardVO selectBoard(int bno);
	
	//회원id, 회원비번
	int selectMember(@Param("id") String id, @Param("pw") String pw);
}

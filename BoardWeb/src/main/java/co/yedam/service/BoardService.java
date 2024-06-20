package co.yedam.service;

import java.util.List;

import co.yedam.vo.BoardVO;
import co.yedam.vo.MemberVO;
import co.yedam.vo.SearchVO;

//목록, 단건조회, 등록, 수정, 삭제
//기능의 실행은 mapper 실행.

public interface BoardService {
	List<BoardVO> boardList(SearchVO search);
	int boardTotal(SearchVO search);
	BoardVO getBoard(int bno);
	boolean addBoard(BoardVO bvo);
	boolean editBoard(BoardVO bvo);
	boolean removeBoard(int bvo);
	MemberVO checkMember(String id, String pw); 
	boolean addMember(MemberVO mvo);
	
	List<MemberVO> memberList();
	boolean addMemberAjax(MemberVO mvo);
	boolean checkMemberId(String id);
	boolean removeMember(String id);
	boolean editMember(MemberVO mvo);
}

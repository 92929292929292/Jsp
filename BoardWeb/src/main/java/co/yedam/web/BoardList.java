package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

//오라클 디비에 있는 게시글 목록을 조회 > boardList.jsp 출력

public class BoardList implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList();
		
		req.setAttribute("boardList", list);
		req.getRequestDispatcher("WEB-INF/view/boardList.jsp").forward(req, resp);
	}

}

package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class Addboard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tit = req.getParameter("tit");
		String wri = req.getParameter("wri");
		String con = req.getParameter("con");
		
		BoardService bs = new BoardServiceImpl();
		BoardVO bvo = new BoardVO();
		
		bvo.setTitle(tit);
		bvo.setWriter(wri);
		bvo.setContent(con);
		
		if (bs.addBoard(bvo)) {
			System.out.println("정상등록...");
			resp.sendRedirect("boardList.do");
		} else {
			System.out.println("등록실패...");
			req.setAttribute("message", "처리중 오류가 발생.");
			req.getRequestDispatcher("WEB-INF/view/boardForm.jsp").forward(req, resp);
		}
	}

}

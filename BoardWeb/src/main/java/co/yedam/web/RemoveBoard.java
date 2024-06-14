package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class RemoveBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		BoardService svc = new BoardServiceImpl();
		BoardVO brd = svc.getBoard(Integer.parseInt(bno));
		
		req.setAttribute("board", brd);
		req.setAttribute("page", page);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		req.getRequestDispatcher("board/removeBoardForm.tiles").forward(req, resp);
	}

}

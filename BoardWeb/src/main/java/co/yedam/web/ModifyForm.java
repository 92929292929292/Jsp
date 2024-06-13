package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class ModifyForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		BoardService svc = new BoardServiceImpl();
		BoardVO brd = svc.getBoard(Integer.parseInt(bno));
		
		req.setAttribute("board", brd);
		req.setAttribute("page", page);
		req.getRequestDispatcher("WEB-INF/view/modifyBoardForm.jsp").forward(req, resp);

	}

}

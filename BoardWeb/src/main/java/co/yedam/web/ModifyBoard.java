package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.common.PageDTO;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class ModifyBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		String tit = req.getParameter("title");
		String con = req.getParameter("content");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		BoardService bs = new BoardServiceImpl();
		BoardVO bvo = new BoardVO();
		
		bvo.setBoardNo(Integer.parseInt(bno));
		bvo.setTitle(tit);
		bvo.setContent(con);

		
		if (bs.editBoard(bvo)) {
			System.out.println("정상수정...");
			resp.sendRedirect("getBoard.do?bno="+bvo.getBoardNo()+"&page="+page+"&searchCondition="+sc+"&keyword="+kw);
		} else {
			System.out.println("수정실패...");
			req.setAttribute("message", "처리중 오류가 발생.");
			req.getRequestDispatcher("WEB-INF/view/boardForm.jsp").forward(req, resp);
		}
	}

}

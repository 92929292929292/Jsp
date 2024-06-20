package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class Gaip implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String nm = req.getParameter("name");
		
		BoardService bs = new BoardServiceImpl();
		MemberVO mvo = new MemberVO();
		
		mvo.setUserId(id);
		mvo.setUserPw(pw);
		mvo.setUserName(nm);

		
		if (bs.addMember(mvo)) {
			System.out.println("정상등록...");
			resp.sendRedirect("boardList.do");
		} else {
			System.out.println("등록실패...");
			req.setAttribute("message", "처리중 오류가 발생.");
			req.getRequestDispatcher("member/gaipForm.tiles").forward(req, resp);
		}
	}

	}


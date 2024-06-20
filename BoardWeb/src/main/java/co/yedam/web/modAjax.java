package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class modAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String nm = req.getParameter("nm");
		
		MemberVO mvo = new MemberVO();
		BoardService bvo = new BoardServiceImpl();
		
		mvo.setUserId(id);
		mvo.setUserPw(pw);
		mvo.setUserName(nm);
		
		if(bvo.editMember(mvo)) {
			resp.getWriter().print("{\"retCode\": \"OK\", \"retMsg\": \"Success\"}");
		} else {
			resp.getWriter().print("{\"retCode\": \"NG\", \"retMsg\": \"Fail\"}");
		}

	}

}

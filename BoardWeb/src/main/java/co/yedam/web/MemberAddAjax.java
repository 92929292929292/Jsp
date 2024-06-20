package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class MemberAddAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String nm = req.getParameter("nm");
		String rp = req.getParameter("rp");
		
		MemberVO mvo = new MemberVO();
		mvo.setUserId(id);
		mvo.setUserPw(pw);
		mvo.setUserName(nm);
		mvo.setResponsibility(rp);
		
		BoardService bvo = new BoardServiceImpl();
		
		if (bvo.addMemberAjax(mvo)) { // {"retCode": "OK", "retMsg": "Success"}
			resp.getWriter().print("{\"retCode\": \"OK\", \"retMsg\": \"Success\"}");
		} else { // {"retCode": "NG", "retMsg": "Fail"}
			resp.getWriter().print("{\"retCode\": \"NG\", \"retMsg\": \"Fail\"}");
		}
	}

}

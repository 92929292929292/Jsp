package co.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.web.AddReply;
import co.yedam.web.AddStudent;
import co.yedam.web.Addboard;
import co.yedam.web.AjaxForm;
import co.yedam.web.BoardForm;
import co.yedam.web.BoardList;
import co.yedam.web.CheckIdAjax;
import co.yedam.web.Gaip;
import co.yedam.web.GaipForm;
import co.yedam.web.GetBoard;
import co.yedam.web.LogoutControl;
import co.yedam.web.MainControl;
import co.yedam.web.MemberAddAjax;
import co.yedam.web.MemberAjax;
import co.yedam.web.MemberList;
import co.yedam.web.ModifyBoard;
import co.yedam.web.ModifyForm;
import co.yedam.web.ProductControl;
import co.yedam.web.RemoveBoard;
import co.yedam.web.RemoveBoard2;
import co.yedam.web.RemoveReply;
import co.yedam.web.ReplyList;
import co.yedam.web.ScriptForm;
import co.yedam.web.StudentForm;
import co.yedam.web.loginControl;
import co.yedam.web.loginForm;
import co.yedam.web.modAjax;
import co.yedam.web.removeIdAjax;

//front -> 요청 url(*.do) - 실행컨트롤 매칭.
//main.do -> FrontController -> /web-inf/public/main.jsp
//객체생성 - init -> service - destroy
public class FrontController extends HttpServlet{
	private Map<String, Control> map; // key: url, value: control
	
	public FrontController() {
		map = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainControl());
		map.put("/product.do", new ProductControl());
		//학생등록화면 studentForm.do
		map.put("/StudentForm.do", new StudentForm()); //등록화면
		map.put("/AddStudent.do", new AddStudent()); //정보db에 저장
		
		//게시글목록.
		map.put("/boardList.do", new BoardList());
		//상세화면
		map.put("/getBoard.do", new GetBoard());
		//게시글등록화면
		map.put("/boardForm.do", new BoardForm());
		map.put("/addBoard.do", new Addboard());
		//게시글삭제
		map.put("/removeForm.do", new RemoveBoard());
		map.put("/removeBoard.do", new RemoveBoard2());
		//게시글수정
		map.put("/modifyForm.do", new ModifyForm());
		map.put("/modifyBoard.do", new ModifyBoard());
		//로그인 화면
		map.put("/loginForm.do", new loginForm());
		//로그인 기능
		map.put("/login.do", new loginControl());
		//로그아웃 기능 
		map.put("/logout.do", new LogoutControl());
		//회원가입 사이트
		map.put("/gaipForm.do", new GaipForm());
		map.put("/gaip.do", new Gaip());
		//회원목록(관리자템플릿)
		map.put("/memberList.do", new MemberList());
		
		//자바스크립트 연습용 페이지
		map.put("/script.do", new ScriptForm());
		//아작스 페이지
		map.put("/ajax.do", new AjaxForm());
		//json 문자열 반환
		map.put("/membersAjax.do", new MemberAjax());
		map.put("/addAjax.do", new MemberAddAjax());
		map.put("/checkIdAjax.do", new CheckIdAjax());
		map.put("/removeIdAjax.do", new removeIdAjax());
		map.put("/modAjax.do", new modAjax());
		
		//댓글관련
		map.put("/replyListJson.do", new ReplyList());
		map.put("/removeReply.do", new RemoveReply());
		map.put("/addReply.do", new AddReply());
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); //http://localhost/BoardWeb/main.do
//		System.out.println("URI : " + uri); //BoardWeb/main.do
		String context = req.getContextPath(); // /BoardWeb -> project name;
//		System.out.println("context : " + context);
		String page = uri.substring(context.length()); //main.do
//		System.out.println("page : " + page);
		
		Control result = map.get(page);
		result.exec(req, resp);
	}
}

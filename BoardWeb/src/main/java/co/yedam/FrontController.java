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
import co.yedam.web.AddStudent;
import co.yedam.web.Addboard;
import co.yedam.web.BoardForm;
import co.yedam.web.BoardList;
import co.yedam.web.GetBoard;
import co.yedam.web.LogoutControl;
import co.yedam.web.MainControl;
import co.yedam.web.ModifyBoard;
import co.yedam.web.ModifyForm;
import co.yedam.web.ProductControl;
import co.yedam.web.RemoveBoard;
import co.yedam.web.RemoveBoard2;
import co.yedam.web.StudentForm;
import co.yedam.web.loginControl;
import co.yedam.web.loginForm;

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

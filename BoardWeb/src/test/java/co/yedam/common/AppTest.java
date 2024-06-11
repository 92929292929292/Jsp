package co.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.BoardMapper;
import co.yedam.vo.BoardVO;

public class AppTest {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory =DataSource.getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//interface - 구현객체.
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		BoardVO bvo = new BoardVO();
		
//		bvo.setTitle("안녕");
//		bvo.setContent("감사해요");
//		bvo.setWriter("user11");
//		
//		mapper.insertBoard(bvo);
//		sqlSession.commit();
		
		
//		sqlSession.commit();
//		
//		bvo.setBoardNo(4);
//		bvo.setContent("잘 있어요");
//		mapper.updateBoard(bvo);
//		
		
		List<BoardVO>list = mapper.boardList();
		for(BoardVO bvo2:list) {
			System.out.println(bvo2.toString());
		}
		
//		Student std = new Student();
////		std.setStdNo("S0010");
////		std.setStdName("정상");
////		std.setPhone("010-5555-3333");
////		std.setBldType("O");
////		
////		sqlSession.insert("co.yedam.mapper.StudentMapper.insertStudent", std);
////		sqlSession.commit();
//		
////		std.setStdNo("S0010");
////		std.setStdName("정상");
////		std.setPhone("010-6666-6666");
////		std.setBldType("O");
//		
////		sqlSession.update("co.yedam.mapper.StudentMapper.updateStudent", std);
////		sqlSession.commit();
//		
//		std.setStdNo("S1111");
////		
////		mapper.updateStudnet(std);
////		sqlSession.commit();
//		
//		mapper.deleteStudent(std);
//		sqlSession.commit();
//		
//		List<Student> list = mapper.selectBlog();
//		for(Student std1 : list) {
//			System.out.println(std1.toString());
//		}
	}
}

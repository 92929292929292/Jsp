package co.yedam.common;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.ReplyMapper;
import co.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory =DataSource.getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		//interface - 구현객체.
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
//		ReplyVO rvo = mapper.selectReply(1);
//		mapper.selectList(1).forEach(reply -> System.out.println(reply));
//		System.out.println(rvo);
		
//		try {
//			if(mapper.deleteReply(2) == 1) {
//			System.out.println("입력성공");
//			}
//		} catch (Exception e) {
//			System.out.println("예외 발생.");
//		}
		
//		ReplyVO rvo = new ReplyVO();
//		rvo.setBoardNo(2);
//		rvo.setReply("뭐");
//		rvo.setReplyer("user01");
//		
//		mapper.insertReply(rvo);
		
//		try {
//			if(mapper.insertReply(rvo) == 1) {
//			System.out.println("입력성공");
//			}
//		} catch (Exception e) {
//			System.out.println("예외 발생.");
//		}
		
//		bvo.setTitle("안녕");
//		bvo.setContent("감사해요");
//		bvo.setWriter("user11");
//		
//		mapper.insertBoard(bvo);
//		sqlSession.commit();
		
//		sqlSession.commit();
		
//		SearchVO search = new SearchVO(1, "t", "깅");
		
//		mapper.boardListPaging(search).forEach(bvo -> System.out.println(bvo));
		
//		List<BoardVO>list = mapper.boardListPaging(1);
//		for(BoardVO bvo2:list) {
//			System.out.println(bvo2.toString());
//		}
		
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

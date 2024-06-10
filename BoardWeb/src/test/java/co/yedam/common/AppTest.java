package co.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.StudentMapper;
import co.yedam.vo.Student;

public class AppTest {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory =DataSource.getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//interface - 구현객체.
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		
		Student std = new Student();
//		std.setStdNo("S0010");
//		std.setStdName("정상");
//		std.setPhone("010-5555-3333");
//		std.setBldType("O");
//		
//		sqlSession.insert("co.yedam.mapper.StudentMapper.insertStudent", std);
//		sqlSession.commit();
		
//		std.setStdNo("S0010");
//		std.setStdName("정상");
//		std.setPhone("010-6666-6666");
//		std.setBldType("O");
		
//		sqlSession.update("co.yedam.mapper.StudentMapper.updateStudent", std);
//		sqlSession.commit();
		
//		std.setStdNo("S0001");
//		
//		mapper.updateStudnet(std);
//		sqlSession.commit();
		
		List<Student> list = mapper.selectBlog();
		for(Student std1 : list) {
			System.out.println(std1.toString());
		}
	}
}

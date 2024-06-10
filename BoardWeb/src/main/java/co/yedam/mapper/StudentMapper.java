package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.Student;

public interface StudentMapper {
	public List<Student> selectBlog();
	public int insertStudnet(Student student);
	public int updateStudnet(Student student);
	public int deleteStudnet(Student student);
}

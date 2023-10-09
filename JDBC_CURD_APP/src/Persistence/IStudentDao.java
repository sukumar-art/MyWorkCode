package Persistence;

import DTO.Student;
/* DAO is Data Access Object Layer */
public interface IStudentDao {
	
	// operations to be implemented
	public String addStudent(String sname, Integer sage, String saddress);

	public Student searchStudent(Integer sid);

	public String updateStudent(Integer sid, String sname, Integer sage, String saddress);

	public String deleteStudent(Integer sid);

}

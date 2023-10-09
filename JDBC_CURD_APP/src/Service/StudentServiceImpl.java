package Service;


public class StudentServiceImpl implements IStudentService {

	Persistence.IStudentDao stdDao;

	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		stdDao = DaoFactory.StudentDaoFactory.getStudentDao();
		return stdDao.addStudent(sname, sage, saddress);
	}

	@Override
	public DTO.Student searchStudent(Integer sid) {
		stdDao = DaoFactory.StudentDaoFactory.getStudentDao();
		return stdDao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		stdDao = DaoFactory.StudentDaoFactory.getStudentDao();
		return stdDao.updateStudent(sid, sname, sage, saddress);
	}

	@Override
	public String deleteStudent(Integer sid) {
		stdDao = DaoFactory.StudentDaoFactory.getStudentDao();
		return stdDao.deleteStudent(sid);
	}

}

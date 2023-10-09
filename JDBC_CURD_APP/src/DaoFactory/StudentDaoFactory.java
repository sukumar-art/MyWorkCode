package DaoFactory;

import Persistence.IStudentDao;

public class StudentDaoFactory {
    private StudentDaoFactory() {

    }

    public static IStudentDao studentDao = null;

    public static IStudentDao getStudentDao() {
        if (studentDao == null) {
            studentDao = new Persistence.StudentDaoImpl();
        }
        return studentDao;
    }

}

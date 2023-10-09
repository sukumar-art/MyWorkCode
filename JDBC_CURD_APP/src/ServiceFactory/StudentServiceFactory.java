package ServiceFactory;

/* Resembelance of this code = Connection connection = DriverManager.getConnection(url, username, pw) */
// Abstract Logic of Implementation
import Service.IStudentService;
import Service.StudentServiceImpl;

public class StudentServiceFactory {
    // Making the Constructor Private
    private StudentServiceFactory() {

    }
    // Making Object as Instance Variable
    private static IStudentService studentService = null;

    /* Static metnod to give Object of Implementation Class of IStudentService */
    // Using Singleton Pattern Code
    public static IStudentService getStudentService() {
        if (studentService == null) {
            studentService = new StudentServiceImpl();
        }
        return studentService;
    }
}

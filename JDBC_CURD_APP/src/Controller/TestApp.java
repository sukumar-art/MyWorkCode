package Controller;

public class TestApp {
	public static void insertOperation() {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		scan.close();
		// Similar to Connection connection = DriverManager.getConnection();
		Service.IStudentService studentService = ServiceFactory.StudentServiceFactory.getStudentService();

		String msg = studentService.addStudent("HarryPotter", 30, "Bengalore");

		if (msg.equalsIgnoreCase("success"))
			System.out.println("Record Inserted Successfully");
		else
			System.out.println("Record Insertion Failed");
	}

	// This is called Bean Transportation or Pojo Transportation or DTO Transportation
	public static void selectOperation () {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println("Enter Student ID:: ");
		int sid = scan.nextInt();

		Service.IStudentService studentService = ServiceFactory.StudentServiceFactory.getStudentService();

		DTO.Student std = studentService.searchStudent(sid);
		if (std != null ) {
			// System.out.println(std);
			System.out.println("SID\tSNAME\tSAGE\tSADDR");
			System.out.println(std.getSid()+"\t"+std.getSname()+"\t"+std.getSage()+"\t"+std.getSaddress());
		} else {
			System.out.println("Record Not found for given Record:: "+sid);
		}
		scan.close();
	}
	public static void deleteOperation () {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println("Enter Student Record for Deletion:: ");
		Integer rec = scan.nextInt();
		Service.IStudentService studentService = ServiceFactory.StudentServiceFactory.getStudentService();
		String msg = studentService.deleteStudent(rec);
		if (msg.equalsIgnoreCase("success") ) {
			System.out.println("Record Deleted Successfully");
		} else {
			System.out.println("Record not found::");
		}
		scan.close();
	} 

	public static void updateOperation () {
		Service.IStudentService studentService =ServiceFactory.StudentServiceFactory.getStudentService();
		String msg = studentService.updateStudent(0, "Sukumar Tusam", 30, "Bangalore");
		if (msg.equalsIgnoreCase("success"))
		System.out.println("Record Updated Successfully...");
		else
		System.out.println("Record Not Found...");
	}

	public static void main(String[] args) {
		// insertOperation();
		// selectOperation();
		// deleteOperation();
		updateOperation();

	}

}

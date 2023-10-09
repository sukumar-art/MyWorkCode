package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;

@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {

		IStudentService stdService = StudentServiceFactory.getStudentService();

		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path info       :: " + request.getPathInfo());

		if (request.getRequestURI().endsWith("addform")) {
			String sage = request.getParameter("sage");
			String sname = request.getParameter("sname");
			String saddr = request.getParameter("saddr");

			Student student = new Student();
			student.setSname(sname);
			student.setSage(Integer.parseInt(sage));
			student.setSaddress(saddr);

			String status = stdService.addStudent(student);
			PrintWriter out = response.getWriter();

			if (status.equals("success")) {
				try {
					request.getRequestDispatcher("/success.html").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} else {
				try {
					request.getRequestDispatcher("/failure.html").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
			out.close();
		}
		if (request.getRequestURI().endsWith("searchform")) {
			String sid = request.getParameter("sid");
			Student student = stdService.searchStudent(Integer.parseInt(sid));
			java.io.PrintWriter out = response.getWriter();
			if (student != null) {
				out.print("<body>");
				out.print("<center>");
				out.print("<br/><br/><br/>");
				out.print("<table border = '1' >");
				out.print("<tr><th>ID</th><td>" + student.getSid() + "</td></tr>");
				out.print("<tr><th>NAME</th><td>" + student.getSname() + "</td></tr>");
				out.print("<tr><th>AGE</th><td>" + student.getSage() + "</td></tr>");
				out.print("<tr><th>ADDRESS</th><td>" + student.getSaddress() + "</td></tr>");
				out.print("</table>");
				out.print("</center>");
				out.print("</body>");
			} else {
				out.print("<h1 style = 'color:red; text-align:center; '>RECORD NOT AVAILABLE FOR THE GIVEN ID " + sid
						+ "</h1>");
			}
			out.close();
		}
		if (request.getRequestURI().endsWith("deleteform")) {
			String sid = request.getParameter("sid");
			String status = stdService.deleteStudent(Integer.parseInt(sid));

			PrintWriter out = response.getWriter();
			if (status.equals("success")) {
				out.println("<body>");
				try {
					request.getRequestDispatcher("/deletesuccess.html").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
				
			} else if (status.equals("failure")) {
				try {
					request.getRequestDispatcher("/deletefailed.html").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}

			} else {
				try {
					request.getRequestDispatcher("/deletenotfound.html").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}

			}
			out.close();
		}
		if (request.getRequestURI().endsWith("editform")) {
			String sid = request.getParameter("sid");

			Student student = stdService.searchStudent(Integer.parseInt(sid));
			PrintWriter out = response.getWriter();
			if (student != null) {
				// Display student records as a form data so it is editable
				out.println("<body>");
				out.println("<center>");
				out.println("<form  method='post' action = './controller/updateRecord '>");
				out.println("<table>");
				out.println("<tr><th>ID</th><td>" + student.getSid() + "</td></tr>");
				out.println("<input type = 'hidden' name = 'sid' value = '" + student.getSid() + "'/>");
				out.println("<tr><th>NAME</th><td><input type = 'text' name = 'sname' value ='" + student.getSname()
						+ "' /></td></tr>");
				out.println("<tr><th>AGE</th><td><input type = 'text' name = 'sage' value ='" + student.getSage()
						+ "' /></td></tr>");
				out.println("<tr><th>ADDRESS</th><td><input type = 'text' name = 'saddr' value ='"
						+ student.getSaddress() + "' /></td></tr>");
				out.println("<tr><td></td><td><input type = 'submit' value = 'update'/> </td></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("<center>");
				out.println("</body>");

			} else {
				// Display not found message
				out.println("<body>");
				out.println("h1 style=' color:red, text-align:center;'> Record not available for the given ID :: " + sid
						+ "</h1>");
				out.println("</body>");
			}
			out.close();
		}
		
		if (request.getRequestURI().endsWith("updateRecord")) {
			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddr = request.getParameter("saddr");

			System.out.println(sid);
			System.out.println(sname);
			System.out.println(sage);
			System.out.println(saddr);
			
			Student student = new Student();
			student.setSid(Integer.parseInt(sid));
			student.setSname(sname);
			student.setSaddress(saddr);
			student.setSage(Integer.parseInt(sage));
			
			String status = stdService.updateStudent(student);
			PrintWriter out = response.getWriter();
			
			if (status.equals("success")) {
				out.println("<h1 style = color:green; text-align:center;'>STUDENT RECORD UPDATED SUCCESSFULLY</h1>");
			} else {
				out.println("<h1 style= color:green; text-align:center;'>STUDENT RECORD UPDATION FAILED</h1>");
			}
		}
	}
}

package app.bank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.Controller;

/**
 * Servlet implementation class session
 */
@WebServlet("/session/*")
public class session extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Controller c = new Controller();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
		java.io.PrintWriter out = response.getWriter();
		out.print("Hello Second Servlet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		new java.io.PrintWriter(response.getWriter()).print("Welcome to Banking App");
		boolean register = c.register(getServletName(), null);
		if(c.register(getServletInfo(), null)) {
			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("layout.html");
//			try {
//				rd.forward(request, response);
//			} catch (ServletException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			
		}
//		response.getHeader(getServletName());
	}

}

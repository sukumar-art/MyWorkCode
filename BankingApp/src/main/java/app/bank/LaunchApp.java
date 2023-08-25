package app.bank;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.Controller;

@WebServlet("/la/*")
public class LaunchApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Integer deposit;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {

//		javax.servlet.RequestDispatcher rd =request.getRequestDispatcher("session");
//		try {
//			rd.forward(request, response);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		java.io.PrintWriter out = response.getWriter();
		try {
			Controller c = new Controller();
			response.setContentType("text/html");

			if (request.getRequestURI().endsWith("register")) {

				/* Register Method */
				String uname = request.getParameter("uname");
				Integer pw = Integer.parseInt(request.getParameter("pw"));
				c.register(uname, pw);
				out.print("<h2 style='color:green; text-align:center; font=size: 300px;'> " + uname + "</h2>");
				out.print(
						"<h1 style = 'color:red; text-align:center; font-family: 'Poppins', sans-serif; font-weight: 900; "
								+ "font=size: 200px; '>" + "Welcome to Banking Application</h1>");
			}
			/* Checking Balance */
			else if (request.getRequestURI().endsWith("checkBalanc")) {

				out.print("<h2 style = 'color:blue; text-align:center; font=size: 300px;'> Your A/c Balance is </h2>");

				out.println(
						"<h2 style = 'color:black; text-align:center; font-family: 'Poppins', sans-serif; font-weight: 900; "
								+ "font=size: 300px; '>" + "Rs: " + c.checkBalance() + "</h2>");

				/* Deposit Logic */
			} else if (request.getRequestURI().endsWith("deposit")) {

				this.deposit = Integer.parseInt(request.getParameter("deposit"));
				c.deposit(this.deposit);

				out.print("<h2 style='color:blue; text-align:center; font=size: 300px;'> Amount Deposited </h2>");
				out.println(
						"<h2 style = 'color:black; text-align:center; font-family: 'Poppins', sans-serif; font-weight: 900; "
								+ "font=size: 300px; '>" + "Rs: " + deposit + "</h2>");

				/* Withdrawl Logic */
			} else if (request.getRequestURI().endsWith("withdrawl")) {
				Integer withdrawl = Integer.parseInt(request.getParameter("withdraw"));
				c.withdraw(withdrawl);
				out.print("<h2 style='color:green; text-align:center; font=size: 300px;'> Amount Withdrawn </h2>");
				out.println(
						"<h2 style = 'color:black; text-align:center; font-family: 'Poppins', sans-serif; font-weight: 900; "
								+ "font=size: 300px; '>" + "Rs: " + withdrawl + "</h2>");

			}

			else {
				out.print(
						/*
						 * "<h2 style = 'color:red; text-align:center; font-family: 'Poppins', sans-serif; font-weight: 900; "
						 * + "font=size: 200px; '>"
						 * +"<a href=\"layout.html\" target=\"body\">Click to Banking</a>" + "</h2>");
						 */
						"<h2 style = 'color:red; text-align:center; font-family: 'Poppins', sans-serif; font-weight: 900; "
								+ "font=size: 200px; '>" + "Click to Banking</h2>");

			}
			/*
			 * } else { out.
			 * print("<h2 style='color:green; text-align:center; font=size: 300px;'> Press - Sign Up </h2>"
			 * ); }
			 */
		} catch (NumberFormatException ne) {
			ne.printStackTrace();
			out.print(
					"<h2 style='color:green; text-align:center; font=size: 300px;'> Please enter 'Decimal values' </h2>");
		}

	}
}

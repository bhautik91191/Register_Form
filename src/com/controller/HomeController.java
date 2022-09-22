package com.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.HomeDao;
import com.model.RegistrationModel;

/**
* Servlet implementation class HomeController
* JSP to get Update data post method
* DoGet method to get parameter value check showData, editUser, deleteUser
* 
* @author  Bhautik Padmani
* @version 1.8
* @since   March 2014 
*/
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public HomeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("showData")) {
			response.sendRedirect("employee_table.jsp");
		} else if(action.equals("editUser")) {
			int userId = Integer.parseInt(request.getParameter("userId"));

			// HomeDao class and editUser Method call and return model
			RegistrationModel recordEdit = null;

			try {
				recordEdit = new HomeDao().editUser(userId);
			} catch (Exception exception) {
				exception.printStackTrace();
			}

			request.setAttribute("editUser", recordEdit);
			request.getRequestDispatcher("register_form.jsp").forward(request, response);
		} else if(action.equals("deleteUser")) {
			int userId = Integer.parseInt(request.getParameter("userId"));

			// HomeDao class to doDeleteUser method call and return Integer value
			int recordDeleted = 0;

			try {
				recordDeleted = new HomeDao().doDeleteUser(userId);
			} catch (Exception exception) {
				exception.printStackTrace();
			}

			// Check delete user or not
			if (recordDeleted > 0) {
				response.sendRedirect("employee_table.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

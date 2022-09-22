package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HomeDao;
import com.dao.RegistrationDao;
import com.model.RegistrationModel;

/**
* Servlet implementation class RegistrationController
* JSP to get data post method and model set data
* Model set to RegistrationDao class and set database and return Integer value
* Check condition Record inserted or not
*
* @author  Bhautik Padmani
* @version 1.8
* @since   March 2014 
*/
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RegistrationController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ((request.getParameter("id")).isEmpty()) {
			RegistrationModel registrationModel = new RegistrationModel();
			registrationModel.setFirstname(request.getParameter("firstname"));
			registrationModel.setLastname(request.getParameter("lastname"));
			registrationModel.setUsername(request.getParameter("username"));
			registrationModel.setPassword(request.getParameter("password"));
			registrationModel.setAddress(request.getParameter("address"));
			registrationModel.setContactno(request.getParameter("contactno"));

			// Insert data and Return Integer value
			int recordInserted = 0;

			try {
				recordInserted = new RegistrationDao().doRegistration(registrationModel);
			} catch (Exception exception) {
				exception.printStackTrace();
			}

			// Check Record inserted or Not
			if (recordInserted > 0) {
				response.sendRedirect("HomeController?action=showData");
			} else {
				request.getRequestDispatcher("register_form.jsp").forward(request, response);
			}
		} else {
			RegistrationModel updateModel = new RegistrationModel();
			updateModel.setId(Integer.parseInt(request.getParameter("id")));
			updateModel.setFirstname(request.getParameter("firstname"));
			updateModel.setLastname(request.getParameter("lastname"));
			updateModel.setUsername(request.getParameter("username"));
			updateModel.setPassword(request.getParameter("password"));
			updateModel.setAddress(request.getParameter("address"));
			updateModel.setContactno(request.getParameter("contactno"));

			// Update model and return Integer value
			int recordUpdated = 0;

			try {
				recordUpdated = new HomeDao().doUpdateUser(updateModel);
			} catch (Exception exception) {
				exception.printStackTrace();
			}

			if (recordUpdated > 0) {
				response.sendRedirect("employee_table.jsp");
			}
		}
		
	}

}

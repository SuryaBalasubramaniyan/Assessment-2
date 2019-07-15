package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.EmployeeBean;
import com.bean.EmployeeDao;
import com.bean.EmployeeDaoImpl;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Unauthorized access to this page!</h1>");
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.include(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApplicationContext factory=new ClassPathXmlApplicationContext("beans.xml");
		EmployeeDaoImpl empDaoImpl =(EmployeeDaoImpl)factory.getBean("emp");
		EmployeeBean emp=new EmployeeBean();
		emp.setName(request.getParameter("name"));
		emp.setPassword(request.getParameter("password"));
		emp.setRole(request.getParameter("role"));
		emp.setAge(Integer.parseInt(request.getParameter("age")));
		emp.setEmail(request.getParameter("email"));
		emp.setMobile(Integer.parseInt(request.getParameter("mobile")));
		try
		{
		empDaoImpl.update(emp);

		
				request.setAttribute("alert", "Updated successfully!");
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);

		}catch(Exception e)
		{
			request.setAttribute("alert", "Updation failed, try again!");
			RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
		}
	}

}

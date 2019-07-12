package com.controllers;
import com.bean.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class ValidateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	   
    public ValidateAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String pwd=request.getParameter("password");
		EmployeeBean emp=new EmployeeBean();
		emp.setName(name);
		emp.setPassword(pwd);
		
		ApplicationContext factory=new ClassPathXmlApplicationContext("beans.xml");
		EmployeeDaoImpl empDaoImpl =(EmployeeDaoImpl)factory.getBean("emp");
		//empDaoImpl.connectDatabase();
		boolean result=empDaoImpl.checkAdmin(emp);
		if(result==true)
		{
			response.sendRedirect("success.html");
			
		}
		else {
			out.println("Invalid login");
		}
		
	}
	}



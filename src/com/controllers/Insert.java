package com.controllers;
import com.bean.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Insert() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		//empDaoImpl.connectDatabase();
		empDaoImpl.insert(emp);
		
		
	}
	}



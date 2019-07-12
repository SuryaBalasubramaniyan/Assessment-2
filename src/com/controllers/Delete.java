package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.EmployeeBean;
import com.bean.EmployeeDaoImpl;


public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Delete() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext factory=new ClassPathXmlApplicationContext("beans.xml");
		EmployeeDaoImpl empDaoImpl =(EmployeeDaoImpl)factory.getBean("emp");
		EmployeeBean emp=new EmployeeBean();
		//empDaoImpl.connectDatabase();
		emp.setName(request.getParameter("name"));
		
		//String name=(request.getParameter("name"));
		//System.out.println(name);
		boolean res=empDaoImpl.delete(emp);
		if(res==true)
				System.out.println("Deleted ......");
	}

}

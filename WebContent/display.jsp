<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ page import="java.util.ArrayList"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import=" org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import=" com.bean.EmployeeBean"%>
<%@ page import=" com.bean.EmployeeDaoImpl"%>
<%@ page import="java.util.Iterator"%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Sapient</title>
</head>
<body>
<% 
		ApplicationContext factory=new ClassPathXmlApplicationContext("beans.xml");
		EmployeeDaoImpl empDaoImpl =(EmployeeDaoImpl)factory.getBean("emp");
		ArrayList<EmployeeBean> emplist= empDaoImpl.display();
		Iterator<EmployeeBean> i = emplist.iterator();
		%>
<h2>Employee Details</h2>	
<table border="2">
        <tr>
            <th>Name</th>
            <th>Password</th>
            <th>Role</th>
            <th>Age</th>
            <th>Email</th>
            <th>Mobile</th>
        </tr>
<%

 
if(emplist!= null)  
{
 Iterator<EmployeeBean> iterator = emplist.iterator();  
 
 while(iterator.hasNext())  
 {
 EmployeeBean empDetails = iterator.next(); 
 %>
 <tr><td><%=empDetails.getName()%></td>
 <td><%=empDetails.getPassword()%></td>
 <td><%=empDetails.getRole()%></td>
 <td><%=empDetails.getAge()%></td>
 <td><%=empDetails.getEmail()%></td>
  <td><%=empDetails.getMobile()%></td>
 </tr>
 <%
 }
}
%>
</table>
</body>
</html>
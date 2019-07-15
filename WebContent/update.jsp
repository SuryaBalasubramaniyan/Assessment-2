<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import=" org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import=" com.bean.EmployeeBean"%>
<%@ page import=" com.bean.EmployeeDaoImpl"%>
<%@ page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body  onload="check()">
<script>
function check()
{
	var Msg ='<%=request.getAttribute("alert")%>';
    if (Msg != "null") {
 alert(Msg);
 }
    else
    	{
	
    	}
}
</script>

<div class="login-card">
<form action="" method="post">
Name: <input type="text" name="name">
<input type="submit" name="s1" value="submit">
</form>
</div>

	<%!
		EmployeeBean emp = null;
	   int track=1;
	%>
	<%
	
		ApplicationContext factory=new ClassPathXmlApplicationContext("beans.xml");
		EmployeeDaoImpl empDaoImpl =(EmployeeDaoImpl)factory.getBean("emp");
		emp=empDaoImpl.search(request.getParameter("name"));
		track=0;
		if(emp==null && track==1)
		{%>
			<h1> Record doesn't exist, try again!!</h1>
		<% 
		
		}else if(emp!=null)
		{
%>
<div class="login-card">
<form action="update " method="post">
		<h2><br>
			Username : <input type="text" name="name" value=<%=emp.getName() %>> <br>
			Password : <input type="password" name="password" value=<%=emp.getPassword() %>><br>
			Role : <input type="text" name="role" value="<%=emp.getRole() %>"> <br>
		    Age : <input type="text" name="age" value="<%=emp.getAge() %>"><br>
			Email : <input type="text" name="email" value="<%=emp.getEmail() %>"> <br>	
			Mobile : <input type="text" name="mobile" value="<%=emp.getMobile() %>"><br>
		    <input type="submit" name="b2" value="UPDATE"><br>
		    <br><br>
		
		</h2>
</form>
</div>
<%} %>
</body>
</html>
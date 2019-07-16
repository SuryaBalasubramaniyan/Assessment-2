package com.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class EmployeeDaoImpl implements EmployeeDao {
	Connection c;
	@Override
	public  boolean checkAdmin(EmployeeBean emp) {
		
		 try {
			 
				//Class.forName("com.mysql.jdbc.Driver");
				 
				String name=emp.getName();
				String pwd=emp.getPassword();
				
					//c = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "Sapient123");
					PreparedStatement ps = c.prepareStatement("select name,password from employee where name=? and password=?");
					ps.setString(1, name);
					ps.setString(2, pwd);
					 System.out.println(name);
					 System.out.println(pwd);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						System.out.println("Account match");
						return true;
					}
				 
				 System.out.println("dao");
				 rs.close();
				 ps.close();
			 } 
		 catch (SQLException e) {
				
				e.printStackTrace();
			} 
			return false;
		
	}

	@Override
	public void connectDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 c = DriverManager.getConnection("jdbc:mysql://localhost/Employee", "root", "Sapient123");
			
		} catch (ClassNotFoundException e) {
			
			
			e.printStackTrace();
		}
		 catch (SQLException e) {
				
				e.printStackTrace();
			} 
		
		
	}

	@Override
	public boolean insert(EmployeeBean emp) {
		try {
			
			
			PreparedStatement preparedStatement=c.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			preparedStatement.setString(1, emp.getName());
			preparedStatement.setString(2, emp.getPassword());
			preparedStatement.setString(3, emp.getRole());
			preparedStatement.setInt(4,emp.getAge());
			preparedStatement.setString(5, emp.getEmail());
			preparedStatement.setInt(6, emp.getMobile());			
			int i=preparedStatement.executeUpdate();
			if(i>0)
			{
				System.out.println("You are successfully registered");
				return true;
			}
			
		preparedStatement.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
		
		
	}
	
	public boolean delete(EmployeeBean emp) {
		//System.out.println(name+"in emp");
		try {
			PreparedStatement stmt=c.prepareStatement("delete from employee where name=? ");
			stmt.setString(1,emp.getName());
			int i=stmt.executeUpdate();
			System.out.println("i:"+i);
		if(i>0){
		 System.out.println("Deleted successfully");
		 return true;
		}
		stmt.close();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public ArrayList<EmployeeBean> display() {
        Statement st;
        ArrayList<EmployeeBean> emplist= new ArrayList<EmployeeBean>();
        int age, mobile;
        String name, password, role,email;
		try {
			
			
			st = c.createStatement();
			ResultSet rs=st.executeQuery("select * from employee;");
			while(rs.next())
			{
				EmployeeBean emp=new EmployeeBean();
				emp.setName(rs.getString(1));
				emp.setPassword(rs.getString(2));
				emp.setRole(rs.getString(3));
				emp.setAge(rs.getInt(4));
				emp.setEmail(rs.getString(5));
				emp.setMobile(rs.getInt(6));
				emplist.add(emp);
		
			}
			rs.close();
			st.close();
				
		} catch (SQLException e) {
						e.printStackTrace();
		}
       return emplist;
		
	}
	
	public EmployeeBean search(String name) {
		try {
			PreparedStatement p=c.prepareStatement("select * from  employee where name=?;");
			p.setString(1, name);
			ResultSet rs = p.executeQuery();
			if(rs.next())
			{
				 EmployeeBean emp=new  EmployeeBean();
				emp.setName(rs.getString(1));
				emp.setPassword(rs.getString(2));
				emp.setRole(rs.getString(3));
				emp.setAge(rs.getInt(4));
				emp.setEmail(rs.getString(5));
				emp.setMobile(rs.getInt(6));
				System.out.println(emp);
				return emp;
		
			}
			rs.close();
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}


	public boolean update(EmployeeBean emp) {
		String update = "update employee set name = ?, password = ?, role = ?, age = ?, email = ?, mobile = ? where name = ?";
		try {
			
		PreparedStatement preparedStatement = c.prepareStatement(update);
		preparedStatement.setString(1, emp.getName());
		preparedStatement.setString(2, emp.getPassword());
		preparedStatement.setString(3, emp.getRole());
		preparedStatement.setInt(4, emp.getAge());
		preparedStatement.setString(5, emp.getEmail());
		preparedStatement.setInt(6, emp.getMobile());
		preparedStatement.setString(7, emp.getName());

		
			if(preparedStatement.execute())
				return true;
			preparedStatement.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
		// TODO Auto-generated method stub
		
	}
}

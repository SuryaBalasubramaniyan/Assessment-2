package com.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ValidateDetails {
	public static boolean validate(int id,String password) {
		boolean status=false;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Employee","root","Sapient123");
			//Statement stmt=conn.createStatement();
			PreparedStatement ps=conn.prepareStatement("select id,password from details where  id=? and password=? ");  
					ps.setInt(1,id);  
					ps.setString(2,password);  
					      
					ResultSet rs=ps.executeQuery();  
					while (rs.next()) {
						System.out.println("Account match");
					status=true;
					}
					//System.out.println("Invalid");
					return status; 
					          
			
			
		}catch(Exception e) {
			System.out.println(e);
			return status;
		}
		
}
}

package com.bean;

import java.util.ArrayList;

public interface EmployeeDao {
	public  boolean checkAdmin(EmployeeBean emp);
	public void connectDatabase();
	public EmployeeBean search(String name);
	public boolean insert(EmployeeBean emp);
	public boolean delete(EmployeeBean emp);
	public ArrayList<EmployeeBean> display();
	public boolean update(EmployeeBean e); 
}

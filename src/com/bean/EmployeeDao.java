package com.bean;

import java.util.ArrayList;

public interface EmployeeDao {
	public  boolean checkAdmin(EmployeeBean emp);
	public void connectDatabase();
	public boolean insert(EmployeeBean emp);
	public void delete(String name);
	public ArrayList<EmployeeBean> display();
}

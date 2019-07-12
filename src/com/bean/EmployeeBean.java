package com.bean;
public class EmployeeBean {
	private String name;
	private String password;
	private String role;
	private int age;
	private String email;
	private int mobile;
	@Override
	public String toString() {
		return "Emp [name=" + name + ", password=" + password + ", role=" + role + ", age=" + age + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	

}

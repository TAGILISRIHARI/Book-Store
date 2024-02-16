package com.pack;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AdminBean implements Serializable
{
	private String adminUname,adminPassword;
	public AdminBean() {}
	
	public String getAdminUname() {
		return adminUname;
	}
	public void setAdminUname(String adminUname) {
		this.adminUname = adminUname;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	
}

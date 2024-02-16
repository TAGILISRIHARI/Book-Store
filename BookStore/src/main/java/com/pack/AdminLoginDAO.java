package com.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDAO 
{
	public AdminBean ab = null;
	public AdminBean login(String userName ,String password)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("select * from Adminbookstore where UNAME=? and PASSWORD=?");
			ps.setString(1, userName);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ab = new AdminBean();
				ab.setAdminUname(rs.getString(1));
				ab.setAdminPassword(rs.getString(2));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ab;
	}
}

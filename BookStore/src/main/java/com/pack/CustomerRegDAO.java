package com.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerRegDAO 
{
	public int k = 0;
	public int registerCustomer(CustomerBean cb)
	{
		try 
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("insert into custmorebookstore57 values(?,?,?,?,?,?,?)");
			ps.setString(1, cb.getuName());
			ps.setString(2, cb.getpWord());
			ps.setString(3, cb.getfName());
			ps.setString(4, cb.getlName());
			ps.setString(5, cb.getMailId());
			ps.setString(6, cb.getAddress());
			ps.setLong(7, cb.getPhNo());
			
			k = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return k;
	}
}

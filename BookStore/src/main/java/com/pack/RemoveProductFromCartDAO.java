package com.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RemoveProductFromCartDAO 
{
	public int k =0;
	public int removeProductFromCart(String bookCode,String userName)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("delete from addtocart57 where CODE=? and CUSTUSERNAME=?");
			ps.setString(1, bookCode);
			ps.setString(2, userName);
			 k = ps.executeUpdate();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return k;
	}
}

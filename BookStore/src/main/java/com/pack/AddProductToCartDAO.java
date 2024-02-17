package com.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProductToCartDAO 
{
	public int k = 0;
	public int addProductToCart(BookBean bb,String userName)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("insert into addtocart57 values(?,?,?,?,?,?)");
			ps.setString(1, bb.getCode());
			ps.setString(2, bb.getName());
			ps.setString(3, bb.getAuthor());
			ps.setLong(4, bb.getPrize());
			ps.setLong(5, bb.getQty());
			ps.setString(6, userName);
			k = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}

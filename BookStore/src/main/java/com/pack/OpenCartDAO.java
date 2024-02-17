package com.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OpenCartDAO 
{
	public ArrayList<BookBean> al = new ArrayList<BookBean>();
	public ArrayList<BookBean> retriveCart(String userName)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("select * from addtocart57 where CUSTUSERNAME=?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			BookBean bb;
			
			while(rs.next())
			{
				bb= new BookBean();
				bb.setCode(rs.getString(1));
				bb.setName(rs.getString(2));
				bb.setAuthor(rs.getString(3));
				bb.setPrize(rs.getLong(4));
				bb.setQty(rs.getLong(5));
				al.add(bb);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
}

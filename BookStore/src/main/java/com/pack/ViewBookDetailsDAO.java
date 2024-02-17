package com.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewBookDetailsDAO 
{
	public ArrayList<BookBean> al = new ArrayList<BookBean>();
	public ArrayList<BookBean> retrive()
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("select * from BookDetails");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				BookBean bookBean = new BookBean();
				bookBean.setCode(rs.getString(1));
				bookBean.setName(rs.getString(2));
				bookBean.setAuthor(rs.getString(3));
				bookBean.setPrize(rs.getLong(4));
				bookBean.setQty(rs.getLong(5));
				al.add(bookBean);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
}

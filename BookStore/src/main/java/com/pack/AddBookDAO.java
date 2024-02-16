package com.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddBookDAO 
{
	public int k=0;
	public int addBook(BookBean bb)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("insert into BookDetails values (?,?,?,?,?)");
			ps.setString(1, bb.getCode());
			ps.setString(2, bb.getName());
			ps.setString(3, bb.getAuthor());
			ps.setLong(4, bb.getPrize());
			ps.setLong(5, bb.getQty());
			
			k = ps.executeUpdate();
			
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return k;
	}

}

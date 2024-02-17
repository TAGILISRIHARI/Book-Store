package com.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteBookDetailsDAO 
{
	public int k = 0;
	public int delete(String bookCode)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("delete from BookDetails where CODE=?");
			ps.setString(1, bookCode);
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

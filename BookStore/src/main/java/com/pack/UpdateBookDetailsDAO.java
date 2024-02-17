package com.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateBookDetailsDAO 
{
	public int k=0;
	public int update(BookBean bb)
	{
		try 
		{
				Connection con = DBConnection.getCon();
				PreparedStatement ps = con.prepareStatement
						("Update BookDetails set PRIZE=? ,QTY=? where CODE=?");
				ps.setLong(1,bb.getPrize());
				ps.setLong(2, bb.getQty());
				ps.setString(3, bb.getCode());
				
				k = ps.executeUpdate();
				
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return k;
	}
}

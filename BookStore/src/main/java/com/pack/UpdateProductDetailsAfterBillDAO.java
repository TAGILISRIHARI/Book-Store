package com.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductDetailsAfterBillDAO 
{
	public void updateProductAfterBill(long reqQty,String bCode)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("update BOOKDETAILS set QTY=QTY-? where CODE = ?");
			ps.setLong(1, reqQty);
			ps.setString(2, bCode);
			int k = ps.executeUpdate();
			System.out.println(k);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

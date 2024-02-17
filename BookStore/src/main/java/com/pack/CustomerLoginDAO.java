package com.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerLoginDAO 
{
		public CustomerBean cb = null;
		public CustomerBean loginCustomer(String uName , String password)
		{
			try 
			{
				Connection con = DBConnection.getCon();
				PreparedStatement ps = con.prepareStatement
						("select * from custmorebookstore57 where USERNAME=? and PASSWORD=?");
				ps.setString(1, uName);
				ps.setString(2, password);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					 cb = new CustomerBean();
					cb.setuName(rs.getString(1));
					cb.setpWord(rs.getString(2));
					cb.setfName(rs.getString(3));
					cb.setlName(rs.getString(4));
					cb.setMailId(rs.getString(5));
					cb.setAddress(rs.getString(6));
					cb.setPhNo(rs.getLong(7));
					
				}
			} 
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return cb;
			
		}
}	

package com.pack;

import static com.pack.DBInfo.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
	public static Connection con = null;
	
	private DBConnection() {}
	
	static
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(dbUrl, uName, pWord);
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static Connection getCon()
	{
		return con;
	}
	
}

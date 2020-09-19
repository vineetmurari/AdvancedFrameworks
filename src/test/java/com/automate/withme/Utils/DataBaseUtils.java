package com.automate.withme.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseUtils {

	public static List<String> Get_data(){
		List<String> result = new ArrayList<String>();
	try{  
		
		Class.forName("com.mysql.jdbc.Driver"); 
		
		/***
		 * 
		 * 1)URI with Port and DB
		 * 2)User name
		 * 3)password
		 * 
		 * 
		 */
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineFruits","root","123");  
		
		Statement stmt=con.createStatement();  
		
		ResultSet rs=stmt.executeQuery("select * from user");  
		
		while(rs.next()) {
			result.add(rs.getString(1));
			result.add(rs.getString(2));
		}
		//System.out.println(rs.getString(1)+"  "+rs.getString(2)); 
		
		con.close();  
		}
	catch(Exception e)
	{ 
			System.out.println(e);
			
	}  
	return result;
	}	
}

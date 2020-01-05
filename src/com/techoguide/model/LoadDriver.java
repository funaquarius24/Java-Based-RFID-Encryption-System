package com.techoguide.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Statement;

// Notice, do not import com.mysql.cj.jdbc.*
// or you will have problems!

public class LoadDriver {
	
	public Connection load() throws SQLException
	{
		Connection conn = null;
    	//...
		String database = Constants.DATABASE_NAME;
    	try {
    		//conn = DriverManager.getConnection("jdbc:mysql://localhost/test1?" +
    		//	                                   "user=root&password=");
    		conn = DriverManager.getConnection( 
    				String.format( "jdbc:mysql://localhost/%s?user=root&password=" , database) );
    	    return conn;

    	} catch (SQLException ex) {
    		if(ex.getErrorCode() == 1149)
    		{
    			System.out.printf
    			("No database named %s. A new database will now be created. The database needs to be created first.\n"
    					+ " You can find the code to create a new databse in the test package.", database);
    			
    		}
    		throw new SQLException();
    	}
	}
}
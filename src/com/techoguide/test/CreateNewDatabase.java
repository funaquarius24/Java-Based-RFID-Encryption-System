package com.techoguide.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.techoguide.model.Constants;

public class CreateNewDatabase {

	public static void main(String[] args) {
		
		Connection conn = null;
    	//...
		String database = Constants.DATABASE_NAME;
    	try {
    		//conn = DriverManager.getConnection("jdbc:mysql://localhost/test1?" +
    		//	                                   "user=root&password=");
    		conn = DriverManager.getConnection( 
    				String.format( "jdbc:mysql://localhost/%s?user=root&password=" , database) );
    		
    		
			String sql = String.format("CREATE DATABASE %s", database);
			PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.executeUpdate(sql);
		    System.out.println("Database created successfully...");

    	} catch (SQLException ex) {
    		ex.printStackTrace();
    	}

	}

}

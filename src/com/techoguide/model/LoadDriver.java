package com.techoguide.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class LoadDriver {
	
	public Connection load() throws SQLException
	{
		Connection conn = null;
    	//...
    	try {
    	    conn =
    	       DriverManager.getConnection("jdbc:mysql://localhost/test?" +
    	                                   "user=root");
    	    return conn;

    	   //...
    	} catch (SQLException ex) {
    		throw new SQLException();
    	}
	}
}
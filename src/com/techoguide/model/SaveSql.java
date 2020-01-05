package com.techoguide.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.BitSet;

public class SaveSql {
	
	Statement stmt;
	private Connection conn;
	
	public SaveSql( Connection conn )
	{
		this.conn = conn;
	}
	
	public void save( String statement ) throws SQLException
	{
		try {
    	    stmt = conn.createStatement();
    	        
    	       System.out.println( 583874387 );

    	    // Now do something with the ResultSet ....
    	}
    	catch (SQLException ex){
    	    throw new SQLException();
    	}
    	finally {

    	    if (stmt != null) {
    	        try {
    	            stmt.close();
    	        } catch (SQLException sqlEx) { } // ignore

    	        stmt = null;
    	    }
    	}
	}
	
	public void saveToKeyTable
	( String name, String info, ArrayList<String> baseTokens, 
			ArrayList<String> baseIndicators, BitSet token, BitSet indicator ) 
			throws SQLException
	{
		String sql = "INSERT INTO keys (Name, Info, BaseTokens, BaseIndicators, Token, Indicator ) VALUES (?, ?, ?, ?, ?, ?)";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, name);
		statement.setString(2, info);
		statement.setObject(3, baseTokens);
		statement.setObject(4, baseIndicators);
		statement.setObject(3, token);
		statement.setObject(4, indicator);
		 
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("A new user was inserted successfully!");
		}
	}
	
	public void saveToHashTable
	( int keyID, BitSet token ) 
			throws SQLException
	{
		String sql = "INSERT INTO keys (Name, Info, BaseTokens, BaseIndicators, Token, Indicator ) VALUES (?, ?, ?, ?, ?, ?)";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, keyID);
		statement.setObject(2, token);
		 
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("A new user was inserted successfully!");
		}
	}
	
	public void saveToHashTable1()
	{
		
	}

}

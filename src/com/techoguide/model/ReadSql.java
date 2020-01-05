package com.techoguide.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadSql {
	
	ResultSet rs;
	Statement stmt;
	private Connection conn;
	
	public ReadSql( Connection conn )
	{
		this.conn = conn;
	}
	
	
	public void read( String statement )
	{
		try {
    	    stmt = conn.createStatement();
    	    //rs = stmt.executeQuery("SELECT foo FROM bar");

    	    // or alternatively, if you don't know ahead of time that
    	    // the query will be a SELECT...

    	    if (stmt.execute("SELECT keyID FROM test1.keys")) {
    	        rs = stmt.getResultSet();
    	        
    	       System.out.println( 583874387 );
    	    }

    	    // Now do something with the ResultSet ....
    	}
    	catch (SQLException ex){
    	    // handle any errors
    	    System.out.println("SQLException: " + ex.getMessage());
    	    System.out.println("SQLState: " + ex.getSQLState());
    	    System.out.println("VendorError: " + ex.getErrorCode());
    	}
    	finally {
    	    // it is a good idea to release
    	    // resources in a finally{} block
    	    // in reverse-order of their creation
    	    // if they are no-longer needed

    	    if (rs != null) {
    	        try {
    	            rs.close();
    	        } catch (SQLException sqlEx) { } // ignore

    	        rs = null;
    	    }

    	    if (stmt != null) {
    	        try {
    	            stmt.close();
    	        } catch (SQLException sqlEx) { } // ignore

    	        stmt = null;
    	    }
    	}
	}

}

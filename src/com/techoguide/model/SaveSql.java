package com.techoguide.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import com.google.gson.Gson;
import com.techoguide.device.Tag;
import com.techoguide.rabin.Rabin;

public class SaveSql {
	
	Statement stmt;
	private Connection conn;
	private ResultSet rs;
	
	private String keyTable = Constants.KEY_TABLE_NAME;
	private String hashTable = Constants.HASH_TABLE_NAME;
	private String database = Constants.DATABASE_NAME;
	
	public SaveSql( Connection conn )
	{
		this.conn = conn;
	} 
	
	public void save( Tag tag ) throws SQLException
	{
		try {
    	    stmt = conn.createStatement();
    	    
    	    long tokenDecimal = getBitSetValue( tag.getKeys().get( 0 ) ); 
    	    System.out.println( tokenDecimal );
    	    long signedToken = Rabin.getRabin( tokenDecimal );
    	    
    	    //System.out.println( rabinKey );
    	    
    	    int keyID = saveToKeyTable( tag.getName() , tag.getInfo(), tag.getBaseTokens(), tag.getBaseIndicators(), signedToken, tag.getKeys().get( 1 ) );
    	    saveToHashTable(keyID, signedToken );
    	    
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
	
	public int saveToKeyTable
	( String name, String info, List<BitSet> baseTokens, 
			List<BitSet> baseIndicators, long signedToken, BitSet indicator ) 
	{
		//String sql = "INSERT INTO test1.keys1 (Name, Info, base_tokens, base_indicators, Token, Indicator ) VALUES (?, ?, ?, ?, ?, ?);";
		
		String sql = String.format
				( "INSERT INTO %s.%s (Name, Info, base_tokens, base_indicators, Token, Indicator ) VALUES (?, ?, ?, ?, ?, ?);" , 
						database, keyTable);
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			List< Long > baseTokensDecimal = new ArrayList<>();
			for( int i = 0; i < baseTokens.size(); i++ )
			{
				baseTokensDecimal.add( getBitSetValue( baseTokens.get( i ) ) );
			}
			
			List< Long > baseIndicatorsDecimal = new ArrayList<>();
			for( int i = 0; i < baseTokens.size(); i++ )
			{
				baseIndicatorsDecimal.add( getBitSetValue( baseIndicators.get( i ) ) );
			}
			
			//long tokenDecimal = getBitSetValue( token );
			long indicatorDecimal = getBitSetValue( indicator );
			
			Gson gson = new Gson();
			String baseTokensDecimalJson = gson.toJson( baseTokensDecimal );
			String baseIndicatorsDecimalJson = gson.toJson( baseIndicatorsDecimal );
			
			
			statement.setString(1, name);
			statement.setString(2, info);
			statement.setString(3, baseTokensDecimalJson);
			statement.setString(4, baseIndicatorsDecimalJson);
			statement.setLong(5, signedToken);
			statement.setLong(6, indicatorDecimal);
			 
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    //System.out.println("A new user was inserted successfully!" + rowsInserted);
			    
			    int autoIncKeyFromFunc = -1;
			    rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");

			    if (rs.next()) {
			        autoIncKeyFromFunc = rs.getInt(1);
			        return autoIncKeyFromFunc;
			    } else {
			        System.err.println("Error: unable to get LAST_INSERT_ID");
			    }
			}
			else System.err.println( "No row was inserted" );
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return 0;
	}
	
	public void saveToHashTable
	( int keyID, long signedToken ) 
	{
		//String sql = "INSERT INTO test1.crypto_table (Cipher, keyID ) VALUES (?, ?);";
		String sql = String.format( "INSERT INTO %s.%s (Cipher, keyID ) VALUES (?, ?);" , database, hashTable );
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			//long tokenDecimal = getBitSetValue( token );
			
			statement.setLong(1, signedToken);
			statement.setInt(2, keyID);
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    
			}
			else System.err.println( "No row was inserted" );
		}catch( SQLException ex )
		{
			//1146
			//System.out.println("teeeee " + ex.getErrorCode());
			ex.printStackTrace();
		}
	}
	
	public void saveAll( List<Tag> tags ) throws SQLException
	{
		try {
    	    stmt = conn.createStatement();
    	        
    	       System.out.println( 583874387 );

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
	
	
	public static long getBitSetValue(BitSet target)
	{
		long value = 0;
		for(int i = 0; i < target.size(); i++)
		{
			if(target.get(i))
				value |= 1 << i;
		}
		return value;
	}

}

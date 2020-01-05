package com.techoguide.init;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import com.techoguide.device.Tag;
import com.techoguide.model.LoadDriver;
import com.techoguide.model.ReadSql;
import com.techoguide.model.SaveSql;

public class Test {
	private static int numberOfTags = 1000;
	private static int numberOfBaseTokens = 4;
	private static int numberOfBaseIndicators = 4;
	private static LoadDriver loadDriver;
	private static DataGenerator generator;
	
	public static void main( String[] args )
	{
		generator = new DataGenerator();
		List<List<BitSet>> data = generator.generateRandomKeys( numberOfTags );
		data.forEach( test -> {System.out.println( test );} );
		loadDriver = new LoadDriver();
		
		try {
			Connection conn = loadDriver.load();
		
		
			ReadSql sqlReader = new ReadSql( conn );
			SaveSql saveSql = new SaveSql( conn );
			//sqlReader.read( "jdhfj" );
			
			Tag tag;
			List<Tag> tagList = new ArrayList<Tag>();
			int count = 0;
			
			for( List< BitSet > test : data )
			{
				tag = new Tag();
				
				tag.setName( String.format( "Tag %d" , count) ).setKeys( test );
				tagList.add( tag );
				count++;
			}
			
			System.out.println( tagList.size() );
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

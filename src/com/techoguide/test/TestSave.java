package com.techoguide.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import com.techoguide.device.Tag;
import com.techoguide.init.DataGenerator;
import com.techoguide.model.LoadDriver;
import com.techoguide.model.ReadSql;
import com.techoguide.model.SaveSql;

public class TestSave {
	private static int numberOfTags = 10;
	
	private static LoadDriver loadDriver;
	private static DataGenerator generator;
	static SaveSql saveSql;
	
	public static void main( String[] args )
	{
		generator = new DataGenerator();
		List<BitSet> tagData = generator.generateRandomTokens( numberOfTags );
		//data.forEach( test -> {System.out.println( test );} );
		loadDriver = new LoadDriver();
		try {
			Connection conn = loadDriver.load();
			
			//ReadSql sqlReader = new ReadSql( conn );
			saveSql = new SaveSql( conn );
			//sqlReader.read( "jdhfj" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println( e.getErrorCode() );
		}
		
		
		Tag tag;
		List<Tag> tagList = new ArrayList<Tag>();
		int count = 0;
		
		for( BitSet test : tagData )
		{
			tag = new Tag();
			List<BitSet> tmp = new ArrayList<>();
			tmp.add( test );
			tmp.add( generator.generateIndicator() );
			List<List<BitSet>> baseTokenIndicators = generator.generateBaseTokenIndicators();
			
			tag.setName( String.format( "Tag %d" , count) ).setKeys( tmp ).
			setBaseIndicators( baseTokenIndicators.get( 1 ) ).setBaseTokens( baseTokenIndicators.get( 0 ) );
			tagList.add( tag );
			count++;
		}
		
		if( saveSql != null )
		{
			try {
				for( int i = 0; i < tagList.size(); i++ )
				{
					saveSql.save( tagList.get( i ) );
				}
			} catch (SQLException e) {
				e.printStackTrace();
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

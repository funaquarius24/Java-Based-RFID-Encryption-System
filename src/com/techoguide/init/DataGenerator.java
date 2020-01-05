package com.techoguide.init;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import com.techoguide.bitset.generator.TokenIndicatorGenerator;

public class DataGenerator {
	
	public List<List<BitSet>> generateRandomKeys( int numberOfTokens ) {
		TokenIndicatorGenerator generator = new TokenIndicatorGenerator();
		List< List<BitSet> > result = new ArrayList<>();
		
		
		for( int i = 0; i < numberOfTokens; i++ )
		{
			BitSet re;
			List<BitSet> tmp = new ArrayList<>();
			do
			{
				re = generator.generate(); //generating the token
			}while( result.contains( (Object)re ) );
			tmp.add( re );
			tmp.add( generator.generate() );//the indicator for this token
			
			result.add( tmp );
			
		}
		
		return result;
	}

}

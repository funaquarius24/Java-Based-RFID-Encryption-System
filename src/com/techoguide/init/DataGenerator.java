package com.techoguide.init;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import com.techoguide.bitset.generator.BaseTokenIndicatorGenerator;
import com.techoguide.bitset.generator.TokenIndicatorGenerator;

public class DataGenerator {
	
	public List<BitSet> generateRandomTokens( int numberOfTokens ) {
		TokenIndicatorGenerator generator = new TokenIndicatorGenerator();
		List<BitSet> result = new ArrayList<>();
		
		
		for( int i = 0; i < numberOfTokens; i++ )
		{
			BitSet re;
			do
			{
				re = generator.generate(); //generating the token
			}while( result.contains( (Object)re ) );
			result.add( re );
			
		}
		
		return result;
	}
	
	public BitSet generateIndicator()
	{
		TokenIndicatorGenerator generator = new TokenIndicatorGenerator();
		BitSet ind = generator.generate();
		return ind;
	}
	
	public List<List<BitSet>> generateBaseTokenIndicators() {
		BaseTokenIndicatorGenerator generator = new BaseTokenIndicatorGenerator();
		List< List<BitSet> > result = generator.generate();
		
		
		
		
		return result;
	}

}

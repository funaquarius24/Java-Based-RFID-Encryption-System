package com.techoguide.bitset.generator;

import java.util.BitSet;
import java.util.Random;

import com.techoguide.model.Constants;

public class TokenIndicatorGenerator {
	
	private static final int BASE_LEN = Constants.BASE_LEN;
	
	public BitSet generate(){
		Random rand = new Random();
		BitSet set = new BitSet();
		
		for( int i = 0; i < BASE_LEN; i++ )
		{
			set.set( i ,  rand.nextBoolean() );
		}
		
		
		return set;
	}

}

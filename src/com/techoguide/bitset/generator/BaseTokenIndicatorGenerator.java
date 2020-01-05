package com.techoguide.bitset.generator;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

import com.techoguide.model.Constants;

public class BaseTokenIndicatorGenerator {
	
	
	private static final int BASE_LEN = Constants.BASE_LEN;
	private static final int BASE_TOKENS = Constants.BASE_TOKENS;
	private static final int BASE_INDICATORS = Constants.BASE_INDICATORS;
	
	

	public List<List<BitSet>> generate()
	{
		Random rand = new Random();
		//BitSet baseTokenSet = new BitSet();
		//BitSet baseIndicatorSet = new BitSet();
		
		List<BitSet> baseTokenSetList = new ArrayList<>();
		List<BitSet> baseIndicatorSetList = new ArrayList<>();
		
		for( int i = 0; i < BASE_TOKENS; i++ )
		{
			BitSet baseTokenSet = new BitSet();
			for (int j = 0; j < BASE_LEN; j++) {
				baseTokenSet.set(j, rand.nextBoolean());
			} 
			baseTokenSetList.add( baseTokenSet );
		}
		
		for( int i = 0; i < BASE_INDICATORS; i++ )
		{
			BitSet baseIndicatorSet = new BitSet();
			for (int j = 0; j < BASE_LEN; j++) {
				baseIndicatorSet.set(j, rand.nextBoolean());
			} 
			baseIndicatorSetList.add( baseIndicatorSet );
		}
		
		List< List< BitSet > > keysList = new ArrayList<>();
		keysList.add( baseTokenSetList );
		keysList.add( baseIndicatorSetList );
		
		return keysList;
	}
	
	public static int getBitSetValue(BitSet target, int len)
	{
		int value = 0;
		for(int i = 0; i < len; i++)
		{
			if(target.get(i))
				value |= 1 << i;
		}
		return value;
	}

}

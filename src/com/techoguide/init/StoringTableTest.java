package com.techoguide.init;

import java.util.BitSet;
import java.util.HashMap;

public class StoringTableTest {
	
	HashMap< Integer, BitSet> table;// = new HashMap<>();
	float loadFactor;
	
	public StoringTableTest()
	{
		table = new HashMap<>();
	}
	
	public StoringTableTest( int capacity, int loadFactor )
	{
		this.loadFactor = loadFactor;
		table = new HashMap<>( capacity, loadFactor );
	}
	
	public StoringTableTest( int capacity )
	{
		table = new HashMap<>( capacity );
	}
	
	
	
	public void store( BitSet token )
	{
		
	}
	
	public static int getValue(BitSet target, int len)
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

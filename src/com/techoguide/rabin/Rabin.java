package com.techoguide.rabin;

import java.util.ArrayList;

public class Rabin {
	private static long p = 95287;
	private static long q = 87257;
	private static long n = p * q;
	
	public static long getRabin( long data )
	{
		Encryption e=new Encryption();
		ArrayList<Long> cipher = e.Encrypt(data, n);
		
		return cipher.get( 0 );
	}

}

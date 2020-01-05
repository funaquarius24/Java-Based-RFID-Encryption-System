package com.techoguide.rabin;
import java.io.Console;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class TestRabin 
{
    
	public static void main(String[] args) 
       {
		     Scanner scan = new Scanner(System.in);
//     -------------------------------Group-13 TESTING RANDOM NUMBER GENERATOR-----------------------------------------------------------------------------------------------------------------------------------------------------------------      
//		     RandomNumber R = new RandomNumber(1000);
//           System.out.println("Random no Generated = "+R.nextValue()+"\n");
//	    -------------------------------Group-13 TESTING RANDOM PRIME GENERATOR-------------------------------------------------------------------------------------------------------------------------
//           RandomPrime prime = new RandomPrime();
//		     System.out.println("prime : "+prime.generatePrime());
//		---------------------------Group-13 TESTING BINARY GENERATOR-----------------------------------------------------------------------------------------------------------------------------------
//		     BinaryGenerator b = new BinaryGenerator();
//		     long x = 100;
//		     System.out.println("Input = "+x);
//		     ArrayList<Integer> temp = b.GenerateBinaryFormat(x);
//           System.out.println("Binary value = "+temp.toString());
//		     DecimalGenerator d = new DecimalGenerator();
//           long d1 = d.getDecimal(temp);
//           System.out.println("Decimal Value Back Again = "+d1);
//           long d2 = d.getPresetAddedDecimal(temp);
//           System.out.println("Preset Added Decimal = "+d2);
		
//		---------------------------------Group-13 TESTING EXTENDED EUCLIDEAN-----------------------------------------------------------------------------------------       
//				ExtendedEuclid eeuclid = new ExtendedEuclid();
//				long p = 23, q= 31;
//				eeuclid.compute(p, q);
//				long invp = eeuclid.getx();
//				if(invp<0){invp = q+ invp;}
//				long invq = eeuclid.gety();
//				if(invq<0){invq = p+ invq;}
//      ----------------------------------------------------------------------------------------------------------------------------------				
		     
		long n=0,p=0,q=0;
		//p = 2927, 35279;
		//q = 7927 , 21601;
		p = 95287;
		q = 87257;
		n = p * q;
		//long msg = scan.nextLong();
           
//		long p = 79, q= 43;
//		long msg = 200,n=3397;
		
		HashMap< Long, BitSet> map = new HashMap<>(65536);
		//Set<Long> set = new HashSet<>();
		
		int counter = 0;
		long init = System.currentTimeMillis();
		long en = 0;
		for( int i = 0; i < 70_000; i++ )
		{
			Encryption e=new Encryption();
			ArrayList<Long> cipher = e.Encrypt(i, n);
			long tmp = cipher.get( 0 ) / 64;
			long key = (long) Math.sqrt( tmp );
			//set.add( cipher.get( 0 ) );
			if( map.containsKey( cipher.get( 0 ) ) )
			{
				counter++;
				System.out.println( i + ": " + "cipher: " + cipher.get( 0 ) );
				System.out.println( cipher.size() );
			}
			else
			{
				map.put( cipher.get( 0 ) ,  getBitSet( cipher.get(0) ) );
			}
			
			
			//System.out.printf( "%d: cipher: %d  key: %d.%n", i, cipher.get( 0 ), key );	
			//System.out.println( "Bitset: " + getBitSet( cipher.get(0) ) );
		}
		
		map.remove( 7512449131L );
		if( map.containsKey( (Object)86857348 ) )
		{
			System.out.println( "ok..." );
		}
		
		System.out.println( System.currentTimeMillis() - init );
		System.out.println( counter );
		//System.out.println( "SetSize: " + set.size() );
		System.out.println( "MapSize: " + map.size() );
		//System.out.println( map );
		
       }
	
	public static BitSet getBitSet(long num){
		BitSet bits = new BitSet();
	    int index = 0;
	    while (num != 0L) {
	      if (num % 2L != 0) {
	        bits.set(index);
	      }
	      ++index;
	      num = num >>> 1;
	    }
	    return bits;
	} 
}

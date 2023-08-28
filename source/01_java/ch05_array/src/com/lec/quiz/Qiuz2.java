package com.lec.quiz;

public class Qiuz2 {
	public static void main(String[] args) {
		
		int[]arr = {10,20,30,40,50} ;
		int tot = 0;
		for(int i=0; i<arr.length; i++ ) {
			tot += i;
			
			System.out.println(arr[i]);
			
			if( i!= arr.length-1) {
			 System.out.printf("+");
			 
		}
		
	}
}
}
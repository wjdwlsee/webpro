package com.lec.ex;
public class varEx04 {
     public static void main(String[] args) {
		int i =40; // 4bite
		long l =220000000L; // 8byte
		System.out.println("l = " +l);
		boolean b = true; // 1byte (true/false)
		System.out.println("b =" +b);
		//실수는 double이 기본
		float f = 3.1415926539f; // 4byte
		double d = 3.1415926539;
		System.out.println("f = " + f);
		System.out.println("d = " + d);
		if (f == d) {
			System.out.println("f와 d가 다르다");	
		}else {
			System.out.println("f와 d가 다르다");
		} 	
		f = 10.1f;
		d = 10.1;
		System.out.println("f = " + f);
		System.out.println("d = " + d);
		if (f == d) {
			System.out.println("f와 d가 다르다");	
		}else {
			System.out.println("f와 d가 다르다");
		} 	
		double result = d + 1; // 8byt + 4byte => 8byte
		System.out.println("d+1 =" + result);
		i = 3;
		System.out.println("i/2 = "+ (i/2.0));
     }
}
     
     
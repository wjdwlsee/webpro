package com.lec.method;

import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
			int su;
			do {
				System.out.println("¸î´Ü?");
				su = scanner.nextInt();
			
			}while(su<2 || su>9) ;
			
			
			
			    Quiz_mathod.sum(su);
			
			    
			
			
			scanner.close();
	}
}

package com.lec.quiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력하세요 :");
		int su = sc.nextInt(); // 키보드로부터 입력받은 수를 su에 할당
		System.out.print("수를 입력하세요 :");
		int su2 = sc.nextInt(); // 키보드로부터 입력받은 수를 su에 할당
		boolean result =  () "o" : "x";
		System.out.printf("%d %s %d 는 %b\n", su, "==", su2, result);
		result = (su >= su2);
		System.out.printf("%d %s %d 는 %b\n", su, ">=", su2, result);	
	}
		
}	


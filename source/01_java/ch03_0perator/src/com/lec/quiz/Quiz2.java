package com.lec.quiz;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args ) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력하세요 :");
		int su = sc.nextInt(); //키보드로부터 입력받은 수를 su에 할당
		String result = (su%2==0) ? "짝수입니다":"홀수입니다";
	}
}
	
		
	
	
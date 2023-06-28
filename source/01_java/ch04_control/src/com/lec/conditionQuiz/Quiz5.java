package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("현재 몇 월 인가요?");
		int month = scanner.nextInt();
	
		switch(month){
	case 12: case 1: case 2:
		System.out.println("겨울이네요");break;
	case 3: case 4: case 5:
		System.out.println("봄이네요");break;
	case 6: case 7: case 8:
		System.out.println("여름이네요");break;
	case 9: case 10: case 11:
		System.out.println("가을이네요");break;
	default:
		System.out.println("유효한 개월 수가 아닙니다.");
		scanner.close();
		}
}
}
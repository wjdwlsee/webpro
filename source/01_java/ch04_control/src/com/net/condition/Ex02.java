package com.net.condition;

import java.util.Scanner;

//두수를 입력받아 몇번쨰 수가 얼마만큼 더 큰지 출력
public class Ex02 {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.print("첫번째 수는 : ");
	int num1 = scanner.nextInt();
	System.out.print("두번째 수는 : ");
	int num2 = scanner.nextInt();
	System.out.print("두번째 수는 : ");
	if (num1>num2) {
		System.out.printf("첫번째 수(%d)가%d만큼 더 큽니다\n" , num1, (num1-num2));
	}else if(num2>num1) {
		System.out.printf("두번째 수(%d)가%d만큼 더 큽니다\n" , num1, (num2-num1));
	}else {
		System.out.print("두 수가 같습니다 ");
	}
	scanner.close();
}
}

package com.lec.loopQuiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�����ܼ��� �Է��ϼ���");
		int su = scanner.nextInt();
		for(int i=1 ; i<=9 ; i++ ) {
			
			System.out.println(su + "*" + i + "=" + (su*i));// ("%d)
			
		}
		scanner.close();
	}
}
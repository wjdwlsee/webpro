package com.lec.conditionQuiz;

import java.util.Scanner;

//����ڷκ��� ���� �Է¹޾� ���밪 ���(ex.-5�� �Է��ϸ� 5�� ���)
public class Quiz1 {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� :");
		int su = 0;
		if(su >= 0) {
			System.out.println("�Է��Ͻ� ���� ���밪��" + su);
		}else {
			System.out.println("�Է��Ͻ� ���� ������ + (-su)");
		scanner.close();	
	}
	}
}
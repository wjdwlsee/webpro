package com.lec.quiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է��ϼ��� :");
		int su = sc.nextInt(); // Ű����κ��� �Է¹��� ���� su�� �Ҵ�
		System.out.print("���� �Է��ϼ��� :");
		int su2 = sc.nextInt(); // Ű����κ��� �Է¹��� ���� su�� �Ҵ�
		boolean result =  () "o" : "x";
		System.out.printf("%d %s %d �� %b\n", su, "==", su2, result);
		result = (su >= su2);
		System.out.printf("%d %s %d �� %b\n", su, ">=", su2, result);	
	}
		
}	


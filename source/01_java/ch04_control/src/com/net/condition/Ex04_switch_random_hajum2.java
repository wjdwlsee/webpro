package com.net.condition;

import java.util.Scanner;
//��������(0~100)�� �Է¹޾� ���� ���
public class Ex04_switch_random_hajum2 {
	public static void main(String[] args) {
		//0<= math.random() <1 �Ǽ����� �߻�
		//0<= math.random() <1 �Ǽ� ���� �߻�
		//0<= (int)(Math.random() * 101); < 101��������
		int score = (int)(Math.random() * 101);
 		System.out.println("���� : " + score);
		
		switch(score/10) {
		case 10 :     case 9 :
			System.out.println("A"); break;
		case 8:
			System.out.println("B"); break;
		case 7:
			System.out.println("c"); break;
		case 6 :
		System.out.println("D"); break;
		default : 
			System.out.println("F"); break;
			}
	}//main


}


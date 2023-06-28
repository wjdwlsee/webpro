package com.net.condition;

import java.util.Scanner;
//랜덤점수(0~100)을 입력받아 학점 출력
public class Ex04_switch_random_hajum2 {
	public static void main(String[] args) {
		//0<= math.random() <1 실수난수 발생
		//0<= math.random() <1 실수 난수 발생
		//0<= (int)(Math.random() * 101); < 101정수난수
		int score = (int)(Math.random() * 101);
 		System.out.println("점수 : " + score);
		
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


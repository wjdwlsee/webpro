package com.net.condition;

import java.util.Scanner;
//사용자로부터 점수(0~100)을 입력받아 학점 출력
public class Ex04_if_hajum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수(0~100) ? ");
		int score = sc.nextInt();
		if( (90<=score)  && (score<=100) ) {
			System.out.println("A");
		}else if ( (80<=score)  && (score<=90) ) {
			System.out.println("B");
		}else if ( (70<=score)  && (score<=80) ) {
			System.out.println();
		}else if ( (60<=score)  && (score<=70) ) {
				System.out.println("C");
		}else if ( (50<=score)  && (score<=60) ) {
			System.out.println("D");
		}else if ( (40<=score)  && (score<=50) ) {
			System.out.println("F");
		}//if
			sc.close();
		}//main
}


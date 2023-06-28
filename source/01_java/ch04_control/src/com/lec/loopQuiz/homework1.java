package com.lec.loopQuiz;

import java.util.Scanner;

public class homework1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("가위(0), 바위(1), 보자기(2), 종료(-1) 중 숫자 하나를 선택하세요 :");
		int you = scanner.nextInt(); sum = 0; //0,1,2,-1 sum=0
		int computer = (int) (Math.random()*3); //0,1,2,-1중 한 난수	 
		String youStr = (you ==0) ? "가위" : (you==1) ? "바위" : "보자기";
		String computerStr = (computer==0)? "가위" : (computer==1)? "바위":"보자기";
		if(you>2 || you<-1) {
			 System.out.println ("잘못 입력하심");
			 System.exit(0);// 프로그램 강제 종료
			}		
		System.out.println("장신은" + youStr + ", 컴퓨터는 " + computerStr);
		//당신이 이겼습니다 || 텀퓨터가 이겼습니다 || 비겼습니다 출력 
		if( (you+2)%3 == computer) {
			System.out.println("당신이 이겼습니다");
		}else if (you == computer) {
			System.out.println("당신이 이겼습니다");
		}else {
			System.out.println("컴퓨터가 이겼습니다 ");
		
			while(you<=2,  ) 
		scanner.close();	
	}
       
}


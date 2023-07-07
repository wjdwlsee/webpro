package com.lec.loopQuiz;

import java.util.Scanner;

public class homework1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("가위(0), 바위(1), 보자기(2), 중 숫자 하나를 선택하세요 (종료:-1):");
			int you = scanner.nextInt();  //0,1,2,
			if(you==-1)break;
			int computer = (int) (Math.random()*3); //0,1,2,-	 
			String youStr = (you ==0) ? "가위" : (you==1) ? "바위" : "보자기";
			String computerStr = (computer==0)? "가위" : (computer==1)? "바위":"보자기";
			if(you>2 || you<-1) {
				 System.out.println ("잘못 입력하심");
				 continue; //조건식 부분으로 감
				}		
			System.out.println("장신은" + youStr + ", 컴퓨터는 " + computerStr);
			//당신이 이겼습니다 || 텀퓨터가 이겼습니다 || 비겼습니다 출력 
			if( (you+2)%3 == computer) {
				System.out.println("당신이 이겼습니다");
			}else if (you == computer) {
				System.out.println("당신이 이겼습니다");
			}else {
				System.out.println("컴퓨터가 이겼습니다 ");
			
		}
		}     
		scanner.close();	
	}
}


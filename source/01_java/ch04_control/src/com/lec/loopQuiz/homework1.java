package com.lec.loopQuiz;

import java.util.Scanner;

public class homework1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("����(0), ����(1), ���ڱ�(2), ����(-1) �� ���� �ϳ��� �����ϼ��� :");
		int you = scanner.nextInt(); sum = 0; //0,1,2,-1 sum=0
		int computer = (int) (Math.random()*3); //0,1,2,-1�� �� ����	 
		String youStr = (you ==0) ? "����" : (you==1) ? "����" : "���ڱ�";
		String computerStr = (computer==0)? "����" : (computer==1)? "����":"���ڱ�";
		if(you>2 || you<-1) {
			 System.out.println ("�߸� �Է��Ͻ�");
			 System.exit(0);// ���α׷� ���� ����
			}		
		System.out.println("�����" + youStr + ", ��ǻ�ʹ� " + computerStr);
		//����� �̰���ϴ� || ��ǻ�Ͱ� �̰���ϴ� || �����ϴ� ��� 
		if( (you+2)%3 == computer) {
			System.out.println("����� �̰���ϴ�");
		}else if (you == computer) {
			System.out.println("����� �̰���ϴ�");
		}else {
			System.out.println("��ǻ�Ͱ� �̰���ϴ� ");
		
			while(you<=2,  ) 
		scanner.close();	
	}
       
}


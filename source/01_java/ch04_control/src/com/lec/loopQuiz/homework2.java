package com.lec.loopQuiz;

import java.util.Scanner;

public class homework2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("����(0), ����(1), ���ڱ�(2), �� ���� �ϳ��� �����ϼ��� (����:���������):");
			int you = scanner.nextInt();  //0,1,2
			int computer = (int) (Math.random()*3); //0,1,2
			String youStr = (you ==0) ? "����" : (you==1) ? "����" : "���ڱ�";
			String computerStr = (computer==0)? "����" : (computer==1)? "����":"���ڱ�";
			if(you>2 || you<-1) {
				 System.out.println ("�߸� �Է��Ͻ�");
				 continue; //���ǽ� �κ����� ��
				}		
			System.out.println("�����" + youStr + ", ��ǻ�ʹ� " + computerStr);
			//����� �̰���ϴ� || ��ǻ�Ͱ� �̰���ϴ� || �����ϴ� ��� 
			if( (you+2)%3 == computer) {
				System.out.println("����� �̰���ϴ�");
				break;
			}else if (you == computer) {
				System.out.println("�����ϴ�");
			}else {
				System.out.println("��ǻ�Ͱ� �̰���ϴ� ");
			break;
			
			 }
		
		}while(true);
	}
}

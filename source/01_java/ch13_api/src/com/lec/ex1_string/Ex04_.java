package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04_ {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String juminNo;
		System.out.println("�ֹι�ȣ 14�ڸ��� �Է��ϼ���");
		juminNo =scanner.next();
		char gender = juminNo.charAt(7);// '1'
		if(gender=='1' || gender=='3')  {
			System.out.println("�����Դϴ�");
	    }else if(gender=='2' || gender== '4') {
	    	System.out.println("�����Դϴ�");
	    }else {
	    	System.out.println("��ȿ���� ���� �ֹι�ȣ�Դϴ�");
	    }
	    scanner.close();
	    
}	
}
			
		
		
			
			
			


package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04_ {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String juminNo;
		System.out.println("주민번호 14자리를 입력하세요");
		juminNo =scanner.next();
		char gender = juminNo.charAt(7);// '1'
		if(gender=='1' || gender=='3')  {
			System.out.println("남자입니다");
	    }else if(gender=='2' || gender== '4') {
	    	System.out.println("여자입니다");
	    }else {
	    	System.out.println("유효하지 않은 주민번호입니다");
	    }
	    scanner.close();
	    
}	
}
			
		
		
			
			
			


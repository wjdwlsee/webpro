package com.net.condition;
//lf vs. switch
public class Ex_swich {
	public static void main(String[] args) {
		int num = 3;
		//switch(정수형이나 문자형이나 문자열만 가능)
		switch(num) {
			case 1:
				System.out.println("주사위1"); break;
			case 2: 
				System.out.println("주사위2"); break;
			case 3:
				System.out.println("주사위3"); break;
			case 4: 
			 System.out.println("주사위4"); break;
			case 5: 
			System.out.println("주사위5"); break;
		}
//		if(num==1) {
//			System.out.println("주사위 1");
//		} else if(num == 2) {
//			System.out.println("주사위 2");
//		} else if(num == 3) {
//			System.out.println("주사위 3"); 
//		} else if(num == 4){
//			System.out.println("주사위 4");
//		} else if(num == 5){
//			System.out.println("주사위 5");
//		}else {
//			System.out.println("주사위 6");
//		}//if
}//main
}//class

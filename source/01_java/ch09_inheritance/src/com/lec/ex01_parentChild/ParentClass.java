package com.lec.ex01_parentChild;
//Parent class == super class == 부모클래식		 
public class ParentClass {
	public String pstr = "부모클래스";
	public ParentClass() {
		System.out.println("부모클래스의 생성자 함수");
		
	}
	public void getpapaName() {
		System.out.println("아빠 이름 : 홍길동");
	}
	public void getMaminame() {
		System.out.println("엄마 이름 : 김길숙");
	}
}

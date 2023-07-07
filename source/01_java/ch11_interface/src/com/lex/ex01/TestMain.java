package com.lex.ex01;
//Interface1 : CONSTANT NUM, method1(추상) 
//InterfaceEx2 : CONSTANT_STRING, method2
public class TestMain {
	public static void main(String[] args) {
		//InterfaceEx01 ex1 = new InterfaceEx01() { //추상클래스와 인터페이스는 객체생성 불가, 오직 타입으로만 가능

//			@Override
//			public void method1() {
//				System.out.println("익명클래스의 메소드");
//				
//			}
	ClassEx obj = new ClassEx();
	obj.method1();
	obj.method2();
	InterfaceEx01 obj1 = new ClassEx(); // =obj; \ 
	obj1.method1();
	//obj1.method2();
	InterfaceEx02 obj2 = new ClassEx();
	obj2.method2();
	//obj2.method1();
	System.out.println("CONSTANT_NUM :" +  InterfaceEx01.CONSTANT_NUM);
	System.out.println("CONSTANT_NUM :" + ClassEx.CONSTANT_NUM);
	System.out.println("CONSTANT_NUM :" + obj.CONSTANT_NUM);//static 은 class 로 접근 추천
	System.out.println("CONSTANT_STRING :" + InterfaceEx02.CONSTANT_STRING);
	System.out.println("CONSTANT_STRING :" + ClassEx.CONSTANT_STRING);
	
	}
		
}

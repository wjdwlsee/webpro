package com.lex.ex01;
//Interface1 : CONSTANT NUM, method1(�߻�) 
//InterfaceEx2 : CONSTANT_STRING, method2
public class TestMain {
	public static void main(String[] args) {
		//InterfaceEx01 ex1 = new InterfaceEx01() { //�߻�Ŭ������ �������̽��� ��ü���� �Ұ�, ���� Ÿ�����θ� ����

//			@Override
//			public void method1() {
//				System.out.println("�͸�Ŭ������ �޼ҵ�");
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
	System.out.println("CONSTANT_NUM :" + obj.CONSTANT_NUM);//static �� class �� ���� ��õ
	System.out.println("CONSTANT_STRING :" + InterfaceEx02.CONSTANT_STRING);
	System.out.println("CONSTANT_STRING :" + ClassEx.CONSTANT_STRING);
	
	}
		
}

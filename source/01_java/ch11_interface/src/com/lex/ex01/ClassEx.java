package com.lex.ex01;
//CONSTANT NUM, method1(�߻�) /CONSTANT_STRING, method2
public class ClassEx implements InterfaceEx01, InterfaceEx02 {

	@Override
	public void method2() {
		System.out.println("���� ������ implements�� Ŭ�������� ��-method2");
		
		
	}

	@Override
	public void method1() {
		System.out.println("���� ������ implements�� Ŭ�������� ��-method1");
		
	}
	
}

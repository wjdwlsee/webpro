package com.lec.ex1_string;

public class Ex09_stringMemorryWaste {
	public static void main(String[] args) {
		String str = "Hello, java";
		//str�ּ� (X)= �ؽ��ڵ�� ��ü
		System.out.println(str.hashCode());
		str = "hello, JAVA" ;
		System.out.println(str.hashCode());
		str= "Hello ,C";
		System.out.println(str.hashCode());
	}
}

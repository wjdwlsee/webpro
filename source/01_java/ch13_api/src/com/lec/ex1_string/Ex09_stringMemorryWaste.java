package com.lec.ex1_string;

public class Ex09_stringMemorryWaste {
	public static void main(String[] args) {
		String str = "Hello, java";
		//str주소 (X)= 해쉬코드로 대체
		System.out.println(str.hashCode());
		str = "hello, JAVA" ;
		System.out.println(str.hashCode());
		str= "Hello ,C";
		System.out.println(str.hashCode());
	}
}

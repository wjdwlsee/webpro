package com.lec.ex03_exception;

public class Ex01_NullPointException {
	public static void main(String[] args) {
		String greeting = "Hello";
		System.out.println(greeting.toUpperCase());
		greeting = null;
		System.out.println(greeting.toUpperCase());
}
}
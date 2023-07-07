package com.lec.ex;
//return 이 없는  method, 매개변수가 없는 mothod
public class Ex04_voidMethod {
	public static void main(String[] args) {
		printLine();
		System.out.println("Hello, java");
		printLine('~');
		System.out.println("Hello, oracle DB");
		printLine(15);
		System.out.println("Hello.world");
		Ex04_voidMethod ex = new Ex04_voidMethod();
		ex.printLine(21, '#');
	
	}
	private  void printLine(int cnt , char c) {
		for(int i=0; i<cnt; i++) {
			System.out.print(c) ;
			}
			System.out.println();
	
	}
	private static void printLine(int cnt) {
		for(int i=0; i<cnt; i++) {
			System.out.print('_') ;
			}
			System.out.println();
	}
		private static void printLine(char c) {
		for(int i=0; i<20; i++) {
			System.out.print('_');
		}
	System.out.println();// 기본라인 그리고 개행
	}
	
	private static void printLine() {
		for(int i=0; i<20; i++) {
			System.out.print('_');
		}
	
		System.out.println();
	
	}	
	
	

	}

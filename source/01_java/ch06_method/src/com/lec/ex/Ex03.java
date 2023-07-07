package com.lec.ex;

import java.util.Scanner;

import com.lec.method.Arithmetic;

public class Ex03 {
	public static void main(String[] args) {
		Scanner s;
		System.out.println("-9의 절대값: "+ Arithmetic.abs(-9)) ;
		Arithmetic arithmetic = new Arithmetic();
		int tot = arithmetic.sum(10);
		System.out.println(arithmetic.evenload(tot));
		tot = arithmetic.sum(10, 100);
		System.out.println("합은"+ tot);
		System.out.println(arithmetic.evenload(tot));
		

	}

}
//package가 다르면 import
//스태틱 변수가 아니면 sca 
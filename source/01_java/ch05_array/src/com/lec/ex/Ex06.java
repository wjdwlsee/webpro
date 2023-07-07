package com.lec.ex;

public class Ex06 {
	public static void main(String[] args) {
		int i = 20; //int 변수 i를 선언, 초기화
		//1. 배열 변수의 선언과 초기화
		int[] iArr = {10,20,30,40,50};
		iArr[2] = 300;
		for(int idx = 0; idx<iArr.length;   idx++) {//iArr.length : iArr 방의 갯수
			System.out.println(iArr[idx]);
	 }
		//2.배열 변수 선언과 배열 메모리 확보		
		int[] iArr2 = new int[5];
		iArr2[2] = 99;
		for(int idx=0 ; idx<iArr.length; idx++) {
			System.out.printf("iArr2[%d] = %d\n" , idx, iArr2[idx]);
		}
		//3.배열 변수 선언
		int[] iArr3; 
		iArr3 = new int[3]; //[0,0,0]
		iArr3[0] =99;
		// 일반 for문
		for(int idx=0 ; idx<iArr3.length; idx++) {
			System.out.print( idx+ "번째 :" + iArr3[idx]);
		}
	}//mai
}
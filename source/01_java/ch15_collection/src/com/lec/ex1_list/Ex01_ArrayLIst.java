package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex01_ArrayLIst {
	public static void main(String[] args) {
		String[] array =new String[3];
		array[0]="str0"; array[1]="str1"; array[2]="str2";
		System.out.println(Arrays.toString(array));
		for(String arr :array) {
			System.out.println(arr);
		}
		for(int i=0; i<array.length; i++) {
			System.out.println(i +"번 인덱스값 :" +array[i]);
		}
		System.out.println("-----------ArrayList----------");
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("str0"); //0번인덱스
		arrayList.add("str1"); //1번인덱스->2
		arrayList.add("str2");
		arrayList.add(1, "str11111");//1번 인덱스
		arrayList.add(2, "str22222");//2번 인덱스값 수정
		System.out.println("arrayList의 사이즈 :" + arrayList.size());
		arrayList.add("str4");
		System.out.println("arrayList의 사이즈:" +arrayList.size());
		System.out.println(arrayList);
		for(String temp : arrayList) {
			System.out.println(temp);
			
		}
		for(int i=0 ; i<arrayList.size() ; i++) {
			System.out.println(i + "번 인덱스 값 :"+ arrayList.get(i));//array[i]

		}
		arrayList.remove(2); //2번 인덱스의 값이 제거 (3번 인덱스 -> 2번 인덱스 , 4번인덱스->3번)
		System.out.println("2번 인덱스 값과 맨 마지막 값 remove 후");
		for(int i=0 ; i<arrayList.size(); i++) {
			System.out.println(i + "번 인덱스 값 : " +arrayList.get(i));//array[i]
			
		}
		arrayList.clear();
		System.out.println(arrayList.size()==0? "데이터 제거 완료 ":"데이터 있음");
		System.out.println(arrayList.isEmpty()?"데이터 제거 완료 ":"데이터 있음");
		//arrayList = null;
		//System.out.println();
		
	
	
	
	}
	
}

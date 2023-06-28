package com.lec.loop;
//break : 반복문 블럭을 빠져 나감
public class Ex_break_continu {
 public static void main(String[] args) {
	for(int i=1 ; i<=100 ; i++) {
		if(i==3)
			//break;//반복문 빠져나감
			continue; //증강식으로 감->조건식으로 감
			System.out.print(i);
		}
 }
}

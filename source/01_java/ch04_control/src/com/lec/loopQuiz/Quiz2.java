package com.lec.loopQuiz;

public class Quiz2 {
	public static void main(String[] args) {
		int tot = 0;
		 for(int i=1; i<=10; i++) {
		 	
		 	
			if((i%2) == 1 ) { //
				tot += i;
			}
		 }
		System.out.println("Ȧ�� �������� " + tot);
	}
}

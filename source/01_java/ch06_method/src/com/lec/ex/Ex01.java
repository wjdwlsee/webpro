package com.lec.ex;
// 1~10 ������ �հ� �� ����� ¦������ Ȧ������ ���
public class Ex01 {
	public static void main(String[] args) {
		int tot = 0;
		for(int i=1 ; i<10 ; i++) {
			tot += i;
			
		}
			System.out.println("1~10���� ������ ���� " + tot);
			System.out.print(tot%2==0 ? "¦���Դϴ�" : "Ȧ���Դϴ�");
			//
			//11~100���� ������ �հ� �� ����� ¦������ Ȧ������ ���
			tot = 0;
			for(int i=11 ; i<100 ; i++) {
				tot += i;
				
			}
				System.out.println("11~100���� ������ ���� " + tot);
				System.out.print(tot%2==0 ? "¦���Դϴ�" : "Ȧ���Դϴ�");	
	}
}

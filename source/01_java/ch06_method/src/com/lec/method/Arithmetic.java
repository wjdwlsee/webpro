package com.lec.method;
//sum (int,int) sum(10),sum(100) - �Լ��� �����ε� /evenOdd (int) /abs(int)���밪
public class Arithmetic {
	public int sum(int from, int to) {//from���� to���� �������� return
		int result = 0;
		for(int i=from ; i<=to ;  i++) {
			result +=i;
		}
		return result;
	}
	public int sum(int to) { //1~to���� ������
	int result =0;
	for(int i=1 ; i<=to ;  i++) {
		result +=i;
	}
	
	return result;
	}
	public String evenload(int vaiue) {
		String result = vaiue%2 == 0 ?  "¦���Դϴ�" : "Ȧ���Դϴ�" ;
		return result;
	}
	public static int abs(int value) {
		int result = value>=0? value:-value; //���밪
		return result;
	}


}
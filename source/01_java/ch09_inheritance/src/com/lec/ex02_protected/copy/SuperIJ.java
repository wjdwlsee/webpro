package com.lec.ex02_protected.copy;

public class SuperIJ {
	protected int i;
	private int j;
	public SuperIJ() {//��ӹ��� Ŭ�������� �θ�Ŭ������ 
		System.out.println("�Ű����� ���� SuoerIJ ������ �Լ�");
		
	}
	public SuperIJ (int i,int j ) {
		System.out.println("�Ű������� �ִ� SuperIJ ������ �Լ��� i ,j�� �ʱ�ȭ");
		this.i = i;
		this.j =j;
		
	}
	public int getI() {return i;}
	public void setI(int i) {this.i = i;}
	public int getJ() {return j;}
	public void setJ(int j) {this.j = j;}
}

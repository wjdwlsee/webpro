package com.lec.ex10_final;
//speed, running(), stop(�������̵� ����)
public class Dog extends Animal {
	@Override
	public void running() {
		// TODO Auto-generated method stub
		super.running();
		speed +=10;
		System.out.println("�������� ������ ���� �پ��. ����ӵ� : " + speed);
		
	}
	

}

package com.lec.ex06_book;

public interface ILendandable {
	public byte STATE_BORROWED =1; //"������"�ǹ� (static final)
	public byte STATE_NORMAL =0; 	//"���Ⱑ��"
	public void checkOut(String borrower, String checkOutDate);//����
	public void checkIn();//�ݳ�
	public void printState();//"å��ȣ å�̸�()���� ���Ⱑ�ɿ���" ���
		
	}
	
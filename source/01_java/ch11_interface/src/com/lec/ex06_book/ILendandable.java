package com.lec.ex06_book;

public interface ILendandable {
	public byte STATE_BORROWED =1; //"대출중"의미 (static final)
	public byte STATE_NORMAL =0; 	//"대출가능"
	public void checkOut(String borrower, String checkOutDate);//대출
	public void checkIn();//반납
	public void printState();//"책번호 책이름()저자 대출가능여부" 출력
		
	}
	
package com.lec.ex04_newException;

import java.util.Date;
import java.util.GregorianCalendar;

public class BookLibOverduTestMain {
	public static void main(String[] args) {
		Book book = new Book("950-ㄱ10", "이것이 자바다", "신윤권");
		System.out.println("대출전:" + book);
		book.checkOut("홍길동"); //대출
		book.setCheckOutDate(new Date(new GregorianCalendar(2023,5,23).getTimeInMillis()));
	//	book.setCheckOutDate(new Date(2023-1900, 5,23));
		System.out.println("대출후 :" + book);
		try {
			book.checkIn();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("반납처리 확인 :" + book);
		
	}
}

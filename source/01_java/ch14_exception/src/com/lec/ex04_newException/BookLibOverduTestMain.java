package com.lec.ex04_newException;

import java.util.Date;
import java.util.GregorianCalendar;

public class BookLibOverduTestMain {
	public static void main(String[] args) {
		Book book = new Book("950-��10", "�̰��� �ڹٴ�", "������");
		System.out.println("������:" + book);
		book.checkOut("ȫ�浿"); //����
		book.setCheckOutDate(new Date(new GregorianCalendar(2023,5,23).getTimeInMillis()));
	//	book.setCheckOutDate(new Date(2023-1900, 5,23));
		System.out.println("������ :" + book);
		try {
			book.checkIn();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("�ݳ�ó�� Ȯ�� :" + book);
		
	}
}

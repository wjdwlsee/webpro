package com.lec.ex2_date;

import java.io.ObjectInputStream.GetField;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex03_Date {
	public static void main(String[] args) {
		Date now = new Date();
	//	Date nowThat = new Date(2023-1900, 6, 12);//비추
		Date nowThat = new Date(new GregorianCalendar(2023, 7, 1).getTimeInMillis());
		System.out.println(now);
		int year = now.getYear();
		System.out.printf("%tY년 %tm월 %td일 %ta요일 %tH시(%tp %tl시) %tM분 %tS초",now);
	}
}

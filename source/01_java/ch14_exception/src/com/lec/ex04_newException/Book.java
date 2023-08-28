package com.lec.ex04_newException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Book book + new Book ("890-ㅁ01", "Java" , "신윤권");
public  class Book implements ILendandable {
	private String bookNO;//청구번호
	private String bookTitle;//책이름
	private String writer;//저자
	private String borrower;//대출인
	private Date checkOutDate; //대출일 (07-08)
	private byte state;//대출가능(0), 대출중(1)
	public Book(String bookNO, String bookTitle, String writer) {
		this.bookNO = bookNO;
		this.bookTitle = bookTitle;
		this.writer = writer;
//	borrowe = null; checkoutDate = null; state = 0;
	}

	@Override
	public void checkOut (String borrower) {//대출 
		if(state == STATE_BORROWED) { //대출중이라는 상태이면 메세지 뿌리고 끝
		System.out.println(bookTitle + "도서는 대출중입니다");
		return;
		}
		//state이 0(STATE_NORMAL)라서 대출진행
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED;
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		System.out.println(bookTitle + "도서가 대출 되었습니다");
		System.out.println("대출인 :" + borrower + "\t대출인:" +checkOutDate);
	}
	

	@Override
	public void checkIn()  throws Exception{
		if(state == STATE_NORMAL) { 
			
			throw new Exception(bookTitle + "도서는 반납이 완료된 책입니다. 확인하세요");
		}
		//현재 날짜를 시스템으로부터 가져와서 대출일 (checkoutdate)과 현재의 날짜차이를 계산 =>14일이 지났으면 연체 뗴끼
		//state가 대출중(1)이라 반납처리
		Date now = new Date();
		long checkOutDateMilli = checkOutDate.getTime();
		long nowMilli 	= now.getTime();
		long diff= nowMilli - checkOutDateMilli;
		int day =(int)(diff / (1000*60*60*24));
		if(day >14) {
			day -=14;
			System.out.println(day +"일만큼 연체되어" +(day*100)+"원 연체로 부과됩니다. 연체료를 받으셨나요");
		Scanner scanner = new Scanner(System.in);
		String answer = scanner.next().trim();
		if(!answer.equalsIgnoreCase("y")) {
		System.out.println("연체료를 미납하시면 반납처리 안 됩니다");
		return;
		}
		}
		
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL();
		System.out.println(bookTitle + "도서가 반납 완료되었습니다");
		
	}


 	@Override
	public String toString() {
		String msg = bookNO + "\t" + bookTitle + "(" + writer + "저)";
		msg += state==STATE_BORROWED ? "대출중(대출일:" + checkOutDate + ")":"대출가능";
		return msg;
	}
	public String getBookNO() {
		return bookNO;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public String getBorrower() {
		return borrower;
	}

	
	public byte getState() {
		return state;

	}
		public void setCheckOutDate(Date checkOutDate) {
			this.checkOutDate = checkOutDate;
	
	}

		
		}

	

	
	
	
	



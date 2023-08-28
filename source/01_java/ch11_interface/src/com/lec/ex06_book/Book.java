package com.lec.ex06_book;
//Book book + new Book ("890-ㅁ01", "Java" , "신윤권");
public class Book implements ILendandable {
	private String bookNO;//청구번호
	private String bookTitle;//책이름
	private String writer;//저자
	private String borrower;//대출인
	private String checkOutDate; //대출일 (07-08)
	private byte state;//대출가능(0), 대출중(1)
	public Book(String bookNO, String bookTitle, String writer) {
		this.bookNO = bookNO;
		this.bookTitle = bookTitle;
		this.writer = writer;
//	borrowe = null; checkoutDate = null; state = 0;
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) { //대출 
		if(state == STATE_BORROWED) { //대출중이라는 상태이면 메세지 뿌리고 끝
		System.out.println(bookTitle + "도서는 대출중입니다");
		return;
		}
		//state이 0(STATE_NORMAL)라서 대출진행
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(bookTitle + "도서가 대출 되었습니다");
		System.out.println("대출인 :" + borrower + "\t대출인:" +checkOutDate);
	}
	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) { 
			System.out.println(bookTitle + "도서는 반납이 완료된 책입니다. 확인하세요");
			return;
		}
		//현재 날짜를 시스템으로부터 가져와서 대출일 (checkoutdate)과 현재의 날짜차이를 계산 =>14일이 지났으면 연체 뗴끼
		//state가 대출중(1)이라 반납처리
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL();
		System.out.println(bookTitle + "도서가 반납 완료되었습니다");
	}

	private byte STATE_NORMAL() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void printState() { //"890 -ㅁ Java (신윤권저) 대출가능"
//		if(state == STATE_BORROWED);
//		System.out.println(bookNo + "\t"+bookTitle + "(" + writer + "저) - 대출중");
//	}else if (state == STATE_NORMAL) {
//		System.out.println(bookNO +"\t" + bookTitle + "(" + writer + "저) - 대출가능");
//	}else {
//		System.out.println(bookNO +"\t" + bookTitle + "(" + writer + "저) - 유령상태");
//	}

	String msg = bookNO + "\t" +bookTitle + "(" + writer + ")";
	msg += state == STATE_BORROWED ? "대출중(대출일"+checkOutDate + ")": "대출가능" ;
	System.out.println(msg);
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

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}
	
}	
	



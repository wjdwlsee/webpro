package com.lec.ex06_book;
//Book book + new Book ("890-��01", "Java" , "������");
public class Book implements ILendandable {
	private String bookNO;//û����ȣ
	private String bookTitle;//å�̸�
	private String writer;//����
	private String borrower;//������
	private String checkOutDate; //������ (07-08)
	private byte state;//���Ⱑ��(0), ������(1)
	public Book(String bookNO, String bookTitle, String writer) {
		this.bookNO = bookNO;
		this.bookTitle = bookTitle;
		this.writer = writer;
//	borrowe = null; checkoutDate = null; state = 0;
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) { //���� 
		if(state == STATE_BORROWED) { //�������̶�� �����̸� �޼��� �Ѹ��� ��
		System.out.println(bookTitle + "������ �������Դϴ�");
		return;
		}
		//state�� 0(STATE_NORMAL)�� ��������
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(bookTitle + "������ ���� �Ǿ����ϴ�");
		System.out.println("������ :" + borrower + "\t������:" +checkOutDate);
	}
	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) { 
			System.out.println(bookTitle + "������ �ݳ��� �Ϸ�� å�Դϴ�. Ȯ���ϼ���");
			return;
		}
		//���� ��¥�� �ý������κ��� �����ͼ� ������ (checkoutdate)�� ������ ��¥���̸� ��� =>14���� �������� ��ü ��
		//state�� ������(1)�̶� �ݳ�ó��
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL();
		System.out.println(bookTitle + "������ �ݳ� �Ϸ�Ǿ����ϴ�");
	}

	private byte STATE_NORMAL() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void printState() { //"890 -�� Java (��������) ���Ⱑ��"
//		if(state == STATE_BORROWED);
//		System.out.println(bookNo + "\t"+bookTitle + "(" + writer + "��) - ������");
//	}else if (state == STATE_NORMAL) {
//		System.out.println(bookNO +"\t" + bookTitle + "(" + writer + "��) - ���Ⱑ��");
//	}else {
//		System.out.println(bookNO +"\t" + bookTitle + "(" + writer + "��) - ���ɻ���");
//	}

	String msg = bookNO + "\t" +bookTitle + "(" + writer + ")";
	msg += state == STATE_BORROWED ? "������(������"+checkOutDate + ")": "���Ⱑ��" ;
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
	



package com.lec.ex04_newException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Book book + new Book ("890-��01", "Java" , "������");
public  class Book implements ILendandable {
	private String bookNO;//û����ȣ
	private String bookTitle;//å�̸�
	private String writer;//����
	private String borrower;//������
	private Date checkOutDate; //������ (07-08)
	private byte state;//���Ⱑ��(0), ������(1)
	public Book(String bookNO, String bookTitle, String writer) {
		this.bookNO = bookNO;
		this.bookTitle = bookTitle;
		this.writer = writer;
//	borrowe = null; checkoutDate = null; state = 0;
	}

	@Override
	public void checkOut (String borrower) {//���� 
		if(state == STATE_BORROWED) { //�������̶�� �����̸� �޼��� �Ѹ��� ��
		System.out.println(bookTitle + "������ �������Դϴ�");
		return;
		}
		//state�� 0(STATE_NORMAL)�� ��������
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED;
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		System.out.println(bookTitle + "������ ���� �Ǿ����ϴ�");
		System.out.println("������ :" + borrower + "\t������:" +checkOutDate);
	}
	

	@Override
	public void checkIn()  throws Exception{
		if(state == STATE_NORMAL) { 
			
			throw new Exception(bookTitle + "������ �ݳ��� �Ϸ�� å�Դϴ�. Ȯ���ϼ���");
		}
		//���� ��¥�� �ý������κ��� �����ͼ� ������ (checkoutdate)�� ������ ��¥���̸� ��� =>14���� �������� ��ü ��
		//state�� ������(1)�̶� �ݳ�ó��
		Date now = new Date();
		long checkOutDateMilli = checkOutDate.getTime();
		long nowMilli 	= now.getTime();
		long diff= nowMilli - checkOutDateMilli;
		int day =(int)(diff / (1000*60*60*24));
		if(day >14) {
			day -=14;
			System.out.println(day +"�ϸ�ŭ ��ü�Ǿ�" +(day*100)+"�� ��ü�� �ΰ��˴ϴ�. ��ü�Ḧ �����̳���");
		Scanner scanner = new Scanner(System.in);
		String answer = scanner.next().trim();
		if(!answer.equalsIgnoreCase("y")) {
		System.out.println("��ü�Ḧ �̳��Ͻø� �ݳ�ó�� �� �˴ϴ�");
		return;
		}
		}
		
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL();
		System.out.println(bookTitle + "������ �ݳ� �Ϸ�Ǿ����ϴ�");
		
	}


 	@Override
	public String toString() {
		String msg = bookNO + "\t" + bookTitle + "(" + writer + "��)";
		msg += state==STATE_BORROWED ? "������(������:" + checkOutDate + ")":"���Ⱑ��";
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

	

	
	
	
	



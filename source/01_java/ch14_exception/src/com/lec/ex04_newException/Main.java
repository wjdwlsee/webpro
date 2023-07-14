package com.lec.ex04_newException;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Book[] books = {new Book ("890-��01", "java", "������"),
					   new Book ("890-��02", "oracle", "���浿"),
					   new Book ("890-��02", "mysql", "���̵�"),
					   new Book ("890-��03", "jabc", "������"),
					   new Book ("890-��03", "html", "�̿���")};
		Scanner scanner = new Scanner(System.in);//White-space �ձ��� �Էµ� ������ ����
		int fn; //��ɹ�ȣ (1:���� , 2:�ݳ�, 3:å list���, 0:����)
		int idx; // �����ϰų� �ݳ��� �� ��ȸ�� å�� index 
		String bTitle, borrower , checkoutDate; //����ڿ��� �Է¹��� å �̸�, ������, ������
		do { 
			System.out.print("1:����� 2:�ݳ� �� 3:ålist�� 0:����");
			fn =scanner.nextInt();
			switch(fn) {
			case 1 : //���� 1.å�̸� �Է� 2.å��ȸ 3.state(å����Ȯ��) 4.������ 5.������ 6.checkOut(������,������)�޼ҵ�ȣ��
				//1.å�̸� �Է�
				System.out.println("������ å �̸��� ?");
				bTitle = scanner.next(); //"spring"White-space �ձ��� �Էµ� ��Ʈ���� ����
				//2.å��ȸ
				for(idx=0 ; idx<books.length ; idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) {
						break;//for���� ��������
					}
				}
				if (idx == books.length) {
					System.out.println("���� �������� �ʴ� �����Դϴ�");
				}else { //books[idx] ������ ����
					//3.å����Ȯ��
					if(books[idx].getState()== Book.STATE_BORROWED) {
						System.out.println("�������� �����Դϴ�");
					}else {
						//4.������ �Է�
						System.out.print("������?");
						borrower = scanner.next();
						//5.������ �Է�
						System.out.println("��������(07-07)?");
						checkoutDate =scanner.next();
						//6.checkout �޼ҵ� ȣ��
						books[idx].checkOut(borrower, checkoutDate);
					}
				}					
				break;
			case 2 : //�ݳ� : 1.å�̸� �Է� 2.å��ȸ 3.checkIn()�޼ҵ� ȣ��
				//1. å�̸� �Է�
				System.out.println("�ݳ��� å �̸���?");
				bTitle =scanner.next();
				for(idx =0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx == books.length) {
					System.out.println("�ش� ������ �� ������ å�� �ƴմϴ�");
				}else {
					//3.checkin()�޼ҵ�ȣ��
					books[idx].checkIn();
				}
				break;
			case 3 :
				for(Book book : books) {
					book.printState();
				}
			}
		}while(fn!=0);
		System.out.println("BYE");		
	}
}
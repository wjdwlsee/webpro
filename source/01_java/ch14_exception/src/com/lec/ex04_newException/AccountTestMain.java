package com.lec.ex04_newException;

public class AccountTestMain {
	public static void main(String[] args) {
		Account hong = new Account("011-1234", "ȫ�浿", 10000);
		System.out.println(hong.infoString());
		Account hong1 = new Account("012-9875", "ȫ����");
		hong1.infoPrint();
		try {
			hong.withdraw(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			hong1.withdraw(10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // �ܾ��� �����ϸ� ���� �Ұ�
		hong1.deposite(100000);
	}
}


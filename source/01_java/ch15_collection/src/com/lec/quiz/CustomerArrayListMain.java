package com.lec.quiz;
//N(n)�� �Է��� �� ���� �� �̸�, ��ȭ , �ּҸ� �Է¹޾� arrayList add
//N(n)�� �Է��ϸ� ������ ������ ���(arrayList for���� ���)
//
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.function.Consumer;

import com.lec.ex1_list.Friend;

public class CustomerArrayListMain {
	public static void main(String[] args) {
	
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Scanner scanner = new Scanner(System.in);
		String answer, name, tel, address;
				
		while(true) {
			System.out.println("ȸ�������� �����ϰڽ��ϱ�(Y/N)?");
			answer = scanner.nextLine();
			if(answer.equalsIgnoreCase("n")) break;
//			"�̸� , ��ȭ��ȣ, �ּ� �Է¹޾� customer��ü ����� customers.add�ϱ�"
			System.out.println("�̸� ?");
			name = scanner.nextLine();
			System.out.println("��ȭ��ȣ ?");
			tel = scanner.nextLine(); 
			System.out.println("�ּ� ?");
			address= scanner.nextLine();
			
			customers.add(new Customer(name, tel , address));
			
		}
		if(customers.size()==0) {
			System.out.println("������ ȸ���� �����ϴ�");
		}else {			
		//customers ��� (Ȯ�� for��, �Ϲ� for�� ��� ����)
			for(Customer customer: customers) {
				System.out.println(customer);
				
			}
			System.out.println(".....");
		}
	}
}

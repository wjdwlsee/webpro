package com.lec.quiz;
//N(n)을 입력할 때 까지 고객 이름, 전화 , 주소를 입력받아 arrayList add
//N(n)을 입력하면 가입한 고객정보 출력(arrayList for문을 출력)
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
			System.out.println("회원가입을 진행하겠습니까(Y/N)?");
			answer = scanner.nextLine();
			if(answer.equalsIgnoreCase("n")) break;
//			"이름 , 전화번호, 주소 입력받아 customer객체 만들어 customers.add하기"
			System.out.println("이름 ?");
			name = scanner.nextLine();
			System.out.println("전화번호 ?");
			tel = scanner.nextLine(); 
			System.out.println("주소 ?");
			address= scanner.nextLine();
			
			customers.add(new Customer(name, tel , address));
			
		}
		if(customers.size()==0) {
			System.out.println("가입한 회원이 없습니다");
		}else {			
		//customers 출력 (확장 for문, 일반 for문 모두 가능)
			for(Customer customer: customers) {
				System.out.println(customer);
				
			}
			System.out.println(".....");
		}
	}
}

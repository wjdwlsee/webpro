package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("ȫ�浿","010-9999-1234","����� ���빮��",new Date(0,05,22)));
		friends.add(new Friend("�ű浿","010-9999-9999","����� ������" ,new Date(0,04,05)));
		
		for(Friend friend : friends) {
			System.out.println(friend);
		}
		String address;
		Scanner scanner = new Scanner(System.in);
		System.out.println("�ּ� �� �α��ڸ� �Է��ϼ���.��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ�");
		address = scanner.nextLine();
		for(int idx=0 ; idx<friends.size() ; idx++) {
			System.out.print(friends.get(idx).getAddress()+ "\t");	
			
			
		}
	}
	
}


package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("홍길동","010-9999-1234","서울시 서대문구",new Date(0,05,22)));
		friends.add(new Friend("신길동","010-9999-9999","서울시 마포구" ,new Date(0,04,05)));
		
		for(Friend friend : friends) {
			System.out.println(friend);
		}
		String address;
		Scanner scanner = new Scanner(System.in);
		System.out.println("주소 앞 두글자만 입력하세요.단, 종료를 원하시면 x를 입력하시오");
		address = scanner.nextLine();
		for(int idx=0 ; idx<friends.size() ; idx++) {
			System.out.print(friends.get(idx).getAddress()+ "\t");	
			
			
		}
	}
	
}


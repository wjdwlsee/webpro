package com.lec.ex2_map;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import javax.naming.directory.SearchResult;

import com.lec.ex1_list.Friend;

public class Ex03_FriendHashMapSearchTel {
	public static void main(String[] args) {
		HashMap<String, Friend> friends =new HashMap<String, Friend>();
		friends.put("010-9999-9999", new Friend("홍길동", "010-9999-9999", new Date(98,0,1)));
		friends.put("010-8888-8888", new Friend("홍길동", "010-8888-8888", new Date(98,6,14)));
		friends.put("010-7777-7777", new Friend("홍길동", "010-7777-7777", new Date(96,6,17)));
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("검색할 전화번호는 (종료:X)?");
			String serchTel =scanner.next();
			if(serchTel.equalsIgnoreCase("X"))break;
			Friend serchResult = friends.get(serchTel);
			if(serchResult!=null) {
				System.out.println("검색결과 :" + serchResult);
			}else {
				System.out.println("검색된 결과가 없습니다");
			}
		}
	}
}

package com.lec.ex1_list;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Ex04_FriendsTodayBirth {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("홍길동", "010-9999-9999", new Date(98,6,14)));
		friends.add(new Friend("김길동", "010-8888-8888", new Date(98,6,14)));
		friends.add(new Friend("마길동", "010-7777-7777", new Date(98,6,14)));
		friends.add(new Friend("박길동", "010-6666-8888", new Date(98,5,14)));
		friends.add(new Friend("윤길동", "010-5555-8888", new Date(98,11,4)));
	//오늘이 생일인 친구만 출력
	System.out.println("오늘이 생일인 친구는");
	Date now =new Date();
	SimpleDateFormat sdf =new SimpleDateFormat("MM-dd");
	String nowStr = sdf.format(now);
	boolean searchOk = false;
	for(Friend friend : friends) {
		Date birth = friend.getBirth();
	if(birth!=null && sdf.format(birth).equals(nowStr)) {
		System.out.println("\n" + friends);
		searchOk = true;
				
			}
		}
	
	if(!searchOk) {
		System.out.println("없스빈다");
	}
	
	}
}	

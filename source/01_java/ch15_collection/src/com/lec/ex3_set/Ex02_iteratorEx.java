package com.lec.ex3_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.lec.ex1_list.Friend;


//iterator :��� �÷��� �ڷᱸ���� ��� ����
public class Ex02_iteratorEx {
	public static void main(String[] args) {
		//1.list
		ArrayList<String> list =new ArrayList<String> ();
		list.add("SAMPLE1"); list.add("SAMPLE2");
		for(String l : list) {
			System.out.println(l);	
		}
//		Iterator<String> iterator = list.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());

		//2.map
		HashMap<String, Friend> map= new HashMap<String,Friend>();
		map.put("ȫ�浿",new Friend("ȫ�浿", "010-9999-9999"));
		map.put("��浿", new Friend("��浿", "010-8888-8888"));
		System.out.println(map.get("ȫ�浿"));
		System.out.println(map.get("��浿"));
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + ":" +map.get(key));
		}
		//3.set
		System.out.println("===3.set ====");
		HashSet<Friend> set =new HashSet<Friend>();
		set.add(new Friend("ȫ�浿", "010-9999-9999"));
		set.add(new Friend("��浿", "010-8888-8888"));
		Iterator<Friend> iterator2= set.iterator();
		while(iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}
			
		
	
	
	}
}

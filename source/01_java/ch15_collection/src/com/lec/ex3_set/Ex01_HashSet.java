package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {
	public static void main(String[] args) {	
//	String s0= "str0";
//	String s1= new String("str0");
//	System.out.println(s0==s1);
//	System.out.println(s0.equals(s1));
//	System.out.println(s0.hashCode());
//	System.out.println(s1.hashCode());
	HashSet<String> hashset= new HashSet<String>();
	hashset.add("str0");
	hashset.add("str1");
	hashset.add("str2");//"str0".equals("str2"); , "str1".equals("str2")
	System.out.println(hashset);
	System.out.println("hashset�� ���̴� ����:" +hashset.size());
	hashset.add("str2");//"str0".equals("str2"); , "str1".equals("str2"),"str2".equals("str2")
						//str2.hashcode() �� "str2".hashcode()�� ����� ���v���� ��
	System.out.println("�ߺ������� add �� : " + hashset);
	System.out.println("�ߺ������� add �� ������ ����: " + hashset.size());
	Iterator<String> iterator = hashset.iterator();//hashset����� �ݺ���
	while(iterator.hasNext()) {
		System.out.println(iterator.next());
	}
}
}
package com.lec.ex2;

import com.lec.ex2_access.AccessTest;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest  obj = new AccessTest();
		//System.out.println(obj.defaultMember);
		//System.out.println(obj.protectMember);
		System.out.println(obj.publicMember);
		
		//obj.defaultMethod();
		//obj.protectMethod();
		obj.publicMethod();
	}



}

package com.lec.ex07_super;

public class TestMain {
	public static void main(String[] args) {
		Person papa = new Person();
		papa.setName("아빠곰"); papa.setCharacter("뚱뚱해");//매개변수 없는
		papa.intro();
		Person mom = new Person("엄마곰","아빠곰");//있는
		mom.intro();
		Person child1 = new Baby ();
		child1.setName("아기곰1"); child1.setCharacter("귀여워");
		child1.intro();
		Baby child2 = new Baby("아기곰2", "너무 귀여워");
		child2.intro();
		//intro 뺴고 for문 돌려서 배열에 넣을 수 있음
		
	}
	
	}


